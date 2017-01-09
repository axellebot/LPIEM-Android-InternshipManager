package com.lp.iem.internshipmanager.presentation;

import android.app.Application;

import com.lp.iem.internshipmanager.data.entity.mapper.FileDataMapper;
import com.lp.iem.internshipmanager.data.entity.mapper.OrganizationPropertyDataMapper;
import com.lp.iem.internshipmanager.data.entity.mapper.ScheduleDataMapper;
import com.lp.iem.internshipmanager.data.entity.mapper.StudentDataMapper;
import com.lp.iem.internshipmanager.data.entity.mapper.StudentPropertyBaseDataMapper;
import com.lp.iem.internshipmanager.data.manager.DBFlowManager;
import com.lp.iem.internshipmanager.data.repository.DataRepository;
import com.lp.iem.internshipmanager.presentation.model.student_property.OrganizationProperty;
import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;

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
        initDBFlow();
    }

    public DataRepository getDataRepository() {
        return dataRepository;
    }

    private void initInjection() {
        DBFlowManager dbFlowManager = new DBFlowManager();
        FileDataMapper fileDataMapper= new FileDataMapper();
        OrganizationPropertyDataMapper organizationProperty= new OrganizationPropertyDataMapper();
        ScheduleDataMapper scheduleDataMapper=new ScheduleDataMapper();
        StudentPropertyBaseDataMapper studentPropertyBaseDataMapper= new StudentPropertyBaseDataMapper();

        StudentDataMapper studentDataMapper = new StudentDataMapper(fileDataMapper,organizationProperty,scheduleDataMapper,studentPropertyBaseDataMapper);

        this.dataRepository = new DataRepository(dbFlowManager, studentDataMapper, scheduleDataMapper);
    }

    private void initDBFlow() {
        // This instantiates DBFlow
        FlowManager.init(new FlowConfig.Builder(this).build());
        // add for verbose logging
        // FlowLog.setMinimumLoggingLevel(FlowLog.Level.V);
    }
}
