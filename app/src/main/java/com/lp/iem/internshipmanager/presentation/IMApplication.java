package com.lp.iem.internshipmanager.presentation;

import android.app.Application;

import com.lp.iem.internshipmanager.data.entity.FileEntity;
import com.lp.iem.internshipmanager.data.entity.ScheduleEntity;
import com.lp.iem.internshipmanager.data.entity.StudentEntity;
import com.lp.iem.internshipmanager.data.entity.mapper.FileDataMapper;
import com.lp.iem.internshipmanager.data.entity.mapper.OrganizationPropertyDataMapper;
import com.lp.iem.internshipmanager.data.entity.mapper.ScheduleDataMapper;
import com.lp.iem.internshipmanager.data.entity.mapper.StudentDataMapper;
import com.lp.iem.internshipmanager.data.entity.mapper.StudentPropertyBaseDataMapper;
import com.lp.iem.internshipmanager.data.entity.student_porperty.AddressPropertyEntity;
import com.lp.iem.internshipmanager.data.entity.student_porperty.EmailPropertyEntity;
import com.lp.iem.internshipmanager.data.entity.student_porperty.NumberPropertyEntity;
import com.lp.iem.internshipmanager.data.entity.student_porperty.OrganizationPropertyEntity;
import com.lp.iem.internshipmanager.data.manager.DBFlowManagerImpl;
import com.lp.iem.internshipmanager.data.repository.DataRepository;
import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;

import java.util.Date;
import java.util.UUID;

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
        DBFlowManagerImpl dbFlowManager = new DBFlowManagerImpl();
        FileDataMapper fileDataMapper = new FileDataMapper();
        OrganizationPropertyDataMapper organizationProperty = new OrganizationPropertyDataMapper();
        ScheduleDataMapper scheduleDataMapper = new ScheduleDataMapper();
        StudentPropertyBaseDataMapper studentPropertyBaseDataMapper = new StudentPropertyBaseDataMapper();

        StudentDataMapper studentDataMapper = new StudentDataMapper(fileDataMapper, organizationProperty, scheduleDataMapper, studentPropertyBaseDataMapper);

        this.dataRepository = new DataRepository(dbFlowManager, studentDataMapper, scheduleDataMapper, fileDataMapper, organizationProperty, studentPropertyBaseDataMapper);
    }

    private void initDBFlow() {
        // This instantiates DBFlow
        FlowManager.init(new FlowConfig.Builder(this).build());
        // add for verbose logging
        // FlowLog.setMinimumLoggingLevel(FlowLog.Level.V);

        //testDBFlow();
    }

    private void testDBFlow(){
        //TEST
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.fname = "Fname";
        studentEntity.lname = "Lname";

        //files
        FileEntity fileEntity = new FileEntity();
        fileEntity.id = UUID.randomUUID().toString();
        fileEntity.filePath = "/sdcard0/test.txt";
        fileEntity.description = "Description";
        fileEntity.student = studentEntity;
        studentEntity.getFileList().add(fileEntity);

        //Address
        AddressPropertyEntity addressPropertyEntity = new AddressPropertyEntity();
        addressPropertyEntity.id = UUID.randomUUID().toString();
        addressPropertyEntity.label = "RDV";
        addressPropertyEntity.value = "21 rue Peter Fink";
        addressPropertyEntity.student = studentEntity;
        studentEntity.getAddressList().add(addressPropertyEntity);

        //Email
        EmailPropertyEntity emailPropertyEntity = new EmailPropertyEntity();
        emailPropertyEntity.id = UUID.randomUUID().toString();
        emailPropertyEntity.label = "Email";
        emailPropertyEntity.value = "example@example.com";
        emailPropertyEntity.student = studentEntity;
        studentEntity.getEmailList().add(emailPropertyEntity);

        //schedules
        ScheduleEntity scheduleEntity = new ScheduleEntity();
        scheduleEntity.id = UUID.randomUUID().toString();
        scheduleEntity.date = new Date();
        scheduleEntity.label = "Label RDV";
        scheduleEntity.description = "Description RDV";
        scheduleEntity.student = studentEntity;
        studentEntity.getScheduleList().add(scheduleEntity);

        //numbers
        NumberPropertyEntity numberPropertyEntity = new NumberPropertyEntity();
        numberPropertyEntity.id= UUID.randomUUID().toString();
        numberPropertyEntity.label="Numero uno";
        numberPropertyEntity.value="+33 6 05 05 05 05";
        numberPropertyEntity.student=studentEntity;
        studentEntity.getNumberList().add(numberPropertyEntity);

        //organnization
        OrganizationPropertyEntity organizationPropertyEntity = new OrganizationPropertyEntity();
        organizationPropertyEntity.id=UUID.randomUUID().toString();
        organizationPropertyEntity.name="L'entreprise";
        organizationPropertyEntity.student=studentEntity;
        studentEntity.getOrganizationList().add(organizationPropertyEntity);

        studentEntity.save();
    }
}
