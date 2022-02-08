package cn.edu.bjfu.professionalpractice.service;

import cn.edu.bjfu.professionalpractice.entity.Resource;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author renhaoyu
 * @since 2021-12-21
 */
public interface ResourceService extends IService<Resource> {

    int upload(MultipartFile multipartFile, String case_id);

    List<Resource> queryResource(String case_id);

    int deleteResource(String r_id);
}
