package com.thoughtworks.examsystem.service;

import com.thoughtworks.examsystem.bean.GetPaperResponse;
import org.springframework.stereotype.Service;

/**
 * @author : luoweiyao
 * @created : 2018/7/29
 * @project : exam-system
 * @package : com.thoughtworks.examsystem.controller
 */
public interface GetPaperService {
    /**
     * 获取试卷内容
     * @param paperId
     * @return
     */
    GetPaperResponse doService(long paperId);
}
