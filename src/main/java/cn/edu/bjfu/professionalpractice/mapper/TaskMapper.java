package cn.edu.bjfu.professionalpractice.mapper;

import cn.edu.bjfu.professionalpractice.entity.Task;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
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
public interface TaskMapper extends BaseMapper<Task> {

    List<Task> queryTask(String g_id, String t_id, String t_name, String t_type, String s_id, String t_state);

    int updateTask_1(String t_id, float t_score, String t_evaluation, LocalDateTime t_evaluationTime);

    int updateTask_2(String t_id, String t_name, String t_type, String s_id, String t_state, LocalDateTime t_endModifyTime);

}
