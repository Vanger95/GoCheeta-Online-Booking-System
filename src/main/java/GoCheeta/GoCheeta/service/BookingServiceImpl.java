package GoCheeta.GoCheeta.service;

import GoCheeta.GoCheeta.entity.Booking;
import GoCheeta.GoCheeta.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Booking saveReservation(Booking booking) {


        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> fetchReservationList() {
        return (List<Booking>)
                bookingRepository.findAll();
    }

    @Override
    public Booking getReservationId(Integer bookingId) {
        Optional<Booking> result = bookingRepository.findById(bookingId);
        if (result.isPresent()) {
            return result.get();
        }
        throw new NotFoundException("Reservation Cannot Found" + bookingId);
    }

    @Override
    public void deleteReservationById(Integer bookingId) throws ReservationNotFoundException {

        Long count = bookingRepository.countByBookingId(bookingId);
        if (count == null || count == 0){
            throw new ReservationNotFoundException("Customer Cannot Found" + bookingId);
        }
        bookingRepository.deleteById(bookingId);

    }


}
