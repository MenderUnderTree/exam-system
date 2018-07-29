package com.thoughtworks.examsystem.service.impl;

import com.thoughtworks.examsystem.bean.GetPaperResponse;
import com.thoughtworks.examsystem.dao.ItemDao;
import com.thoughtworks.examsystem.dao.PaperDao;
import com.thoughtworks.examsystem.dao.PaperUserRepository;
import com.thoughtworks.examsystem.entity.Item;
import com.thoughtworks.examsystem.entity.Paper;
import com.thoughtworks.examsystem.entity.PaperUser;
import com.thoughtworks.examsystem.entity.enums.Option;
import com.thoughtworks.examsystem.exception.PaperHasBeenFinishedException;
import com.thoughtworks.examsystem.service.GetPaperService;
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

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : luoweiyao
 * @created : 2018/7/29
 * @project : exam-system
 * @package : com.thoughtworks.examsystem.service.impl
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
@ComponentScan(basePackages = {"com.thoughtworks.*"})
public class GetPaperServiceImplTest {
    @Resource
    private GetPaperService getPaperService;
    @Autowired
    private PaperDao paperDao;
    @Autowired
    private ItemDao itemDao;
    @Autowired
    private PaperUserRepository repository;

    private long paperId;
    private long finishedPaperId;

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

        Paper finishedPaper = new Paper();
        finishedPaper.setName("finished");
        finishedPaper.setPrice(0);
        finishedPaper.setItems(items);
        finishedPaperId = paperDao.save(finishedPaper).getId();

        PaperUser paperUser = new PaperUser();
        paperUser.setPaperId(finishedPaperId);
        paperUser.setUserId(1L);
        paperUser.setPoint(23);
        repository.save(paperUser);
    }

    @Test
    public void testDoService() {
        GetPaperResponse result = getPaperService.doService(paperId);
        Assert.assertThat(result.getItemBeanList().size(), Is.is(2));
    }

    @Test(expected = PaperHasBeenFinishedException.class)
    public void getExceptionWhenPaperIsFinished() {
        getPaperService.doService(finishedPaperId);
    }
}