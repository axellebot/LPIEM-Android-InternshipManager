package com.lp.iem.internshipmanager.data.entity.mapper;

import com.lp.iem.internshipmanager.data.entity.NumberEntity;
import com.lp.iem.internshipmanager.presentation.model.Number;

import java.util.ArrayList;
import java.util.List;

public class NumberDataMapper {
    public List<Number> transform(List<NumberEntity> numberEntityList) {
        List<Number> emailList = new ArrayList<>();
        for (NumberEntity numberEntity : numberEntityList) {
            emailList.add(transform(numberEntity));
        }
        return emailList;
    }

    public Number transform(NumberEntity emailEntity) {
        Number number = new Number();
        number.setId(emailEntity.id);
        number.setLabel(emailEntity.label);
        number.setValue(emailEntity.value);
        number.setStudentId(emailEntity.student.id);
        return number;
    }
}
