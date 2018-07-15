package com.course.testng.suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class SuiteConfig {

    @BeforeSuite
    public  void beforeSuit(){
        System.out.println("before suite");
    }

    @AfterSuite
    public  void afterSuit(){
        System.out.println("after suite");
    }


}
