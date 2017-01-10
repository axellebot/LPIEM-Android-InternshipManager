package com.lp.iem.internshipmanager.data.repository;

import android.support.annotation.NonNull;

import com.lp.iem.internshipmanager.data.entity.StudentEntity;
import com.lp.iem.internshipmanager.data.entity.mapper.AddressDataMapper;
import com.lp.iem.internshipmanager.data.entity.mapper.EmailDataMapper;
import com.lp.iem.internshipmanager.data.entity.mapper.FileDataMapper;
import com.lp.iem.internshipmanager.data.entity.mapper.NumberDataMapper;
import com.lp.iem.internshipmanager.data.entity.mapper.OrganizationDataMapper;
import com.lp.iem.internshipmanager.data.entity.mapper.ScheduleDataMapper;
import com.lp.iem.internshipmanager.data.entity.mapper.StudentDataMapper;
import com.lp.iem.internshipmanager.data.entity.mapper.WebsiteDataMapper;
import com.lp.iem.internshipmanager.data.manager.DBFlowManagerImpl;
import com.lp.iem.internshipmanager.presentation.model.Student;

import java.util.List;

import rx.Observable;
import rx.functions.Func1;

public class DataRepository {
    private DBFlowManagerImpl dbFlowManager;

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

    public Observable<List<Student>> getStudents() {
        return dbFlowManager.getStudentList().map(new Func1<List<StudentEntity>, List<Student>>() {
            @Override
            public List<Student> call(List<StudentEntity> studentEntityList) {
                List<Student> studentList = studentDataMapper.transform(studentEntityList);
                for (int i = 0; i < studentEntityList.size(); i++) {
                    hydrateStudent(studentList.get(i), studentEntityList.get(i));
                }
                return studentList;
            }
        });
    }

    public Observable<Student> getStudent(@NonNull String id) {
        return dbFlowManager.getStudent(id).map(new Func1<StudentEntity, Student>() {
            @Override
            public Student call(StudentEntity studentEntity) {
                Student student = studentDataMapper.transform(studentEntity);
                hydrateStudent(student, studentEntity);
                return student;
            }
        });
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

    public Observable<Student> saveStudent(@NonNull Student student) {
        return dbFlowManager.saveStudent(student).map(new Func1<StudentEntity, Student>() {
            @Override
            public Student call(StudentEntity studentEntity) {
                Student student = studentDataMapper.transform(studentEntity);
                hydrateStudent(student, studentEntity);
                return student;
            }
        });
    }


}
