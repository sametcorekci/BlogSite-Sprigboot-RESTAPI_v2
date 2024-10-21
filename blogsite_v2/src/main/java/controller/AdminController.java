package controller;

import model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminServices;

    @PostMapping("/create")
    public ResponseEntity<Admin> cretedAdmin(@RequestBody Admin admin){
        Admin saveAdmin = adminServices.saveAdmin(admin);
        return new ResponseEntity<>(saveAdmin, HttpStatus.CREATED);
    }
}
