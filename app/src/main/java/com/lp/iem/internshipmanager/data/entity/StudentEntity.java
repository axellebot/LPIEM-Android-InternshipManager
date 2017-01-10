package com.lp.iem.internshipmanager.data.entity;

import com.lp.iem.internshipmanager.data.entity.student_property.AddressPropertyEntity_Table;
import com.lp.iem.internshipmanager.data.entity.student_property.EmailPropertyEntity_Table;
import com.lp.iem.internshipmanager.data.entity.student_property.NumberPropertyEntity_Table;
import com.lp.iem.internshipmanager.data.entity.student_property.OrganizationPropertyEntity_Table;
import com.lp.iem.internshipmanager.data.entity.student_property.WebsitePropertyEntity_Table;
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
        addressList = new ArrayList<>();
        emailList = new ArrayList<>();
        numberList = new ArrayList<>();
        websiteList = new ArrayList<>();
        fileList = new ArrayList<>();
        organizationList = new ArrayList<>();
        scheduleList = new ArrayList<>();
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

    public void setAddressList(List<AddressEntity> addressList) {
        this.addressList = addressList;
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

    public void setEmailList(List<EmailEntity> emailList) {
        this.emailList = emailList;
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

    public void setNumberList(List<NumberEntity> numberList) {
        this.numberList = numberList;
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

    public void setWebsiteList(List<WebsiteEntity> websiteList) {
        this.websiteList = websiteList;
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

    public void setFileList(List<FileEntity> fileList) {
        this.fileList = fileList;
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

    public void setOrganizationList(List<OrganizationEntity> organizationList) {
        this.organizationList = organizationList;
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

    public void setScheduleList(List<ScheduleEntity> scheduleList) {
        this.scheduleList = scheduleList;
    }


}
