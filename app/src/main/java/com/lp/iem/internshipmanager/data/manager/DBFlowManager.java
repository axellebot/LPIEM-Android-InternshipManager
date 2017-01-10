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
    Observable<List<StudentEntity>> getStudents();

    Observable<StudentEntity> getStudent(@NonNull String id);

    Observable<FileEntity> getFile(@NonNull String id);

    Observable<ScheduleEntity> getSchedule(@NonNull String id);

    Observable<AddressEntity> getAddress(@NonNull String id);

    Observable<EmailEntity> getEmail(@NonNull String id);

    Observable<NumberEntity> getNumber(@NonNull String id);

    Observable<OrganizationEntity> getOrganization(@NonNull String id);

    Observable<WebsiteEntity> getWebsite(@NonNull String id);

    //SAVE
    Observable<StudentEntity> saveStudent(@NonNull Student student);

    Observable<FileEntity> saveFile(@NonNull File file);

    Observable<ScheduleEntity> saveSchedule(@NonNull Schedule schedule);

    Observable<AddressEntity> saveAddress(@NonNull Address address);

    Observable<EmailEntity> saveEmail(@NonNull Email email);

    Observable<NumberEntity> saveNumber(@NonNull Number number);

    Observable<OrganizationEntity> saveOrganization(@NonNull Organization organization);

    Observable<WebsiteEntity> saveWebsite(@NonNull Website website);
}
