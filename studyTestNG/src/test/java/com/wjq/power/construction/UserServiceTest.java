package com.wjq.power.construction;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(UserService.class)
public class UserServiceTest {

    @Test
    public void saveUser() {

        UserDao userDao = PowerMockito.mock(UserDao.class);
        String name = "haha";
        String password = "123";

        try {
            PowerMockito.whenNew(UserDao.class).withArguments(name,password).thenReturn(userDao);
            PowerMockito.doNothing().when(userDao).insertUser();

            UserService userService = new UserService();
            userService.saveUser(name,password);

            Mockito.verify(userDao).insertUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}