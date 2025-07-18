package com.project.MicroservicesSpringBoot.company.impl;

import com.project.MicroservicesSpringBoot.Job.Job;
import com.project.MicroservicesSpringBoot.company.Company;
import com.project.MicroservicesSpringBoot.company.CompanyRepository;
import com.project.MicroservicesSpringBoot.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class companyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;

    public companyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Company company, Long id) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if (companyOptional.isPresent()) {
            Company company1 = companyOptional.get();
            company1.setDescription(company.getDescription());
            company1.setName(company.getName());
            company1.setJobs(company.getJobs());
            companyRepository.save(company1);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Company createCompany(Company company) {
        if(company.getJobs() != null){
            for (Job job: company.getJobs()){
                job.setCompany(company);
            }
        }
        return companyRepository.save(company);
    }
}
