package com.guiji.enums;

import lombok.Getter;

@Getter
public enum ResCodeEnum {

    SUCCESS(true,20000, "成功"),
    FAILED(false,20001, "失败");
    private final Boolean flag;
    private final Integer code;
    private final String message;

    ResCodeEnum(Boolean flag, Integer code, String message) {
        this.flag = flag;
        this.code = code;
        this.message = message;
    }
}
