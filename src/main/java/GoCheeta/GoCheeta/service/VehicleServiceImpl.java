package GoCheeta.GoCheeta.service;

import GoCheeta.GoCheeta.entity.Vehicle;
import GoCheeta.GoCheeta.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class VehicleServiceImpl implements VehicleService{

    @Autowired
    private VehicleRepository vehicleRepository;

    // Save operation
    @Override
    public Vehicle saveVehicle(Vehicle vehicle)
    {

        return vehicleRepository.save(vehicle);
    }

    // Read operation
    @Override
    public List<Vehicle> fetchVehicleList()
    {
        return (List<Vehicle>)
                vehicleRepository.findAll();
    }

    // Update operation
    @Override
    public Vehicle updateVehicle(Vehicle vehicle, Integer vehicleId)
    {
        Vehicle depDB = vehicleRepository.findById(vehicleId).get();

        if (Objects.nonNull(vehicle.getVehicleName())
                && !"".equalsIgnoreCase(vehicle.getVehicleName())) {
            depDB.setVehicleName(
                    vehicle.getVehicleName());
        }

        if (Objects.nonNull(vehicle.getVehicleCategory())
                && !"".equalsIgnoreCase(
                vehicle.getVehicleCategory())) {
            depDB.setVehicleCategory(
                    vehicle.getVehicleCategory());
        }

        if (Objects.nonNull(
                vehicle.getVehicleNumber())
                && !"".equalsIgnoreCase(
                vehicle.getVehicleNumber())) {
            depDB.setVehicleNumber(
                    vehicle.getVehicleNumber());
        }

        return vehicleRepository.save(depDB);
    }

    // Delete operation
    @Override
    public void deleteVehicleById(Integer driverId)
    {

        vehicleRepository.deleteById(driverId);
    }
}
