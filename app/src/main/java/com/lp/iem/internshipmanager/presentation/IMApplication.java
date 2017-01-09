package com.lp.iem.internshipmanager.presentation;

import android.app.Application;

import com.lp.iem.internshipmanager.data.repository.DataRepository;
import com.lp.iem.internshipmanager.data.manager.DBFlowManager;
import com.lp.iem.internshipmanager.data.entity.mapper.StudentDataMapper;
import com.lp.iem.internshipmanager.data.entity.mapper.ScheduleDataMapper;

public class IMApplication extends Application {
    private static IMApplication application;
    public static IMApplication app() {
        return application;
    }

    private DataRepository dataRepository;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        initInjection();
    }

    public DataRepository getDataRepository() {
        return dataRepository;
    }

    private void initInjection() {
        DBFlowManager dbFlowManager = new DBFlowManager();
        StudentDataMapper studentDataMapper=new StudentDataMapper();
        ScheduleDataMapper scheduleDataMapper= new ScheduleDataMapper();

        this.dataRepository = new DataRepository(dbFlowManager,studentDataMapper,scheduleDataMapper);
    }
}
