package com.thoughtworks.examsystem.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * @author : luoweiyao
 * @created : 2018/7/28
 * @project : exam-system
 * @package : com.thoughtworks.examsystem.bean
 */
@Getter
@Setter
public class ItemBean {
    private Long id;

    private Integer points;

    private String description;

    private String optionA;

    private String optionB;

    private String optionC;

    private String optionD;
}
