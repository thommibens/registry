package it.thommibens.poc.customer.config;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import it.thommibens.poc.customer.manager.CustomerManager;
import it.thommibens.poc.customer.manager.CustomersMock;

@Configuration
public class CustomerDevConfiguration {

    @Bean
    CustomerManager customerManager() throws JsonParseException, JsonMappingException, IOException {
        return new CustomersMock();
    }

}
