package cn.edu.bjfu.professionalpractice.service.impl;

import cn.edu.bjfu.professionalpractice.entity.Usertable;
import cn.edu.bjfu.professionalpractice.mapper.UsertableMapper;
import cn.edu.bjfu.professionalpractice.service.UsertableService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.NullPointerException;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author renhaoyu
 * @since 2021-12-21
 */
@Service
public class UsertableServiceImpl extends ServiceImpl<UsertableMapper, Usertable> implements UsertableService {

    @Autowired
    UsertableMapper usertableMapper;

    @Override
    public Usertable login(String username, String password) throws NullPointerException{
        Usertable one = usertableMapper.login(username,password);
        if (one == null){
            throw new NullPointerException("登录失败！");
        }
        return one;
    }

    @Override
    public int addUser(String u_id, String u_type) {
        return usertableMapper.addUser(u_id,u_type);
    }
}
