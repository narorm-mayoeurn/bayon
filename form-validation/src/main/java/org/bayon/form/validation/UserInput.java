package org.bayon.form.validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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
        this.dateOfBirth = dateOfBirth;
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

    public int underEighteen() throws ParseException {
        int age = 0;
        int factor = 0;
        Date currentDate = new Date();
        Calendar cal1 = new GregorianCalendar();
        Calendar cal2 = new GregorianCalendar();
        Date dob = new SimpleDateFormat("MM/dd/yyyy").parse(dateOfBirth);

        cal1.setTime(dob);
        cal2.setTime(currentDate);

        if(cal2.get(Calendar.DAY_OF_YEAR)<cal1.get(Calendar.DAY_OF_YEAR)){
            factor = -1;
        }

        age = cal2.get(Calendar.YEAR) - cal1.get(Calendar.YEAR) + factor;
        return age;
    }
}
