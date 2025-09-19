package com.CrudOperation.Management.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class ManagementEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer companyId;

    private String companyName;
    private String typeOfCompany;
    private int projectId;
    private String projectName;
}
