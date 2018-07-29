package com.thoughtworks.examsystem.service;

import com.thoughtworks.examsystem.bean.AnswerPaperRequest;

public interface AnswerPaperService {
    void exam(long paperId, AnswerPaperRequest answer);
}
