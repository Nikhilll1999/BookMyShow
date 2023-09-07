package com.nctech.bookmyshow.services.impl;

import com.nctech.bookmyshow.dto.BookingDTO;
import com.nctech.bookmyshow.repositories.BookingRepository;
import com.nctech.bookmyshow.repositories.impl.BookingRepositoryImpl;
import com.nctech.bookmyshow.services.bookingservices.BookingServices;

import java.util.List;
import java.util.Objects;

/**
 * Implementation of the {@link BookingServices} interface that provides methods to manage bookings.
 */
public class BookingServicesImpl implements BookingServices {

    BookingRepository bookingRepository = new BookingRepositoryImpl();

    /**
     * Saves a booking.
     *
     * @param booking the booking to be saved
     */
    @Override
    public void save(BookingDTO booking) {
        booking.setId(bookingRepository.get().size() + 1);
        bookingRepository.save(booking);
    }

    /**
     * Retrieves all the bookings.
     *
     * @return a list of all the bookings
     */
    @Override
    public List<BookingDTO> fetchAll() {
        return bookingRepository.get();
    }

    /**
     * Retrieves a booking by its ID.
     *
     * @param id the ID of the booking to be retrieved
     * @return the booking with the specified ID, or null if not found
     */
    @Override
    public BookingDTO fetchByID(Integer id) {
        for (BookingDTO booking : bookingRepository.get()) {
            if (Objects.equals(id, booking.getId())) {
                return booking;
            }
        }
        return null;
    }

    /**
     * Updates a booking.
     *
     * @param booking the booking to be updated
     */
    @Override
    public void update(BookingDTO booking) {
        for (BookingDTO existingBooking : bookingRepository.get()) {
            if (Objects.equals(booking.getId(), existingBooking.getId())) {
                existingBooking.setChosenMovie(booking.getChosenMovie());
                existingBooking.setChooseBy(booking.getChooseBy());
                existingBooking.setTime(booking.getTime());
                break;
            }
        }
    }

    /**
     * Deletes a booking.
     *
     * @param id the ID of the booking to be deleted
     * @return true if the booking is deleted successfully, false otherwise
     */
    @Override
    public boolean delete(Integer id) {
        BookingDTO booking = fetchByID(id);
        List<BookingDTO> bookings = bookingRepository.get();
        return bookings.remove(booking);
    }
}
