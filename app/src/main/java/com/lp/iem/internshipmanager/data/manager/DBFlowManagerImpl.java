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
    public Observable<List<StudentEntity>> getStudentList() {
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
    public Observable<List<FileEntity>> getFileList() {
        return Observable.just(
                SQLite.select().
                        from(FileEntity.class).
                        queryList()
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
    public Observable<List<ScheduleEntity>> getScheduleList() {
        return Observable.just(
                SQLite.select().
                        from(ScheduleEntity.class).
                        queryList()
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
    public Observable<List<AddressEntity>> getAddressList() {
        return Observable.just(
                SQLite.select().
                        from(AddressEntity.class).
                        queryList()
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
    public Observable<List<EmailEntity>> getEmailList() {
        return Observable.just(
                SQLite.select().
                        from(EmailEntity.class).
                        queryList()
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
    public Observable<List<NumberEntity>> getNumberList() {
        return Observable.just(
                SQLite.select().
                        from(NumberEntity.class).
                        queryList()
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
    public Observable<List<OrganizationEntity>> getOrganizationList() {
        return Observable.just(
                SQLite.select().
                        from(OrganizationEntity.class).
                        queryList()
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
    public Observable<List<WebsiteEntity>> getWebsiteList() {
        return Observable.just(
                SQLite.select().
                        from(WebsiteEntity.class).
                        queryList()
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
    public Observable<List<StudentEntity>> saveStudentList(@NonNull List<Student> studentList) {
        return null;
    }

    /***************************
     * SAVE
     **************************/
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

        saveFileList(student.getFileList());
        saveScheduleList(student.getScheduleList());
        saveAddressList(student.getAddressList());
        saveEmailList(student.getEmailList());
        saveNumberList(student.getNumberList());
        saveOrganizationList(student.getOrganizationList());
        saveWebsiteList(student.getWebSites());

        return getStudent(student.getId());
    }

    @Override
    public Observable<List<FileEntity>> saveFileList(@NonNull List<File> fileList) {
        for (File file : fileList) {
            saveFile(file);
        }
        return null;
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
        fileEntity.filePath = file.getAbsolutePath();
        fileEntity.description = file.getDescription();
        fileEntity.student = getStudentSync(file.getStudentId());

        fileEntity.save();

        return getFile(file.getId());
    }

    @Override
    public Observable<List<ScheduleEntity>> saveScheduleList(@NonNull List<Schedule> scheduleList) {
        for (Schedule schedule : scheduleList) {
            saveSchedule(schedule);
        }
        return null;
    }

    @Override
    public Observable<ScheduleEntity> saveSchedule(@NonNull Schedule schedule) {
        ScheduleEntity scheduleEntity;
        scheduleEntity = SQLite.select().
                from(ScheduleEntity.class).
                where(ScheduleEntity_Table.id.is(schedule.getId())).
                querySingle();
        if (scheduleEntity == null) {
            scheduleEntity = new ScheduleEntity();
        }
        scheduleEntity.id = schedule.getId();
        scheduleEntity.label = schedule.getLabel();
        scheduleEntity.description = schedule.getDescription();
        scheduleEntity.date = schedule.getDate();
        scheduleEntity.student = getStudentSync(schedule.getId());

        scheduleEntity.save();

        return getSchedule(schedule.getId());
    }

    @Override
    public Observable<List<AddressEntity>> saveAddressList(@NonNull List<Address> addressList) {
        for (Address address : addressList) {
            saveAddress(address);
        }
        return null;
    }

    @Override
    public Observable<AddressEntity> saveAddress(@NonNull Address address) {
        AddressEntity addressEntity;
        addressEntity = SQLite.select().
                from(AddressEntity.class).
                where(AddressEntity_Table.id.is(address.getId())).
                querySingle();
        if (addressEntity == null) {
            addressEntity = new AddressEntity();
        }
        addressEntity.id = address.getId();
        addressEntity.label = address.getLabel();
        addressEntity.value = address.getValue();
        addressEntity.student = getStudentSync(address.getId());

        addressEntity.save();

        return getAddress(address.getId());
    }

    @Override
    public Observable<List<EmailEntity>> saveEmailList(@NonNull List<Email> emailList) {
        for (Email email : emailList) {
            saveEmail(email);
        }
        return null;
    }

    @Override
    public Observable<EmailEntity> saveEmail(@NonNull Email email) {
        EmailEntity emailEntity;
        emailEntity = SQLite.select().
                from(EmailEntity.class).
                where(EmailEntity_Table.id.is(email.getId())).
                querySingle();
        if (emailEntity == null) {
            emailEntity = new EmailEntity();
        }
        emailEntity.id = email.getId();
        emailEntity.label = email.getLabel();
        emailEntity.value = email.getValue();
        emailEntity.student = getStudentSync(email.getId());

        emailEntity.save();

        return getEmail(email.getId());
    }

    @Override
    public Observable<List<NumberEntity>> saveNumberList(@NonNull List<Number> numberList) {
        for (Number number : numberList) {
            saveNumber(number);
        }
        return null;
    }

    @Override
    public Observable<NumberEntity> saveNumber(@NonNull Number number) {
        NumberEntity numberEntity;
        numberEntity = SQLite.select().
                from(NumberEntity.class).
                where(NumberEntity_Table.id.is(number.getId())).
                querySingle();
        if (numberEntity == null) {
            numberEntity = new NumberEntity();
        }
        numberEntity.id = number.getId();
        numberEntity.label = number.getLabel();
        numberEntity.value = number.getValue();
        numberEntity.student = getStudentSync(number.getId());

        numberEntity.save();

        return getNumber(number.getId());
    }

    @Override
    public Observable<List<OrganizationEntity>> saveOrganizationList(@NonNull List<Organization> organizationList) {
        for (Organization organization : organizationList) {
            saveOrganization(organization);
        }
        return null;
    }

    @Override
    public Observable<OrganizationEntity> saveOrganization(@NonNull Organization organization) {
        OrganizationEntity organizationEntity;
        organizationEntity = SQLite.select().
                from(OrganizationEntity.class).
                where(OrganizationEntity_Table.id.is(organization.getId())).
                querySingle();
        if (organizationEntity == null) {
            organizationEntity = new OrganizationEntity();
        }
        organizationEntity.id = organization.getId();
        organizationEntity.name = organization.getName();
        organizationEntity.student = getStudentSync(organization.getId());

        organizationEntity.save();

        return getOrganization(organization.getId());
    }

    @Override
    public Observable<List<WebsiteEntity>> saveWebsiteList(@NonNull List<Website> websiteList) {
        for (Website website : websiteList) {
            saveWebsite(website);
        }
        return null;
    }

    @Override
    public Observable<WebsiteEntity> saveWebsite(@NonNull Website website) {
        WebsiteEntity websiteEntity;
        websiteEntity = SQLite.select().
                from(WebsiteEntity.class).
                where(WebsiteEntity_Table.id.is(website.getId())).
                querySingle();
        if (websiteEntity == null) {
            websiteEntity = new WebsiteEntity();
        }
        websiteEntity.id = website.getId();
        websiteEntity.label = website.getLabel();
        websiteEntity.value = website.getValue();
        websiteEntity.student = getStudentSync(website.getId());

        websiteEntity.save();

        return getWebsite(website.getId());
    }

    private StudentEntity getStudentSync(@NonNull String id) {
        return
                SQLite.select().
                        from(StudentEntity.class).
                        where(StudentEntity_Table.id.is(id)).
                        querySingle();

    }
}
