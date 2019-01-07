package com.zwk.weibo.exception;

//自定义异常处理
public class MyException extends RuntimeException{
    private String msg;
    private String code;

    public MyException(String message, Throwable cause, String msg) {
        super(message, cause);
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
