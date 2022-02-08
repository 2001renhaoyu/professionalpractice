package cn.edu.bjfu.professionalpractice.controller;


import cn.edu.bjfu.professionalpractice.common.Result;
import cn.edu.bjfu.professionalpractice.entity.Course;
import cn.edu.bjfu.professionalpractice.entity.Teacher;
import cn.edu.bjfu.professionalpractice.service.CourseService;
import cn.edu.bjfu.professionalpractice.service.TeacherService;
import cn.hutool.core.map.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author renhaoyu
 * @since 2021-12-21
 */
@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    CourseService courseService;

    /**
     * 查询课程
     * @param
     * @return Result
     */
    @GetMapping("/queryCourse")
    public Result queryCourse(String c_id, String c_name, String t_id,String c_isArchive,String s_id) {
        List<Course> courseList = courseService.queryCourse(c_id,c_name,t_id,c_isArchive,s_id);
        return Result.succ(MapUtil.builder()
                .put("courseList", courseList)
                .put("total", courseList.size())
                .map()
        );
    }

    /**
     * 修改课程
     * @param
     * @return Result
     */
    @PostMapping("/updateCourse")
    public Result updateCourse(@RequestBody Map<String,String> params) {
        int n = courseService.updateCourse(
                params.get("c_id"),params.get("c_name"),
                LocalDateTime.parse(params.get("c_startTime")),params.get("t_id"),
                params.get("c_isArchive"));
        return Result.succ(MapUtil.builder()
                .map()
        );
    }

    /**
     * 添加课程
     * @param
     * @return Result
     */
    @PostMapping("/addCourse")
    public Result addCourse(@RequestBody Map<String,String> params) throws ParseException {
        int n = courseService.addCourse(
                params.get("c_id"),params.get("c_name"),
                stringToLocalDateTime(params.get("c_startTime")),params.get("t_id"));
        return Result.succ(MapUtil.builder()
                .map()
        );
    }
    /**
     * 删除课程
     * @param
     * @return Result
     */
    @PostMapping("/deleteCourse")
    public Result deleteCourse(@RequestBody Map<String,String> params) {
        int n = courseService.deleteCourse(params.get("c_id"));
        return Result.succ(MapUtil.builder()
                .map()
        );
    }

    private LocalDateTime stringToLocalDateTime(String dateString) throws ParseException {
        dateString = dateString.replace("Z", " UTC");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
        Date date = format.parse(dateString);
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
        return localDateTime;
    }

}
