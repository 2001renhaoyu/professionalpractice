package cn.edu.bjfu.professionalpractice.service.impl;

import cn.edu.bjfu.professionalpractice.entity.Course;
import cn.edu.bjfu.professionalpractice.mapper.CourseMapper;
import cn.edu.bjfu.professionalpractice.service.CourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {
    @Autowired
    CourseMapper courseMapper;

    @Override
    public List<Course> queryCourse(String c_id, String c_name, String t_id, String c_isArchive, String s_id) {
        if (c_name!=null)
            c_name= "%" + c_name + "%";
        return courseMapper.queryCourse(c_id,c_name,t_id,c_isArchive,s_id);
    }

    @Override
    public int updateCourse(String c_id, String c_name, LocalDateTime c_startTime, String t_id, String c_isArchive) {
        return courseMapper.updateCourse(c_id,c_name,c_startTime,t_id,c_isArchive);
    }

    @Override
    public int addCourse(String c_id, String c_name, LocalDateTime c_startTime, String t_id) {
        Course course = new Course();
        course.setC_id(c_id);
        course.setC_name(c_name);
        course.setC_startTime(c_startTime);
        course.setT_id(t_id);
        return courseMapper.insert(course);
    }

    @Override
    public int deleteCourse(String c_id) {
        Map<String,Object>map = new HashMap<>();
        map.put("c_id",c_id);
        return courseMapper.deleteByMap(map);
    }
}
