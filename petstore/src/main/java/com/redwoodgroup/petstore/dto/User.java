package com.redwoodgroup.petstore.dto;

public class User {
   private int id;
   private String username;
   private String firstName;
   private String lastName;
   private  String email;
   private String password;
   private String phone;
   private int userStatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = 1234;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = "mccarthy";
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = "thaga";
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = "matjomane";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = "thagamccarthy@gmail.com";
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = "12345";
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = "0646603393";
    }

    public int getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", userStatus=" + userStatus +
                '}';
    }
}
