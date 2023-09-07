package com.nctech.bookmyshow.services.impl;

import com.nctech.bookmyshow.dto.UserDTO;
import com.nctech.bookmyshow.repositories.UserRepository;
import com.nctech.bookmyshow.repositories.impl.UserRepositoryImpl;
import com.nctech.bookmyshow.services.userservices.UserServices;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

public class UserServicesImpl implements UserServices {
    UserRepository userRepository = new UserRepositoryImpl();
    @Override
    public void save(UserDTO user) {
        userRepository.save(user);
    }

    @Override
    public UserDTO fetchByID(Integer id) {
        ListIterator<UserDTO> iterator = userRepository.get().listIterator();
        while (iterator.hasNext()) {
            UserDTO user = iterator.next();
            if (Objects.equals(user.getId(), id)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<UserDTO> fetchAll() {
        return userRepository.get();
    }

    @Override
    public void update(UserDTO newUser) {
        for (UserDTO existingUser : userRepository.toArrayList()) {
            existingUser.setId(newUser.getId());
            existingUser.setUserName(newUser.getUserName());
            existingUser.setPassword(newUser.getPassword());
            existingUser.setName(newUser.getName());
            existingUser.setAge(newUser.getAge());
            existingUser.setContact(newUser.getContact());
            existingUser.setEmail(newUser.getEmail());
            existingUser.setUserType(newUser.getUserType());
        }
    }

    @Override
    public boolean delete(Integer id) {
        return userRepository.toArrayList().remove(fetchByID(id));
    }
}
