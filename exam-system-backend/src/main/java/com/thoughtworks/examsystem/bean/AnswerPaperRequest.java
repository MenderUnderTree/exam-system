package com.thoughtworks.examsystem.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AnswerPaperRequest {
    private List<AnswerItemBean> answerItemBeans;
}
