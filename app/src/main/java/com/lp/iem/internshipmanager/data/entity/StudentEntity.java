package com.lp.iem.internshipmanager.data.entity;

import com.lp.iem.internshipmanager.data.entity.student_porperty.AddressPropertyEntity;
import com.lp.iem.internshipmanager.data.entity.student_porperty.AddressPropertyEntity_Table;
import com.lp.iem.internshipmanager.data.entity.student_porperty.EmailPropertyEntity;
import com.lp.iem.internshipmanager.data.entity.student_porperty.EmailPropertyEntity_Table;
import com.lp.iem.internshipmanager.data.entity.student_porperty.NumberPropertyEntity;
import com.lp.iem.internshipmanager.data.entity.student_porperty.NumberPropertyEntity_Table;
import com.lp.iem.internshipmanager.data.entity.student_porperty.OrganizationPropertyEntity;
import com.lp.iem.internshipmanager.data.entity.student_porperty.OrganizationPropertyEntity_Table;
import com.lp.iem.internshipmanager.data.entity.student_porperty.WebsitePropertyEntity;
import com.lp.iem.internshipmanager.data.entity.student_porperty.WebsitePropertyEntity_Table;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.OneToMany;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.List;

@Table(database = MyDatabase.class)
public class StudentEntity extends BaseModel {
    @Column
    @PrimaryKey
    String uid;

    @Column
    String fname;

    @Column
    String lname;

    @Column
    String notes;

    List<AddressPropertyEntity> addressList;
    List<EmailPropertyEntity> emailList;
    List<NumberPropertyEntity> numberList;
    List<WebsitePropertyEntity> websiteList;
    List<FileEntity> fileList;
    List<OrganizationPropertyEntity> organizationList;

    @OneToMany(methods = {OneToMany.Method.ALL}, variableName = "addressList")
    public List<AddressPropertyEntity> getAddressList() {
        if (addressList == null || addressList.isEmpty()) {
            addressList = SQLite.select()
                    .from(AddressPropertyEntity.class)
                    .where(AddressPropertyEntity_Table.student_uid.eq(uid))
                    .queryList();
        }
        return addressList;
    }

    @OneToMany(methods = {OneToMany.Method.ALL}, variableName = "emailList")
    public List<EmailPropertyEntity> getEmailList() {
        if (emailList == null || emailList.isEmpty()) {
            emailList = SQLite.select()
                    .from(EmailPropertyEntity.class)
                    .where(EmailPropertyEntity_Table.student_uid.eq(uid))
                    .queryList();
        }
        return emailList;
    }

    @OneToMany(methods = {OneToMany.Method.ALL}, variableName = "numberList")
    public List<NumberPropertyEntity> getNumberList() {
        if (numberList == null || numberList.isEmpty()) {
            numberList = SQLite.select()
                    .from(NumberPropertyEntity.class)
                    .where(NumberPropertyEntity_Table.student_uid.eq(uid))
                    .queryList();
        }
        return numberList;
    }

    @OneToMany(methods = {OneToMany.Method.ALL}, variableName = "websiteList")
    public List<WebsitePropertyEntity> getWebsiteList() {
        if (websiteList == null || websiteList.isEmpty()) {
            websiteList = SQLite.select()
                    .from(WebsitePropertyEntity.class)
                    .where(WebsitePropertyEntity_Table.student_uid.eq(uid))
                    .queryList();
        }
        return websiteList;
    }

    @OneToMany(methods = {OneToMany.Method.ALL}, variableName = "fileList")
    public List<FileEntity> getFileList() {
        if (fileList == null || fileList.isEmpty()) {
            fileList = SQLite.select()
                    .from(FileEntity.class)
                    .where(FileEntity_Table.student_uid.eq(uid))
                    .queryList();
        }
        return fileList;
    }

    @OneToMany(methods = {OneToMany.Method.ALL}, variableName = "organizationList")
    public List<OrganizationPropertyEntity> organizationList() {
        if (organizationList == null || organizationList.isEmpty()) {
            organizationList = SQLite.select()
                    .from(OrganizationPropertyEntity.class)
                    .where(OrganizationPropertyEntity_Table.student_uid.eq(uid))
                    .queryList();
        }
        return organizationList;
    }
}
