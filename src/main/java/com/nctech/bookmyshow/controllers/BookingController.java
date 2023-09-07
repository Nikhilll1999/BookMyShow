package com.nctech.bookmyshow.controllers;

import com.nctech.bookmyshow.dto.BookingDTO;
import com.nctech.bookmyshow.repositories.BookingRepository;
import com.nctech.bookmyshow.repositories.impl.BookingRepositoryImpl;
import com.nctech.bookmyshow.services.bookingservices.BookingServices;
import com.nctech.bookmyshow.services.impl.BookingServicesImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for handling booking-related API endpoints.
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/bookmyshow/booking/")
public class BookingController {
    BookingServices bookingServices = new BookingServicesImpl();
    BookingRepository bookingRepository = new BookingRepositoryImpl();

    /**
     * Handles the create or update booking API endpoint.
     *
     * <p>This API endpoint allows creating or updating a booking based on the provided {@link BookingDTO} object.
     * If the booking ID is null, a new booking will be created, otherwise, an existing booking will be updated.</p>
     *
     * @param booking the {@link BookingDTO} object representing the booking details
     */
    @RequestMapping({"create", "update"})
    public void createOrUpdateBooking(@RequestBody BookingDTO booking) {
        bookingRepository.loadData();
        bookingRepository.saveToFile();
        if (booking.getId() == null) {
            bookingServices.save(booking);
        } else {
            bookingServices.update(booking);
        }
    }

    /**
     * Handles the fetch all bookings API endpoint.
     *
     * <p>This API endpoint fetches all the bookings stored in the system.</p>
     *
     * @return a {@link List} of {@link BookingDTO} objects representing all the bookings
     */
    @RequestMapping("fetchAll")
    @ResponseBody
    public List<BookingDTO> fetchAll() {
        bookingRepository.loadData();
        return bookingServices.fetchAll();
    }

    /**
     * Handles the fetch booking by ID API endpoint.
     *
     * <p>This API endpoint fetches a booking based on the provided booking ID.</p>
     *
     * @param id the ID of the booking to fetch
     * @return the {@link BookingDTO} object representing the fetched booking
     */
    @RequestMapping("fetchByID/{id}")
    @ResponseBody
    public BookingDTO fetchByID(@PathVariable int id) {
        bookingRepository.loadData();
        return bookingServices.fetchByID(id);
    }

    /**
     * Handles the delete booking API endpoint.
     *
     * <p>This API endpoint deletes a booking based on the provided booking ID.</p>
     *
     * @param id the ID of the booking to delete
     * @return a boolean indicating whether the deletion was successful
     */
    @RequestMapping("delete/{id}")
    @ResponseBody
    public boolean delete(@PathVariable int id) {
        bookingRepository.loadData();
        return bookingServices.delete(id);
    }
}
