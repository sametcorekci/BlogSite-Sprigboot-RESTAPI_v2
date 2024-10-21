package service;

import model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AdminRepository;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepo;
    public Admin saveAdmin(Admin admin) {
        return adminRepo.save(admin);
    }
}
