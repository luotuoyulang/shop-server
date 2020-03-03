package cn.luotuoyulang.system.controller;

import cn.luotuoyulang.common.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description TODO
 * @Classname FileController
 * @Date 2020/3/3 12:08
 * @Created by liuyuhu
 */
@RestController
public class FileController {

    @Autowired
    FileUtils fileUtils;

    @PostMapping("/upload")
    public String upload(MultipartFile file){
        String upload = fileUtils.upload(file);
        String accessPath = fileUtils.getAccessPath(upload);
        return accessPath;
    }
}
