package com.example.demo.batch;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;

import com.example.demo.model.Client;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class StepConfig {

    private final PlatformTransactionManager transactionManager;
    private final JobRepository jobRepository;

    
    @JobScope
    @Bean("myStep")
    Step myStep(
    		@Qualifier("myReader") RepositoryItemReader<Client> reader,
    		@Qualifier("myWriter") RepositoryItemWriter<Client>  writer,
    		@Qualifier("threadPoolTaskExecutor") TaskExecutor taskExecutor) {
    	
        return new StepBuilder("my-step", jobRepository)
                .<Client,Client>chunk(10, transactionManager)
                .reader(reader)
                .processor(processor())
                .writer(writer)
                .taskExecutor(taskExecutor)
                .build();
    }
    
    
    @Bean("myProcessor")
    ItemProcessor<Client, Client> processor() {
        return new Processor();
    }
    
}
