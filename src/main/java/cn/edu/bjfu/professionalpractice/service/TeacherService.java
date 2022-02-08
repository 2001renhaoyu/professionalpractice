package cn.edu.bjfu.professionalpractice.service;

import cn.edu.bjfu.professionalpractice.entity.Teacher;
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
public interface TeacherService extends IService<Teacher> {
    List<Teacher> queryTeacher(String t_id, String t_name, String t_phone);

    int addTeacher(String t_id, String t_name, String t_phone);

    int updateTeacher(String t_id, String t_name, String t_phone);
}

