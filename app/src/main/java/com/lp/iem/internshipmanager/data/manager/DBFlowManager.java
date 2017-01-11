package com.lp.iem.internshipmanager.data.manager;

import android.support.annotation.NonNull;

import com.lp.iem.internshipmanager.data.entity.AddressEntity;
import com.lp.iem.internshipmanager.data.entity.EmailEntity;
import com.lp.iem.internshipmanager.data.entity.FileEntity;
import com.lp.iem.internshipmanager.data.entity.NumberEntity;
import com.lp.iem.internshipmanager.data.entity.OrganizationEntity;
import com.lp.iem.internshipmanager.data.entity.ScheduleEntity;
import com.lp.iem.internshipmanager.data.entity.StudentEntity;
import com.lp.iem.internshipmanager.data.entity.WebsiteEntity;

import java.util.List;

public interface DBFlowManager {
    /***************************
     * SELECT
     **************************/
    List<StudentEntity> getStudentEntityList();

    StudentEntity getStudentEntity(@NonNull String id);

    List<FileEntity> getFileEntityList();

    FileEntity getFileEntity(@NonNull String id);

    List<ScheduleEntity> getScheduleEntityList();

    ScheduleEntity getScheduleEntity(@NonNull String id);

    List<AddressEntity> getAddressEntityList();

    AddressEntity getAddressEntity(@NonNull String id);

    List<EmailEntity> getEmailEntityList();

    EmailEntity getEmailEntity(@NonNull String id);

    List<NumberEntity> getNumberEntityList();

    NumberEntity getNumberEntity(@NonNull String id);

    List<OrganizationEntity> getOrganizationEntityList();

    OrganizationEntity getOrganizationEntity(@NonNull String id);

    List<WebsiteEntity> getWebsiteEntityList();

    WebsiteEntity getWebsiteEntity(@NonNull String id);
}
