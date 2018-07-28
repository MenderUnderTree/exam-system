package com.thoughtworks.examsystem.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.examsystem.ExamSystemApplication;
import com.thoughtworks.examsystem.bean.GetPaperResponse;
import com.thoughtworks.examsystem.dao.ItemDao;
import com.thoughtworks.examsystem.dao.PaperDao;
import com.thoughtworks.examsystem.entity.Item;
import com.thoughtworks.examsystem.entity.Paper;
import com.thoughtworks.examsystem.service.GetPaperService;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author : luoweiyao
 * @created : 2018/7/29
 * @project : exam-system
 * @package : com.thoughtworks.examsystem.service.impl
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ComponentScan(basePackages = {"com.thoughtworks.*"})
public class GetPaperServiceImplTest {
    @Resource
    private GetPaperService getPaperService;
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
        itemA.setCorrectOption(Item.CorrectOption.A);
        itemA.setDescription("jiojiwda");
        itemA.setPoints(5);
        itemA = itemDao.save(itemA);
        items.add(itemA);
        Item itemB = new Item();
        itemB.setOptionA("hui");
        itemB.setOptionB("da");
        itemB.setOptionC("dawdw");
        itemB.setOptionD("dwa");
        itemB.setCorrectOption(Item.CorrectOption.A);
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
    public void doService() {
        GetPaperResponse result = getPaperService.doService(paperId);
        Assert.assertThat(result.getItemBeanList().size(), Is.is(2));
    }

    @Test
    public void he() {

    }
}