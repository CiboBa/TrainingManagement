package pl.bciborowski.trainingmanagement.implementation;

import com.sun.tools.javac.util.List;
import org.springframework.stereotype.Service;
import pl.bciborowski.trainingmanagement.domain.Customer;
import pl.bciborowski.trainingmanagement.service.CustomerService;

import java.util.HashMap;
import java.util.Map;

@Service
public class CustomerServiceImpl implements CustomerService {

    private Map<Integer, Customer> customers;

    public CustomerServiceImpl(){
        customers=new HashMap<>();
    }

    @Override
    public List<Customer> listAllCustomers() {
        return null;
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return null;
    }

    @Override
    public Customer saveOrUpdateCustomer(Integer id) {
        return null;
    }

    @Override
    public Customer activeCustomer(Boolean active) {
        return null;
    }
}
