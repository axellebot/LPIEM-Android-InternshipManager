package com.lp.iem.internshipmanager.data.repository;

import com.lp.iem.internshipmanager.data.entity.mapper.ScheduleDataMapper;
import com.lp.iem.internshipmanager.data.entity.mapper.StudentDataMapper;
import com.lp.iem.internshipmanager.data.manager.DBFlowManager;

public class DataRepository {

    private  DBFlowManager dbFlowManager;
    private StudentDataMapper studentDataMapper;
    private ScheduleDataMapper scheduleDataMapper;

    public DataRepository(DBFlowManager dbFlowManager, StudentDataMapper studentDataMapper, ScheduleDataMapper scheduleDataMapper) {
        this.dbFlowManager = dbFlowManager;
        this.studentDataMapper = studentDataMapper;
        this.scheduleDataMapper = scheduleDataMapper;
    }
}
