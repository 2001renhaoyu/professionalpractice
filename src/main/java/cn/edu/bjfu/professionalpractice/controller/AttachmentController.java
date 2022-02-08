package cn.edu.bjfu.professionalpractice.controller;


import cn.edu.bjfu.professionalpractice.common.Result;
import cn.edu.bjfu.professionalpractice.entity.Attachment;
import cn.edu.bjfu.professionalpractice.entity.Course;
import cn.edu.bjfu.professionalpractice.service.AttachmentService;
import cn.edu.bjfu.professionalpractice.service.CourseService;
import cn.hutool.core.map.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author renhaoyu
 * @since 2021-12-21
 */
@RestController
@RequestMapping("/attachment")
public class AttachmentController {
    @Autowired
    AttachmentService attachmentService;

    /**
     * 获取附件
     * @param
     * @return Result
     */
    @GetMapping("/queryAttachment")
    public Result queryAttachment(String t_id) {
        List<Attachment> attachmentList = attachmentService.queryAttachment(t_id);
        if (attachmentList.size()==0){
            return Result.succ(MapUtil.builder()
                    .map()
            );
        }
        return Result.succ(MapUtil.builder()
                .put("attachment", attachmentList.get(0))
                .map()
        );
    }

    /**
     * 上传资源
     * @param
     * @return Result
     */
    @PostMapping("/upload")
    public Result upload(@RequestParam MultipartFile file, String t_id){
        int uploadNum = attachmentService.upload(file,t_id);
        return Result.succ(MapUtil.builder()
                .put("uploadNum", uploadNum)
                .map()
        );
    }
}
