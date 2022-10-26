package GoCheeta.GoCheeta.service;

import GoCheeta.GoCheeta.entity.Customer;

import java.util.List;

public interface CustomerService {

    Customer saveCustomer(Customer customer);

    // Read operation
    List<Customer> fetchCustomerList();

    Customer getCustomerbyId (Integer customerId) throws CustomerNotFoundException;
    // Update operation
    Customer updateCustomer(Customer customer,
                        Integer customerId);

    // Delete operation
    void deleteCustomerById(Integer customerId) throws CustomerNotFoundException;
}
