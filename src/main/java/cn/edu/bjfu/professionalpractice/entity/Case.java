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
@TableName("Case")
public class Case implements Serializable {

    private static final long serialVersionUID = 1L;

    private String caseId;

    private String caseName;

    private String cId;

    @TableField("case_isDel")
    private String caseIsdel;


}
