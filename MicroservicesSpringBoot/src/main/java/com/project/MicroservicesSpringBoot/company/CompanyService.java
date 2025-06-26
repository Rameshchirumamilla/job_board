package com.project.MicroservicesSpringBoot.company;

import java.util.List;

public interface CompanyService  {

List<Company> getAllCompanies();

boolean updateCompany(Company company, Long id);
 Company createCompany(Company company);


}
