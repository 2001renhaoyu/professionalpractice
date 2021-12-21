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
@TableName("Resource")
public class Resource implements Serializable {

    private static final long serialVersionUID = 1L;

    private String rId;

    private String rName;

    private String rType;

    private String caseId;

    @TableField("r_physicalLocation")
    private String rPhysicallocation;


}
