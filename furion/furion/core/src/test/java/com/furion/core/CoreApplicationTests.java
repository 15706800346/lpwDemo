package com.furion.core;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ObjectUtils;

@SpringBootTest
class CoreApplicationTests {

    @Test
    void contextLoads() {

            String s = null;
            String s1 = "";

            if (ObjectUtils.isEmpty(s)) {
                System.out.println(1);
            }
            if (ObjectUtils.isEmpty(s1)) {
                System.out.println(2);
            }


    }

}
