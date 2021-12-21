package cn.edu.bjfu.professionalpractice.service.impl;

import cn.edu.bjfu.professionalpractice.entity.Student;
import cn.edu.bjfu.professionalpractice.mapper.StudentMapper;
import cn.edu.bjfu.professionalpractice.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author renhaoyu
 * @since 2021-12-21
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}
