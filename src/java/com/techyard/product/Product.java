package com.techyard.product;

public class Product {
    String P_Name, P_Id, P_Image, P_Info;
    int P_Price;
    
    // Constructor
    public Product(String p_Name, String p_Id, String p_Image, String p_Info, int p_Price) {
        P_Name = p_Name;
        P_Id = p_Id;
        P_Image = p_Image;
        P_Info = p_Info;
        P_Price = p_Price;
    }

    Product() {}

    // Getter and Setter
    public String getP_Name() {
        return P_Name;
    }

    public void setP_Name(String p_Name) {
        P_Name = p_Name;
    }

    public String getP_Id() {
        return P_Id;
    }

    public void setP_Id(String p_Id) {
        P_Id = p_Id;
    }

    public String getP_Image() {
        return P_Image;
    }

    public void setP_Image(String p_Image) {
        P_Image = p_Image;
    }

    public String getP_Info() {
        return P_Info;
    }

    public void setP_Info(String p_Info) {
        P_Info = p_Info;
    }

    public int getP_Price() {
        return P_Price;
    }

    public void setP_Price(int p_Price) {
        P_Price = p_Price;
    }
}