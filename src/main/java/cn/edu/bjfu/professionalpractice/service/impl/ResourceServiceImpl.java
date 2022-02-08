package cn.edu.bjfu.professionalpractice.service.impl;

import cn.edu.bjfu.professionalpractice.entity.Resource;
import cn.edu.bjfu.professionalpractice.mapper.CourseMapper;
import cn.edu.bjfu.professionalpractice.mapper.ResourceMapper;
import cn.edu.bjfu.professionalpractice.service.ResourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource> implements ResourceService {

    private  final static String rootPath = "D:/uploadFiles";

    @Autowired
    ResourceMapper resourceMapper;

    @Override
    public int upload(MultipartFile multipartFile,String case_id) {
        try {
            if (multipartFile != null ) {
                // 获取当前系统时间的年月日
                LocalDate now = LocalDate.now();
                int year = now.getYear();
                int month = now.getMonthValue();
                int day = now.getDayOfMonth();
                String path = rootPath+ File.separator + year + File.separator + month + File.separator + day;
                // 创建父目录
                File parentDir = new File(path);
                // 如果父目录不存在，则创建
                if (!parentDir.exists()) {
                    parentDir.mkdirs();
                }
                try {
                    String r_id = String.valueOf(UUID.randomUUID());
                    String storagePath = path +File.separator + r_id + multipartFile.getOriginalFilename();
                    multipartFile.transferTo(new File(storagePath));

                    Resource resource = new Resource();
                    resource.setCase_id(case_id);
                    resource.setR_name(multipartFile.getOriginalFilename());
                    resource.setR_physicalLocation(storagePath);
                    resource.setR_type(multipartFile.getContentType());
                    resource.setR_id(r_id);
                    resourceMapper.insert(resource);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public List<Resource> queryResource(String case_id) {
        return resourceMapper.queryResource(case_id);
    }

    @Override
    public int deleteResource(String r_id) {
        Map<String,Object> map = new HashMap<>();
        map.put("r_id",r_id);
        return resourceMapper.deleteByMap(map);
    }

}
