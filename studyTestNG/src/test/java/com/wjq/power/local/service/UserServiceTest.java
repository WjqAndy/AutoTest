package com.wjq.power.local.service;


import com.wjq.power.common.User;
import com.wjq.power.local.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mockito;
import org.mockito.internal.verification.Times;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(UserService.class)
public class UserServiceTest {

    @Test
    public void queryUserCount() {
        try {
            UserDao userDao = PowerMockito.mock(UserDao.class);
            PowerMockito.whenNew(UserDao.class).withNoArguments().thenReturn(userDao);

            System.out.println(userDao.getClass());

            PowerMockito.doReturn(10).when(userDao).getCount();
            UserService service = new UserService();
            int res = service.queryUserCount();
            assertEquals(10,res);

        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void saveUser() {
        UserDao userDao = PowerMockito.mock(UserDao.class);
        try {
            User user = new User();
            PowerMockito.whenNew(UserDao.class).withAnyArguments().thenReturn(userDao);
            PowerMockito.doNothing().when(userDao).insertUser(user);

            UserService userService = new UserService();
            userService.saveUser(user);

            Mockito.verify(userDao,Mockito.times(1)).insertUser(user);

        } catch (Exception e) {
            fail();
        }
    }
}