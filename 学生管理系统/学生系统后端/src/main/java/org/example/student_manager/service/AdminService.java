package org.example.student_manager.service;

import org.apache.ibatis.annotations.Param;
import org.example.student_manager.dao.Admin;
import org.example.student_manager.dao.Student;
import org.example.student_manager.dao.Teacher;
import org.example.student_manager.mapper.AdminMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    private final AdminMapper adminMapper;
    public AdminService(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }
    public Admin login(String name, String password) {
        return adminMapper.login(name, password);
    }
    public int addTeacher(Teacher teacher) {
        //UUID
        teacher.setId(java.util.UUID.randomUUID().toString());
        return adminMapper.addTeacher(teacher);
    }
    public int addStudent(Student student) {
        //UUID
        student.setId(java.util.UUID.randomUUID().toString());
        return adminMapper.addStudent(student);
    }

    //添加管理员
    public int addAdmin(Admin admin) {
        //UUID
        admin.setId(java.util.UUID.randomUUID().toString());
        return adminMapper.addAdmin(admin);
    }
    //查询所有管理员
    public List<Admin> queryAllAdmin() {
        return adminMapper.findAll() ;
    }
    //更新课程
    public int agreeCourse(@Param("id") String id) {
        return adminMapper.agreeCourse(id);
    }
}
