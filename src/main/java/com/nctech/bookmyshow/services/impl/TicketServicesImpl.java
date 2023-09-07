package com.nctech.bookmyshow.services.impl;

import com.nctech.bookmyshow.dto.TicketDTO;
import com.nctech.bookmyshow.repositories.TicketRepository;
import com.nctech.bookmyshow.repositories.impl.TicketRepositoryImpl;
import com.nctech.bookmyshow.services.ticketservices.TicketServices;

import java.util.List;
import java.util.Objects;

public class TicketServicesImpl implements TicketServices {

    TicketRepository ticketRepository = new TicketRepositoryImpl();
    @Override
    public void save(TicketDTO ticket) {
        ticket.setId(ticketRepository.get().size() + 1);
        ticketRepository.save(ticket);
    }

    @Override
    public List<TicketDTO> fetchAll() {
        return ticketRepository.get();
    }

    @Override
    public TicketDTO fetchByID(Integer id) {
        for (TicketDTO ticket : ticketRepository.get()) {
            if (Objects.equals(id, ticket.getId())) {
                return ticket;
            }
        }
        return null;
    }

    @Override
    public void update(TicketDTO ticket) {
        for (TicketDTO existingTicket : ticketRepository.get()) {
            if (Objects.equals(ticket.getId(), existingTicket.getId())) {
                existingTicket.setMovie(ticket.getMovie());
                existingTicket.setTime(ticket.getTime());
                existingTicket.setPrice(ticket.getPrice());
                existingTicket.setSeatNumber(ticket.getSeatNumber());
                break;
            }
        }
    }

    @Override
    public boolean delete(Integer id) {
        TicketDTO ticket = fetchByID(id);
        List<TicketDTO> shows = ticketRepository.get();
        return shows.remove(ticket);
    }
}
