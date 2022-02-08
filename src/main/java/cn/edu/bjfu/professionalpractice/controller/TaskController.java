package cn.edu.bjfu.professionalpractice.controller;


import cn.edu.bjfu.professionalpractice.common.Result;
import cn.edu.bjfu.professionalpractice.entity.Task;
import cn.edu.bjfu.professionalpractice.service.TaskService;
import cn.hutool.core.map.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
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
@RequestMapping("/task")
public class TaskController {
    @Autowired
    TaskService taskService;

    /**
     * 查询任务
     * @param
     * @return Result
     */
    @GetMapping("/queryTask")
    public Result queryTask(String g_id,String t_id, String t_name, String t_type,String s_id,String t_state) {
        List<Task> taskList = taskService.queryTask(g_id,t_id,t_name,t_type,s_id,t_state);
        return Result.succ(MapUtil.builder()
                .put("taskList", taskList)
                .put("total", taskList.size())
                .map()
        );
    }

    /**
     * 添加任务
     * @param
     * @return Result
     */
//    @PostMapping("/addTask")
//    public Result addTask(@RequestBody Map<String,String> params) throws ParseException {
//        int n = taskService.addTask(
//                params.get("p_id"),params.get("p_name"),
//                params.get("p_content"),params.get("p_numPeople"),
//                params.get("p_instructions"),params.get("c_id"));
//        return Result.succ(MapUtil.builder()
//                .map()
//        );
//    }

    /**
     * 删除任务
     * @param
     * @return Result
     */
    @PostMapping("/deleteTask")
    public Result deleteTask(@RequestBody Map<String,String> params) {
        int n = taskService.deleteTask(params.get("t_id"));
        return Result.succ(MapUtil.builder()
                .map()
        );
    }

    /**
     * 修改任务
     * @param
     * @return Result
     */
    @PostMapping("/updateTask")
    public Result updateTask(@RequestBody Map<String,String> params) {
        float t_score = -1;
        if (params.get("t_score")!=null){
            t_score = Float.parseFloat(params.get("t_score"));
        }
        int n = taskService.updateTask(
                params.get("t_id"),params.get("t_name"),
                params.get("t_type"),params.get("s_id"),
                params.get("t_state"),t_score,params.get("t_evaluation"));
        return Result.succ(MapUtil.builder()
                .map()
        );
    }

}
