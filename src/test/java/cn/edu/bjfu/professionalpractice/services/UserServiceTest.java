package cn.edu.bjfu.professionalpractice.services;

import cn.edu.bjfu.professionalpractice.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService userService;

    @BeforeEach
    void setUp() {

    }

    @Test
    void findOneById() {
        User user = userService.findOneById("s001");
        assertEquals(user.getPassword(),"s001");
    }
}