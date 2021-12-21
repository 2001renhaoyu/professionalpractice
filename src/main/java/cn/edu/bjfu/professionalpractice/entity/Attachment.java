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

    private String aId;

    private String tId;

    @TableField("a_physicalLocation")
    private String aPhysicallocation;

    @TableField("a_upTime")
    private LocalDateTime aUptime;


}
