package com.wjq.power.helloworld.service;

import com.wjq.power.common.User;
import com.wjq.power.helloworld.dao.UserDao;

public class UserService {

    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public int queryUserCount(){
        return  userDao.getCount();
    }

    public void saveUser(User user){
         userDao.insertUser(user);
    }
}
