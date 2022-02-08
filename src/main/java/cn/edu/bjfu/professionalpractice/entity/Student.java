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
@TableName("Student")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    private String s_id;

    private String s_name;

    private String s_sex;

    private String s_phone;

    private String s_major;

    @TableField("s_startTime")
    private LocalDateTime s_startTime;

    private String s_class;

    @TableField("s_isDel")
    private String s_isDel;


}
