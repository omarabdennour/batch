package com.example.demo.batch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.batch.item.data.builder.RepositoryItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Client;
import com.example.demo.repository.ClientRepository;


@Service
@StepScope
public class ReaderConfig {
	
    @Autowired
    ClientRepository clientRepository;
    
    

	@StepScope
	@Bean("myReader")
	RepositoryItemReader<Client> clearListReader() {
		
		List<Boolean> args = new ArrayList<Boolean>();
		args.add(false);
		return new RepositoryItemReaderBuilder<Client>()
                .name("my-reader")
                .repository(clientRepository)
                .methodName("findByIsEnabled")
                .arguments(args)
                .sorts(Collections.singletonMap("createdDate", Sort.Direction.ASC))
                .pageSize(10)
                .saveState(true)
                .build();
	}
	
}