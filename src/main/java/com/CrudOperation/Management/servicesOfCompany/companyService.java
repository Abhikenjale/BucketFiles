package com.CrudOperation.Management.servicesOfCompany;

import com.CrudOperation.Management.Entity.ManagementEntity;
import com.CrudOperation.Management.Repo.CompanyRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class companyService {
    private final CompanyRepo repo;

    public companyService(CompanyRepo repo){
        this.repo=repo;
    }
    public ManagementEntity createCompany(ManagementEntity company){
        return repo.save(company);
    }

    public List<ManagementEntity> getAllCompanies() {
        return repo.findAll();
    }



    public ManagementEntity getCompanyById(Integer companyId){
        return repo.findById(companyId).orElse(null);
    }

    public void delete(int companyId){
        repo.deleteById(companyId);
    }
    public ManagementEntity updateCompany(Integer id,ManagementEntity updatecompany){
        return repo.findById(id).map(company->{
            company.setCompanyName(updatecompany.getCompanyName());
            company.setTypeOfCompany(updatecompany.getTypeOfCompany());
            company.setProjectName(updatecompany.getProjectName());
            company.setProjectId(updatecompany.getProjectId());
            return repo.save(company);
        }).orElse(null);
    }

}
