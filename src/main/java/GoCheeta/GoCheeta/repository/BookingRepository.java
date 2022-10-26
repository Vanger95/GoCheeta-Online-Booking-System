package GoCheeta.GoCheeta.repository;

import GoCheeta.GoCheeta.entity.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Integer> {

    public Long countByBookingId(Integer bookingId);
}
