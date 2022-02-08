package cn.edu.bjfu.professionalpractice.controller;


import cn.edu.bjfu.professionalpractice.common.Result;
import cn.edu.bjfu.professionalpractice.entity.Project;
import cn.edu.bjfu.professionalpractice.entity.Student;
import cn.edu.bjfu.professionalpractice.service.ProjectService;
import cn.edu.bjfu.professionalpractice.service.StudentService;
import cn.hutool.core.map.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;
import java.time.LocalDateTime;
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
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    /**
     * 查询学生
     * @param
     * @return Result
     */
    @GetMapping("/queryStudent")
    public Result queryStudent(String c_id, String s_id, String s_sex,String s_isDel, String s_major,String s_class, String s_name, String s_phone,String g_id) {
        List<Student> studentList = studentService.queryStudent(c_id,s_id,s_sex,s_isDel,s_major,s_class,s_name,s_phone,g_id);
        return Result.succ(MapUtil.builder()
                .put("studentList", studentList)
                .put("total", studentList.size())
                .map()
        );
    }
    /**
     * 导入学生
     * @param
     * @return Result
     */
    @PostMapping("/importStudent")
    public Result importStudent(@RequestParam MultipartFile file,String c_id){
        int importNum = studentService.readExcel(file,c_id);
        return Result.succ(MapUtil.builder()
                .put("importNum", importNum)
                .map()
        );
    }

    /**
     * 修改学生
     * @param
     * @return Result
     */
    @PostMapping("/updateStudent")
    public Result updateStudent(@RequestBody Map<String,String> params) {
        int n = studentService.updateStudent(
                params.get("s_id"),params.get("s_name"),
                params.get("s_sex"),params.get("s_class"),
                params.get("s_major"),params.get("s_phone"));
        return Result.succ(MapUtil.builder()
                .map()
        );
    }

    /**
     * 添加学生
     * @param
     * @return Result
     */
    @PostMapping("/addStudent")
    public Result addStudent(@RequestBody Map<String,String> params)  {
        int n = studentService.addStudent(params.get("c_id"),
                params.get("s_id"),params.get("s_name"),
                params.get("s_sex"),params.get("s_class"),
                params.get("s_major"),params.get("s_phone"));
        return Result.succ(MapUtil.builder()
                .map()
        );
    }
    /**
     * 删除学生
     * @param
     * @return Result
     */
    @PostMapping("/deleteStudent")
    public Result deleteStudent(@RequestBody Map<String,String> params) {
        int n = studentService.deleteStudent(params.get("s_id"));
        return Result.succ(MapUtil.builder()
                .map()
        );
    }

}
