package com.thoughtworks.examsystem.controller;

import com.thoughtworks.examsystem.bean.GetPaperResponse;
import com.thoughtworks.examsystem.dao.PaperRepository;
import com.thoughtworks.examsystem.dto.PageReturn;
import com.thoughtworks.examsystem.dto.PaperReturn;
import com.thoughtworks.examsystem.entity.Paper;
import com.thoughtworks.examsystem.service.GetPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @Autowired
    private PaperRepository repository;

    @RequestMapping(value = "/papers/{paperId}", method = RequestMethod.GET)
    public GetPaperResponse getPaper(@PathVariable long paperId) {
        return getPaperService.doService(paperId);
    }


    @RequestMapping(value = "/papers",method = RequestMethod.GET)
    public PageReturn<PaperReturn> getAll(int currentPage, int pageSize){
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Pageable pageable = PageRequest.of(currentPage + 1,pageSize,sort);
        Page<Paper> datas = repository.findAll(pageable);

        return new PageReturn<PaperReturn>();
    }
}
