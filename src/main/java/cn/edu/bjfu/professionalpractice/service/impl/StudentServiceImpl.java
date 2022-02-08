package cn.edu.bjfu.professionalpractice.service.impl;

import cn.edu.bjfu.professionalpractice.entity.*;
import cn.edu.bjfu.professionalpractice.mapper.ScMapper;
import cn.edu.bjfu.professionalpractice.mapper.StudentMapper;
import cn.edu.bjfu.professionalpractice.mapper.UsertableMapper;
import cn.edu.bjfu.professionalpractice.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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
    @Autowired
    StudentMapper studentMapper;

    @Autowired
    UsertableMapper usertableMapper;

    @Autowired
    ScMapper scMapper;

    @Override
    public List<Student> queryStudent(String c_id, String s_id, String s_sex, String s_isDel, String s_major, String s_class, String s_name, String s_phone, String g_id) {
        if (s_major!=null)
            s_major= "%" + s_major + "%";
        if (s_class!=null)
            s_class= "%" + s_class + "%";
        if (s_name!=null)
            s_name= "%" + s_name + "%";
        if (s_phone!=null)
            s_phone= "%" + s_phone + "%";
        return studentMapper.queryStudent(c_id, s_id, s_sex, s_isDel, s_major, s_class,s_name,s_phone,g_id);
    }

    @Override
    public int readExcel(MultipartFile file,String c_id) {
        try {
            InputStream inputStream = file.getInputStream();
            String fileName = file.getOriginalFilename();
            Workbook work = getWorkbook(inputStream, fileName);
            if (null == work) {
                return -1;
            }

            Sheet sheet = null;
            Row row = null;
            Cell cell = null;
            int importNum = 0;

            for (int i = 0; i < work.getNumberOfSheets(); i++) {
                sheet = work.getSheetAt(i);
                if (sheet == null) {
                    continue;
                }

                for (int j = 1; j <= sheet.getLastRowNum(); j++) {
                    row = sheet.getRow(j);
                    if (row == null || row.getFirstCellNum() == j) {
                        continue;
                    }

                    List<String> li = new ArrayList<>();
                    for (int y = 1; y < row.getLastCellNum(); y++) {
                        cell = row.getCell(y);
                        li.add(cell.getStringCellValue());
                    }
                    Usertable userTable = new Usertable();
                    userTable.setuId(li.get(0));
                    userTable.setuPassword("123");
                    userTable.setuType("student");
                    try {
                        usertableMapper.insert(userTable);
                    } catch (Exception e) {

                    }
                    Student student = new Student();
                    student.setS_id(li.get(0));
                    student.setS_name(li.get(1));
                    if (li.get(3).equals("男"))
                        student.setS_sex("1");
                    else  student.setS_sex("0");
                    student.setS_class(li.get(3));
                    try {
                        studentMapper.insert(student);
                    } catch (Exception e) {

                    }
                    Sc sc = new Sc();
                    sc.setS_id(li.get(1));
                    sc.setC_id(c_id);
                    sc.setSc_isdel("0");
                    try {
                        importNum+=scMapper.insert(sc);
                    } catch (Exception e) {

                    }
                }
            }
            work.close();
            return importNum;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }


    @Override
    public int addStudent(String c_id,String s_id, String s_name, String s_sex, String s_class, String s_major, String s_phone) {
        Student student = new Student();
        student.setS_id(s_id);
        student.setS_name(s_name);
        student.setS_sex(s_sex);
        student.setS_class(s_class);
        student.setS_major(s_major);
        student.setS_phone(s_phone);
        student.setS_isDel("0");
        Sc sc = new Sc();
        sc.setS_id(s_id);
        sc.setC_id(c_id);
        sc.setSc_isdel("0");
        studentMapper.insert(student);
        return scMapper.insert(sc);
    }

    @Override
    public int deleteStudent(String s_id) {
        return studentMapper.deleteStudent(s_id);
    }

    @Override
    public int updateStudent(String s_id, String s_name, String s_sex, String s_class, String s_major, String s_phone) {
        return studentMapper.updateStudent(s_id,s_name,s_sex,s_class,s_major,s_phone);
    }

    private Workbook getWorkbook(InputStream inStr, String fileName) throws Exception {
        Workbook workbook = null;
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        if (".xls".equals(fileType)) {
            workbook = new HSSFWorkbook(inStr);
        } else if (".xlsx".equals(fileType)) {
            workbook = new XSSFWorkbook(inStr);
        } else {
            throw new Exception("请上传excel文件！");
        }
        return workbook;
    }
}
