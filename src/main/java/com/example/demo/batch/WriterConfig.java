package com.example.demo.batch;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.data.builder.RepositoryItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.example.demo.model.Client;
import com.example.demo.repository.ClientRepository;

@Service
public class WriterConfig {
	
	@Autowired
	ClientRepository clientRepository;
	
	@Bean("myWriter")
	@StepScope
	RepositoryItemWriter<Client> clearListWriter() {
		return new RepositoryItemWriterBuilder<Client>()
				.methodName("save")
				.repository(clientRepository)
				.build();
	}

}
