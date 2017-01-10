package com.lp.iem.internshipmanager.data.repository;

import android.support.annotation.NonNull;

import com.lp.iem.internshipmanager.data.entity.StudentEntity;
import com.lp.iem.internshipmanager.data.entity.mapper.FileDataMapper;
import com.lp.iem.internshipmanager.data.entity.mapper.OrganizationDataMapper;
import com.lp.iem.internshipmanager.data.entity.mapper.ScheduleDataMapper;
import com.lp.iem.internshipmanager.data.entity.mapper.StudentDataMapper;
import com.lp.iem.internshipmanager.data.entity.mapper.StudentPropertyBaseDataMapper;
import com.lp.iem.internshipmanager.data.manager.DBFlowManagerImpl;
import com.lp.iem.internshipmanager.presentation.model.Student;

import java.util.List;

import rx.Observable;
import rx.functions.Func1;

public class DataRepository {

    private DBFlowManagerImpl dbFlowManager;
    private StudentDataMapper studentDataMapper;
    private ScheduleDataMapper scheduleDataMapper;
    private FileDataMapper fileDataMapper;
    private OrganizationDataMapper organizationProperty;
    private StudentPropertyBaseDataMapper studentPropertyBaseDataMapper;

    public DataRepository(@NonNull DBFlowManagerImpl dbFlowManager, @NonNull StudentDataMapper studentDataMapper, @NonNull ScheduleDataMapper scheduleDataMapper, @NonNull FileDataMapper fileDataMapper, @NonNull OrganizationDataMapper organizationProperty, @NonNull StudentPropertyBaseDataMapper studentPropertyBaseDataMapper) {
        this.dbFlowManager = dbFlowManager;
        this.studentDataMapper = studentDataMapper;
        this.scheduleDataMapper = scheduleDataMapper;
        this.fileDataMapper = fileDataMapper;
        this.organizationProperty = organizationProperty;
        this.studentPropertyBaseDataMapper = studentPropertyBaseDataMapper;
    }

    public Observable<List<Student>> getStudents() {
        return dbFlowManager.getStudents().map(new Func1<List<StudentEntity>, List<Student>>() {
            @Override
            public List<Student> call(List<StudentEntity> studentEntities) {
                List<Student> studentList = studentDataMapper.transform(studentEntities);
                return studentList;
            }
        });
    }

    public Observable<Student> getStudent(@NonNull String id) {
        return dbFlowManager.getStudent(id).map(new Func1<StudentEntity, Student>() {
            @Override
            public Student call(StudentEntity studentEntity) {
                Student student = studentDataMapper.transform(studentEntity);
                return student;
            }
        });
    }

}
