package com.thoughtworks.examsystem.bean;

/**
 * @author : luoweiyao
 * @created : 2018/7/29
 * @project : exam-system
 * @package : com.thoughtworks.examsystem.controller
 */
public class ErrorInfo {
    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
