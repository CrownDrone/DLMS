package com.example.dbms;

public class forGate {//this class just hold values for filling field
    static String passLicense, passID;

    public void setPassLicense(String passLicense) {
        this.passLicense = passLicense;
    }
    public String getPassLicense(){
        return this.passLicense;
    }
    public String getPassID() {
        return passID;
    }

    public void setPassID(String passID) {
        forGate.passID = passID;
    }
}
