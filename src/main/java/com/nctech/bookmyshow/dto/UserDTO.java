package com.nctech.bookmyshow.dto;

/**
 * Represents a user data transfer object (DTO) used for transferring user information.
 */
public class UserDTO {
    private Integer id;
    private String userName;
    private String password;
    private String name;
    private Integer age;
    private String email;
    private String contact;
    private String userType;

    /**
     * Default constructor for the UserDTO class.
     */
    public UserDTO() {
    }

    /**
     * Constructor for the UserDTO class with parameters.
     * **Callouts:** Use this constructor to create a new UserDTO object with the specified details
     *
     * @param id       the user ID
     * @param userName the username
     * @param password the password
     * @param name     the user's name
     * @param age      the user's age
     * @param email    the user's email address
     * @param contact  the user's contact number
     * @param userType the user's type (e.g., "admin", "customer", etc.)
     */
    public UserDTO(Integer id, String userName, String password, String name, Integer age, String email, String contact, String userType) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.age = age;
        this.email = email;
        this.contact = contact;
        this.userType = userType;
    }

    /**
     * Retrieves the user's ID.
     *
     * @return the user's ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the user's ID.
     *
     * @param id the user's ID to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Retrieves the username.
     *
     * @return the username
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the username.
     *
     * @param userName the username to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Retrieves the password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     *
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Retrieves the user's name.
     *
     * @return the user's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the user's name.
     *
     * @param name the user's name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the user's age.
     *
     * @return the user's age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * Sets the user's age.
     *
     * @param age the user's age to set
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * Retrieves the user's email address.
     *
     * @return the user's email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the user's email address.
     *
     * @param email the user's email address to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retrieves the user's contact number.
     *
     * @return the user's contact number
     */
    public String getContact() {
        return contact;
    }

    /**
     * Sets the user's contact number.
     *
     * @param contact the user's contact number to set
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * Retrieves the user's type.
     *
     * @return the user's type
     */
    public String getUserType() {
        return userType;
    }

    /**
     * Sets the user's type.
     *
     * @param userType the user's type to set
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
