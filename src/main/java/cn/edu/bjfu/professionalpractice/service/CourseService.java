package cn.edu.bjfu.professionalpractice.service;

import cn.edu.bjfu.professionalpractice.entity.Course;
import com.baomidou.mybatisplus.extension.service.IService;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author renhaoyu
 * @since 2021-12-21
 */
public interface CourseService extends IService<Course> {

    List<Course> queryCourse(String c_id, String c_name, String t_id, String c_isArchive, String s_id);

    int updateCourse(String c_id, String c_name, LocalDateTime c_startTime, String t_id, String c_isArchive);

    int addCourse(String c_id, String c_name, LocalDateTime c_startTime, String t_id);

    int deleteCourse(String c_id);
}
