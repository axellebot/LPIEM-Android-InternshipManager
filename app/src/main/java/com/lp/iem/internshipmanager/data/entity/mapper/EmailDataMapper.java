package com.lp.iem.internshipmanager.data.entity.mapper;

import com.lp.iem.internshipmanager.data.entity.EmailEntity;
import com.lp.iem.internshipmanager.presentation.model.student_property.Email;

import java.util.ArrayList;
import java.util.List;

public class EmailDataMapper {
    public List<Email> transform(List<EmailEntity> emailEntityList){
        List<Email> emailList = new ArrayList<>();
        for(EmailEntity emailEntity : emailEntityList){
            emailList.add(transform(emailEntity));
        }
        return emailList;
    }
    public Email transform(EmailEntity emailEntity){
        Email email = new Email();
        email.setId(emailEntity.id);
        email.setLabel(emailEntity.label);
        email.setValue(emailEntity.value);
        email.setStudentId(emailEntity.student.id);
        return email;
    }
}
