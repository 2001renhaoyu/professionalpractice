package cn.edu.bjfu.professionalpractice.controllers;

import cn.edu.bjfu.professionalpractice.models.User;
import cn.edu.bjfu.professionalpractice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 登陆控制
 * @author renhaoyu
 */
@Controller
public class MainController {
    @Autowired
    private UserService userService;

    @GetMapping(value = {"","/login"})
    public String getLogin(){
        return "login";
    }

    @PostMapping("/signIn")
    public String signIn(@RequestParam("username") String username, @RequestParam("password") String password){
        User user = userService.signIn(username,password);

        return "login";
    }
}
