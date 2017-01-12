package com.lp.iem.internshipmanager.presentation.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Student {
    private String id;
    private String fname;
    private String lname;
    private String notes;
    private List<Email> emailList;
    private List<Number> numberList;
    private List<Address> addressList;
    private List<Organization> organizationList;
    private List<Website> webSites;
    private List<File> fileList;
    private List<Schedule> scheduleList;

    public Student() {
        this.id = UUID.randomUUID().toString();
        this.emailList = new ArrayList<>();
        this.numberList = new ArrayList<>();
        this.addressList = new ArrayList<>();
        this.organizationList = new ArrayList<>();
        this.webSites = new ArrayList<>();
        this.fileList = new ArrayList<>();
        this.scheduleList = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<Email> getEmailList() {
        return emailList;
    }

    public void setEmailList(List<Email> emailList) {
        this.emailList = emailList;
    }

    public List<Number> getNumberList() {
        return numberList;
    }

    public void setNumberList(List<Number> numberList) {
        this.numberList = numberList;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public List<Organization> getOrganizationList() {
        return organizationList;
    }

    public void setOrganizationList(List<Organization> organizationList) {
        this.organizationList = organizationList;
    }

    public List<Website> getWebSites() {
        return webSites;
    }

    public void setWebSites(List<Website> webSites) {
        this.webSites = webSites;
    }

    public List<File> getFileList() {
        return fileList;
    }

    public void setFileList(List<File> fileList) {
        this.fileList = fileList;
    }

    public List<Schedule> getScheduleList() {
        return scheduleList;
    }

    public void setScheduleList(List<Schedule> scheduleList) {
        this.scheduleList = scheduleList;
    }
}
