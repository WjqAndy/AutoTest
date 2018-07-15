package com.wjq.power.mockfinal.service;


import com.wjq.power.mockfinal.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({UserService.class,UserDao.class})
public class UserServiceTest {

    @Test
    public void queryUserCount() {

        UserDao userDao = PowerMockito.mock(UserDao.class);
        PowerMockito.when(userDao.getCount()).thenReturn(10);

        System.out.println(userDao.getClass());

        UserService userService = new UserService(userDao);
        int res = userService.queryUserCount();
        assertEquals(10,res);

    }
}