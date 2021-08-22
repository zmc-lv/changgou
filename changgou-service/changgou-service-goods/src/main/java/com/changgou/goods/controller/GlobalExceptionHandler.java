package com.changgou.goods.controller;

import entity.Result;
import entity.StatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * package name: com.changgou.goods.controller
 *
 * @author zmc
 * Date: 2021/8/19
 */
@ControllerAdvice //标识该类就是一个异常处理类
public class GlobalExceptionHandler{

    /**
     * 该方法 当你通过注解指定的异常发生的时候 将会被调用 返回给前端数据
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Result handlerException(Exception e){
        //异常输出到日志文件中
        e.printStackTrace();
        return new Result(false, StatusCode.ERROR, e.getMessage());
    }
}
