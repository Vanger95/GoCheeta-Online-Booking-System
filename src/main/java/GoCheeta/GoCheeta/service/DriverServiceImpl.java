package GoCheeta.GoCheeta.service;

import GoCheeta.GoCheeta.entity.Driver;
import GoCheeta.GoCheeta.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DriverServiceImpl implements DriverService{

    @Autowired
    private DriverRepository driverRepository;

    // Save operation
    @Override
    public Driver saveDriver(Driver driver)
    {

        return driverRepository.save(driver);
    }

    // Read operation


    @Override
    public List<Driver> fetchDriverList()
    {
        return (List<Driver>)
                driverRepository.findAll();
    }

    @Override
    public Driver getDriverbyId (Integer driverId) throws DriverNotFoundException {

        Optional<Driver> result =  driverRepository.findById(driverId);
        if (result.isPresent())
        {
            return result.get();
        }
        throw new DriverNotFoundException("Driver Cannot Found" + driverId);
    }

    // Update operation
    @Override
    public Driver updateDriver(Driver driver, Integer driverId)
    {
        Driver depDB = driverRepository.findById(driverId).get();

        if (Objects.nonNull(driver.getFirstName())
                && !"".equalsIgnoreCase(driver.getFirstName())) {
            depDB.setFirstName(
                    driver.getFirstName());
        }

        if (Objects.nonNull(driver.getLastName())
                && !"".equalsIgnoreCase(
                driver.getLastName())) {
            depDB.setLastName(
                    driver.getLastName());
        }

        if (Objects.nonNull(
                driver.getContactNumber())
                && !"".equalsIgnoreCase(
                driver.getContactNumber())) {
            depDB.setContactNumber(
                    driver.getContactNumber());
        }

        return driverRepository.save(depDB);
    }

    // Delete operation
    @Override
    public void deleteDriverById(Integer driverId) throws CustomerNotFoundException {

        Long count = driverRepository.countBydriverId(driverId);
        if (count == null || count == 0){
            throw new CustomerNotFoundException("Driver Cannot Found" + driverId);
        }
        driverRepository.deleteById(driverId);
    }
}
