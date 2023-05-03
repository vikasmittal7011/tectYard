package com.techyard.orderAndcart;

public class Order {
    // Id's of order, payment, delivery table
    int O_Id, Pay_Id, D_Id, P_Price;
    // Basic attribute and one product id
    String U_Email, P_Id, DOB, DOD, U_Address, U_Name, U_Contact, P_Name, P_Info;
    boolean Pay_Status, D_Status; 

    // Constructor
    public Order() {
    }

    public Order(int O_Id, int Pay_Id, int D_Id, int P_Price, String U_Email, String P_Id, String DOB, String DOD, String U_Address, String U_Name, String U_Contact, String P_Name, String P_Info, boolean Pay_Status, boolean D_Status) {
        this.O_Id = O_Id;
        this.Pay_Id = Pay_Id;
        this.D_Id = D_Id;
        this.P_Price = P_Price;
        this.U_Email = U_Email;
        this.P_Id = P_Id;
        this.DOB = DOB;
        this.DOD = DOD;
        this.U_Address = U_Address;
        this.U_Name = U_Name;
        this.U_Contact = U_Contact;
        this.P_Name = P_Name;
        this.P_Info = P_Info;
        this.Pay_Status = Pay_Status;
        this.D_Status = D_Status;
    }

    public Order(int O_Id, int Pay_Id, int P_Price, String U_Email, String P_Id, String DOB, String DOD, String U_Address, String U_Name, String U_Contact, String P_Name, String P_Info, boolean Pay_Status) {
        this.O_Id = O_Id;
        this.Pay_Id = Pay_Id;
        this.P_Price = P_Price;
        this.U_Email = U_Email;
        this.P_Id = P_Id;
        this.DOB = DOB;
        this.DOD = DOD;
        this.U_Address = U_Address;
        this.U_Name = U_Name;
        this.U_Contact = U_Contact;
        this.P_Name = P_Name;
        this.P_Info = P_Info;
        this.Pay_Status = Pay_Status;
    }

    public int getO_Id() {
        return O_Id;
    }

    public void setO_Id(int O_Id) {
        this.O_Id = O_Id;
    }

    public int getPay_Id() {
        return Pay_Id;
    }

    public void setPay_Id(int Pay_Id) {
        this.Pay_Id = Pay_Id;
    }

    public int getD_Id() {
        return D_Id;
    }

    public void setD_Id(int D_Id) {
        this.D_Id = D_Id;
    }

    public String getU_Email() {
        return U_Email;
    }

    public void setU_Email(String U_Email) {
        this.U_Email = U_Email;
    }

    public String getP_Id() {
        return P_Id;
    }

    public void setP_Id(String P_Id) {
        this.P_Id = P_Id;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getDOD() {
        return DOD;
    }

    public void setDOD(String DOD) {
        this.DOD = DOD;
    }

    public String getU_Address() {
        return U_Address;
    }

    public void setU_Address(String U_Address) {
        this.U_Address = U_Address;
    }

    public String getU_Name() {
        return U_Name;
    }

    public void setU_Name(String U_Name) {
        this.U_Name = U_Name;
    }

    public String getU_Contact() {
        return U_Contact;
    }

    public void setU_Contact(String U_Contact) {
        this.U_Contact = U_Contact;
    }

    public String getP_Name() {
        return P_Name;
    }

    public void setP_Name(String P_Name) {
        this.P_Name = P_Name;
    }

    public String getP_Info() {
        return P_Info;
    }

    public void setP_Info(String P_Info) {
        this.P_Info = P_Info;
    }

    public int getP_Price() {
        return P_Price;
    }

    public void setP_Price(int P_Price) {
        this.P_Price = P_Price;
    }

    public boolean isPay_Status() {
        return Pay_Status;
    }

    public void setPay_Status(boolean Pay_Status) {
        this.Pay_Status = Pay_Status;
    }

    public boolean isD_Status() {
        return D_Status;
    }

    public void setD_Status(boolean D_Status) {
        this.D_Status = D_Status;
    }
    
}