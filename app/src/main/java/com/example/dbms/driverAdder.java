package com.example.dbms;

public class driverAdder {

    //DECLARE THEM
    String names;
    String licensenos;
    String statuss;
    String genderss;
    String bloods;
    String nationals;
    String eyes;
    String weightt;
    String heightt;
    String adresss;
    String agencycodes;
    String dlcodes;
    String conditionss;


    //HOLD THEM
    public driverAdder(String names, String licensenos, String statuss, String genderss, String bloods, String nationals, String eyes, String weightt, String heightt, String adresss, String agencycodes, String dlcodes, String conditionss) {
        this.names = names;
        this.licensenos = licensenos;
        this.statuss = statuss;
        this.genderss = genderss;
        this.bloods = bloods;
        this.nationals = nationals;
        this.eyes = eyes;
        this.weightt = weightt;
        this.heightt = heightt;
        this.adresss = adresss;
        this.agencycodes = agencycodes;
        this.dlcodes = dlcodes;
        this.conditionss = conditionss;
    }

    //GIVE THEM
    public String getNames() {
        return names;
    }

    public String getLicensenos() {
        return licensenos;
    }

    public String getStatuss() {
        return statuss;
    }

    public String getGenderss() {
        return genderss;
    }

    public String getBloods() {
        return bloods;
    }

    public String getNationals() {
        return nationals;
    }

    public String getEyes() {
        return eyes;
    }

    public String getWeightt() {
        return weightt;
    }

    public String getHeightt() {
        return heightt;
    }

    public String getAdresss() {
        return adresss;
    }

    public String getAgencycodes() {
        return agencycodes;
    }

    public String getDlcodes() {
        return dlcodes;
    }

    public String getConditionss() {
        return conditionss;
    }
}
