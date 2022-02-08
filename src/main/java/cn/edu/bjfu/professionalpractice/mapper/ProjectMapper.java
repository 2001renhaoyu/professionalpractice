package cn.edu.bjfu.professionalpractice.mapper;

import cn.edu.bjfu.professionalpractice.entity.Project;
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
public interface ProjectMapper extends BaseMapper<Project> {

    List<Project> queryProject(String t_id, String p_id, String c_id, Integer p_numPeople, String p_name, String p_content);

    int updateProject(String p_id, String p_name, String p_content, Integer p_numPeople, String p_instructions, String c_id);
}
