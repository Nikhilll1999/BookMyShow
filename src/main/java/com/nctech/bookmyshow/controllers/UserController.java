package com.nctech.bookmyshow.controllers;

import com.nctech.bookmyshow.dto.LoginRequest;
import com.nctech.bookmyshow.dto.UserDTO;
import com.nctech.bookmyshow.repositories.UserRepository;
import com.nctech.bookmyshow.repositories.impl.UserRepositoryImpl;
import com.nctech.bookmyshow.services.impl.LoginServicesImpl;
import com.nctech.bookmyshow.services.impl.UserServicesImpl;
import com.nctech.bookmyshow.services.loginservices.LoginServices;
import com.nctech.bookmyshow.services.userservices.UserServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for handling user-related API endpoints.
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/bookmyshow/user/")
public class UserController {
    LoginServices loginServices = new LoginServicesImpl();
    UserServices userServices = new UserServicesImpl();
    UserRepository userRepository = new UserRepositoryImpl();

    /**
     * Creates or updates a user based on the provided {@link UserDTO} object.
     *
     * @param user the {@link UserDTO} object representing the user details
     */
    @RequestMapping({"signup", "update"})
    public void createOrUpdateUser(@RequestBody UserDTO user) {
        userRepository.loadData();
        userRepository.saveToFile();

        if (user.getId() == null) {
            loginServices.signup(user);
        } else {
            userServices.update(user);
        }
    }

    /**
     * Authenticates a user based on the provided login credentials.
     *
     * @param loginRequest the {@link LoginRequest} object containing the login credentials
     * @return a string representing the authentication status
     */
    @RequestMapping("login")
    @ResponseBody
    public String login(@RequestBody LoginRequest loginRequest) {
        userRepository.loadData();
        return loginServices.login(loginRequest);
    }

    /**
     * Fetches all users stored in the system.
     *
     * @return a {@link List} of {@link UserDTO} objects representing all the users
     */
    @RequestMapping("fetchAll")
    @ResponseBody
    public List<UserDTO> fetchAll() {
        userRepository.loadData();
        return userServices.fetchAll();
    }

    /**
     * Fetches a user based on the provided user ID.
     *
     * @param id the ID of the user to fetch
     * @return the {@link UserDTO} object representing the fetched user
     */
    @RequestMapping("fetchByID/{id}")
    @ResponseBody
    public UserDTO fetchByID(@PathVariable int id) {
        userRepository.loadData();
        return userServices.fetchByID(id);
    }

    /**
     * Deletes a user based on the provided user ID.
     *
     * @param id the ID of the user to delete
     * @return a boolean indicating whether the deletion was successful
     */
    @RequestMapping("delete/{id}")
    @ResponseBody
    public boolean delete(@PathVariable int id) {
        userRepository.loadData();
        return userServices.delete(id);
    }
}
