package GoCheeta.GoCheeta.repository;

import GoCheeta.GoCheeta.entity.Driver;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends CrudRepository<Driver, Integer> {
    public Long countBydriverId(Integer driverId);

}
