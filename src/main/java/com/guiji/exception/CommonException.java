package com.guiji.exception;

import com.guiji.common.CommonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CommonException {

    @ExceptionHandler(Exception.class)
    public CommonResult doException(Exception e){
        e.printStackTrace();
        return CommonResult.fail().msg("服务器故障,请稍后再试!!!");
    }
}
