package cn.edu.bjfu.professionalpractice.mapper;

import cn.edu.bjfu.professionalpractice.entity.Student;
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
public interface StudentMapper extends BaseMapper<Student> {

    List<Student> queryStudent(String c_id, String s_id, String s_sex, String s_isDel, String s_major, String s_class, String s_name, String s_phone, String g_id);

    int updateStudent(String s_id, String s_name, String s_sex, String s_class, String s_major, String s_phone);

    int deleteStudent(String s_id);

}
