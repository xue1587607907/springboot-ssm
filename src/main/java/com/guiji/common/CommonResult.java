package com.guiji.common;

import com.guiji.enums.ResCodeEnum;
import lombok.Data;

@Data
public class CommonResult {

    private Integer code;
    private String msg;
    private Boolean success;
//    private Map<String, Object> data = new HashMap<>();
    private Object data;

    public static CommonResult success(Object data) {
        CommonResult cr = build(ResCodeEnum.SUCCESS);
        cr.setData(data);
        return cr;
    }

    public static CommonResult success() {
        return build(ResCodeEnum.SUCCESS);
    }

    public static CommonResult fail(Object data) {
        CommonResult cr = build(ResCodeEnum.FAILED);
        cr.setData(data);
        return cr;
    }

    public static CommonResult fail() {
        return build(ResCodeEnum.FAILED);
    }

    public static CommonResult build(ResCodeEnum resCodeEnum){
        CommonResult cr = new CommonResult();
        cr.setSuccess(resCodeEnum.getFlag());
        cr.setCode(resCodeEnum.getCode());
        cr.setMsg(resCodeEnum.getMessage());
        return cr;
    }

    public CommonResult data(Object data) {
        this.data = data;
        return this;
    }

    public CommonResult msg(String msg){
        this.msg = msg;
        return this;
    }
}
