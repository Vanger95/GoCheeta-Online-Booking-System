package GoCheeta.GoCheeta.service;


import GoCheeta.GoCheeta.entity.Vehicle;

import java.util.List;

public interface VehicleService {

    Vehicle saveVehicle(Vehicle vehicle);

    // Read operation
    List<Vehicle> fetchVehicleList();

    // Update operation
    Vehicle updateVehicle(Vehicle vehicle,
                        Integer vehicleId);

    // Delete operation
    void deleteVehicleById(Integer vehicleId);
}
