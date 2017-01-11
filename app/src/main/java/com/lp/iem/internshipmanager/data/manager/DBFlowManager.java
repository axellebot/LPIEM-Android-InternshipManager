package com.lp.iem.internshipmanager.data.manager;

import android.support.annotation.NonNull;

import com.lp.iem.internshipmanager.data.entity.AddressEntity;
import com.lp.iem.internshipmanager.data.entity.EmailEntity;
import com.lp.iem.internshipmanager.data.entity.FileEntity;
import com.lp.iem.internshipmanager.data.entity.NumberEntity;
import com.lp.iem.internshipmanager.data.entity.OrganizationEntity;
import com.lp.iem.internshipmanager.data.entity.ScheduleEntity;
import com.lp.iem.internshipmanager.data.entity.StudentEntity;
import com.lp.iem.internshipmanager.data.entity.WebsiteEntity;
import com.lp.iem.internshipmanager.presentation.model.Address;
import com.lp.iem.internshipmanager.presentation.model.Email;
import com.lp.iem.internshipmanager.presentation.model.File;
import com.lp.iem.internshipmanager.presentation.model.Number;
import com.lp.iem.internshipmanager.presentation.model.Organization;
import com.lp.iem.internshipmanager.presentation.model.Schedule;
import com.lp.iem.internshipmanager.presentation.model.Student;
import com.lp.iem.internshipmanager.presentation.model.Website;

import java.util.List;

import rx.Observable;

public interface DBFlowManager {
    Observable<List<StudentEntity>> getStudentList();

    Observable<StudentEntity> getStudent(@NonNull String id);

    Observable<List<FileEntity>> getFileList();

    Observable<FileEntity> getFile(@NonNull String id);

    Observable<List<ScheduleEntity>> getScheduleList();

    Observable<ScheduleEntity> getSchedule(@NonNull String id);

    Observable<List<AddressEntity>> getAddressList();

    Observable<AddressEntity> getAddress(@NonNull String id);

    Observable<List<EmailEntity>> getEmailList();

    Observable<EmailEntity> getEmail(@NonNull String id);

    Observable<List<NumberEntity>> getNumberList();

    Observable<NumberEntity> getNumber(@NonNull String id);

    Observable<List<OrganizationEntity>> getOrganizationList();

    Observable<OrganizationEntity> getOrganization(@NonNull String id);

    Observable<List<WebsiteEntity>> getWebsiteList();

    Observable<WebsiteEntity> getWebsite(@NonNull String id);

    //SAVE
    Observable<List<StudentEntity>> saveStudentList(@NonNull List<Student> studentList);

    Observable<StudentEntity> saveStudent(@NonNull Student student);

    Observable<List<FileEntity>> saveFileList(@NonNull List<File> fileList);

    Observable<FileEntity> saveFile(@NonNull File file);

    Observable<List<ScheduleEntity>> saveScheduleList(@NonNull List<Schedule> scheduleList);

    Observable<ScheduleEntity> saveSchedule(@NonNull Schedule schedule);

    Observable<List<AddressEntity>> saveAddressList(@NonNull List<Address> addressList);

    Observable<AddressEntity> saveAddress(@NonNull Address address);

    Observable<List<EmailEntity>> saveEmailList(@NonNull List<Email> emailList);

    Observable<EmailEntity> saveEmail(@NonNull Email email);

    Observable<List<NumberEntity>> saveNumberList(@NonNull List<Number> numberList);

    Observable<NumberEntity> saveNumber(@NonNull Number number);

    Observable<List<OrganizationEntity>> saveOrganizationList(@NonNull List<Organization> organizationList);

    Observable<OrganizationEntity> saveOrganization(@NonNull Organization organization);

    Observable<List<WebsiteEntity>> saveWebsiteList(@NonNull List<Website> websiteList);

    Observable<WebsiteEntity> saveWebsite(@NonNull Website website);
}
