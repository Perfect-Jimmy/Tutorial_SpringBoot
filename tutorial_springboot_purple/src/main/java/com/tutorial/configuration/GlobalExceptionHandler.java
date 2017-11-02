package com.tutorial.configuration;

import com.tutorial.util.exception.ResultMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by jimmy on 2017/11/1.
 * 统一异常处理
 * http://blog.csdn.net/chinrui/article/details/71056847
 * http://blog.csdn.net/xiaoliuliu2050/article/details/76615740
 * http://blog.csdn.net/je_ge/article/details/53326516
 */
@ControllerAdvice
//如果返回的为json数据或其它对象，添加该注解
@ResponseBody
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    //添加全局异常处理流程，根据需要设置需要处理的异常，本文以MethodArgumentNotValidException为例
    @ExceptionHandler(value=MethodArgumentNotValidException.class)
    public Object MethodArgumentNotValidHandler(HttpServletRequest request,
                                                MethodArgumentNotValidException exception) //throws Exception
    {
        //exception.printStackTrace();
        //按需重新封装需要返回的错误信息
      //  List<ArgumentInvalidResult> invalidArguments = new ArrayList<>();
        ResultMsg resultMsg = new ResultMsg();
      //  List<ObjectError> errors = e.getBindingResult().getAllErrors();
        //解析原错误信息，封装后返回，此处返回非法的字段名称，原始值，错误信息
        for (FieldError error : exception.getBindingResult().getFieldErrors()) {
          /*  ArgumentInvalidResult invalidArgument = new ArgumentInvalidResult();
            invalidArgument.setDefaultMessage(error.getDefaultMessage());
            invalidArgument.setField(error.getField());
            invalidArgument.setRejectedValue(error.getRejectedValue());
            invalidArguments.add(invalidArgument);*/
            System.out.println("field:"+error.getField());
            System.out.println("value:"+error.getRejectedValue());
            System.out.println("msg:"+error.getDefaultMessage());
            resultMsg.setErrorCode("301");
            resultMsg.setErrorMsg("参数不合法");
           // resultMsg.setErrorMsg(error.getDefaultMessage());
        }

       // ResultMsg resultMsg = new ResultMsg(ResultStatusCode.PARAMETER_ERROR.getErrcode(), ResultStatusCode.PARAMETER_ERROR.getErrmsg(), invalidArguments);
        return resultMsg;
    }
}
