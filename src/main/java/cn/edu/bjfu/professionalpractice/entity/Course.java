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
@TableName("Course")
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;

    private String c_id;

    private String c_name;

    @TableField("c_startTime")
    private LocalDateTime c_startTime;

    private String t_id;

    @TableField("c_isArchive")
    private String c_isArchive;


}
