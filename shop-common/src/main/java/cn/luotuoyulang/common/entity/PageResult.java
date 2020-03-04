package cn.luotuoyulang.common.entity;

import cn.luotuoyulang.common.enums.ResultEnum;
import com.github.pagehelper.PageInfo;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @Description 分页返回实体类
 * @Classname PageResult
 * @Date 2020/3/4 15:53
 * @Created by liuyuhu
 * @Email 17600520726@163.com
 */
@Data
@Accessors(chain = true)
public class PageResult<T> extends BaseResult<T>{

    /**
     * 当前页
     */
    private Integer pageNum;

    /**
     * 每页显示多少条
     */
    private Integer pageSize;

    /**
     * 总个数
     */
    private Long total;

    /**
     * 总页数
     */
    private Integer pages;

    public PageResult() {}

    /**
     * @Description 疑问：如何通过构造方法一级一级得赋值
     * @param list
     * @return {@link {@link null}}
     * @throws
     * @author liuyuhu
     * @date 2020/3/4 17:16
     */
    public PageResult(List<T> list) {
        PageInfo<T> pageInfo = new PageInfo<>(list);
        this.pageNum = pageInfo.getPageNum();
        this.pageSize = pageInfo.getPageSize();
        this.total = pageInfo.getTotal();
        this.pages = pageInfo.getPages();
        this.data = (T)pageInfo.getList();
        this.code = ResultEnum.SUCCESS.getCode();
        this.msg = ResultEnum.SUCCESS.getMsg();
    }
}
