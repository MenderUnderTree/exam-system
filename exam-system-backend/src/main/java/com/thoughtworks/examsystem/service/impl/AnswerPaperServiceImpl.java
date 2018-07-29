package com.thoughtworks.examsystem.service.impl;

import com.thoughtworks.examsystem.bean.Answer;
import com.thoughtworks.examsystem.bean.AnswerItemBean;
import com.thoughtworks.examsystem.bean.AnswerPaperRequest;
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
    public void exam(long paperId, AnswerPaperRequest answer) {
        Paper paper = paperDao.getOne(paperId);
        if (paper == null) {
            throw new InvalidParameterException();
        }
        PaperUser paperUser = new PaperUser();
        paperUser.setPaperId(paperId);
        paperUser.setUserId(UserUtil.getLoginUserId());
        long paperUserId = paperUserRepository.save(paperUser).getId();
        List<Record> records = paper.getItems().stream().map(value -> {
            Record record = new Record();
            record.setPaperUserId(paperUserId);
            record.setItemId(value.getId());
            Answer presentAnswer = getAnswerItemBean(answer.getAnswerItemBeans(), value.getId()).getAnswer();
            if (presentAnswer != null) {
                record.setAnswer(Option.valueOf(presentAnswer.name()));
                record.setIsCorrect(presentAnswer.name().equals(value.getCorrectOption().name()));
            } else {
                record.setIsCorrect(false);
            }
            return record;
        }).collect(Collectors.toList());

    }

    private AnswerItemBean getAnswerItemBean(List<AnswerItemBean> answerItemBeans, long itemId) {
        return answerItemBeans.stream()
                .filter(v -> v.getId() == itemId)
                .findFirst()
                .orElseThrow(InvalidParameterException::new);
    }
}
