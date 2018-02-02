package io.renren;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Random;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mvc.xml","classpath:spring-jdbc.xml",
        "classpath:spring-redis.xml","classpath:spring-scheduler.xml",})
public class RedisTest {

    @Test
    public void test(){
        Random ran1 = new Random(100);
        System.out.println(ran1.nextInt(100));
        System.out.println(ran1.nextInt(100));
    }
}
