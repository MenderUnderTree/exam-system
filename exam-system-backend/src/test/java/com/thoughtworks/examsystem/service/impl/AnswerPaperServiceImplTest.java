package com.thoughtworks.examsystem.service.impl;

import com.thoughtworks.examsystem.bean.AnswerBeanResponse;
import com.thoughtworks.examsystem.bean.RecordBean;
import com.thoughtworks.examsystem.dao.ItemDao;
import com.thoughtworks.examsystem.dao.PaperDao;
import com.thoughtworks.examsystem.entity.Item;
import com.thoughtworks.examsystem.entity.Paper;
import com.thoughtworks.examsystem.entity.enums.Option;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
@ComponentScan(basePackages = {"com.thoughtworks.*"})
public class AnswerPaperServiceImplTest {
    @Autowired
    private AnswerPaperServiceImpl answerPaperService;
    @Autowired
    private PaperDao paperDao;
    @Autowired
    private ItemDao itemDao;

    private long paperId;
    @Before
    public void init() {
        List<Item> items = new ArrayList<>();
        Item itemA = new Item();
        itemA.setOptionA("hui");
        itemA.setOptionB("da");
        itemA.setOptionC("dawdw");
        itemA.setOptionD("dwa");
        itemA.setCorrectOption(Option.A);
        itemA.setDescription("jiojiwda");
        itemA.setPoints(5);
        itemA = itemDao.save(itemA);
        items.add(itemA);
        Item itemB = new Item();
        itemB.setOptionA("hui");
        itemB.setOptionB("da");
        itemB.setOptionC("dawdw");
        itemB.setOptionD("dwa");
        itemB.setCorrectOption(Option.A);
        itemB.setDescription("jiojiwda");
        itemB.setPoints(5);
        itemB = itemDao.save(itemB);
        items.add(itemB);

        Paper paper = new Paper();
        paper.setName("dsa");
        paper.setPrice(34);
        paper.setItems(items);
        paperId = paperDao.save(paper).getId();
    }
    @Test
    public void getRecordsListWhenRequest() {
        AnswerBeanResponse answerBeanResponse = answerPaperService.exam(paperId);
        List<RecordBean> recordBeans = answerBeanResponse.getRecordBeans();
        Assert.assertThat(recordBeans.size(), Is.is(2));
        Assert.assertThat(recordBeans.get(0).getCorrectIndex(), Is.is(0));

    }
}