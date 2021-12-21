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

    private String sId;

    private String sName;

    private String sSex;

    private String sPhone;

    private String sMajor;

    @TableField("s_startTime")
    private LocalDateTime sStarttime;

    private String sClass;

    @TableField("s_isDel")
    private String sIsdel;


}
