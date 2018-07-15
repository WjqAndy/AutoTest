package com.wjq.power.log;

import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

import static org.junit.Assert.*;

public class UserServiceTest {

    @Test
    public void foo() {
        UserService userService = PowerMockito.spy(new UserService());
        userService.foo();
    }
    @Test
    public void check() {
        UserService userService = PowerMockito.spy(new UserService());
        try {
            PowerMockito.doReturn(true).when(userService,"exist","haha");
            assertTrue(userService.exist("haha"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}