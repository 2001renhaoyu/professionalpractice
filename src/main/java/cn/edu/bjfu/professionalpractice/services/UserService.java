package cn.edu.bjfu.professionalpractice.services;

import cn.edu.bjfu.professionalpractice.mappers.UserMapper;
import cn.edu.bjfu.professionalpractice.models.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserService implements UserDetailsService {
    // 注入UserMapper:
    @Resource
    UserMapper userMapper;

    public User findOneById(String id) {
        // 调用Mapper方法:
        User user = userMapper.findOneById(id);
        if (user == null) {
            throw new RuntimeException("User not found by id.");
        }
        return user;
    }

    public User signIn(String id, String password) {
        User user = findOneById(id);
        if (user.getU_password().equals(password)) {
            return user;
        }
        throw new RuntimeException("Password Error");
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=findOneById(username);
        if (user == null) {
            throw new RuntimeException("User not found by id.");
        }

        return user;
    }
}
