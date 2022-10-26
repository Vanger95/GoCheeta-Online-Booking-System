package GoCheeta.GoCheeta;


import GoCheeta.GoCheeta.entity.Booking;
import GoCheeta.GoCheeta.repository.BookingRepository;
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
public class ReservationTest {

    @Autowired
    private BookingRepository repo;

    @Test
    public void testAddNew()
    {
        Booking booking = new Booking();
        booking.setCustomerName("vinura");
        booking.setPickupLocation("Colombo");
        booking.setDropLocation("Gampaha");
        booking.setFair("100.00 RS");
        booking.setDistance("50Km");

        Booking savedBooking = repo.save(booking);

        Assertions.assertThat(savedBooking).isNotNull();
        Assertions.assertThat(savedBooking.getBookingId()).isGreaterThan(0);
    }

    @Test
    public void testListAll()
    {
        Iterable<Booking> booking = repo.findAll();
        Assertions.assertThat(booking).hasSizeGreaterThan(0);

        for(Booking bookings: booking){
            System.out.println(bookings);
        }

    }

    @Test
    public void testGetById()
    {
        Integer bookingId = 5;
        Optional<Booking> bookingOptional = repo.findById(bookingId);

        Assertions.assertThat(bookingOptional).isPresent();
        System.out.println(bookingOptional.get());
    }

    @Test
    public void testDeleteById()
    {
        Integer bookingId = 5;
        repo.deleteById(bookingId);

        Optional<Booking> bookingOptional = repo.findById(bookingId);
        Assertions.assertThat(bookingOptional).isNotPresent();
    }
}
