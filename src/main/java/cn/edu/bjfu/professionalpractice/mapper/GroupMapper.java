package cn.edu.bjfu.professionalpractice.mapper;

import cn.edu.bjfu.professionalpractice.entity.StudentGroup;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author renhaoyu
 * @since 2021-12-21
 */
@Repository
public interface GroupMapper extends BaseMapper<StudentGroup> {

    List<StudentGroup> queryGroup(String t_id, String c_id, String g_id, String g_name, String s_leader_id, String s_id);

    int updateGroup(String c_id, String g_id, String g_name, String s_leader_id);

    int addGroup(String c_id, String g_id, String g_name, String s_leader_id);

    int joinGroup(String g_id, String s_id);
}
