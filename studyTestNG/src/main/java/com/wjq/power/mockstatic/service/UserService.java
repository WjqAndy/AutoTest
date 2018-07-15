package com.wjq.power.mockstatic.service;

import com.wjq.power.common.User;
import com.wjq.power.mockstatic.dao.UserDao;

public class UserService {

    public int queryUserCount(){
        return  UserDao.getCount();
    }

    public void saveUser(User user){
        UserDao.insertUser(user);
    }
}
