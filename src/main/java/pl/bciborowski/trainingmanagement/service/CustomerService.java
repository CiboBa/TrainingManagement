package pl.bciborowski.trainingmanagement.service;

import pl.bciborowski.trainingmanagement.domain.Customer;

public interface CustomerService {

    Object listAllCustomers();

    Customer getCustomerById(Integer id);

    Customer saveOrUpdateCustomer(Integer id);

    Customer activeCustomer(Boolean active);
}
