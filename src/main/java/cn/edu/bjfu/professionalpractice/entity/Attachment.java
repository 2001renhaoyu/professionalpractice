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
@TableName("Attachment")
public class Attachment implements Serializable {

    private static final long serialVersionUID = 1L;

    private String a_id;

    private String t_id;

    @TableField("a_physicalLocation")
    private String a_physicalLocation;

    @TableField("a_upTime")
    private LocalDateTime a_uptime;


}
