package cn.edu.bjfu.professionalpractice.controller;


import cn.edu.bjfu.professionalpractice.common.Result;
import cn.edu.bjfu.professionalpractice.entity.Project;
import cn.edu.bjfu.professionalpractice.entity.Teacher;
import cn.edu.bjfu.professionalpractice.service.ProjectService;
import cn.edu.bjfu.professionalpractice.service.TeacherService;
import cn.hutool.core.map.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    ProjectService projectService;

    /**
     * 查询项目
     * @param
     * @return Result
     */
    @GetMapping("/queryProject")
    public Result queryProject(String t_id, String p_id, String c_id,Integer p_numPeople, String p_name, String p_content) {
        List<Project> projectList = projectService.queryProject(t_id,p_id,c_id,p_numPeople,p_name,p_content);
        return Result.succ(MapUtil.builder()
                .put("projectList", projectList)
                .put("total", projectList.size())
                .map()
        );
    }
    /**
     * 添加项目
     * @param
     * @return Result
     */
    @PostMapping("/addProject")
    public Result addProject(@RequestBody Map<String,String> params) throws ParseException {
        int n = projectService.addProject(
                params.get("p_id"),params.get("p_name"),
                params.get("p_content"),params.get("p_numPeople"),
                params.get("p_instructions"),params.get("c_id"));
        return Result.succ(MapUtil.builder()
                .map()
        );
    }

    /**
     * 删除项目
     * @param
     * @return Result
     */
    @PostMapping("/deleteProject")
    public Result deleteProject(@RequestBody Map<String,String> params) {
        int n = projectService.deleteProject(params.get("p_id"));
        return Result.succ(MapUtil.builder()
                .map()
        );
    }

    /**
     * 修改项目
     * @param
     * @return Result
     */
    @PostMapping("/updateProject")
    public Result updateProject(@RequestBody Map<String,String> params) {
        int n = projectService.updateProject(
                params.get("p_id"),params.get("p_name"),
                params.get("p_content"),params.get("p_numPeople"),
                params.get("p_instructions"),params.get("c_id"));
        return Result.succ(MapUtil.builder()
                .map()
        );
    }
}
