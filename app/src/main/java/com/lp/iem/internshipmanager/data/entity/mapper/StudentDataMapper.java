package com.lp.iem.internshipmanager.data.entity.mapper;

import com.lp.iem.internshipmanager.data.entity.StudentEntity;
import com.lp.iem.internshipmanager.presentation.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDataMapper {
    public List<Student> transform(List<StudentEntity> studentEntityList){
        List<Student> studentsList = new ArrayList<>();
        for(StudentEntity studentEntity : studentEntityList){
            studentsList.add(transform(studentEntity));
        }
        return studentsList;
    }
    public Student transform(StudentEntity studentEntity){
        Student student = new Student();
        return student;
    }
}
