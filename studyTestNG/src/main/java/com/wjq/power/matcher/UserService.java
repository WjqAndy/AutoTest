package com.wjq.power.matcher;

public class UserService {

    public String quertByName(String  name){
        UserDao userDao = new UserDao();
        return  userDao.queryNmae(name);
    }
}
