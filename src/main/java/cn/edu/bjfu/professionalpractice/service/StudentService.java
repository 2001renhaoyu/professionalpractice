package cn.edu.bjfu.professionalpractice.service;

import cn.edu.bjfu.professionalpractice.entity.Student;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author renhaoyu
 * @since 2021-12-21
 */
public interface StudentService extends IService<Student> {

    List<Student> queryStudent(String c_id, String s_id, String s_sex, String s_isDel, String s_major, String s_class, String s_name, String s_phone, String g_id);

    int readExcel(MultipartFile file,String c_id);

    int addStudent(String c_id,String s_id, String s_name, String s_sex, String s_class, String s_major, String s_phone);

    int deleteStudent(String s_id);

    int updateStudent(String s_id, String s_name, String s_sex, String s_class, String s_major, String s_phone);
}

