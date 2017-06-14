package org.bayon.form.validation;

/**
 * Created by Chandara Leang on 6/14/2017.
 */

public class UserInput {
    private String name;
    private String gender;
    private String dateOfBirth;
    private String email;
    private String password;
    private String SSN;
    private String phone;
    private String street;
    private String city;
    private String state;
    private String zip;
    private boolean isInputValid;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getGender(){
        return gender;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public String getDateOfBirth(){
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth){
        this.dateOfBirth =dateOfBirth;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getSSN(){
        return SSN;
    }

    public void setSSN(String SSN){
        this.SSN = SSN;
    }

    public String getPhone(){
        return phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getStreet(){
        return street;
    }

    public void setStreet(String street){
        this.street = street;
    }

    public String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city = city;
    }

    public String getState(){
        return state;
    }

    public void setState(String state){
        this.state = state;
    }

    public String getZip(){
        return zip;
    }

    public void setZip(String zip){
        this.zip = zip;
    }

    public boolean isInputValid(){
        return isInputValid;
    }

    public void setInputValid(boolean isInputValid){
        this.isInputValid = isInputValid;
    }
}
