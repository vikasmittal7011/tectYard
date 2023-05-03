package com.techyard.orderAndcart;
public class Cart {
    int C_Id, P_Price;
    String P_Id, P_Name, P_Image, P_Info, U_Email;

    // Constructor
    public Cart(int C_Id, int P_Price, String P_Id, String P_Name, String P_Image, String P_Info) {
        this.C_Id = C_Id;
        this.P_Price = P_Price;
        this.P_Id = P_Id;
        this.P_Name = P_Name;
        this.P_Image = P_Image;
        this.P_Info = P_Info;
    }
    
    // Setter & Getter
    public Cart() {
    }

    public int getC_Id() {
        return C_Id;
    }

    public void setC_Id(int c_Id) {
        C_Id = c_Id;
    }

    public int getP_Price() {
        return P_Price;
    }

    public void setP_Price(int p_Price) {
        P_Price = p_Price;
    }

    public String getP_Id() {
        return P_Id;
    }

    public void setP_Id(String p_Id) {
        P_Id = p_Id;
    }

    public String getP_Name() {
        return P_Name;
    }

    public void setP_Name(String p_Name) {
        P_Name = p_Name;
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

    public String getU_Email() {
        return U_Email;
    }

    public void setU_Email(String u_Email) {
        U_Email = u_Email;
    }
}