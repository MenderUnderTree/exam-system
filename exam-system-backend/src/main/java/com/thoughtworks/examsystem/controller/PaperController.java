package com.thoughtworks.examsystem.controller;

import com.thoughtworks.examsystem.bean.GetPaperResponse;
import com.thoughtworks.examsystem.bean.ErrorInfo;
import com.thoughtworks.examsystem.dao.PaperRepository;
import com.thoughtworks.examsystem.dao.PaperUserRepository;
import com.thoughtworks.examsystem.dto.PageReturn;
import com.thoughtworks.examsystem.dto.PaperReturn;
import com.thoughtworks.examsystem.entity.Paper;
import com.thoughtworks.examsystem.exception.BadRequestException;
import com.thoughtworks.examsystem.entity.PaperUser;
import com.thoughtworks.examsystem.service.AnswerPaperService;
import com.thoughtworks.examsystem.service.GetPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


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

    @Autowired
    private PaperUserRepository paperUserRepository;

    @Resource
    private AnswerPaperService answerPaperService;

    @RequestMapping(value = "/papers/{paperId}", method = RequestMethod.GET)
    public GetPaperResponse getPaper(@PathVariable long paperId) {
        return getPaperService.doService(paperId);
    }


    @RequestMapping(value = "/papers",method = RequestMethod.GET)
    public PageReturn<PaperReturn> getAll(int currentPage, int pageSize){
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Pageable pageable = PageRequest.of(currentPage - 1,pageSize,sort);
        Page<Paper> datas = repository.findAll(pageable);
        List<PaperReturn> paperReturns = new ArrayList<>();

        for(Paper paper : datas.getContent()){
            PaperUser pu = paperUserRepository.findByPaperIdAndAndUserId(paper.getId(), Long.valueOf(1));
            paperReturns.add(new PaperReturn(paper,pu));
        }
        return new PageReturn<PaperReturn>(currentPage,datas.getTotalElements(),paperReturns);
    }

    @RequestMapping(value = "/papers/{paperId}/records", method = RequestMethod.POST)
    public void examAnswer(@PathVariable long paperId, @RequestBody AnswerPaperService answerPaperService) {

    }
    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorInfo exceptionHandler(BadRequestException ex) {
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setCode(ex.getCode());
        errorInfo.setMsg(ex.getDescription());
        return errorInfo;
    }
}
