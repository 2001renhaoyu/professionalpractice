package cn.edu.bjfu.professionalpractice.service;

import cn.edu.bjfu.professionalpractice.entity.StudentGroup;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author renhaoyu
 * @since 2021-12-21
 */
public interface GroupService extends IService<StudentGroup> {

    List<StudentGroup> queryGroup(String t_id, String c_id, String g_id, String g_name, String s_leader_id, String s_id);

    int addGroup(String c_id, String g_id, String g_name, String s_leader_id);

    int deleteGroup(String g_id);

    int updateGroup(String c_id, String g_id, String g_name, String s_leader_id);

    int joinGroup(String g_id, String s_id);
}
