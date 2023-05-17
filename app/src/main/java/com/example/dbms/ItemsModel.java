package com.example.dbms;

public class ItemsModel  {
    String drivername;
    String license;
    String status;

    public ItemsModel(String drivername, String license, String status) {
        this.drivername = drivername;
        this.license = license;
        this.status = status;
    }


    public String getDrivername() {
        return drivername;
    }

    public void setDrivername(String drivername) {
        this.drivername = drivername;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
