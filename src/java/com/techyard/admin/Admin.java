package com.techyard.admin;

public class Admin {

    // Veriable of table fileds
    String A_Name, A_Email, A_Contact, A_Passeword;

    // Constructor
    public Admin(String a_Name, String a_Email, String a_Contact, String a_Passeword) {
        A_Name = a_Name;
        A_Email = a_Email;
        A_Contact = a_Contact;
        A_Passeword = a_Passeword;
    }

    // Setter
    public void setA_Name(String a_Name) {
        A_Name = a_Name;
    }

    public void setA_Email(String a_Email) {
        A_Email = a_Email;
    }

    public void setA_Contact(String a_Contact) {
        A_Contact = a_Contact;
    }

    public void setA_Passeword(String a_Passeword) {
        A_Passeword = a_Passeword;
    }

    // Getter
    public String getA_Name() {
        return A_Name;
    }

    public String getA_Email() {
        return A_Email;
    }

    public String getA_Contact() {
        return A_Contact;
    }

    public String getA_Passeword() {
        return A_Passeword;
    }
}