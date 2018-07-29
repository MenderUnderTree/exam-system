package com.thoughtworks.examsystem.bean;

import com.thoughtworks.examsystem.entity.Record;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AnswerBeanResponse {
    private List<RecordBean> recordBeans;
}
