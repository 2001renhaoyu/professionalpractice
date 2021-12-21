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

    private String tId;

    private String tName;

    private String tContent;

    private String tType;

    private String sId;

    @TableField("t_startTime")
    private LocalDateTime tStarttime;

    private String tState;

    @TableField("t_endModifyTime")
    private LocalDateTime tEndmodifytime;

    private Float tScore;

    private String tEvaluation;

    @TableField("t_evaluationTime")
    private LocalDateTime tEvaluationtime;


}
