package cn.edu.bjfu.professionalpractice.service.impl;

import cn.edu.bjfu.professionalpractice.entity.Teacher;
import cn.edu.bjfu.professionalpractice.mapper.TeacherMapper;
import cn.edu.bjfu.professionalpractice.mapper.UsertableMapper;
import cn.edu.bjfu.professionalpractice.service.TeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author renhaoyu
 * @since 2021-12-21
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

    @Autowired
    TeacherMapper teacherMapper;

    @Autowired
    UsertableMapper usertableMapper;

    @Override
    public List<Teacher> queryTeacher(String t_id, String t_name, String t_phone) {
        if (t_name!=null)
            t_name= "%" + t_name + "%";
        if (t_phone!=null)
            t_phone= "%" + t_phone + "%";
        return teacherMapper.queryTeacher(t_id,t_name,t_phone);
    }

    @Override
    public int addTeacher(String t_id, String t_name, String t_phone) {
        usertableMapper.addUser(t_id,"teacher");
        return teacherMapper.addTeacher(t_id,t_name,t_phone);
    }

    @Override
    public int updateTeacher(String t_id, String t_name, String t_phone) {
        return teacherMapper.updateTeacher(t_id,t_name,t_phone);
    }

}
