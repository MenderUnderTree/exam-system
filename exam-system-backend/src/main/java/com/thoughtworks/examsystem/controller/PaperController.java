package com.thoughtworks.examsystem.controller;

import com.thoughtworks.examsystem.bean.GetPaperResponse;
import com.thoughtworks.examsystem.dto.PageReturn;
import com.thoughtworks.examsystem.entity.Paper;
import com.thoughtworks.examsystem.service.GetPaperService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * @author : luoweiyao
 * @created : 2018/7/28
 * @project : exam-system
 * @package : com.thoughtworks.examsystem.controller
 */
@RestController
@RequestMapping("/exam")
public class PaperController {
    @Resource
    private GetPaperService getPaperService;

    @RequestMapping(value = "/papers/{paperId}", method = RequestMethod.GET)
    public GetPaperResponse getPaper(@PathVariable long paperId) {
        return getPaperService.doService(paperId);
    }


    @RequestMapping(value = "/papers/",method = RequestMethod.GET)
    public PageReturn<Paper> getAll(int currentPage,int pageSize){
        return new PageReturn<>();
    }
}
