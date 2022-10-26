package GoCheeta.GoCheeta.repository;

import GoCheeta.GoCheeta.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT u FROM Customer u WHERE u.email = ?1")
    public Customer findByEmail(String email);
}
