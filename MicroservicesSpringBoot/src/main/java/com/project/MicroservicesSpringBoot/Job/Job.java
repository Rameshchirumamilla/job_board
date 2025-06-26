package com.project.MicroservicesSpringBoot.Job;

import com.project.MicroservicesSpringBoot.company.Company;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String jobDescrption;
    private String minSalary;
    private String maxSalary;
    private String location;

    @ManyToOne
    @JoinColumn(name = "company_id") // Foreign key column in Job table
    private Company company;
    public Job() {
    }

    public Job(String title, String jobDescrption, String minSalary, String maxSalary, String location) {
        this.title = title;
        this.jobDescrption = jobDescrption;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getjobDescrption() {
        return jobDescrption;
    }

    public void setjobDescrption(String jobDescrption) {
        this.jobDescrption = jobDescrption;
    }

    public String getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(String minSalary) {
        this.minSalary = minSalary;
    }

    public String getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(String maxSalary) {
        this.maxSalary = maxSalary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
