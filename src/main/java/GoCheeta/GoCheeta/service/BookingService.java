package GoCheeta.GoCheeta.service;

import GoCheeta.GoCheeta.entity.Booking;

import java.util.List;

public interface BookingService {

    Booking saveReservation(Booking booking);

    // Read operation
    List<Booking> fetchReservationList();

    Booking getReservationId (Integer bookingId);

    // Delete operation
    void deleteReservationById(Integer bookingId) throws ReservationNotFoundException;

}
