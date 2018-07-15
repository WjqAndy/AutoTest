package com.wjq.power.helloworld.service;

import com.wjq.power.common.User;
import com.wjq.power.helloworld.dao.UserDao;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.testng.annotations.BeforeSuite;

import javax.management.OperationsException;

import static org.junit.Assert.*;

public class UserServiceTest {

    private  UserService userService;



    @Before
    public void setUp(){
        userService = new UserService(new UserDao());
    }

    @Mock
    private  UserDao userDao;

    @Test
    public void insertUserWithPowerMockito(){

        UserDao udao = PowerMockito.mock(UserDao.class);
        User user = new User();
        PowerMockito.doNothing().when(udao).insertUser(user);

        UserService userService = new UserService(udao);
        userService.saveUser(user);

        Mockito.verify(udao).insertUser(user);

    }
    @Test
    public void queryUserCountWithPowerMockito() throws  Exception{

        UserDao uDao = PowerMockito.mock(UserDao.class);

        UserService userService = new UserService(uDao);
        PowerMockito.when(uDao.getCount()).thenReturn(10);

        int result = userService.queryUserCount();
        //不加最后的断言 只是有没有判别的意思
        //是不会影响到覆盖率的统计的
       // assertEquals(10,result);

    }

    /*
    此处的代码的逻辑是
    在这段代码中本质上调用的是UserDao 的方法
    但是不能获得UserDao的实际对象，就只能mock 一个userDao
    然后注入进去，并定制其行为 表示已经 正常调用了此方法
    （其实默认的意思是userDao 方法是正确的或者实现解耦）
     */
    @Ignore
    @Test
    public void queryUserCountWithMockito() throws  Exception{
        MockitoAnnotations.initMocks(this);
         userService = new UserService( userDao);
        Mockito.when(userDao.getCount()).thenReturn(10);//也就是说这里是不会再抛异常了
        //同时注意其本质也就没有调用实际的方法，所以如果测试覆盖率
        //是测试不到userDao 中的方法的
        int result = userService.queryUserCount();
        assertEquals(10,result);

    }

    @Ignore
    @Test
    public void queryUserCount() throws  Exception{
        try {
            userService.queryUserCount();
            fail("shoud not run here");
        }catch (Exception e){
            assertTrue(e instanceof UnsupportedOperationException);
        }
    }

    @Ignore
    @Test
    public void saveUser() throws  Exception{

        try {
            userService.saveUser(new User());
            fail("shoud not run here");
        }catch (Exception e){
            assertTrue(e instanceof UnsupportedOperationException);
        }

    }
}