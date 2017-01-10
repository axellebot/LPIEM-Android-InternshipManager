package com.lp.iem.internshipmanager.data.entity.mapper;

import com.lp.iem.internshipmanager.data.entity.FileEntity;
import com.lp.iem.internshipmanager.data.entity.student_porperty.OrganizationPropertyEntity;
import com.lp.iem.internshipmanager.presentation.model.File;
import com.lp.iem.internshipmanager.presentation.model.student_property.OrganizationProperty;

import java.util.ArrayList;
import java.util.List;

public class OrganizationPropertyDataMapper {
    public List<OrganizationProperty> transform(List<OrganizationPropertyEntity> organizationPropertyEntityList){
        List<OrganizationProperty> organizationPropertyList = new ArrayList<>();
        for(OrganizationPropertyEntity organizationPropertyEntity : organizationPropertyEntityList){
            organizationPropertyList.add(transform(organizationPropertyEntity));
        }
        return organizationPropertyList;
    }
    public OrganizationProperty transform(OrganizationPropertyEntity organizationPropertyEntity){
        OrganizationProperty organizationProperty = new OrganizationProperty();
        organizationProperty.setId(organizationPropertyEntity.id);
        organizationProperty.setName(organizationPropertyEntity.name);
        organizationProperty.setStudentId(organizationProperty.getStudentId());
        return organizationProperty;
    }
}
