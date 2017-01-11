package com.lp.iem.internshipmanager.presentation;

import android.app.Application;

import com.lp.iem.internshipmanager.data.entity.AddressEntity;
import com.lp.iem.internshipmanager.data.entity.EmailEntity;
import com.lp.iem.internshipmanager.data.entity.FileEntity;
import com.lp.iem.internshipmanager.data.entity.NumberEntity;
import com.lp.iem.internshipmanager.data.entity.OrganizationEntity;
import com.lp.iem.internshipmanager.data.entity.ScheduleEntity;
import com.lp.iem.internshipmanager.data.entity.StudentEntity;
import com.lp.iem.internshipmanager.data.entity.mapper.AddressDataMapper;
import com.lp.iem.internshipmanager.data.entity.mapper.EmailDataMapper;
import com.lp.iem.internshipmanager.data.entity.mapper.FileDataMapper;
import com.lp.iem.internshipmanager.data.entity.mapper.NumberDataMapper;
import com.lp.iem.internshipmanager.data.entity.mapper.OrganizationDataMapper;
import com.lp.iem.internshipmanager.data.entity.mapper.ScheduleDataMapper;
import com.lp.iem.internshipmanager.data.entity.mapper.StudentDataMapper;
import com.lp.iem.internshipmanager.data.entity.mapper.WebsiteDataMapper;
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

        AddressDataMapper addressDataMapper = new AddressDataMapper();
        EmailDataMapper emailDataMapper = new EmailDataMapper();
        FileDataMapper fileDataMapper = new FileDataMapper();
        NumberDataMapper numberDataMapper = new NumberDataMapper();
        OrganizationDataMapper organizationDataMapper = new OrganizationDataMapper();
        ScheduleDataMapper scheduleDataMapper = new ScheduleDataMapper();
        StudentDataMapper studentDataMapper = new StudentDataMapper();
        WebsiteDataMapper websiteDataMapper = new WebsiteDataMapper();

        this.dataRepository = new DataRepository(dbFlowManager, addressDataMapper, emailDataMapper, fileDataMapper, numberDataMapper, organizationDataMapper, scheduleDataMapper, studentDataMapper, websiteDataMapper);
    }

    private void initDBFlow() {
        // This instantiates DBFlow
        FlowManager.init(new FlowConfig.Builder(this).build());
        // add for verbose logging
        // FlowLog.setMinimumLoggingLevel(FlowLog.Level.V);

        //testDBFlow();
    }

    private void testDBFlow() {
        //TEST
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.id = UUID.randomUUID().toString();
        studentEntity.fname = "Marty";
        studentEntity.lname = "MacFly";
        studentEntity.notes = "Some notes about \nthis student";

        //files
        FileEntity fileEntity = new FileEntity();
        fileEntity.id = UUID.randomUUID().toString();
        fileEntity.filePath = "/sdcard0/test.txt";
        fileEntity.description = "Description";
        fileEntity.student = studentEntity;
        studentEntity.getFileList().add(fileEntity);

        //Address
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.id = UUID.randomUUID().toString();
        addressEntity.label = "RDV";
        addressEntity.value = "21 rue Peter Fink";
        addressEntity.student = studentEntity;
        studentEntity.getAddressList().add(addressEntity);

        //Email
        EmailEntity emailEntity = new EmailEntity();
        emailEntity.id = UUID.randomUUID().toString();
        emailEntity.label = "Email";
        emailEntity.value = "example@example.com";
        emailEntity.student = studentEntity;
        studentEntity.getEmailList().add(emailEntity);

        //schedules
        ScheduleEntity scheduleEntity = new ScheduleEntity();
        scheduleEntity.id = UUID.randomUUID().toString();
        scheduleEntity.date = new Date();
        scheduleEntity.label = "Label RDV";
        scheduleEntity.description = "Description RDV";
        scheduleEntity.student=studentEntity;
        studentEntity.getScheduleList().add(scheduleEntity);

        //numbers
        NumberEntity numberEntity = new NumberEntity();
        numberEntity.id = UUID.randomUUID().toString();
        numberEntity.label = "Numero uno";
        numberEntity.value = "+33 6 05 05 05 05";
        numberEntity.student=studentEntity;
        studentEntity.getNumberList().add(numberEntity);

        //organnization
        OrganizationEntity organizationEntity = new OrganizationEntity();
        organizationEntity.id = UUID.randomUUID().toString();
        organizationEntity.name = "L'entreprise";
        organizationEntity.student=studentEntity;
        studentEntity.getOrganizationList().add(organizationEntity);

        studentEntity.save();
    }
}
