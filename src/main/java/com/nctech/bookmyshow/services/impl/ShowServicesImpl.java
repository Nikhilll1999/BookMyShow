package com.nctech.bookmyshow.services.impl;

import com.nctech.bookmyshow.dto.ShowDTO;
import com.nctech.bookmyshow.repositories.ShowRepository;
import com.nctech.bookmyshow.repositories.impl.ShowRepositoryImpl;
import com.nctech.bookmyshow.services.showservices.ShowServices;

import java.util.List;
import java.util.Objects;

public class ShowServicesImpl implements ShowServices {

    ShowRepository showRepository = new ShowRepositoryImpl();
    @Override
    public void save(ShowDTO show) {
        show.setId(showRepository.get().size() + 1);
        showRepository.save(show);
    }

    @Override
    public List<ShowDTO> fetchAll() {
        return showRepository.get();
    }

    @Override
    public ShowDTO fetchByID(Integer id) {
        for (ShowDTO show : showRepository.get()) {
            if (Objects.equals(id, show.getId())) {
                return show;
            }
        }
        return null;
    }

    @Override
    public void update(ShowDTO show) {
        for (ShowDTO existingShow : showRepository.get()) {
            if (Objects.equals(show.getId(), existingShow.getId())) {
                existingShow.setName(show.getName());
                existingShow.setGenre(show.getGenre());
                existingShow.setRating(show.getRating());
                existingShow.setDescription(show.getDescription());
                break;
            }
        }
    }

    @Override
    public boolean delete(Integer id) {
        ShowDTO show = fetchByID(id);
        List<ShowDTO> shows = showRepository.get();
        return shows.remove(show);
    }
}
