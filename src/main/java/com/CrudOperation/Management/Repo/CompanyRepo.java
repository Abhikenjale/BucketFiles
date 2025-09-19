package com.CrudOperation.Management.Repo;

import com.CrudOperation.Management.Entity.ManagementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepo extends JpaRepository<ManagementEntity,Integer> {
}
