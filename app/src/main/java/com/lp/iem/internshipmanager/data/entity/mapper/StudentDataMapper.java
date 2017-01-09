package com.lp.iem.internshipmanager.data.entity.mapper;

import com.lp.iem.internshipmanager.data.entity.StudentEntity;
import com.lp.iem.internshipmanager.data.entity.student_porperty.StudentPropertyBaseEntity;
import com.lp.iem.internshipmanager.presentation.model.File;
import com.lp.iem.internshipmanager.presentation.model.Schedule;
import com.lp.iem.internshipmanager.presentation.model.Student;
import com.lp.iem.internshipmanager.presentation.model.student_property.AddressProperty;
import com.lp.iem.internshipmanager.presentation.model.student_property.EmailProperty;
import com.lp.iem.internshipmanager.presentation.model.student_property.NumberProperty;
import com.lp.iem.internshipmanager.presentation.model.student_property.StudentPropertyBase;

import java.util.ArrayList;
import java.util.List;

public class StudentDataMapper {

    private FileDataMapper fileDataMapper;
    private OrganizationPropertyDataMapper organizationPropertyDataMapper;
    private ScheduleDataMapper scheduleDataMapper;
    private StudentPropertyBaseDataMapper studentPropertyBaseDataMapper;


    public StudentDataMapper(FileDataMapper fileDataMapper, OrganizationPropertyDataMapper organizationPropertyDataMapper, ScheduleDataMapper scheduleDataMapper, StudentPropertyBaseDataMapper studentPropertyBaseDataMapper) {
        this.fileDataMapper = fileDataMapper;
        this.organizationPropertyDataMapper = organizationPropertyDataMapper;
        this.scheduleDataMapper = scheduleDataMapper;
        this.studentPropertyBaseDataMapper = studentPropertyBaseDataMapper;
    }

    public List<Student> transform(List<StudentEntity> studentEntityList) {
        List<Student> studentsList = new ArrayList<>();
        for (StudentEntity studentEntity : studentEntityList) {
            studentsList.add(transform(studentEntity));
        }
        return studentsList;
    }

    public Student transform(StudentEntity studentEntity) {
        Student student = new Student();
        List<StudentPropertyBase> studentPropertyBaseList;
        studentPropertyBaseList = studentPropertyBaseDataMapper.transform((List<StudentPropertyBaseEntity>) (List<?>) studentEntity.getAddressList());
        student.setAddressList((List<AddressProperty>) (List<?>) studentPropertyBaseList);

        studentPropertyBaseList = studentPropertyBaseDataMapper.transform((List<StudentPropertyBaseEntity>) (List<?>) studentEntity.getAddressList());
        student.setEmailList((List<EmailProperty>) (List<?>) studentPropertyBaseList);
        
        studentPropertyBaseList = studentPropertyBaseDataMapper.transform((List<StudentPropertyBaseEntity>) (List<?>) studentEntity.getNumberList());
        student.setNumberList((List<NumberProperty>) (List<?>) studentPropertyBaseList);

        student.setFileList(fileDataMapper.transform(studentEntity.getFileList()));
        student.setOrganizationList(organizationPropertyDataMapper.transform(studentEntity.getOrganizationList()));
        student.setScheduleList(scheduleDataMapper.transform(studentEntity.getScheduleList()));

        return student;
    }
}
