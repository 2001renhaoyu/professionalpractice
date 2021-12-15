package cn.edu.bjfu.professionalpractice.controllers;

import cn.edu.bjfu.professionalpractice.models.User;
import cn.edu.bjfu.professionalpractice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * 登陆控制
 * @author renhaoyu
 */
@Controller
public class MainController {
    @Resource
    private UserService userService;

    @GetMapping(value = {"","/login"})
    public String getLogin(){
        return "login";
    }

    @GetMapping("/logout")
    public String logOut(){
        SecurityContextHolder.clearContext();
        return "redirect:/login";
    }

}
