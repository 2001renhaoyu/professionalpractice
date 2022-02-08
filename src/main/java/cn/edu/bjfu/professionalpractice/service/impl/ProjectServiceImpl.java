package cn.edu.bjfu.professionalpractice.service.impl;

import cn.edu.bjfu.professionalpractice.entity.Course;
import cn.edu.bjfu.professionalpractice.entity.Project;
import cn.edu.bjfu.professionalpractice.mapper.CourseMapper;
import cn.edu.bjfu.professionalpractice.mapper.ProjectMapper;
import cn.edu.bjfu.professionalpractice.service.ProjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author renhaoyu
 * @since 2021-12-21
 */
@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements ProjectService {

    @Autowired
    ProjectMapper projectMapper;

    @Override
    public List<Project> queryProject(String t_id, String p_id, String c_id, Integer p_numPeople, String p_name, String p_content) {
        if (p_name!=null)
            p_name= "%" + p_name + "%";
        if (p_content!=null)
            p_content= "%" + p_content + "%";
        return projectMapper.queryProject(t_id, p_id, c_id, p_numPeople, p_name, p_content);
    }

    @Override
    public int addProject(String p_id, String p_name, String p_content, String p_numPeople, String p_instructions, String c_id) {
        Project project = new Project();
        project.setP_id(p_id);
        project.setP_name(p_name);
        project.setP_content(p_content);
        project.setP_numPeople(Integer.valueOf(p_numPeople));
        project.setP_instructions(p_instructions);
        project.setC_id(c_id);
        return projectMapper.insert(project);

    }

    @Override
    public int deleteProject(String p_id) {
        Map<String,Object> map = new HashMap<>();
        map.put("p_id",p_id);
        return projectMapper.deleteByMap(map);
    }

    @Override
    public int updateProject(String p_id, String p_name, String p_content, String p_numPeople, String p_instructions, String c_id) {
        return projectMapper.updateProject(p_id,p_name,p_content,Integer.valueOf(p_numPeople),p_instructions,c_id);
    }
}
