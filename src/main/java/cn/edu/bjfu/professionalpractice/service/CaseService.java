package cn.edu.bjfu.professionalpractice.service;

import cn.edu.bjfu.professionalpractice.entity.CourseCase;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author renhaoyu
 * @since 2021-12-21
 */
public interface CaseService extends IService<CourseCase> {

    List<CourseCase> queryCase(String t_id, String case_id, String case_name, String case_isDel, String c_id);

    int deleteCase(String case_id);

    int addCase(String case_id, String case_name, String c_id, String case_isDel);

    int updateCase(String case_id, String case_name, String c_id, String case_isDel);
}
