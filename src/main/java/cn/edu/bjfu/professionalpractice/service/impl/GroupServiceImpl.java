package cn.edu.bjfu.professionalpractice.service.impl;

import cn.edu.bjfu.professionalpractice.entity.StudentGroup;
import cn.edu.bjfu.professionalpractice.mapper.GroupMapper;
import cn.edu.bjfu.professionalpractice.service.GroupService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author renhaoyu
 * @since 2021-12-21
 */
@Service
public class GroupServiceImpl extends ServiceImpl<GroupMapper, StudentGroup> implements GroupService {
    @Autowired
    GroupMapper groupMapper;

    @Override
    public List<StudentGroup> queryGroup(String t_id, String c_id, String g_id, String g_name, String s_leader_id, String s_id) {
        if (g_name!=null)
            g_name= "%" + g_name + "%";
        return groupMapper.queryGroup(t_id,c_id,g_id,g_name,s_leader_id,s_id);
    }

    @Override
    public int addGroup(String c_id, String g_id, String g_name, String s_leader_id) {
        return groupMapper.addGroup(c_id,g_id,g_name,s_leader_id);
    }

    @Override
    public int deleteGroup(String g_id) {
        Map<String,Object> map = new HashMap<>();
        map.put("g_id",g_id);
        return groupMapper.deleteByMap(map);
    }

    @Override
    public int updateGroup(String c_id, String g_id, String g_name, String s_leader_id) {
        return groupMapper.updateGroup(c_id,g_id,g_name,s_leader_id);
    }

    @Override
    public int joinGroup(String g_id, String s_id) {
        return groupMapper.joinGroup(g_id,s_id);
    }
}
