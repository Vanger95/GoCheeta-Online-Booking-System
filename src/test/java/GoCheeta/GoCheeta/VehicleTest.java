package GoCheeta.GoCheeta;

import GoCheeta.GoCheeta.entity.Vehicle;
import GoCheeta.GoCheeta.repository.VehicleRepository;
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
public class VehicleTest {

    @Autowired
    private VehicleRepository repo;

    @Test
    public void testAddNew()
    {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleNumber("AB-12345");
        vehicle.setVehicleCategory("Car");
        vehicle.setVehicleName("Alto");


        Vehicle savedVehicle = repo.save(vehicle);

        Assertions.assertThat(savedVehicle).isNotNull();
        Assertions.assertThat(savedVehicle.getVehicleId()).isGreaterThan(0);
    }

    @Test
    public void testListAll()
    {
        Iterable<Vehicle> vehicles = repo.findAll();
        Assertions.assertThat(vehicles).hasSizeGreaterThan(0);

        for(Vehicle vehicle: vehicles){
            System.out.println(vehicle);
        }

    }

    @Test
    public void testGetById()
    {
        Integer vehicleId = 6;
        Optional<Vehicle> optionalVehicle = repo.findById(vehicleId);

        Assertions.assertThat(optionalVehicle).isPresent();
        System.out.println(optionalVehicle.get());
    }

    @Test
    public void testUpdate()
    {
        Integer vehicleId = 28;
        Optional<Vehicle> optionalVehicle = repo.findById(vehicleId);
        Vehicle vehicle = optionalVehicle.get();
        vehicle.setVehicleNumber("AB-45670");
        repo.save(vehicle);
        Vehicle updateVehicle = repo.findById(vehicleId).get();

        Assertions.assertThat(updateVehicle.getVehicleNumber());

    }

    @Test
    public void testDeleteById()
    {
        Integer vehicleId = 27;
        repo.deleteById(vehicleId);

        Optional<Vehicle> optionalVehicle = repo.findById(vehicleId);
        Assertions.assertThat(optionalVehicle).isNotPresent();
    }


}
