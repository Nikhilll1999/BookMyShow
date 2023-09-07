package com.nctech.bookmyshow.services.impl;

import com.nctech.bookmyshow.constants.Constants;
import com.nctech.bookmyshow.dto.LoginRequest;
import com.nctech.bookmyshow.dto.UserDTO;
import com.nctech.bookmyshow.repositories.UserRepository;
import com.nctech.bookmyshow.repositories.impl.UserRepositoryImpl;
import com.nctech.bookmyshow.services.loginservices.LoginServices;

import java.util.Random;

public class LoginServicesImpl implements LoginServices {

    UserRepository userRepository = new UserRepositoryImpl();
    @Override
    public String login(LoginRequest loginRequest) {
        for (UserDTO tempUser : userRepository.get()) {
            if (tempUser.getUserName().equals(loginRequest.getUserName()) && tempUser.getPassword().equals(loginRequest.getPassword())) {
                return "Login Success As "+tempUser.getUserType();
            }
        }
        return "Login Failed!";
    }

    @Override
    public boolean signup(UserDTO user) {


        userRepository.save(user);

        if (user.getUserType().equals(Constants.Login.ADMIN)) {
            return true;
        }

        if (user.getUserName().equals(Constants.Login.USER)) {
            return false;
        }
        return false;
    }

    @Override
    public String askUserName() {
        return null;
    }

    @Override
    public String askPassWord() {
        return null;
    }

    @Override
    public String askFullName() {
        return null;
    }

    @Override
    public String askDOB() {
        return null;
    }

    @Override
    public String askContact() {
        return null;
    }

    @Override
    public int generateUserID() {
        UserDTO admin = new UserDTO();
        Random r = new Random(System.currentTimeMillis());
        admin.setId(1 + r.nextInt(99));
        return admin.getId();
    }

    @Override
    public String askUserType() {
        return null;
    }
    @Override
    public UserDTO askUserDetails() {
        return null;
    }
}
