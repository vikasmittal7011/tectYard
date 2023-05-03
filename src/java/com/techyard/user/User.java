package com.techyard.user;
public class User {

    //Data types
    String U_Name, U_Email, U_Contact, U_Password, U_Street, U_City, U_State, U_Pincode;
    int U_Age, U_HouseNo;
    
    //Constructor
    public User(String u_Name, String u_Email, String u_Contact, String u_Password, String u_Street, String u_City, String u_State, String u_Pincode, int u_Age, int u_HouseNo) {
        U_Name = u_Name;
        U_Email = u_Email;
        U_Contact = u_Contact;
        U_Password = u_Password;
        U_Street = u_Street;
        U_City = u_City;
        U_State = u_State;
        U_Pincode = u_Pincode;
        U_Age = u_Age;
        U_HouseNo = u_HouseNo;
    }

    public User(String u_Name, String u_Email, String u_Contact, String u_Password, int u_Age) {
        U_Name = u_Name;
        U_Email = u_Email;
        U_Contact = u_Contact;
        U_Password = u_Password;
        U_Age = u_Age;
    }

    public User(String u_Email, String u_Street, String u_City, String u_State, String u_Pincode, int u_HouseNo) {
        U_Email = u_Email;
        U_Street = u_Street;
        U_City = u_City;
        U_State = u_State;
        U_Pincode = u_Pincode;
        U_HouseNo = u_HouseNo;
    }

    public User(String u_Email, String u_Password) {
        U_Email = u_Email;
        U_Password = u_Password;
    }

    public User() {}

    //Setters
    public void setU_Name(String u_Name) {
        U_Name = u_Name;
    }

    public void setU_Email(String u_Email) {
        U_Email = u_Email;
    }

    public void setU_Contact(String u_Contact) {
        U_Contact = u_Contact;
    }

    public void setU_Password(String u_Password) {
        U_Password = u_Password;
    }

    public void setU_Street(String u_Street) {
        U_Street = u_Street;
    }

    public void setU_City(String u_City) {
        U_City = u_City;
    }

    public void setU_State(String u_State) {
        U_State = u_State;
    }

    public void setU_Pincode(String u_Pincode) {
        U_Pincode = u_Pincode;
    }

    public void setU_Age(int u_Age) {
        U_Age = u_Age;
    }

    public void setU_HouseNo(int u_HouseNo) {
        U_HouseNo = u_HouseNo;
    }

    //Getter
    public String getU_Name() {
        return U_Name;
    }

    public String getU_Email() {
        return U_Email;
    }

    public String getU_Contact() {
        return U_Contact;
    }

    public String getU_Password() {
        return U_Password;
    }

    public String getU_Street() {
        return U_Street;
    }

    public String getU_City() {
        return U_City;
    }

    public String getU_State() {
        return U_State;
    }

    public String getU_Pincode() {
        return U_Pincode;
    }

    public int getU_Age() {
        return U_Age;
    }

    public int getU_HouseNo() {
        return U_HouseNo;
    }
}