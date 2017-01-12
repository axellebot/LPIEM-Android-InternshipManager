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

    /**
     * Does not take into account the relationships
     */
    public List<OrganizationEntity> transformReverse(List<Organization> organizationList) {
        List<OrganizationEntity> organizationEntityList = new ArrayList<>();
        for (Organization organization : organizationList) {
            organizationEntityList.add(transformReverse(organization));
        }
        return organizationEntityList;
    }

    /**
     * Does not take into account the relationships
     */
    public OrganizationEntity transformReverse(Organization organization) {
        OrganizationEntity organizationEntity = new OrganizationEntity();
        organizationEntity.id = organization.getId();
        organizationEntity.name = organization.getName();
        return organizationEntity;
    }
}
