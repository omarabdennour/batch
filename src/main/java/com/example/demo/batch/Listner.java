package com.example.demo.batch;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.repository.ClientRepository;

import lombok.extern.log4j.Log4j2;

@Component("myListener")
@Log4j2
public class Listner implements JobExecutionListener{
	
	@Autowired
	ClientRepository clientRepository;
	 
	    @Override
	    public void beforeJob(JobExecution jobExecution) {
	    	System.out.println("-----------------------------");
	    	System.out.println("Before Job ...");
	    	System.out.println("Unprocessed clients  -> " + clientRepository.countByIsProcessed(false) );
	    	System.out.println("Processed clients  -> " + clientRepository.countByIsProcessed(true) );
	    	System.out.println("-----------------------------");
	        
	        log.info("Batch is Running...");
	 }

	    @Override
	    public void afterJob(JobExecution jobExecution) {
	    	System.out.println("-----------------------------");
	    	System.out.println("After Job ...");
	    	System.out.println("Unprocessed clients  -> " + clientRepository.countByIsProcessed(false) );
	    	System.out.println("Processed clients  -> " + clientRepository.countByIsProcessed(true) );
	    	System.out.println("-----------------------------");
	    }

}
