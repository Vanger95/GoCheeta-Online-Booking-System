package GoCheeta.GoCheeta.controller;


import GoCheeta.GoCheeta.entity.Vehicle;
import GoCheeta.GoCheeta.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    // Save operation
    @PostMapping("/vehicles")
    public Vehicle saveVehicle(@RequestBody Vehicle vehicle)
    {

        return vehicleService.saveVehicle(vehicle);
    }

    // Read operation
    @GetMapping("/vehicles")
    public List<Vehicle> fetchVehicleList()
    {

        return vehicleService.fetchVehicleList();
    }

    // Update operation
    @PutMapping("/vehicles/{id}")
    public Vehicle updateVehicle(@RequestBody Vehicle vehicle, @PathVariable("id") Integer vehicleId)
    {
        return vehicleService.updateVehicle(
                vehicle, vehicleId);
    }

    // Delete operation
    @DeleteMapping("/vehicles/{id}")
    public String deleteVehicleById(@PathVariable("id") Integer vehicleId)
    {
        vehicleService.deleteVehicleById(vehicleId);
        return "Deleted Successfully";
    }
}
