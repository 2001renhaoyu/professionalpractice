package cn.edu.bjfu.professionalpractice.controller;


import cn.edu.bjfu.professionalpractice.common.Result;
import cn.edu.bjfu.professionalpractice.entity.Usertable;
import cn.edu.bjfu.professionalpractice.service.StudentService;
import cn.edu.bjfu.professionalpractice.service.TeacherService;
import cn.edu.bjfu.professionalpractice.service.UsertableService;
import cn.hutool.core.map.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
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
@RequestMapping("/usertable")
public class UsertableController {

    @Autowired
    UsertableService usertableService;

    @Autowired
    StudentService studentService;

    @Autowired
    TeacherService teacherService;


    /**
     * 登陆
     * @param
     * @return Result
     */
    @PostMapping("/loginById")
    public Result loginById(@RequestBody Map<String,String> params) {
        try {
            Usertable one = usertableService.login(params.get("username"),params.get("password"));
            ArrayList<String> role = new ArrayList<String>();
            role.add(one.getuType());
            return Result.succ(MapUtil.builder()
                    .put("uid", one.getuId())
                    .put("token", one.getuType())
                    .put("role", role)
                    .map()
            );
        }
        catch (NullPointerException e){
            return Result.succ(MapUtil.builder()
                            .map()
            );
        }

    }

    /**
     * 获取用户信息
     * @param
     * @return Result
     */
    @GetMapping("/getInfo")
    public Result getInfo(String token) {

        ArrayList<String> role = new ArrayList<String>();
        role.add(token);

        // 为了简便，每个角色role只有一种，其值为其类型
        if (token.equals("admin")){
            return Result.succ(MapUtil.builder()
                    .put("role", role)
                    .map()
            );
        }
        else if(token.equals("student")){
            return Result.succ(MapUtil.builder()
                    .put("role", role)
                    .map()
            );
        }
        else if(token.equals("teacher")){
            return Result.succ(MapUtil.builder()
                    .put("role", role)
                    .map()
            );
        }
        return Result.fail("权限错误");
    }
    /**
     * 退出登陆
     * @param
     * @return Result
     */
    @PostMapping("/logout")
    public Result logout() {
        return Result.succ(MapUtil.builder()
                .map()
        );
    }
}
