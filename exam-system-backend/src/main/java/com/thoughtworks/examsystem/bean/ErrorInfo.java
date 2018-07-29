package com.thoughtworks.examsystem.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * @author : luoweiyao
 * @created : 2018/7/29
 * @project : exam-system
 * @package : com.thoughtworks.examsystem.controller
 */
@Getter
@Setter
public class ErrorInfo {
    private int code;
    private String msg;
}
