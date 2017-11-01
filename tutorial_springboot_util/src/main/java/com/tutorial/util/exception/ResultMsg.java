package com.tutorial.util.exception;

import lombok.Data;

/**
 * Created by jimmy on 2017/11/1.
 * 全局异常返回信息
 */
@Data
public class ResultMsg {

    private String errorCode;
    private String errorMsg;
    private Object object;
}
