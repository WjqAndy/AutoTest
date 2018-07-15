package com.wjq.power.verify;

import com.wjq.power.common.User;

public class UserService {

    public void saveOrUpdate(User user){

        UserDao userDao = new UserDao();

        if(userDao.getCount(user) > 0){
            userDao.updateUser(user);
        }else {
            userDao.insertUser(user);
        }
    }
}
