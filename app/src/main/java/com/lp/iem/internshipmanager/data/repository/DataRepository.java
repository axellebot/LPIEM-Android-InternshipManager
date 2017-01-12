package com.lp.iem.internshipmanager.data.repository;

import android.support.annotation.NonNull;

import com.lp.iem.internshipmanager.data.entity.AddressEntity;
import com.lp.iem.internshipmanager.data.entity.EmailEntity;
import com.lp.iem.internshipmanager.data.entity.FileEntity;
import com.lp.iem.internshipmanager.data.entity.NumberEntity;
import com.lp.iem.internshipmanager.data.entity.OrganizationEntity;
import com.lp.iem.internshipmanager.data.entity.ScheduleEntity;
import com.lp.iem.internshipmanager.data.entity.StudentEntity;
import com.lp.iem.internshipmanager.data.entity.WebsiteEntity;
import com.lp.iem.internshipmanager.data.entity.mapper.AddressDataMapper;
import com.lp.iem.internshipmanager.data.entity.mapper.EmailDataMapper;
import com.lp.iem.internshipmanager.data.entity.mapper.FileDataMapper;
import com.lp.iem.internshipmanager.data.entity.mapper.NumberDataMapper;
import com.lp.iem.internshipmanager.data.entity.mapper.OrganizationDataMapper;
import com.lp.iem.internshipmanager.data.entity.mapper.ScheduleDataMapper;
import com.lp.iem.internshipmanager.data.entity.mapper.StudentDataMapper;
import com.lp.iem.internshipmanager.data.entity.mapper.WebsiteDataMapper;
import com.lp.iem.internshipmanager.data.manager.DBFlowManager;
import com.lp.iem.internshipmanager.data.manager.DBFlowManagerImpl;
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

public class DataRepository {
    private DBFlowManager dbFlowManager;

    private AddressDataMapper addressDataMapper;
    private EmailDataMapper emailDataMapper;
    private FileDataMapper fileDataMapper;
    private NumberDataMapper numberDataMapper;
    private OrganizationDataMapper organizationDataMapper;
    private ScheduleDataMapper scheduleDataMapper;
    private StudentDataMapper studentDataMapper;
    private WebsiteDataMapper websiteDataMapper;

    public DataRepository(DBFlowManagerImpl dbFlowManager, AddressDataMapper addressDataMapper, EmailDataMapper emailDataMapper, FileDataMapper fileDataMapper, NumberDataMapper numberDataMapper, OrganizationDataMapper organizationDataMapper, ScheduleDataMapper scheduleDataMapper, StudentDataMapper studentDataMapper, WebsiteDataMapper websiteDataMapper) {
        this.dbFlowManager = dbFlowManager;
        this.addressDataMapper = addressDataMapper;
        this.emailDataMapper = emailDataMapper;
        this.fileDataMapper = fileDataMapper;
        this.numberDataMapper = numberDataMapper;
        this.organizationDataMapper = organizationDataMapper;
        this.scheduleDataMapper = scheduleDataMapper;
        this.studentDataMapper = studentDataMapper;
        this.websiteDataMapper = websiteDataMapper;
    }

    /***************************
     * READ
     **************************/
    public Observable<List<Student>> getStudentList() {
        List<StudentEntity> studentEntityList = dbFlowManager.getStudentEntityList();
        List<Student> studentList = studentDataMapper.transform(studentEntityList);
        for (int i = 0; i < studentEntityList.size(); i++) {
            hydrateStudent(studentList.get(i), studentEntityList.get(i));
        }
        return Observable.just(studentList);
    }

    public Observable<Student> getStudent(@NonNull String id) {
        StudentEntity studentEntity = dbFlowManager.getStudentEntity(id);
        Student student = studentDataMapper.transform(studentEntity);
        hydrateStudent(student, studentEntity);
        return Observable.just(student);
    }

    private void hydrateStudent(Student student, StudentEntity studentEntity) {
        student.setScheduleList(scheduleDataMapper.transform(studentEntity.getScheduleList()));
        student.setAddressList(addressDataMapper.transform(studentEntity.getAddressList()));
        student.setEmailList(emailDataMapper.transform(studentEntity.getEmailList()));
        student.setFileList(fileDataMapper.transform(studentEntity.getFileList()));
        student.setNumberList(numberDataMapper.transform(studentEntity.getNumberList()));
        student.setOrganizationList(organizationDataMapper.transform(studentEntity.getOrganizationList()));
        student.setWebSites(websiteDataMapper.transform(studentEntity.getWebsiteList()));
    }

    public Observable<List<Address>> getAddressList() {
        List<AddressEntity> addressEntities = dbFlowManager.getAddressEntityList();
        List<Address> addressList = addressDataMapper.transform(addressEntities);
        return Observable.just(addressList);
    }

    public Observable<Address> getAddress(@NonNull String id) {
        AddressEntity addressEntity = dbFlowManager.getAddressEntity(id);
        Address address = addressDataMapper.transform(addressEntity);
        return Observable.just(address);
    }

    public Observable<List<Email>> getEmailList() {
        List<EmailEntity> emailEntities = dbFlowManager.getEmailEntityList();
        List<Email> emailList = emailDataMapper.transform(emailEntities);
        return Observable.just(emailList);
    }

    public Observable<Email> getEmail(@NonNull String id) {
        EmailEntity emailEntity = dbFlowManager.getEmailEntity(id);
        Email email = emailDataMapper.transform(emailEntity);
        return Observable.just(email);
    }

    public Observable<List<File>> getFileList() {
        List<FileEntity> fileEntities = dbFlowManager.getFileEntityList();
        List<File> fileList = fileDataMapper.transform(fileEntities);
        return Observable.just(fileList);
    }

