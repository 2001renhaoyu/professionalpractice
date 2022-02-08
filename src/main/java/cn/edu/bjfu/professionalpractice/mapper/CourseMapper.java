package cn.edu.bjfu.professionalpractice.mapper;

import cn.edu.bjfu.professionalpractice.entity.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
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
public interface CourseMapper extends BaseMapper<Course> {

    List<Course> queryCourse(String c_id, String c_name, String t_id, String c_isArchive, String s_id);

    int updateCourse(String c_id, String c_name, LocalDateTime c_startTime, String t_id, String c_isArchive);

}
