package com.nctech.bookmyshow.controllers;

import com.nctech.bookmyshow.dto.TicketDTO;
import com.nctech.bookmyshow.repositories.TicketRepository;
import com.nctech.bookmyshow.repositories.impl.TicketRepositoryImpl;
import com.nctech.bookmyshow.services.impl.TicketServicesImpl;
import com.nctech.bookmyshow.services.ticketservices.TicketServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for handling ticket-related API endpoints.
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/bookmyshow/ticket/")
public class TicketController {
    TicketServices ticketServices = new TicketServicesImpl();
    TicketRepository ticketRepository = new TicketRepositoryImpl();

    /**
     * Creates or updates a ticket based on the provided {@link TicketDTO} object.
     *
     * @param ticket the {@link TicketDTO} object representing the ticket details
     */
    @RequestMapping({"create", "update"})
    public void createOrUpdateTicket(@RequestBody TicketDTO ticket) {
        ticketRepository.loadData();
        ticketRepository.saveToFile();
        if (ticket.getId() == null) {
            ticketServices.save(ticket);
        } else {
            ticketServices.update(ticket);
        }
    }

    /**
     * Fetches all tickets stored in the system.
     *
     * @return a {@link List} of {@link TicketDTO} objects representing all the tickets
     */
    @RequestMapping("fetchAll")
    @ResponseBody
    public List<TicketDTO> fetchAll() {
        ticketRepository.loadData();
        return ticketServices.fetchAll();
    }

    /**
     * Fetches a ticket based on the provided ticket ID.
     *
     * @param id the ID of the ticket to fetch
     * @return the {@link TicketDTO} object representing the fetched ticket
     */
    @RequestMapping("fetchByID/{id}")
    @ResponseBody
    public TicketDTO fetchByID(@PathVariable int id) {
        ticketRepository.loadData();
        return ticketServices.fetchByID(id);
    }

    /**
     * Deletes a ticket based on the provided ticket ID.
     *
     * @param id the ID of the ticket to delete
     * @return a boolean indicating whether the deletion was successful
     */
    @RequestMapping("delete/{id}")
    @ResponseBody
    public boolean delete(@PathVariable int id) {
        ticketRepository.loadData();
        return ticketServices.delete(id);
    }
}
