package com.tutorial.configuration;

import com.tutorial.util.exception.ResultMsg;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by jimmy on 2017/11/1.
 */
//@ControllerAdvice
//如果返回的为json数据或其它对象，添加该注解
//@ResponseBody
public class GlobalExceptionHandler {

    //添加全局异常处理流程，根据需要设置需要处理的异常，本文以MethodArgumentNotValidException为例
    @ExceptionHandler(value=MethodArgumentNotValidException.class)
    public Object MethodArgumentNotValidHandler(HttpServletRequest request,
                                                MethodArgumentNotValidException exception) throws Exception
    {
        //按需重新封装需要返回的错误信息
      //  List<ArgumentInvalidResult> invalidArguments = new ArrayList<>();
        ResultMsg resultMsg = new ResultMsg();
        //解析原错误信息，封装后返回，此处返回非法的字段名称，原始值，错误信息
        for (FieldError error : exception.getBindingResult().getFieldErrors()) {
          /*  ArgumentInvalidResult invalidArgument = new ArgumentInvalidResult();
            invalidArgument.setDefaultMessage(error.getDefaultMessage());
            invalidArgument.setField(error.getField());
            invalidArgument.setRejectedValue(error.getRejectedValue());
            invalidArguments.add(invalidArgument);*/
            System.out.println(error.getField());
            System.out.println(error.getRejectedValue());
            resultMsg.setErrorCode("301");
            resultMsg.setErrorMsg("参数不合法");
            resultMsg.setErrorMsg(error.getDefaultMessage());
        }

       // ResultMsg resultMsg = new ResultMsg(ResultStatusCode.PARAMETER_ERROR.getErrcode(), ResultStatusCode.PARAMETER_ERROR.getErrmsg(), invalidArguments);
        return resultMsg;
    }
}
