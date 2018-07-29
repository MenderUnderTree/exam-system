package com.thoughtworks.examsystem.dto;

import com.thoughtworks.examsystem.entity.Paper;
import com.thoughtworks.examsystem.entity.PaperUser;
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
    private Integer point;
    private Boolean isFinished;

    public PaperReturn(Paper paper, PaperUser pu) {
        this.setId(paper.getId());
        this.setName(paper.getName());
        this.setPrice(paper.getPrice());
        if(null == pu){
            isFinished = false;
        }else {
            this.point = pu.getPoint();
            this.isFinished = true;
        }
    }
}
