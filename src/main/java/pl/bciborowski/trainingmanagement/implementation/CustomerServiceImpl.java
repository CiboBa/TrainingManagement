package pl.bciborowski.trainingmanagement.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.bciborowski.trainingmanagement.domain.Customer;
import pl.bciborowski.trainingmanagement.repository.CustomerRepository;
import pl.bciborowski.trainingmanagement.service.CustomerService;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerServiceImpl() {
    }

    @Override
    public List<Customer> listAllCustomers() {
        List<Customer> result = new LinkedList<>();
        customerRepository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public Customer getById(Integer id) {
        Optional<Customer> result = customerRepository.findById(id);
        return result.orElse(new Customer());
    }

    @Override
    public Customer save(Customer customer) {
        if (customer != null) {
            return customerRepository.save(customer);
        } else {
            throw new RuntimeException("Nie mogę zapisać użytkownika!!! Wypełnij wszystkie pola!!!");
        }
    }

    @Override
    public Customer activateCustomer(Boolean active) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
