package com.chenlinghong.javaskso.handler;

import com.chenlinghong.javaskso.exception.GlobalException;
import com.chenlinghong.javaskso.result.CodeMsg;
import com.chenlinghong.javaskso.result.Result;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Created By Mr.Chen
 * Date: 18/09/10
 * Time: 14:55
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Result<String> exceptionHandler(HttpServletRequest request,Exception e){
        if (e instanceof GlobalException){
            GlobalException globalException = (GlobalException)e;
            return Result.error(globalException.getCodeMsg());
        }else if (e instanceof BindException){
            BindException bindException = (BindException) e;
            List<ObjectError> errors = bindException.getAllErrors();
            //此处仅取第一个
            ObjectError objectError = errors.get(0);
            String msg = objectError.getDefaultMessage();
            return Result.error(CodeMsg.BIND_ERROR.fillArgs(msg));
        } else {
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }

}
