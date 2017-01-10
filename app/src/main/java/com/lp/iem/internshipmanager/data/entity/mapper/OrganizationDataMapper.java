package com.lp.iem.internshipmanager.data.entity.mapper;

import com.lp.iem.internshipmanager.data.entity.OrganizationEntity;
import com.lp.iem.internshipmanager.presentation.model.Organization;

import java.util.ArrayList;
import java.util.List;

public class OrganizationDataMapper {
    public List<Organization> transform(List<OrganizationEntity> organizationEntityList) {
        List<Organization> organizationList = new ArrayList<>();
        for (OrganizationEntity organizationEntity : organizationEntityList) {
            organizationList.add(transform(organizationEntity));
        }
        return organizationList;
    }

    public Organization transform(OrganizationEntity organizationEntity) {
        Organization organization = new Organization();
        organization.setId(organizationEntity.id);
        organization.setName(organizationEntity.name);
        organization.setStudentId(organizationEntity.student.id);
        return organization;
    }
}
