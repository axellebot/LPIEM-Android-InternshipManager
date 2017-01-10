package com.lp.iem.internshipmanager.data.repository;

import com.lp.iem.internshipmanager.data.entity.mapper.FileDataMapper;
import com.lp.iem.internshipmanager.data.entity.mapper.OrganizationPropertyDataMapper;
import com.lp.iem.internshipmanager.data.entity.mapper.ScheduleDataMapper;
import com.lp.iem.internshipmanager.data.entity.mapper.StudentDataMapper;
import com.lp.iem.internshipmanager.data.entity.mapper.StudentPropertyBaseDataMapper;
import com.lp.iem.internshipmanager.data.manager.DBFlowManager;

public class DataRepository {

    private  DBFlowManager dbFlowManager;
    private StudentDataMapper studentDataMapper;
    private ScheduleDataMapper scheduleDataMapper;
    private FileDataMapper fileDataMapper;
    private OrganizationPropertyDataMapper organizationProperty;
    private StudentPropertyBaseDataMapper studentPropertyBaseDataMapper;

    public DataRepository(DBFlowManager dbFlowManager, StudentDataMapper studentDataMapper, ScheduleDataMapper scheduleDataMapper, FileDataMapper fileDataMapper, OrganizationPropertyDataMapper organizationProperty, StudentPropertyBaseDataMapper studentPropertyBaseDataMapper) {
        this.dbFlowManager = dbFlowManager;
        this.studentDataMapper = studentDataMapper;
        this.scheduleDataMapper = scheduleDataMapper;
        this.fileDataMapper = fileDataMapper;
        this.organizationProperty = organizationProperty;
        this.studentPropertyBaseDataMapper = studentPropertyBaseDataMapper;
    }
}
