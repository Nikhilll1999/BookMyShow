package com.nctech.bookmyshow.services.impl;

import com.nctech.bookmyshow.dto.TheaterDTO;
import com.nctech.bookmyshow.repositories.TheaterRepository;
import com.nctech.bookmyshow.repositories.impl.TheaterRepositoryImpl;
import com.nctech.bookmyshow.services.theaterservices.TheaterServices;

import java.util.List;
import java.util.Objects;

public class TheaterServicesImpl implements TheaterServices {
    
    TheaterRepository theaterRepository = new TheaterRepositoryImpl();
    @Override
    public void save(TheaterDTO theater) {
        theater.setId(theaterRepository.get().size() + 1);
        theaterRepository.save(theater);
    }

    @Override
    public List<TheaterDTO> fetchAll() {
        return theaterRepository.get();
    }

    @Override
    public TheaterDTO fetchByID(Integer id) {
        for (TheaterDTO theater : theaterRepository.get()) {
            if (Objects.equals(id, theater.getId())) {
                return theater;
            }
        }
        return null;
    }

    @Override
    public void update(TheaterDTO theater) {
        for (TheaterDTO existingTheater : theaterRepository.get()) {
            if (theater.getId() == existingTheater.getId()) {
                existingTheater.setName(theater.getName());
                existingTheater.setLocation(theater.getLocation());
                existingTheater.setNoOfScreens(theater.getNoOfScreens());
                existingTheater.setCapacity(theater.getCapacity());
                break;
            }
        }
    }

    @Override
    public boolean delete(Integer id) {
        TheaterDTO theater = fetchByID(id);
        List<TheaterDTO> theaters = theaterRepository.get();
        return theaters.remove(theater);
    }
}
