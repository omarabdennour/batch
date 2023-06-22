package com.example.demo.batch;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.example.demo.model.Client;

@StepScope
@Service
public class Processor implements ItemProcessor<Client, Client> {

	@Override
	@StepScope
	public Client process(Client item) throws Exception {

		Client client = item.toBuilder().isEnabled(true).build();
		client.setId(item.getId());
		return client;
	}
	
	
}