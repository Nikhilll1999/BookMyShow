package com.nctech.bookmyshow.controllers;

import com.nctech.bookmyshow.dto.ShowDTO;
import com.nctech.bookmyshow.repositories.ShowRepository;
import com.nctech.bookmyshow.repositories.impl.ShowRepositoryImpl;
import com.nctech.bookmyshow.services.impl.ShowServicesImpl;
import com.nctech.bookmyshow.services.showservices.ShowServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for handling show-related API endpoints.
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/bookmyshow/show/")
public class ShowController {
    ShowServices showServices = new ShowServicesImpl();
    ShowRepository showRepository = new ShowRepositoryImpl();

    /**
     * Creates or updates a show based on the provided {@link ShowDTO} object.
     *
     * <p>
     *     This API endpoint allows creating or updating a show based on the provided {@link ShowDTO} object.
     *     If the show ID is null, a new show will be created, otherwise, an existing show will be updated.
     * </p>
     *
     * @param show the {@link ShowDTO} object representing the show details
     */
    @RequestMapping({"create", "update"})
    public void createOrUpdateShow(@RequestBody ShowDTO show) {
        showRepository.loadData();
        showRepository.saveToFile();
        if (show.getId() == null) {
            showServices.save(show);
        } else {
            showServices.update(show);
        }
    }

    /**
     * Fetches all shows stored in the system.
     *
     * <p>
     *     This API endpoint fetches all the shows stored in the system.
     * </p>
     *
     * @return a {@link List} of {@link ShowDTO} objects representing all the shows
     */
    @RequestMapping("fetchAll")
    @ResponseBody
    public List<ShowDTO> fetchAll() {
        showRepository.loadData();
        return showServices.fetchAll();
    }

    /**
     * Fetches a show based on the provided show ID.
     *
     * <p>
     *     This API endpoint fetches a show based on the provided show ID.
     * </p>
     *
     * @param id the ID of the show to fetch
     * @return the {@link ShowDTO} object representing the fetched show
     */
    @RequestMapping("fetchByID/{id}")
    @ResponseBody
    public ShowDTO fetchByID(@PathVariable int id) {
        showRepository.loadData();
        return showServices.fetchByID(id);
    }

    /**
     * Deletes a show based on the provided show ID.
     *
     * <p>
     *     This API endpoint deletes a show based on the provided show ID.
     * </p>
     *
     * @param id the ID of the show to delete
     * @return a boolean indicating whether the deletion was successful
     */
    @RequestMapping("delete/{id}")
    @ResponseBody
    public boolean delete(@PathVariable int id) {
        showRepository.loadData();
        return showServices.delete(id);
    }
}
