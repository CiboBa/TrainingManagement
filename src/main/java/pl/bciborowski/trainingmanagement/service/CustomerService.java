package pl.bciborowski.trainingmanagement.service;

import java.util.List;
import pl.bciborowski.trainingmanagement.domain.Customer;

public interface CustomerService {

    List<Customer> listAllCustomers();

    Customer getById(Integer id);

    Customer save(Customer customer);

    void activateCustomer(Boolean active);

    void delete(Integer id);
}
