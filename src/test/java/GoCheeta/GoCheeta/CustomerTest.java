package GoCheeta.GoCheeta;

import GoCheeta.GoCheeta.entity.Customer;
import GoCheeta.GoCheeta.repository.CustomerRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class CustomerTest {

    @Autowired
    private CustomerRepository repo;

    @Test
    public void testAddNew()
    {
        Customer customer = new Customer();
        customer.setFirstname("Srimathi");
        customer.setLastname("Kalupahana");
        customer.setAddress("Boralsagamuwa");
        customer.setEmail("srimathi@gmail.com");
        customer.setPassword("SR1234567");

        Customer savedCustomer = repo.save(customer);

        Assertions.assertThat(savedCustomer).isNotNull();
        Assertions.assertThat(savedCustomer.getCustomerId()).isGreaterThan(0);
    }

    @Test
    public void testListAll()
    {
        Iterable<Customer> customer = repo.findAll();
        Assertions.assertThat(customer).hasSizeGreaterThan(0);

        for(Customer customers: customer){
                System.out.println(customers);
        }

    }

    @Test
    public void testGetById()
    {
        Integer customerId = 6;
        Optional<Customer> optionalcustomer = repo.findById(customerId);

        Assertions.assertThat(optionalcustomer).isPresent();
        System.out.println(optionalcustomer.get());
    }

    @Test
    public void testUpdate()
    {
        Integer customerId = 6;
        Optional<Customer> optionalcustomer = repo.findById(customerId);
        Customer customer = optionalcustomer.get();
        customer.setPassword("vidura1234");
        repo.save(customer);
        Customer updateCustomer = repo.findById(customerId).get();

        Assertions.assertThat(updateCustomer.getPassword()).isEqualTo("vidura1234");

    }

    @Test
    public void testDeleteById()
    {
        Integer customerId = 5;
        repo.deleteById(customerId);

        Optional<Customer> optionalcustomer = repo.findById(customerId);
        Assertions.assertThat(optionalcustomer).isNotPresent();
    }


}