    public Observable<File> getFile(@NonNull String id) {
        FileEntity fileEntity = dbFlowManager.getFileEntity(id);
        File file = fileDataMapper.transform(fileEntity);
        return Observable.just(file);
    }

    public Observable<List<Number>> getNumberList() {
        List<NumberEntity> numberEntities = dbFlowManager.getNumberEntityList();
        List<Number> numberList = numberDataMapper.transform(numberEntities);
        return Observable.just(numberList);
    }

    public Observable<Number> getNumber(@NonNull String id) {
        NumberEntity numberEntity = dbFlowManager.getNumberEntity(id);
        Number number = numberDataMapper.transform(numberEntity);
        return Observable.just(number);
    }

    public Observable<List<Organization>> getOrganizationList() {
        List<OrganizationEntity> organizationEntities = dbFlowManager.getOrganizationEntityList();
        List<Organization> organizationList = organizationDataMapper.transform(organizationEntities);
        return Observable.just(organizationList);
    }

    public Observable<Organization> getOrganization(@NonNull String id) {
        OrganizationEntity organizationEntity = dbFlowManager.getOrganizationEntity(id);
        Organization organization = organizationDataMapper.transform(organizationEntity);
        return Observable.just(organization);
    }

    public Observable<List<Schedule>> getScheduleList() {
        List<ScheduleEntity> scheduleEntities = dbFlowManager.getScheduleEntityList();
        List<Schedule> scheduleList = scheduleDataMapper.transform(scheduleEntities);
        return Observable.just(scheduleList);
    }

    public Observable<Schedule> getSchedule(@NonNull String id) {
        ScheduleEntity scheduleEntity = dbFlowManager.getScheduleEntity(id);
        Schedule schedule = scheduleDataMapper.transform(scheduleEntity);
        return Observable.just(schedule);
    }

    public Observable<List<Website>> getWebsiteList() {
        List<WebsiteEntity> websiteEntities = dbFlowManager.getWebsiteEntityList();
        List<Website> websiteList = websiteDataMapper.transform(websiteEntities);
        return Observable.just(websiteList);
    }

    public Observable<Website> getWebsite(@NonNull String id) {
        WebsiteEntity websiteEntity = dbFlowManager.getWebsiteEntity(id);
        Website website = websiteDataMapper.transform(websiteEntity);
        return Observable.just(website);
    }

    /***************************
     * CREATE |UPDATE
     **************************/
    public Observable<Student> saveStudent(@NonNull Student student) {
        StudentEntity studentEntity = studentDataMapper.transformReverse(student);
        studentEntity.save();
        return getStudent(student.getId());
    }

    public Observable<Address> saveAddress(@NonNull Address address) {
        AddressEntity addressEntity = addressDataMapper.transformReverse(address);
        addressEntity.student = dbFlowManager.getStudentEntity(address.getId());

        addressEntity.save();

        return getAddress(address.getId());
    }

    public Observable<Email> saveEmail(@NonNull Email email) {
        EmailEntity emailEntity = emailDataMapper.transformReverse(email);
        emailEntity.student = dbFlowManager.getStudentEntity(email.getId());

        emailEntity.save();

        return getEmail(email.getId());
    }

    public Observable<File> saveFile(@NonNull File file) {
        FileEntity fileEntity = fileDataMapper.transformReverse(file);
        fileEntity.student = dbFlowManager.getStudentEntity(file.getStudentId());

        fileEntity.save();

        return getFile(file.getId());
    }

    public Observable<Number> saveNumber(@NonNull Number number) {
        NumberEntity numberEntity = numberDataMapper.transformReverse(number);
        numberEntity.student = dbFlowManager.getStudentEntity(number.getId());

        numberEntity.save();

        return getNumber(number.getId());
    }

    public Observable<Organization> saveOrganization(@NonNull Organization organization) {
        OrganizationEntity organizationEntity = organizationDataMapper.transformReverse(organization);
        organizationEntity.student = dbFlowManager.getStudentEntity(organization.getId());

        organizationEntity.save();

        return getOrganization(organization.getId());
    }

    public Observable<Schedule> saveSchedule(@NonNull Schedule schedule) {
        ScheduleEntity scheduleEntity = scheduleDataMapper.transformReverse(schedule);
        scheduleEntity.student = dbFlowManager.getStudentEntity(schedule.getId());

        scheduleEntity.save();

        return getSchedule(schedule.getId());
    }

    public Observable<Website> saveWebsite(@NonNull Website website) {
        WebsiteEntity websiteEntity = websiteDataMapper.transformReverse(website);
        websiteEntity.student = dbFlowManager.getStudentEntity(website.getId());

        websiteEntity.save();

        return getWebsite(website.getId());
    }

    /***************************
     * DELETE
     **************************/
    public void deleteStudent(Student student) {
        dbFlowManager.getStudentEntity(student.getId()).delete();
    }

    public void deleteAddress(Address address) {
        dbFlowManager.getAddressEntity(address.getId()).delete();
    }

    public void deleteEmail(Email email) {
        dbFlowManager.getEmailEntity(email.getId()).delete();
    }

    public void deleteFile(File file) {
        dbFlowManager.getFileEntity(file.getId()).delete();
    }

    public void deleteNumber(Number number) {
        dbFlowManager.getNumberEntity(number.getId()).delete();
    }

    public void deleteOrganization(Organization organization) {
        dbFlowManager.getOrganizationEntity(organization.getId()).delete();
    }

    public void deleteSchedule(Schedule schedule) {
        dbFlowManager.getScheduleEntity(schedule.getId()).delete();
    }

    public void deleteWebsite(Website website) {
        dbFlowManager.getWebsiteEntity(website.getId()).delete();
    }
}
