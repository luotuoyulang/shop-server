package cn.luotuoyulang.common.utils;

import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.domain.fdfs.ThumbImageConfig;
import com.github.tobato.fastdfs.domain.proto.storage.DownloadByteArray;
import com.github.tobato.fastdfs.exception.FdfsUnsupportStorePathException;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @Description TODO
 * @Classname FileUtils
 * @Date 2020/3/3 12:03
 * @Created by liuyuhu
 */
@Component
public class FileUtils {

    @Autowired
    private FastFileStorageClient storageClient;
    @Autowired
    private ThumbImageConfig thumbImageConfig;

    @Value("${fdfs.accessUrl}")
    private String accessUrl;

    /**
     * @Description 上传文件
     * @param file
     * @return {@link {@link String}}
     * @throws
     * @author liuyuhu
     * @date 2020/3/3 12:04
     */
    public String upload(MultipartFile file){
        try {
            //文件名
            String originalFilename = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
            // 文件扩展名
            String ext = originalFilename.substring(originalFilename.lastIndexOf(".") + 1, originalFilename.length());

            StorePath storePath = this.storageClient.uploadImageAndCrtThumbImage(file.getInputStream(), file.getSize(),originalFilename , null);

            String path = storePath.getFullPath();

            return  path;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @Description 删除文件
     * @param fileUrl
     * @return {@link }
     * @throws
     * @author liuyuhu
     * @date 2020/3/3 12:05
     */
    @GetMapping("deleteFile")
    public void deleteFile(String fileUrl) {
        if (StringUtils.isEmpty(fileUrl)) {
            return;
        }
        try {
            StorePath storePath = StorePath.parseFromUrl(fileUrl);
            storageClient.deleteFile(storePath.getGroup(), storePath.getPath());
        } catch (FdfsUnsupportStorePathException e) {
            e.printStackTrace();
        }
    }

    /**
     * @Description 下载文件
     * @param group
     * @param path
     * @param response
     * @return {@link }
     * @throws
     * @author liuyuhu
     * @date 2020/3/3 12:05
     */
    @GetMapping("/download")
    public void downLoad(String group,String path, HttpServletResponse response) throws IOException {

        StorePath storePath = StorePath.parseFromUrl(path);
        // 获取文件
        byte[] bytes = storageClient.downloadFile(storePath.getGroup(), storePath.getPath(), new DownloadByteArray());

        //设置相应类型application/octet-stream        （注：applicatoin/octet-stream 为通用，一些其它的类型苹果浏览器下载内容可能为空）
        response.reset();
        response.setContentType("applicatoin/octet-stream");
        //设置头信息                 Content-Disposition为属性名  附件形式打开下载文件   指定名称  为 设定的fileName
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("xiaoliu", "UTF-8"));
        // 写入到流
        ServletOutputStream out = response.getOutputStream();
        out.write(bytes);
        out.close();
//        IOUtils.write(bytes, out);
    }

    public String getAccessPath(String fileUrl){
        if(StringUtils.isEmpty(fileUrl)){
            throw new RuntimeException("123123");
        }
        return accessUrl + fileUrl;
    }
}

