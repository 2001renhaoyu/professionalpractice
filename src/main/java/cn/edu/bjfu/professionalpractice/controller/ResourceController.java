package cn.edu.bjfu.professionalpractice.controller;


import cn.edu.bjfu.professionalpractice.common.Result;
import cn.edu.bjfu.professionalpractice.entity.Resource;
import cn.edu.bjfu.professionalpractice.service.ResourceService;
import cn.hutool.core.map.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author renhaoyu
 * @since 2021-12-21
 */
@RestController
@RequestMapping("/resource")
public class ResourceController {
    @Autowired
    ResourceService resourceService;
    /**
     * 查询资源
     * @param
     * @return Result
     */
    @GetMapping("/queryResource")
    public Result queryResource(String case_id) {
        List<Resource> resourceList = resourceService.queryResource(case_id);
        return Result.succ(MapUtil.builder()
                .put("resourceList", resourceList)
                .put("total", resourceList.size())
                .map()
        );
    }
    /**
     * 上传资源
     * @param
     * @return Result
     */
    @PostMapping("/upload")
    public Result upload(@RequestParam MultipartFile file, String case_id){
        int uploadNum = resourceService.upload(file,case_id);
        return Result.succ(MapUtil.builder()
                .put("uploadNum", uploadNum)
                .map()
        );
    }

    /**
     * 下载资源
     * @param
     * @return Result
     */
    @PostMapping("/downloadResource")
    public void downloadResource(@RequestBody Map<String, String> params, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String r_name = params.get("r_name");
        String r_type = params.get("r_type");
        String r_physicalLocation = params.get("r_physicalLocation");

        // 通过文件路径和文件名得到file对象
        File file = new File(r_physicalLocation);
        // 判断是否存在，并且是一个标准文件
        if (file.exists() && file.isFile()){
            // 设置响应数据的 MIME 类型
            response.setContentType(r_type);

            // 判断浏览器是否是 IE
            String userAgent = request.getHeader("User-Agent");
            if (userAgent.contains("MSIE")) {
                // IE
                // 设置文件的名称
                response.setHeader("Content-Disposition", "attachment; fileName="
                        + URLEncoder.encode(r_name, "UTF-8"));
            } else {
                // 非IE
                response.setHeader("Content-Disposition", "attachment; fileName="
                        + new String(r_name.getBytes("UTF-8"), "ISO-8859-1"));
            }
            ServletOutputStream out = response.getOutputStream();
            // 将文件复制到输出流中，响应给浏览器
            Files.copy(Paths.get(file.getAbsolutePath()), out);
            out.close();
        }
    }

    /**
     * 删除项目
     * @param
     * @return Result
     */
    @PostMapping("/deleteResource")
    public Result deleteResource(@RequestBody Map<String, UUID> params) {
        int n = resourceService.deleteResource(String.valueOf(params.get("r_id")));
        return Result.succ(MapUtil.builder()
                .map()
        );
    }
}
