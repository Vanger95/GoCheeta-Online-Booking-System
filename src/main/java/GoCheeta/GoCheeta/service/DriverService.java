package GoCheeta.GoCheeta.service;

import GoCheeta.GoCheeta.entity.Driver;

import java.util.List;

public interface DriverService {

    Driver saveDriver(Driver driver);

    // Read operation
    List<Driver> fetchDriverList();

    Driver getDriverbyId (Integer driverId) throws DriverNotFoundException;

    // Update operation
    Driver updateDriver(Driver driver,
                            Integer driverId);

    // Delete operation
    void deleteDriverById(Integer driverId) throws CustomerNotFoundException;

}
