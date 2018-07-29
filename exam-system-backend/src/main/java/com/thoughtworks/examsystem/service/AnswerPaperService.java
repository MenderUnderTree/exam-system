package com.thoughtworks.examsystem.service;

import com.thoughtworks.examsystem.bean.AnswerBeanResponse;

public interface AnswerPaperService {
    AnswerBeanResponse exam(long paperId);
}
