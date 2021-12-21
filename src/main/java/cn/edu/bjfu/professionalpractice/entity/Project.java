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

    private String pId;

    private String pName;

    private String pContent;

    @TableField("p_numPeople")
    private Integer pNumpeople;

    private String pInstructions;

    private String cId;


}
