package cn.luotuoyulang.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Description TODO
 * @Classname DogEntity
 * @Date 2020/3/2 23:41
 * @Created by liuyuhu
 */
@Data
public class DogEntity {

    /**
     * id
     */
    private Integer id;

    /**
     * 年龄
     */
    private String age;

    /**
     * 修改时间
     */
    private Date updateDate;

    /**
     * 创建时间
     */
    private Date createDate;
}
