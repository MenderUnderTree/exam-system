package com.thoughtworks.examsystem.service.impl;

import com.thoughtworks.examsystem.bean.Answer;
import com.thoughtworks.examsystem.bean.AnswerBeanResponse;
import com.thoughtworks.examsystem.bean.AnswerItemBean;
import com.thoughtworks.examsystem.bean.RecordBean;
import com.thoughtworks.examsystem.dao.PaperDao;
import com.thoughtworks.examsystem.dao.PaperUserRepository;
import com.thoughtworks.examsystem.entity.Paper;
import com.thoughtworks.examsystem.entity.PaperUser;
import com.thoughtworks.examsystem.entity.Record;
import com.thoughtworks.examsystem.entity.enums.Option;
import com.thoughtworks.examsystem.service.AnswerPaperService;
import com.thoughtworks.examsystem.util.UserUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.security.InvalidParameterException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnswerPaperServiceImpl implements AnswerPaperService {
    @Resource
    private PaperUserRepository paperUserRepository;
    @Resource
    private PaperDao paperDao;

    @Transactional
    @Override
    public AnswerBeanResponse exam(long paperId) {
        long userId = UserUtil.getLoginUserId();
        PaperUser paperUser = new PaperUser();
        paperUser.setUserId(userId);
        paperUser.setPaperId(paperId);
        paperUserRepository.save(paperUser);
        Paper paper = paperDao.getOne(paperId);
        List<RecordBean> recordBeans = paper.getItems().stream()
                .map(value -> {
                    RecordBean recordBean = new RecordBean();
                    recordBean.setId(value.getId());
                    recordBean.setCorrectIndex(value.getCorrectOption().ordinal());
                    return recordBean;
                })
                .collect(Collectors.toList());
        AnswerBeanResponse answerBeanResponse = new AnswerBeanResponse();
        answerBeanResponse.setRecordBeans(recordBeans);
        return answerBeanResponse;
    }
}
