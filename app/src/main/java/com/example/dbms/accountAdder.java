package com.example.dbms;

public class accountAdder {
    String names;
    String accountIDs;
    String adresss;
    String agencycodes;
    String contactnos;
    String ages;
    String emails;
    String passwords;
    String genderss;
    String nationals;
    String birth;
    public accountAdder(String names, String accountIDs, String adresss, String agencycodes, String contactnos, String ages, String emails, String passwords, String genderss, String nationals, String birth) {
        this.names = names;
        this.accountIDs = accountIDs;
        this.adresss = adresss;
        this.agencycodes = agencycodes;
        this.contactnos = contactnos;
        this.ages = ages;
        this.emails = emails;
        this.passwords = passwords;
        this.genderss = genderss;
        this.nationals = nationals;
        this.birth = birth;
    }

    public String getNames() {
        return names;
    }

    public String getAccountIDs() {
        return accountIDs;
    }

    public String getAdresss() {
        return adresss;
    }

    public String getAgencycodes() {
        return agencycodes;
    }

    public String getContactnos() {
        return contactnos;
    }

    public String getAges() {
        return ages;
    }

    public String getEmails() {
        return emails;
    }

    public String getPasswords() {
        return passwords;
    }
    public String getGenderss() {
        return genderss;
    }

    public String getNationals() {
        return nationals;
    }

    public String getBirth(){
        return birth;
    }

}
