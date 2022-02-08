package cn.edu.bjfu.professionalpractice.mapper;

import cn.edu.bjfu.professionalpractice.entity.Teacher;
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
public interface TeacherMapper extends BaseMapper<Teacher> {
    List<Teacher> queryTeacher(String t_id, String t_name, String t_phone);

    int addTeacher(String t_id, String t_name, String t_phone);

    int updateTeacher(String t_id, String t_name, String t_phone);
}
