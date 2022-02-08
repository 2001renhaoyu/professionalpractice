package cn.edu.bjfu.professionalpractice.service;

import cn.edu.bjfu.professionalpractice.entity.Task;
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
public interface TaskService extends IService<Task> {

    List<Task> queryTask(String g_id, String t_id, String t_name, String t_type, String s_id, String t_state);

    int updateTask(String t_id, String t_name, String t_type, String s_id, String t_state, float t_score, String t_evaluation);

    int deleteTask(String t_id);

}
