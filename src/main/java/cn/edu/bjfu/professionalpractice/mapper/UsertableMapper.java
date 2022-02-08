package cn.edu.bjfu.professionalpractice.mapper;

import cn.edu.bjfu.professionalpractice.entity.Usertable;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author renhaoyu
 * @since 2021-12-21
 */
@Repository
public interface UsertableMapper extends BaseMapper<Usertable> {
    Usertable login(String username, String password);

    int addUser(String u_id, String u_type);
}
