package cn.edu.bjfu.professionalpractice.mapper;

import cn.edu.bjfu.professionalpractice.models.User;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {
    User findOneById(String u_id);
}
