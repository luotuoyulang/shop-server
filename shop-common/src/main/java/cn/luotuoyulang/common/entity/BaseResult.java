package cn.luotuoyulang.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 全局返回类
 * @Classname Result
 * @Date 2020/3/4 12:52
 * @Created by liuyuhu
 * @Email 17600520726@163.com
 */
@Data
public class BaseResult<T> {

    /**
     * 错误码
     */
    public Integer code;

    /**
     * 错误信息
     */
    public String msg;

    /**
     * 返回内容
     */
    public T data;

}
