package com.thoughtworks.examsystem.dao;

import com.thoughtworks.examsystem.entity.Paper;
import com.thoughtworks.examsystem.entity.PaperUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Auther: Realks
 * @Date: 2018/7/29 02:16
 * @Description:
 */
@Repository
public interface PaperUserRepository extends JpaRepository<PaperUser,Long> {
    PaperUser findByPaperIdAndAndUserId(Long paperId,Long userId);
}
