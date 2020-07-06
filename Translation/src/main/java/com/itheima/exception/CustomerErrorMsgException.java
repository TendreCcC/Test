package com.itheima.exception;

/**
 * 用户自定义异常
 */
public class CustomerErrorMsgException extends Exception {

    //重写父类的有参数构造方法，传入错误信息
    public CustomerErrorMsgException(String message) {
        super(message);
    }
}