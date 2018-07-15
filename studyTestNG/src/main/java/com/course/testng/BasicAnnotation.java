package com.course.testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


@Test
public class BasicAnnotation {
    @Test
    public void testCase1(){
        System.out.println("this is the test 1");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println(" before method");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println(" after method");
    }

}
