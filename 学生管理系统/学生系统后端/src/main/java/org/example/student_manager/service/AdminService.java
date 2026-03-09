package org.example.student_manager.service;

import org.example.student_manager.dao.Admin;
import org.example.student_manager.mapper.AdminMapper;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    private final AdminMapper adminMapper;
    public AdminService(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }
    public Admin login(String name, String password) {
        return adminMapper.login(name, password);
    }
}
