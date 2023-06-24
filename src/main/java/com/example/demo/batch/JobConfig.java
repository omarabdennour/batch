package com.example.demo.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class JobConfig {
	
	private final JobRepository jobRepository;
	
	@Bean("myJob")
    Job clearListJob(@Qualifier("myStep") 	  Step 	               step,
    				 @Qualifier("myListener") JobExecutionListener listener) {
    	
        return new JobBuilder("my-job", jobRepository)
        		.listener(listener)
        		.incrementer(new RunIdIncrementer())
                .flow(step)
                .end()
                .build();
    }

}
