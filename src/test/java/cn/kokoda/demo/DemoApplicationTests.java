package cn.kokoda.demo;

import cn.kokoda.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    UserService userService;

    @Test
    void contextLoads() throws SQLException {
        System.out.println(userService.register("12345678@foxmail.com", "12334"));
    }

}
