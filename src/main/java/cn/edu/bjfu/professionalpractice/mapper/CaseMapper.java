package cn.edu.bjfu.professionalpractice.mapper;

import cn.edu.bjfu.professionalpractice.entity.CourseCase;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author renhaoyu
 * @since 2021-12-21
 */
@Repository
public interface CaseMapper extends BaseMapper<CourseCase> {

    List<CourseCase> queryCase(String t_id, String case_id, String case_name, String case_isDel, String c_id);

    int updateCase(String case_id, String case_name, String c_id, String case_isDel);
}
