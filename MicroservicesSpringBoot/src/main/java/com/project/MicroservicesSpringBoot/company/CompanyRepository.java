package com.project.MicroservicesSpringBoot.company;

//import com.project.MicroservicesSpringBoot.company.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {


}
