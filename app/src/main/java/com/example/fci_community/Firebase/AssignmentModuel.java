package com.example.fci_community.Firebase;

public class AssignmentModuel {
    private String Ans_1,Ans_2,Ans_3,Ans_4,R_Ans,Qus;

    public AssignmentModuel() {
    }

    public AssignmentModuel(String ans_1, String ans_2, String ans_3, String ans_4, String r_Ans,String qus) {
        Ans_1 = ans_1;
        Ans_2 = ans_2;
        Ans_3 = ans_3;
        Ans_4 = ans_4;
        R_Ans = r_Ans;
        Qus=qus;

    }

    public String getAns_1() {
        return Ans_1;
    }

    public void setAns_1(String ans_1) {
        Ans_1 = ans_1;
    }

    public String getAns_2() {
        return Ans_2;
    }

    public void setAns_2(String ans_2) {
        Ans_2 = ans_2;
    }

    public String getAns_3() {
        return Ans_3;
    }

    public void setAns_3(String ans_3) {
        Ans_3 = ans_3;
    }

    public String getAns_4() {
        return Ans_4;
    }

    public void setAns_4(String ans_4) {
        Ans_4 = ans_4;
    }

    public String getR_Ans() {
        return R_Ans;
    }

    public void setR_Ans(String r_Ans) {
        R_Ans = r_Ans;
    }

    public String getQus() {
        return Qus;
    }

    public void setQus(String qus) {
        Qus = qus;
    }
}
