package com.nctech.bookmyshow.services.loginservices;

import com.nctech.bookmyshow.dto.LoginRequest;
import com.nctech.bookmyshow.dto.UserDTO;

public interface LoginServices {
    public String login(LoginRequest loginRequest);
    public boolean signup(UserDTO user);
    public String askUserName();
    public String askPassWord();
    public String askFullName();
    public String askDOB();
    public String askContact();
    public int generateUserID();
    public String askUserType();
    public UserDTO askUserDetails();
}
