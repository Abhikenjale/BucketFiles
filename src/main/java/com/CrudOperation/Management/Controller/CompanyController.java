package com.CrudOperation.Management.Controller;

import com.CrudOperation.Management.Entity.ManagementEntity;
import com.CrudOperation.Management.servicesOfCompany.companyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private final companyService service;

    public CompanyController(companyService service){
        this.service=service;
    }
   //CREATE COMPANY
    @PostMapping("/createCompany")
    public ResponseEntity<ManagementEntity> createCompany(@RequestBody ManagementEntity company){
        return ResponseEntity.ok(service.createCompany(company));
    }

    //FIND THE COMPANY
    @GetMapping("FindCompany")
    public ResponseEntity<ManagementEntity> getCompany(@PathVariable Integer id){
        ManagementEntity company = service.getCompanyById(id);
        return company!= null?ResponseEntity.ok(company):ResponseEntity.notFound().build();
    }

    //DETELE THE COMPANY
    @DeleteMapping("/Delete")
    public ResponseEntity<Void> deleteCompany(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    //UPDATETHECOMPANY
    @PostMapping("/update/{id}")
    public ResponseEntity<ManagementEntity> updateCompany(
            @PathVariable Integer id,
            @RequestBody ManagementEntity updateCompany){
        ManagementEntity company = service.updateCompany(id,updateCompany);
        return company!= null?ResponseEntity.ok(company):ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<ManagementEntity>> getAllCompanies() {
        return ResponseEntity.ok(service.getAllCompanies());
    }



}
