package com.lp.iem.internshipmanager.data.entity.mapper;

import com.lp.iem.internshipmanager.data.entity.StudentEntity;
import com.lp.iem.internshipmanager.presentation.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDataMapper {
    public List<Student> transform(List<StudentEntity> studentEntityList) {
        List<Student> studentsList = new ArrayList<>();
        for (StudentEntity studentEntity : studentEntityList) {
            studentsList.add(transform(studentEntity));
        }
        return studentsList;
    }

    public Student transform(StudentEntity studentEntity) {
        Student student = new Student();
        student.setId(studentEntity.id);
        student.setFname(studentEntity.fname);
        student.setLname(studentEntity.lname);
        student.setNotes(studentEntity.notes);

        return student;
    }

    /**
     * Does not take into account the relationships
     */
    public List<StudentEntity> transformReverse(List<Student> studentList) {
        List<StudentEntity> studentEntityList = new ArrayList<>();
        for (Student student : studentList) {
            studentEntityList.add(transformReverse(student));
        }
        return studentEntityList;
    }

    /**
     * Does not take into account the relationships
     */
    public StudentEntity transformReverse(Student student) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.id = student.getId();
        studentEntity.fname = student.getFname();
        studentEntity.lname = student.getLname();
        studentEntity.notes = student.getNotes();
        return studentEntity;
    }
}
