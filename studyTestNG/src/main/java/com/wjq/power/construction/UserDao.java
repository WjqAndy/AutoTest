package com.wjq.power.construction;

import com.wjq.power.common.User;

import javax.lang.model.element.NestingKind;

public class UserDao {

    private String name;
    private  String password;

    public UserDao(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public void insertUser(){
        throw new UnsupportedOperationException();
    }
}
