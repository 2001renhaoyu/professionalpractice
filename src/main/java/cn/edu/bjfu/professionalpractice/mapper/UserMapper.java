package cn.edu.bjfu.professionalpractice.mapper;

import cn.edu.bjfu.professionalpractice.models.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User findOneById(String u_id);
}
