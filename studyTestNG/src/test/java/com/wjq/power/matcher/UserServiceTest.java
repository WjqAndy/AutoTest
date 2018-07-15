package com.wjq.power.matcher;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(UserService.class)
public class UserServiceTest {

    @Test
    public void quertByName() {
        UserDao userDao = PowerMockito.mock(UserDao.class);
        try {
            PowerMockito.whenNew(UserDao.class).withNoArguments().thenReturn(userDao);
            String  name = "ha";
            PowerMockito.when(userDao.queryNmae(name)).thenReturn("123");

            UserService userService = new UserService();
            String res = userService.quertByName(name);
            assertEquals("123",res);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void quertByNameMathcer() {
        UserDao userDao = PowerMockito.mock(UserDao.class);
        try {
            PowerMockito.whenNew(UserDao.class).withNoArguments().thenReturn(userDao);

            PowerMockito.when(userDao.queryNmae(Matchers.argThat(new MyArgumentMatcher())))
                    .thenReturn("123");

            UserService userService = new UserService();
            String res = userService.quertByName("a");
            assertEquals("123",res);
            String res1 = userService.quertByName("b");
            assertEquals("123",res);

            fail("not process here");//这是一个断言

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void quertByNameAnswer() {
        UserDao userDao = PowerMockito.mock(UserDao.class);
        UserService userService = new UserService();
        try {
            PowerMockito.whenNew(UserDao.class).withNoArguments().thenReturn(userDao);

            PowerMockito.when(userDao.queryNmae(Mockito.anyString()))
                    .then(invocation -> {
                        String arg = (String) invocation.getArguments()[0];
                        switch (arg){
                            case "a":
                                return "wan";
                            case "b":
                                return  "hello";
                            default:
                                throw new RuntimeException("not support"+arg);

                        }
                    });


            assertEquals("wan", userService.quertByName("a"));
            assertEquals("hello", userService.quertByName("b"));

            //也是可以通过mockito.any 模拟出任意的一个想要的类型的参数
            //String res = userService.quertByName(Mockito.anyString());

        } catch (Exception e) {
           assertTrue(e instanceof  RuntimeException);
        }
        //String res = userService.quertByName(Mockito.anyString());
        //fail("not process here");
    }

    static  class  MyArgumentMatcher extends ArgumentMatcher<String >{

        @Override
        public boolean matches(Object o) {
            String arg = (String) o;
            switch (arg){
                case "a":
                case "b":
                case "c":
                case "d":
                    return true;
                    default:return false;
            }

        }
    }
}