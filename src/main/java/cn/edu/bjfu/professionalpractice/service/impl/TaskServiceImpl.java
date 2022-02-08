package cn.edu.bjfu.professionalpractice.service.impl;

import cn.edu.bjfu.professionalpractice.entity.Task;
import cn.edu.bjfu.professionalpractice.mapper.TaskMapper;
import cn.edu.bjfu.professionalpractice.service.TaskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task> implements TaskService {
    @Autowired
    TaskMapper taskMapper;

    @Override
    public List<Task> queryTask(String g_id, String t_id, String t_name, String t_type, String s_id, String t_state) {
        if (t_name!=null)
            t_name= "%" + t_name + "%";
        return taskMapper.queryTask(g_id,t_id,t_name,t_type,s_id,t_state);
    }

    @Override
    public int updateTask(String t_id, String t_name, String t_type, String s_id, String t_state, float t_score, String t_evaluation) {
       // 判断是否为教师评分
        if (t_score>0){
            LocalDateTime t_evaluationTime = LocalDateTime.now();
            return taskMapper.updateTask_1(t_id,t_score,t_evaluation,t_evaluationTime);
        }
        else{
            LocalDateTime t_endModifyTime = LocalDateTime.now();
            return taskMapper.updateTask_2(t_id,t_name,t_type,s_id,t_state,t_endModifyTime);
        }
    }

    @Override
    public int deleteTask(String t_id) {
        Map<String,Object> map = new HashMap<>();
        map.put("t_id",t_id);
        return taskMapper.deleteByMap(map);
    }

}