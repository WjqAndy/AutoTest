package com.wjq.power.construction;

public class UserService {

    public void saveUser(String name,String password){
        UserDao userDao = new UserDao(name,password);
         userDao.insertUser();
    }
}
