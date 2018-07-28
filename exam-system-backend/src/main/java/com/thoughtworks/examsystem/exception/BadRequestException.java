package com.thoughtworks.examsystem.exception;

/**
 * @author : luoweiyao
 * @created : 2018/7/29
 * @project : exam-system
 * @package : com.thoughtworks.examsystem.exception
 */
public class BadRequestException extends RuntimeException{
    public int getCode() {
        return 0;
    }

    public String getDescription() {
        return "";
    }
}
