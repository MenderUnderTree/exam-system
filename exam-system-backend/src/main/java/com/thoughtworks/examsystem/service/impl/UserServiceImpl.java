package com.thoughtworks.examsystem.service.impl;

import com.thoughtworks.examsystem.dao.UserRepository;
import com.thoughtworks.examsystem.entity.User;
import com.thoughtworks.examsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String checkUserInfo(String name, String password) {
        String responseMsg = "用户不存在！";
        Optional<User> userVal = Optional.ofNullable(userRepository.findByUserName(name));
        if(userVal.isPresent()){
            User user = userRepository.findByUserName(name);
            String relPassword = user.getPwd();
            if(relPassword.equals(password)){
                responseMsg = "登录成功！";
            } else {
                responseMsg = "密码错误！";
            }
        }
        return responseMsg;
    }
}
