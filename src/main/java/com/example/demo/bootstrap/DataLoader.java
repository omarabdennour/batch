package com.example.demo.bootstrap;

import java.time.Duration;
import java.time.Instant;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.model.Client;
import com.example.demo.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Component
@RequiredArgsConstructor
@Log4j2
public class DataLoader implements CommandLineRunner {

	
	private final JobLauncher jobLauncher;
	
	@Qualifier("myJob")
	private final Job job;
	
	@Autowired
	ClientRepository clientRepository;

	@Override
	public void run(String... args) throws Exception {

		loaddata();
		launchJob();
	}

	void loaddata() {
		int index = 0;
		while (index < 10000) {

			String name = String.format("%s%s", "name", index);
			String email = String.format("%s%s", name, "@domain.com");

			clientRepository.save(Client.builder().name(name).email(email).isEnabled(false).build());
			index = index + 1;
		}
	}
	
	
	void launchJob() {
		try {
			Instant start = Instant.now();
        	JobParameters jobParameters = new JobParametersBuilder()
        			.addString("startAt", start.toString())
                    .toJobParameters();
        	JobExecution jobExecution = jobLauncher.run(job, jobParameters);
            
        	System.out.println("Job Name: " + job.getName());
            System.out.println("JobExecution: " + jobExecution.getStatus());
            System.out.println("Job Duration: " + Duration.between(start, Instant.now()));
			
		}  catch(Exception e){
            log.error("Exception while dealing with batch processing");
            log.error("cause ->  {}",e.getCause());
            log.error("cause ->  {}",e.getMessage());
        }
		
		
	}

}
