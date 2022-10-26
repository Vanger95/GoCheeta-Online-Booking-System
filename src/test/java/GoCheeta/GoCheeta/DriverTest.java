package GoCheeta.GoCheeta;


import GoCheeta.GoCheeta.entity.Driver;
import GoCheeta.GoCheeta.repository.DriverRepository;
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
public class DriverTest {

    @Autowired
    private DriverRepository repo;

    @Test
    public void testAddNew()
    {
        Driver driver = new Driver();
        driver.setFirstName("Pubudu");
        driver.setLastName("pereraa");
        driver.setContactNumber("0754811841");
        driver.setActive(true);


        Driver savedDriver = repo.save(driver);

        Assertions.assertThat(savedDriver).isNotNull();
        Assertions.assertThat(savedDriver.getDriverId()).isGreaterThan(0);
    }

    @Test
    public void testListAll()
    {
        Iterable<Driver> driver = repo.findAll();
        Assertions.assertThat(driver).hasSizeGreaterThan(0);

        for(Driver drivers: driver){
            System.out.println(drivers);
        }

    }

    @Test
    public void testGetById()
    {
        Integer driverId = 5;
        Optional<Driver> optionalDriver = repo.findById(driverId);

        Assertions.assertThat(optionalDriver).isPresent();
        System.out.println(optionalDriver.get());
    }

    @Test
    public void testUpdate()
    {
        Integer driverId = 6;
        Optional<Driver> optionalDriver = repo.findById(driverId);
        Driver driver = optionalDriver.get();
        driver.setContactNumber("0717855966");
        repo.save(driver);
        Driver updateDriver = repo.findById(driverId).get();

        Assertions.assertThat(updateDriver.getContactNumber()).isEqualTo("0717855966");

    }

    @Test
    public void testDeleteById()
    {
        Integer driverId = 5;
        repo.deleteById(driverId);

        Optional<Driver> optionalDriver = repo.findById(driverId);
        Assertions.assertThat(optionalDriver).isNotPresent();
    }

}
