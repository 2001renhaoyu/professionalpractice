package cn.edu.bjfu.professionalpractice.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("CourseCase")
public class CourseCase implements Serializable {

    private static final long serialVersionUID = 1L;

    private String case_id;

    private String case_name;

    private String c_id;

    @TableField("case_isDel")
    private String case_isDel;


}
