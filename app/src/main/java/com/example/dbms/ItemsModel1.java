package com.example.dbms;

import java.io.Serializable;

public class ItemsModel1 implements Serializable {
    String accountname;
    String accountid;

    public ItemsModel1(String accountname, String accountid) {
        this.accountname = accountname;
        this.accountid = accountid;
    }


    public String getAccountname() {

        return accountname;
    }

    public void setAccountname(String accountname) {

        this.accountname = accountname;
    }

    public String getAccountid() {

        return accountid;
    }

    public void setAccountid(String accountid) {
        this.accountid = accountid;
    }


}


