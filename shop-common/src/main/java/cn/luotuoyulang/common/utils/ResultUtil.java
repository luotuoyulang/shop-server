package cn.luotuoyulang.common.utils;

import cn.luotuoyulang.common.entity.PageResult;
import cn.luotuoyulang.common.entity.BaseResult;
import cn.luotuoyulang.common.enums.ResultEnum;
import cn.luotuoyulang.common.exception.BusinessException;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * @Description TODO
 * @Classname ResultUtil
 * @Date 2020/3/4 12:57
 * @Created by liuyuhu
 * @Email 17600520726@163.com
 */
public class ResultUtil {

    public static BaseResult success(Object object) {
        BaseResult result = new BaseResult();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        result.setData(object);
        return result;
    }

    public static BaseResult success() {
        return success(null);
    }

    public static PageResult page(List list) {
        if(!(list instanceof Page))
            throw new BusinessException(ResultEnum.PAGEHELPER_ERROR);
        return new PageResult(list);
    }

    public static BaseResult error(ResultEnum resultEnum) {
        BaseResult result = new BaseResult();
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getMsg());
        return result;
    }
}
