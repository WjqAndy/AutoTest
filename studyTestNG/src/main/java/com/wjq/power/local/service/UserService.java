package com.wjq.power.local.service;

import com.wjq.power.common.User;
import com.wjq.power.local.dao.UserDao;

public class UserService {

    public int queryUserCount(){

        UserDao userDao = new UserDao();
        return  userDao.getCount();
    }

    public void saveUser(User user){
        UserDao userDao = new UserDao();
        userDao.insertUser(user);
    }
}
