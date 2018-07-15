package com.wjq.power.verify;

import com.wjq.power.common.User;

public class UserDao {

    //注意mock 是不会去调用实际对象的方法的
    //通过修改字节码的方式 来获得实际对象的mock 对象
    public int getCount(User user){
        throw new UnsupportedOperationException();
    }

    public int updateUser(User user){
        throw new UnsupportedOperationException();
    }

    public int insertUser(User user){
        throw new UnsupportedOperationException();
    }




}
