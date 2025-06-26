package com.project.MicroservicesSpringBoot.Job.Implementation;

import com.project.MicroservicesSpringBoot.Job.Job;
import com.project.MicroservicesSpringBoot.Job.JobRepository;
import com.project.MicroservicesSpringBoot.Job.JobService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

    //private List<Job> jobs = new ArrayList<>();
    JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    private Long nextID = 1L;
    @Override
    public List<Job> finadAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
     jobRepository.save(job);
    }


    @Override
    public Job getJobById(Long id) {
//        for (Job job: jobs
//             ) {
//            if(job.getId().equals(id)){
//                return job;
//            }
//
//        }
//        return null;
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobById(Long id) {

//        Iterator<Job> iterator = jobs.iterator();
//        while(iterator.hasNext()){
//            Job job = iterator.next();
//            if(job.getId().equals(id)){
//                iterator.remove();
//                return true;
//            }
//        }
//        return false;
        try {
            jobRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public boolean updateJob(Long id, Job updatedJob) {
        //Iterator<Job>  iterator = jobs.iterator();

//        for(Job job: jobs){
//            if(job.getId().equals(id)){
//               job.setTitle(updatedJob.getTitle());
//                job.setjobDescrption(updatedJob.getjobDescrption());
//                job.setMinSalary(updatedJob.getMinSalary());
//                job.setMaxSalary(updatedJob.getMaxSalary());
//                job.setLocation(updatedJob.getLocation());
//                return true;
//            }
//        }
//        return false;
        Optional<Job> jobOptional = jobRepository.findById(id);
        if(jobOptional.isPresent()){
                Job job = jobOptional.get();
                job.setTitle(updatedJob.getTitle());
                job.setjobDescrption(updatedJob.getjobDescrption());
                job.setMinSalary(updatedJob.getMinSalary());
                job.setMaxSalary(updatedJob.getMaxSalary());
                job.setLocation(updatedJob.getLocation());
             return true;
        }
        return false;
    }
}
