package com.wjq.power.log;

public class UserService {
    public  void foo(){
        log();
    }

    private void log(){
        System.out.println("i an console log");
    }

    public boolean exist(String name){
        return checkExist(name);
    }

    private boolean checkExist(String name) {
        throw  new UnsupportedOperationException();
    }
}
