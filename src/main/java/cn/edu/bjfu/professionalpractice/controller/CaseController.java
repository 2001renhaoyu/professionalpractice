package cn.edu.bjfu.professionalpractice.controller;


import cn.edu.bjfu.professionalpractice.common.Result;
import cn.edu.bjfu.professionalpractice.entity.CourseCase;
import cn.edu.bjfu.professionalpractice.service.CaseService;
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
@RequestMapping("/case")
public class CaseController {
    @Autowired
    CaseService caseService;

    /**
     * 查询案例
     * @param
     * @return Result
     */
    @GetMapping("/queryCase")
    public Result queryCase(String t_id,String case_id, String case_name, String case_isDel, String c_id) {
        List<CourseCase> caseList = caseService.queryCase(t_id,case_id,case_name,case_isDel,c_id);
        return Result.succ(MapUtil.builder()
                .put("caseList", caseList)
                .put("total", caseList.size())
                .map()
        );
    }
    /**
     * 添加案例
     * @param
     * @return Result
     */
    @PostMapping("/addCase")
    public Result addCase(@RequestBody Map<String,String> params) throws ParseException {
        int n = caseService.addCase(
                params.get("case_id"),params.get("case_name"),
                params.get("c_id"),params.get("case_isDel"));
        return Result.succ(MapUtil.builder()
                .map()
        );
    }

    /**
     * 删除案例
     * @param
     * @return Result
     */
    @PostMapping("/deleteCase")
    public Result deleteCase(@RequestBody Map<String,String> params) {
        int n = caseService.deleteCase(params.get("case_id"));
        return Result.succ(MapUtil.builder()
                .map()
        );
    }

    /**
     * 修改案例
     * @param
     * @return Result
     */
    @PostMapping("/updateCase")
    public Result updateCase(@RequestBody Map<String,String> params) {
        int n = caseService.updateCase(
                params.get("case_id"),params.get("case_name"),
                params.get("c_id"),params.get("case_isDel"));
        return Result.succ(MapUtil.builder()
                .map()
        );
    }
}
