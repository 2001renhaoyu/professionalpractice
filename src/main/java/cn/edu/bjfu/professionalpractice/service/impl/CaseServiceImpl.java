package cn.edu.bjfu.professionalpractice.service.impl;

import cn.edu.bjfu.professionalpractice.entity.CourseCase;
import cn.edu.bjfu.professionalpractice.entity.Project;
import cn.edu.bjfu.professionalpractice.mapper.CaseMapper;
import cn.edu.bjfu.professionalpractice.service.CaseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author renhaoyu
 * @since 2021-12-21
 */
@Service
public class CaseServiceImpl extends ServiceImpl<CaseMapper, CourseCase> implements CaseService {
    @Autowired
    CaseMapper caseMapper;

    @Override
    public List<CourseCase> queryCase(String t_id, String case_id, String case_name, String case_isDel, String c_id) {
        if (case_name!=null)
            case_name= "%" + case_name + "%";
        return caseMapper.queryCase(t_id,case_id,case_name,case_isDel,c_id);
    }

    @Override
    public int deleteCase(String case_id) {
        Map<String,Object> map = new HashMap<>();
        map.put("case_id",case_id);
        return caseMapper.deleteByMap(map);
    }

    @Override
    public int addCase(String case_id, String case_name, String c_id, String case_isDel) {
        CourseCase courseCase = new CourseCase();
        courseCase.setCase_id(case_id);
        courseCase.setCase_name(case_name);
        courseCase.setC_id(c_id);
        courseCase.setCase_isDel(case_isDel);
        return caseMapper.insert(courseCase);
    }

    @Override
    public int updateCase(String case_id, String case_name, String c_id, String case_isDel) {
        return caseMapper.updateCase(case_id,case_name,c_id,case_isDel);
    }
}
