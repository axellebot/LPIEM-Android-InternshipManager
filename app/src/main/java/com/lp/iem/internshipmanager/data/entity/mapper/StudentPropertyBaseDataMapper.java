package com.lp.iem.internshipmanager.data.entity.mapper;

import com.lp.iem.internshipmanager.data.entity.FileEntity;
import com.lp.iem.internshipmanager.data.entity.student_porperty.StudentPropertyBaseEntity;
import com.lp.iem.internshipmanager.presentation.model.File;
import com.lp.iem.internshipmanager.presentation.model.student_property.StudentPropertyBase;

import java.util.ArrayList;
import java.util.List;

public class StudentPropertyBaseDataMapper {
    public List<StudentPropertyBase> transform(List<StudentPropertyBaseEntity> studentPropertyBaseEntityList){
        List<StudentPropertyBase> studentPropertyBaseList = new ArrayList<>();
        for(StudentPropertyBaseEntity studentPropertyBaseEntity : studentPropertyBaseEntityList){
            studentPropertyBaseList.add(transform(studentPropertyBaseEntity));
        }
        return studentPropertyBaseList;
    }
    public StudentPropertyBase transform(StudentPropertyBaseEntity studentPropertyBaseEntity){
        StudentPropertyBase studentPropertyBase = new StudentPropertyBase();
        studentPropertyBase.setId(studentPropertyBaseEntity.id);
        studentPropertyBase.setLabel(studentPropertyBaseEntity.label);
        studentPropertyBase.setValue(studentPropertyBaseEntity.value);
        return studentPropertyBase;
    }
}
