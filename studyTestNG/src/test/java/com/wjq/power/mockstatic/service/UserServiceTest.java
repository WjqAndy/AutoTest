package com.wjq.power.mockstatic.service;

import com.wjq.power.common.User;
import com.wjq.power.mockstatic.dao.UserDao;
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
        PowerMockito.mockStatic(UserDao.class);
        PowerMockito.when(UserDao.getCount()).thenReturn(10);

        UserService userService = new UserService();
        int res = userService.queryUserCount();
        assertEquals(10,res);
    }

    @Test
    public void saveUser() {
        PowerMockito.mockStatic(UserDao.class);
        PowerMockito.doNothing().when(UserDao.class);

        UserService userService = new UserService();
        userService.saveUser(new User());

        PowerMockito.verifyStatic();
    }
}