package com.lp.iem.internshipmanager.data.manager;

import android.support.annotation.NonNull;

import com.lp.iem.internshipmanager.data.entity.AddressEntity;
import com.lp.iem.internshipmanager.data.entity.AddressEntity_Table;
import com.lp.iem.internshipmanager.data.entity.EmailEntity;
import com.lp.iem.internshipmanager.data.entity.EmailEntity_Table;
import com.lp.iem.internshipmanager.data.entity.FileEntity;
import com.lp.iem.internshipmanager.data.entity.FileEntity_Table;
import com.lp.iem.internshipmanager.data.entity.NumberEntity;
import com.lp.iem.internshipmanager.data.entity.NumberEntity_Table;
import com.lp.iem.internshipmanager.data.entity.OrganizationEntity;
import com.lp.iem.internshipmanager.data.entity.OrganizationEntity_Table;
import com.lp.iem.internshipmanager.data.entity.ScheduleEntity;
import com.lp.iem.internshipmanager.data.entity.ScheduleEntity_Table;
import com.lp.iem.internshipmanager.data.entity.StudentEntity;
import com.lp.iem.internshipmanager.data.entity.StudentEntity_Table;
import com.lp.iem.internshipmanager.data.entity.WebsiteEntity;
import com.lp.iem.internshipmanager.data.entity.WebsiteEntity_Table;
import com.lp.iem.internshipmanager.presentation.model.Address;
import com.lp.iem.internshipmanager.presentation.model.Email;
import com.lp.iem.internshipmanager.presentation.model.File;
import com.lp.iem.internshipmanager.presentation.model.Number;
import com.lp.iem.internshipmanager.presentation.model.Organization;
import com.lp.iem.internshipmanager.presentation.model.Schedule;
import com.lp.iem.internshipmanager.presentation.model.Student;
import com.lp.iem.internshipmanager.presentation.model.Website;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

import rx.Observable;

public class DBFlowManagerImpl implements DBFlowManager {

    @Override
    public Observable<List<StudentEntity>> getStudents() {
        return Observable.just(
                SQLite.select().
                        from(StudentEntity.class).
                        queryList()
        );
    }

    @Override
    public Observable<StudentEntity> getStudent(@NonNull String id) {
        return Observable.just(
                SQLite.select().
                        from(StudentEntity.class).
                        where(StudentEntity_Table.id.is(id)).
                        querySingle()
        );
    }

    @Override
    public Observable<FileEntity> getFile(@NonNull String id) {
        return Observable.just(
                SQLite.select().
                        from(FileEntity.class).
                        where(FileEntity_Table.id.is(id)).
                        querySingle()
        );
    }

    @Override
    public Observable<ScheduleEntity> getSchedule(@NonNull String id) {
        return Observable.just(
                SQLite.select().
                        from(ScheduleEntity.class).
                        where(ScheduleEntity_Table.id.is(id)).
                        querySingle()
        );
    }

    @Override
    public Observable<AddressEntity> getAddress(@NonNull String id) {
        return Observable.just(
                SQLite.select().
                        from(AddressEntity.class).
                        where(AddressEntity_Table.id.is(id)).
                        querySingle()
        );
    }

    @Override
    public Observable<EmailEntity> getEmail(@NonNull String id) {
        return Observable.just(
                SQLite.select().
                        from(EmailEntity.class).
                        where(EmailEntity_Table.id.is(id)).
                        querySingle()
        );
    }

    @Override
    public Observable<NumberEntity> getNumber(@NonNull String id) {
        return Observable.just(
                SQLite.select().
                        from(NumberEntity.class).
                        where(NumberEntity_Table.id.is(id)).
                        querySingle()
        );
    }

    @Override
    public Observable<OrganizationEntity> getOrganization(@NonNull String id) {
        return Observable.just(
                SQLite.select().
                        from(OrganizationEntity.class).
                        where(OrganizationEntity_Table.id.is(id)).
                        querySingle()
        );
    }

    @Override
    public Observable<WebsiteEntity> getWebsite(@NonNull String id) {
        return Observable.just(
                SQLite.select().
                        from(WebsiteEntity.class).
                        where(WebsiteEntity_Table.id.is(id)).
                        querySingle()
        );
    }

    @Override
    public Observable<StudentEntity> saveStudent(@NonNull Student student) {
        StudentEntity studentEntity;
        studentEntity =
                SQLite.select().
                        from(StudentEntity.class).
                        where(StudentEntity_Table.id.is(student.getId())).
                        querySingle();
        if (studentEntity == null) {
            studentEntity = new StudentEntity();
            studentEntity.id = student.getId();
        }
        studentEntity.fname = student.getFname();
        studentEntity.lname = student.getLname();
        studentEntity.notes = student.getNotes();

        studentEntity.save();


        return getStudent(student.getId());
    }

    @Override
    public Observable<FileEntity> saveFile(@NonNull File file) {
        FileEntity fileEntity;
        fileEntity = SQLite.select().
                from(FileEntity.class).
                where(FileEntity_Table.id.is(file.getId())).
                querySingle();
        if (fileEntity == null) {
            fileEntity = new FileEntity();
        }
        fileEntity.id = file.getId();
//        fileEntity.student = getStudent(file.getStudentId());
        fileEntity.filePath = file.getAbsolutePath();
        fileEntity.description = file.getDescription();

        fileEntity.save();

        return getFile(file.getId());
    }

    @Override
    public Observable<ScheduleEntity> saveSchedule(@NonNull Schedule schedule) {
        return null;
    }

    @Override
    public Observable<AddressEntity> saveAddress(@NonNull Address address) {
        return null;
    }

    @Override
    public Observable<EmailEntity> saveEmail(@NonNull Email email) {
        return null;
    }

    @Override
    public Observable<NumberEntity> saveNumber(@NonNull Number number) {
        return null;
    }

    @Override
    public Observable<OrganizationEntity> saveOrganization(@NonNull Organization organization) {
        return null;
    }

    @Override
    public Observable<WebsiteEntity> saveWebsite(@NonNull Website website) {
        return null;
    }

}
