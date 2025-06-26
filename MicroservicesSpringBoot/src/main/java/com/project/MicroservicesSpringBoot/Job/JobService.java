package com.project.MicroservicesSpringBoot.Job;

import java.util.List;

public interface JobService {

    List<Job> finadAll();
    void createJob(Job job);

    Job getJobById(Long id);

    boolean deleteJobById(Long id);

    boolean updateJob(Long id, Job updatedJob);
}
