package com.robin.task;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

@SpringBootTest
class TaskManagerApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testRandom() {
        for(int i = 0; i < 500; i++) {
            System.out.println((int)(Math.random()*8999 + 1000));
        }
    }
}
