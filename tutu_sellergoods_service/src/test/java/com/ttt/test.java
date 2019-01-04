package com.ttt;

import com.test.demo.Singleton;
import org.junit.Test;
import org.springframework.security.authentication.dao.SaltSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class test {
    @Test
    public void testDemo(){
        Singleton singleton = Singleton.getSingleton();
    }
}
