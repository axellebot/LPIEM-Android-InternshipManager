package com.lp.iem.internshipmanager.presentation.model;

import android.content.ContentValues;

import com.lp.iem.internshipmanager.presentation.model.student_property.AddressProperty;
import com.lp.iem.internshipmanager.presentation.model.student_property.EmailProperty;
import com.lp.iem.internshipmanager.presentation.model.student_property.NumberProperty;
import com.lp.iem.internshipmanager.presentation.model.student_property.OrganizationProperty;
import com.lp.iem.internshipmanager.presentation.model.student_property.WebsiteProperty;

import java.util.List;
import java.util.UUID;

public class Student {
    private String id;
    private String fname;
    private String lname;
    private String notes;
    private List<EmailProperty> emailList;
    private List<NumberProperty> numberList;
    private List<AddressProperty> addressList;
    private List<OrganizationProperty> organizationList;
    private List<WebsiteProperty> webSites;

    private List<File> fileList;
    private List<Schedule> scheduleList;

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

    public List<EmailProperty> getEmailList() {
        return emailList;
    }

    public void setEmailList(List<EmailProperty> emailList) {
        this.emailList = emailList;
    }

    public List<NumberProperty> getNumberList() {
        return numberList;
    }

    public void setNumberList(List<NumberProperty> numberList) {
        this.numberList = numberList;
    }

    public List<AddressProperty> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<AddressProperty> addressList) {
        this.addressList = addressList;
    }

    public List<OrganizationProperty> getOrganizationList() {
        return organizationList;
    }

    public void setOrganizationList(List<OrganizationProperty> organizationList) {
        this.organizationList = organizationList;
    }

    public List<WebsiteProperty> getWebSites() {
        return webSites;
    }

    public void setWebSites(List<WebsiteProperty> webSites) {
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
