package GoCheeta.GoCheeta.repository;

import GoCheeta.GoCheeta.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    public Long countBycustomerId(Integer customerId);



}
