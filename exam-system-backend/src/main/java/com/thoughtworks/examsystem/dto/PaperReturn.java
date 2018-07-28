package com.thoughtworks.examsystem.dto;

import com.thoughtworks.examsystem.entity.Paper;
import lombok.Getter;
import lombok.Setter;

/**
 * @Auther: Realks
 * @Date: 2018/7/29 01:39
 * @Description:
 */
@Getter
@Setter
public class PaperReturn extends Paper {
    private Long point;
    private Boolean isFinished;
}
