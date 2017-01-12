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

    /**
     * Does not take into account the relationships
     */
    public List<NumberEntity> transformReverse(List<Number> numberList) {
        List<NumberEntity> numberEntityList = new ArrayList<>();
        for (Number number : numberList) {
            numberEntityList.add(transformReverse(number));
        }
        return numberEntityList;
    }

    /**
     * Does not take into account the relationships
     */
    public NumberEntity transformReverse(Number number) {
        NumberEntity numberEntity = new NumberEntity();
        numberEntity.id = number.getId();
        numberEntity.label = number.getLabel();
        numberEntity.value = number.getValue();
        return numberEntity;
    }
}
