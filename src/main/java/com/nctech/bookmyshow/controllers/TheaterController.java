package com.nctech.bookmyshow.controllers;

import com.nctech.bookmyshow.dto.TheaterDTO;
import com.nctech.bookmyshow.repositories.TheaterRepository;
import com.nctech.bookmyshow.repositories.impl.TheaterRepositoryImpl;
import com.nctech.bookmyshow.services.impl.TheaterServicesImpl;
import com.nctech.bookmyshow.services.theaterservices.TheaterServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for handling theater-related API endpoints.
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/bookmyshow/theater/")
public class TheaterController {
    TheaterServices theaterServices = new TheaterServicesImpl();
    TheaterRepository theaterRepository = new TheaterRepositoryImpl();

    /**
     * Creates or updates a theater based on the provided {@link TheaterDTO} object.
     *
     * @param theater the {@link TheaterDTO} object representing the theater details
     */
    @RequestMapping({"create", "update"})
    public void createOrUpdateTheater(@RequestBody TheaterDTO theater) {
        theaterRepository.loadData();
        theaterRepository.saveToFile();
        if (theater.getId() == null) {
            theaterServices.save(theater);
        } else {
            theaterServices.update(theater);
        }
    }

    /**
     * Fetches all theaters stored in the system.
     *
     * @return a {@link List} of {@link TheaterDTO} objects representing all the theaters
     */
    @RequestMapping("fetchAll")
    @ResponseBody
    public List<TheaterDTO> fetchAll() {
        theaterRepository.loadData();
        return theaterServices.fetchAll();
    }

    /**
     * Fetches a theater based on the provided theater ID.
     *
     * @param id the ID of the theater to fetch
     * @return the {@link TheaterDTO} object representing the fetched theater
     */
    @RequestMapping("fetchByID/{id}")
    @ResponseBody
    public TheaterDTO fetchByID(@PathVariable int id) {
        theaterRepository.loadData();
        return theaterServices.fetchByID(id);
    }

    /**
     * Deletes a theater based on the provided theater ID.
     *
     * @param id the ID of the theater to delete
     * @return a boolean indicating whether the deletion was successful
     */
    @RequestMapping("delete/{id}")
    @ResponseBody
    public boolean delete(@PathVariable int id) {
        theaterRepository.loadData();
        return theaterServices.delete(id);
    }
}
