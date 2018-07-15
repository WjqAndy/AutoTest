package com.wjq.power.verify;

import com.wjq.power.common.User;
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
    public void saveOrUpdate() {

        User user = PowerMockito.mock(User.class);
        UserDao userDao = PowerMockito.mock(UserDao.class);
        try {
            //局部变量 插入进去
            PowerMockito.whenNew(UserDao.class).withAnyArguments().thenReturn(userDao);
           //定制行为
            PowerMockito.when(userDao.getCount(user)).thenReturn(1);

            PowerMockito.when(userDao.insertUser(user)).thenReturn(1);
            PowerMockito.when(userDao.updateUser(user)).thenReturn(1);

            UserService userService = new UserService();
            userService.saveOrUpdate(user);

            //verify 可以用来验证 那些方法被调用
            Mockito.verify(userDao).getCount(user);
           // Mockito.verify(userDao.getCount(user));
            Mockito.verify(userDao).updateUser(user);
            Mockito.verify(userDao, Mockito.never()).insertUser(user);


         /*   PowerMockito.when(userDao.getCount(user)).thenReturn(0);
            userService.saveOrUpdate(user);


            Mockito.verify(userDao.insertUser(user));*/
        } catch (Exception e) {
            fail();
        }


    }
}