package com.neo.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyPropertiesTest {
    @Autowired
	private NeoProperties myProperties;

    @Test
    public void getNamegetDescription() {
        System.out.println(myProperties.getName());
		System.out.println(myProperties.getPassword());
    }

}