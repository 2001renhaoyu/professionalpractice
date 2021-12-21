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

    private String cId;

    private String cName;

    @TableField("c_startTime")
    private LocalDateTime cStarttime;

    private String tId;

    @TableField("c_isArchive")
    private String cIsarchive;


}
