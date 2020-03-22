package pl.bciborowski.trainingmanagement.repository;

import org.springframework.data.repository.CrudRepository;
import pl.bciborowski.trainingmanagement.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
