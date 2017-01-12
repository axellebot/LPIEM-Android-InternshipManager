package com.lp.iem.internshipmanager.data.manager;

import android.support.annotation.NonNull;

import com.lp.iem.internshipmanager.data.entity.AddressEntity;
import com.lp.iem.internshipmanager.data.entity.AddressEntity_Table;
import com.lp.iem.internshipmanager.data.entity.EmailEntity;
import com.lp.iem.internshipmanager.data.entity.EmailEntity_Table;
import com.lp.iem.internshipmanager.data.entity.FileEntity;
import com.lp.iem.internshipmanager.data.entity.FileEntity_Table;
import com.lp.iem.internshipmanager.data.entity.NumberEntity;
import com.lp.iem.internshipmanager.data.entity.NumberEntity_Table;
import com.lp.iem.internshipmanager.data.entity.OrganizationEntity;
import com.lp.iem.internshipmanager.data.entity.OrganizationEntity_Table;
import com.lp.iem.internshipmanager.data.entity.ScheduleEntity;
import com.lp.iem.internshipmanager.data.entity.ScheduleEntity_Table;
import com.lp.iem.internshipmanager.data.entity.StudentEntity;
import com.lp.iem.internshipmanager.data.entity.StudentEntity_Table;
import com.lp.iem.internshipmanager.data.entity.WebsiteEntity;
import com.lp.iem.internshipmanager.data.entity.WebsiteEntity_Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

public class DBFlowManagerImpl implements DBFlowManager {
    /***************************
     * SELECT
     **************************/
    @Override
    public List<StudentEntity> getStudentEntityList() {
        return
                SQLite.select().
                        from(StudentEntity.class).
                        queryList();
    }


    @Override
    public StudentEntity getStudentEntity(@NonNull String id) {
        return
                SQLite.select().
                        from(StudentEntity.class).
                        where(StudentEntity_Table.id.is(id)).
                        querySingle();
    }


    @Override
    public List<FileEntity> getFileEntityList() {
        return
                SQLite.select().
                        from(FileEntity.class).
                        queryList();
    }


    @Override
    public FileEntity getFileEntity(@NonNull String id) {
        return
                SQLite.select().
                        from(FileEntity.class).
                        where(FileEntity_Table.id.is(id)).
                        querySingle();
    }


    @Override
    public List<ScheduleEntity> getScheduleEntityList() {
        return
                SQLite.select().
                        from(ScheduleEntity.class).
                        queryList();
    }


    @Override
    public ScheduleEntity getScheduleEntity(@NonNull String id) {
        return
                SQLite.select().
                        from(ScheduleEntity.class).
                        where(ScheduleEntity_Table.id.is(id)).
                        querySingle();
    }


    @Override
    public List<AddressEntity> getAddressEntityList() {
        return
                SQLite.select().
                        from(AddressEntity.class).
                        queryList();
    }


    @Override
    public AddressEntity getAddressEntity(@NonNull String id) {
        return
                SQLite.select().
                        from(AddressEntity.class).
                        where(AddressEntity_Table.id.is(id)).
                        querySingle();
    }


    @Override
    public List<EmailEntity> getEmailEntityList() {
        return
                SQLite.select().
                        from(EmailEntity.class).
                        queryList();
    }


    @Override
    public EmailEntity getEmailEntity(@NonNull String id) {
        return
                SQLite.select().
                        from(EmailEntity.class).
                        where(EmailEntity_Table.id.is(id)).
                        querySingle();
    }


    @Override
    public List<NumberEntity> getNumberEntityList() {
        return
                SQLite.select().
                        from(NumberEntity.class).
                        queryList();
    }


    @Override
    public NumberEntity getNumberEntity(@NonNull String id) {
        return
                SQLite.select().
                        from(NumberEntity.class).
                        where(NumberEntity_Table.id.is(id)).
                        querySingle();
    }


    @Override
    public List<OrganizationEntity> getOrganizationEntityList() {
        return
                SQLite.select().
                        from(OrganizationEntity.class).
                        queryList();
    }


    @Override
    public OrganizationEntity getOrganizationEntity(@NonNull String id) {
        return
                SQLite.select().
                        from(OrganizationEntity.class).
                        where(OrganizationEntity_Table.id.is(id)).
                        querySingle();
    }

    @Override
    public List<WebsiteEntity> getWebsiteEntityList() {
        return
                SQLite.select().
                        from(WebsiteEntity.class).
                        queryList();
    }

    @Override
    public WebsiteEntity getWebsiteEntity(@NonNull String id) {
        return
                SQLite.select().
                        from(WebsiteEntity.class).
                        where(WebsiteEntity_Table.id.is(id)).
                        querySingle();
    }
}
