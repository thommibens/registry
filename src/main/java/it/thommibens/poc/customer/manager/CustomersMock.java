package it.thommibens.poc.customer.manager;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.thommibens.poc.customer.Customer;

public class CustomersMock implements CustomerManager {

    private final CustomerList customers;
    private static final String mock_file = "/mock/customer.json";

    public CustomersMock() throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        this.customers = mapper.readValue(CustomersMock.class.getResourceAsStream(mock_file), CustomerList.class);
    }

    @Override
    public Customer get(String id) {
        return customers.copiedStream().filter((customer) -> customer.get_id().equals(id)).findFirst()
                .orElseThrow(() -> {
                    return new ResponseStatusException(HttpStatus.NOT_FOUND,
                            String.format("No Customer found for id: %s", id));
                });
    }

    @Override
    public List<Customer> get() {
        return customers.copiedStream().collect(Collectors.toCollection(CustomerList::new));
    }

}

class CustomerList extends LinkedList<Customer> {

    private static final long serialVersionUID = 1L;

    // Deep copy
    public Stream<Customer> copiedStream() {
        return parallelStream()
        // .map((customer) -> customer.clone());
        ;
    }
}
