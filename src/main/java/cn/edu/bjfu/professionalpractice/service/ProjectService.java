package cn.edu.bjfu.professionalpractice.service;

import cn.edu.bjfu.professionalpractice.entity.Project;
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
public interface ProjectService extends IService<Project> {

    List<Project> queryProject(String t_id, String p_id, String c_id, Integer p_numPeople, String p_name, String p_content);

    int addProject(String p_id, String p_name, String p_content, String p_numPeople, String p_instructions, String c_id);

    int deleteProject(String p_id);

    int updateProject(String p_id, String p_name, String p_content, String p_numPeople, String p_instructions, String c_id);
}
