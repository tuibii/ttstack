package com.tt.stack;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StackApplicationTests {

    @Test
    public void contextLoads() {
        System.out.println(new SimpleDateFormat("yyyyMMdd").format(new Date()));
    }

}
