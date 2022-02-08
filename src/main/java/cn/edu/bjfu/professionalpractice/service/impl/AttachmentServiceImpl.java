package cn.edu.bjfu.professionalpractice.service.impl;

import cn.edu.bjfu.professionalpractice.entity.Attachment;
import cn.edu.bjfu.professionalpractice.entity.Resource;
import cn.edu.bjfu.professionalpractice.mapper.AttachmentMapper;
import cn.edu.bjfu.professionalpractice.mapper.CaseMapper;
import cn.edu.bjfu.professionalpractice.service.AttachmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author renhaoyu
 * @since 2021-12-21
 */
@Service
public class AttachmentServiceImpl extends ServiceImpl<AttachmentMapper, Attachment> implements AttachmentService {
    private  final static String rootPath = "D:/uploadAttachments";

    @Autowired
    AttachmentMapper attachmentMapper;

    @Override
    public List<Attachment> queryAttachment(String t_id) {
        return attachmentMapper.queryAttachment(t_id);
    }

    @Override
    public int upload(MultipartFile multipartFile, String t_id) {
        try {
            if (multipartFile != null) {
                // 获取当前系统时间的年月日
                LocalDate now = LocalDate.now();
                int year = now.getYear();
                int month = now.getMonthValue();
                int day = now.getDayOfMonth();
                String path = rootPath + File.separator + year + File.separator + month + File.separator + day;
                // 创建父目录
                File parentDir = new File(path);
                // 如果父目录不存在，则创建
                if (!parentDir.exists()) {
                    parentDir.mkdirs();
                }
                try {
                    String a_id = String.valueOf(UUID.randomUUID());
                    String storagePath = path + File.separator + a_id + multipartFile.getOriginalFilename();
                    multipartFile.transferTo(new File(storagePath));

                    Attachment attachment = new Attachment();
                    attachment.setA_id(a_id);
                    attachment.setA_uptime(now.atStartOfDay());
                    attachment.setT_id(t_id);
                    attachment.setA_physicalLocation(storagePath);
                    attachmentMapper.insert(attachment);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }
}
