package com.example.demo.batch;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class TaskExecutorConfig {
	
	  @Bean("threadPoolTaskExecutor")
	  @StepScope
	  TaskExecutor threadPoolTaskExecutor() {
	     ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
	     
	     int  corePoolSize = 5 ;
	     int  maxPoolSize = 10 ;
	     int  queueCapacity = 5 ;
	     
	     executor.setCorePoolSize(corePoolSize);
	     executor.setMaxPoolSize(maxPoolSize);
	     executor.setQueueCapacity(queueCapacity);
	     executor.initialize();
	     return executor;
	  }
	  
	  
	 

}
