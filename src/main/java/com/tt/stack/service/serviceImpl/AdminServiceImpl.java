package com.tt.stack.service.serviceImpl;

import com.tt.stack.dao.AdminDao;
import com.tt.stack.entity.Admin;
import com.tt.stack.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    
    @Autowired
    AdminDao adminDao;
    
    @Override
    public String loginCheck(Admin admin) {
        Admin adminByAccount = adminDao.getAdminByAccount(admin.getAccount());
        if (adminByAccount == null){
            return "-1";
        }else {
            if (!admin.getPassword().equals(adminByAccount.getPassword()))
                return "0";
            else
                return "1";
        }
    }
}
