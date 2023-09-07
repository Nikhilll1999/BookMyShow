
package com.nctech.bookmyshow.entity;

import lombok.Data;

/**
 * The UsersEntity class represents a user object
 */
@Data
public class UsersEntity {
    private Integer id;
    private String userName;
    private String password;
    private String name;
    private Integer age;
    private String email;
    private String contact;
    private String userType;
}

