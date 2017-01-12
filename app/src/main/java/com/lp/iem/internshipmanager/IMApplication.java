package com.lp.iem.internshipmanager;

import android.app.Application;
import android.os.Environment;

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
import com.lp.iem.internshipmanager.presentation.model.Address;
import com.lp.iem.internshipmanager.presentation.model.Email;
import com.lp.iem.internshipmanager.presentation.model.File;
import com.lp.iem.internshipmanager.presentation.model.Number;
import com.lp.iem.internshipmanager.presentation.model.Organization;
import com.lp.iem.internshipmanager.presentation.model.Schedule;
import com.lp.iem.internshipmanager.presentation.model.Student;
import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;

import java.util.Date;

public class IMApplication extends Application {
    private static IMApplication application;
    private DataRepository dataRepository;

    public static IMApplication app() {
        return application;
    }

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
        Student student = new Student();
        student.setFname("Marty");
        student.setLname("MacFly");
        student.setNotes("Some notes about \nthis student");

        //file
        File file = new File(Environment.getRootDirectory().toString() + "/test.txt");
        file.setDescription("Description");
        student.getFileList().add(file);

        //Address
        Address address = new Address();
        address.setLabel("IUT");
        address.setValue("71 rue Peter Fink");
        student.getAddressList().add(address);

        //Email
        Email email = new Email();
        email.setLabel("Email");
        email.setValue("example@example.com");
        student.getEmailList().add(email);

        //schedules
        Schedule schedule = new Schedule();
        schedule.setDate(new Date());
        schedule.setLabel("Label RDV");
        schedule.setDescription("Description RDV");
        student.getScheduleList().add(schedule);

        //numbers
        Number number = new Number();
        number.setLabel("Numero uno");
        number.setValue("+33 6 05 05 05 05");
        student.getNumberList().add(number);

        //organization
        Organization organization = new Organization();
        organization.setName("L'entreprise");
        student.getOrganizationList().add(organization);

        dataRepository.saveStudent(student);
    }
}
