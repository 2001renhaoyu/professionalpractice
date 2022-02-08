package cn.edu.bjfu.professionalpractice.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author renhaoyu
 * @since 2021-12-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("Task")
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;

    private String t_id;

    private String t_name;

    private String t_content;

    private String t_type;

    private String s_id;

    @TableField("t_startTime")
    private LocalDateTime t_startTime;

    private String t_state;

    @TableField("t_endModifyTime")
    private LocalDateTime t_endModifyTime;

    private Float t_score;

    private String t_evaluation;

    @TableField("t_evaluationTime")
    private LocalDateTime t_evaluationTime;


}
