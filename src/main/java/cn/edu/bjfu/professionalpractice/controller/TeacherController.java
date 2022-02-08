package cn.edu.bjfu.professionalpractice.controller;


import cn.edu.bjfu.professionalpractice.common.Result;
import cn.edu.bjfu.professionalpractice.entity.Teacher;
import cn.edu.bjfu.professionalpractice.service.TeacherService;
import cn.hutool.core.map.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    /**
     * 查询教师
     * @param
     * @return Result
     */
    @GetMapping("/queryTeacher")
    public Result queryTeacher(String t_id, String t_name, String t_phone) {
        List<Teacher> teacherList = teacherService.queryTeacher(t_id,t_name,t_phone);
        return Result.succ(MapUtil.builder()
                .put("teacherList", teacherList)
                .put("total", teacherList.size())
                .map()
        );
    }

    /**
     * 添加教师
     * @param
     * @return Result
     */
    @PostMapping("/addTeacher")
    public Result addTeacher(@RequestBody Map<String,String> params) {
        int n = teacherService.addTeacher(params.get("t_id"),params.get("t_name"),params.get("t_phone"));
        return Result.succ(MapUtil.builder()
                .map()
        );
    }

    /**
     * 修改教师
     * @param
     * @return Result
     */
    @PostMapping("/updateTeacher")
    public Result updateTeacher(@RequestBody Map<String,String> params) {
        int n = teacherService.updateTeacher(params.get("t_id"),params.get("t_name"),params.get("t_phone"));
        return Result.succ(MapUtil.builder()
                .map()
        );
    }
}
