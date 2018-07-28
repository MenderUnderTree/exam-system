package com.thoughtworks.examsystem.service.impl;

import com.thoughtworks.examsystem.bean.GetPaperResponse;
import com.thoughtworks.examsystem.dao.PaperDao;
import com.thoughtworks.examsystem.service.GetPaperService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author : luoweiyao
 * @created : 2018/7/29
 * @project : exam-system
 * @package : com.thoughtworks.examsystem.service.impl
 */
@Service
public class GetPaperServiceImpl implements GetPaperService {
    @Resource
    private PaperDao paperDao;
    @Override
    public GetPaperResponse doService(long paperId) {
        paperDao.getOne(paperId);
        return null;
    }
}
