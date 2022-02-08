package cn.edu.bjfu.professionalpractice.controller;


import cn.edu.bjfu.professionalpractice.common.Result;
import cn.edu.bjfu.professionalpractice.entity.StudentGroup;
import cn.edu.bjfu.professionalpractice.service.GroupService;
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
@RequestMapping("/group")
public class GroupController {
    @Autowired
    GroupService groupService;

    /**
     * 查询小组
     * @param
     * @return Result
     */
    @GetMapping("/queryGroup")
    public Result queryGroup(String t_id, String c_id, String g_id, String g_name, String s_leader_id,String s_id) {
        List<StudentGroup> groupList = groupService.queryGroup(t_id,c_id,g_id,g_name,s_leader_id,s_id);
        return Result.succ(MapUtil.builder()
                .put("groupList", groupList)
                .put("total", groupList.size())
                .map()
        );
    }

    /**
     * 添加小组
     * @param
     * @return Result
     */
    @PostMapping("/addGroup")
    public Result addGroup(@RequestBody Map<String,String> params) throws ParseException {
        int n = groupService.addGroup(
                params.get("c_id"),params.get("g_id"),
                params.get("g_name"),params.get("s_leader_id"));
        return Result.succ(MapUtil.builder()
                .map()
        );
    }

    /**
     * 删除小组
     * @param
     * @return Result
     */
    @PostMapping("/deleteGroup")
    public Result deleteGroup(@RequestBody Map<String,String> params) {
        int n = groupService.deleteGroup(params.get("g_id"));
        return Result.succ(MapUtil.builder()
                .map()
        );
    }

    /**
     * 修改小组
     * @param
     * @return Result
     */
    @PostMapping("/updateGroup")
    public Result updateGroup(@RequestBody Map<String,String> params) {
        int n = groupService.updateGroup(
                params.get("c_id"),params.get("g_id"),
                params.get("g_name"),params.get("s_leader_id"));
        return Result.succ(MapUtil.builder()
                .map()
        );
    }
    /**
     * 加入小组
     * @param
     * @return Result
     */
    @PostMapping("/joinGroup")
    public Result joinGroup(@RequestBody Map<String,String> params) {
        try {
            int n = groupService.joinGroup(
                    params.get("g_id"),params.get("s_id"));
            if (n!=0){
                return Result.succ(MapUtil.builder()
                        .map()
                );
            }
        }catch (Exception e){
            return Result.fail("");
        }
        return Result.fail("");
    }
}
