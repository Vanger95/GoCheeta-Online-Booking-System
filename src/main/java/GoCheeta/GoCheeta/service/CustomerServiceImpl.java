package GoCheeta.GoCheeta.service;

import GoCheeta.GoCheeta.entity.Customer;
import GoCheeta.GoCheeta.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public Customer saveCustomer(Customer customer) {

        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerbyId (Integer customerId) throws CustomerNotFoundException {
        Optional<Customer> result =  customerRepository.findById(customerId);
        if (result.isPresent())
        {
            return result.get();
        }
        throw new CustomerNotFoundException("Customer Cannot Found" + customerId);
    }

    @Override
    public List<Customer> fetchCustomerList() {
        return (List<Customer>)
                customerRepository.findAll();
    }

    @Override
    public Customer updateCustomer(Customer customer, Integer customerId) {

        Customer depDB = customerRepository.findById(customerId).get();

        if (Objects.nonNull(customer.getFirstname())
                && !"".equalsIgnoreCase(customer.getFirstname())) {
            depDB.setFirstname(
                    customer.getFirstname());
        }
        if (Objects.nonNull(customer.getLastname())
                && !"".equalsIgnoreCase(customer.getLastname())) {
            depDB.setLastname(
                    customer.getLastname());
        }

        if (Objects.nonNull(customer.getAddress())
                && !"".equalsIgnoreCase(
                customer.getAddress())) {
            depDB.setAddress(
                    customer.getAddress());
        }

        if (Objects.nonNull(
                customer.getEmail())
                && !"".equalsIgnoreCase(
                customer.getEmail())) {
            depDB.setEmail(
                    customer.getEmail());
        }


        if (Objects.nonNull(
                customer.getPassword())
                && !"".equalsIgnoreCase(
                customer.getPassword())) {
            depDB.setPassword(
                    customer.getPassword());
        }

        return customerRepository.save(depDB);
    }

    @Override
    public void deleteCustomerById(Integer customerId) throws CustomerNotFoundException {

        Long count = customerRepository.countBycustomerId(customerId);
        if (count == null || count == 0){
            throw new CustomerNotFoundException("Customer Cannot Found" + customerId);
        }
        customerRepository.deleteById(customerId);
    }
}
