package com.techyard.orderAndcart;

public class CancelOrder {
    int C_Id;
    String U_Email, P_Id, C_Reason, C_Date_Of_Cancel, P_Name;

    // Constructors
 
   public CancelOrder(int C_Id, String U_Email, String P_Name, String C_Reason, String C_Date_Of_Cancel) {
        this.C_Id = C_Id;
        this.U_Email = U_Email;
        this.P_Name = P_Name;
        this.C_Reason = C_Reason;
        this.C_Date_Of_Cancel = C_Date_Of_Cancel;
    }
    public CancelOrder(String U_Email, String P_Id, String C_Reason, String C_Date_Of_Cancel) {
        this.U_Email = U_Email;
        this.P_Id = P_Id;
        this.C_Reason = C_Reason;
        this.C_Date_Of_Cancel = C_Date_Of_Cancel;
    }
    
    // Getter & Setter
    public int getC_Id() {
        return C_Id;
    }

    public void setC_Id(int C_Id) {
        this.C_Id = C_Id;
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

    public String getC_Reason() {
        return C_Reason;
    }

    public void setC_Reason(String C_Reason) {
        this.C_Reason = C_Reason;
    }

    public String getC_Date_Of_Cancel() {
        return C_Date_Of_Cancel;
    }

    public void setC_Date_Of_Cancel(String C_Date_Of_Cancel) {
        this.C_Date_Of_Cancel = C_Date_Of_Cancel;
    }

    public String getP_Name() {
        return P_Name;
    }

    public void setP_Name(String P_Name) {
        this.P_Name = P_Name;
    }
}