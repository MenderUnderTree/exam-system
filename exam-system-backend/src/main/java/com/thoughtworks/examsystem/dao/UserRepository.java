package com.thoughtworks.examsystem.dao;

import com.thoughtworks.examsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    User findByUserName(String name);
}
