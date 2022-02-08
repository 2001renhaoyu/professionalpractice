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
@TableName("Project")
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;

    private String p_id;

    private String p_name;

    private String p_content;

    @TableField("p_numPeople")
    private Integer p_numPeople;

    private String p_instructions;

    private String c_id;


}
