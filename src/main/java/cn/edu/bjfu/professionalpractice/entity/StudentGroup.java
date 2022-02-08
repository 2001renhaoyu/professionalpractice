package cn.edu.bjfu.professionalpractice.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("StudentGroup")
public class StudentGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    private String g_id;

    private String g_name;

    private String s_leader_id;

    private String p_id;


}
