package com.lp.iem.internshipmanager.data.entity;

import com.lp.iem.internshipmanager.data.entity.student_porperty.AddressEntity;
import com.lp.iem.internshipmanager.data.entity.student_porperty.AddressPropertyEntity_Table;
import com.lp.iem.internshipmanager.data.entity.student_porperty.EmailEntity;
import com.lp.iem.internshipmanager.data.entity.student_porperty.EmailPropertyEntity_Table;
import com.lp.iem.internshipmanager.data.entity.student_porperty.NumberEntity;
import com.lp.iem.internshipmanager.data.entity.student_porperty.NumberPropertyEntity_Table;
import com.lp.iem.internshipmanager.data.entity.student_porperty.OrganizationEntity;
import com.lp.iem.internshipmanager.data.entity.student_porperty.OrganizationPropertyEntity_Table;
import com.lp.iem.internshipmanager.data.entity.student_porperty.WebsiteEntity;
import com.lp.iem.internshipmanager.data.entity.student_porperty.WebsitePropertyEntity_Table;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.OneToMany;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.ArrayList;
import java.util.List;

@Table(database = MyDatabase.class)
public class StudentEntity extends BaseModel {
    @Column
    @PrimaryKey
    public String id;

    @Column
    public String fname;

    @Column
    public String lname;

    @Column
    public String notes;

    List<AddressEntity> addressList;
    List<EmailEntity> emailList;
    List<NumberEntity> numberList;
    List<WebsiteEntity> websiteList;
    List<FileEntity> fileList;
    List<OrganizationEntity> organizationList;
    List<ScheduleEntity> scheduleList;

    public StudentEntity() {
        addressList=new ArrayList<>();
        emailList=new ArrayList<>();
        numberList=new ArrayList<>();
        websiteList=new ArrayList<>();
        fileList=new ArrayList<>();
        organizationList=new ArrayList<>();
        scheduleList=new ArrayList<>();
    }

    public void setAddressList(List<AddressEntity> addressList) {
        this.addressList = addressList;
    }

    public void setEmailList(List<EmailEntity> emailList) {
        this.emailList = emailList;
    }

    public void setNumberList(List<NumberEntity> numberList) {
        this.numberList = numberList;
    }

    public void setWebsiteList(List<WebsiteEntity> websiteList) {
        this.websiteList = websiteList;
    }

    public void setFileList(List<FileEntity> fileList) {
        this.fileList = fileList;
    }

    public void setOrganizationList(List<OrganizationEntity> organizationList) {
        this.organizationList = organizationList;
    }

    public void setScheduleList(List<ScheduleEntity> scheduleList) {
        this.scheduleList = scheduleList;
    }

    @OneToMany(methods = {OneToMany.Method.ALL}, variableName = "addressList")
    public List<AddressEntity> getAddressList() {
        if (addressList == null || addressList.isEmpty()) {
            addressList = SQLite.select()
                    .from(AddressEntity.class)
                    .where(AddressPropertyEntity_Table.student_id.eq(id))
                    .queryList();
        }
        return addressList;
    }

    @OneToMany(methods = {OneToMany.Method.ALL}, variableName = "emailList")
    public List<EmailEntity> getEmailList() {
        if (emailList == null || emailList.isEmpty()) {
            emailList = SQLite.select()
                    .from(EmailEntity.class)
                    .where(EmailPropertyEntity_Table.student_id.eq(id))
                    .queryList();
        }
        return emailList;
    }

    @OneToMany(methods = {OneToMany.Method.ALL}, variableName = "numberList")
    public List<NumberEntity> getNumberList() {
        if (numberList == null || numberList.isEmpty()) {
            numberList = SQLite.select()
                    .from(NumberEntity.class)
                    .where(NumberPropertyEntity_Table.student_id.eq(id))
                    .queryList();
        }
        return numberList;
    }

    @OneToMany(methods = {OneToMany.Method.ALL}, variableName = "websiteList")
    public List<WebsiteEntity> getWebsiteList() {
        if (websiteList == null || websiteList.isEmpty()) {
            websiteList = SQLite.select()
                    .from(WebsiteEntity.class)
                    .where(WebsitePropertyEntity_Table.student_id.eq(id))
                    .queryList();
        }
        return websiteList;
    }

    @OneToMany(methods = {OneToMany.Method.ALL}, variableName = "fileList")
    public List<FileEntity> getFileList() {
        if (fileList == null || fileList.isEmpty()) {
            fileList = SQLite.select()
                    .from(FileEntity.class)
                    .where(FileEntity_Table.student_id.eq(id))
                    .queryList();
        }
        return fileList;
    }

    @OneToMany(methods = {OneToMany.Method.ALL}, variableName = "organizationList")
    public List<OrganizationEntity> getOrganizationList() {
        if (organizationList == null || organizationList.isEmpty()) {
            organizationList = SQLite.select()
                    .from(OrganizationEntity.class)
                    .where(OrganizationPropertyEntity_Table.student_id.eq(id))
                    .queryList();
        }
        return organizationList;
    }

    @OneToMany(methods = {OneToMany.Method.ALL}, variableName = "scheduleList")
    public List<ScheduleEntity> getScheduleList() {
        if (scheduleList == null || scheduleList.isEmpty()) {
            scheduleList = SQLite.select()
                    .from(ScheduleEntity.class)
                    .where(ScheduleEntity_Table.student_id.eq(id))
                    .queryList();
        }
        return scheduleList;
    }


}
