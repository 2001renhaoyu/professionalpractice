package cn.edu.bjfu.professionalpractice.controllers;


import cn.edu.bjfu.professionalpractice.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Collection;

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

    @RequestMapping("/successLogin")
    public String successLogin(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", auth.getName());
        Collection<GrantedAuthority> authorityCollection = (Collection<GrantedAuthority>) auth.getAuthorities();
        String type = authorityCollection.toString();

        String url = type.substring(1,type.length()-1) +"/index";
        return url;
    }
}
