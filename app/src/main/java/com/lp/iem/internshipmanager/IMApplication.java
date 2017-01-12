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

        //testDBFlowStudent1();
        //testDBFlowStudent2();
    }

    private void testDBFlowStudent1() {
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

    private void testDBFlowStudent2() {
        //TEST
        Student student = new Student();
        student.setFname("Marty");
        student.setLname("MacFly");
        student.setNotes("Some notes about \nthis student");

        //file
        File file = new File(Environment.getRootDirectory().toString() + "/test.txt");
        file.setDescription("Description");
        student.getFileList().add(file);
        //file2
        File file2 = new File(Environment.getRootDirectory().toString() + "/test.txt");
        file2.setDescription("Description");
        student.getFileList().add(file2);
        //file3
        File file3 = new File(Environment.getRootDirectory().toString() + "/test.txt");
        file3.setDescription("Description");
        student.getFileList().add(file3);
        //file
        File file4 = new File(Environment.getRootDirectory().toString() + "/test.txt");
        file4.setDescription("Description");
        student.getFileList().add(file4);

        //Address
        Address address = new Address();
        address.setLabel("IUT");
        address.setValue("71 rue Peter Fink");
        student.getAddressList().add(address);
        Address address2 = new Address();
        address2.setLabel("IUT");
        address2.setValue("71 rue Peter Fink");
        student.getAddressList().add(address);
        Address address3 = new Address();
        address3.setLabel("IUT");
        address3.setValue("71 rue Peter Fink");
        student.getAddressList().add(address3);

        //Email
        Email email = new Email();
        email.setLabel("Email");
        email.setValue("example@example.com");
        student.getEmailList().add(email);

        Email email2 = new Email();
        email2.setLabel("Email");
        email2.setValue("example@example.com");
        student.getEmailList().add(email2);

        //schedules
        Schedule schedule = new Schedule();
        schedule.setDate(new Date());
        schedule.setLabel("Label RDV");
        schedule.setDescription("Description RDV");
        student.getScheduleList().add(schedule);
        //schedules
        Schedule schedule2 = new Schedule();
        schedule2.setDate(new Date());
        schedule2.setLabel("Label RDV");
        schedule2.setDescription("Description RDV");
        student.getScheduleList().add(schedule2);
        //schedules
        Schedule schedule3 = new Schedule();
        schedule3.setDate(new Date());
        schedule3.setLabel("Label RDV");
        schedule3.setDescription("Description RDV");
        student.getScheduleList().add(schedule3);
        //schedules
        Schedule schedule4 = new Schedule();
        schedule4.setDate(new Date());
        schedule4.setLabel("Label RDV");
        schedule4.setDescription("Description RDV");
        student.getScheduleList().add(schedule4);
        //schedules
        Schedule schedule5 = new Schedule();
        schedule5.setDate(new Date());
        schedule5.setLabel("Label RDV");
        schedule5.setDescription("Description RDV");
        student.getScheduleList().add(schedule5);

        //numbers
        Number number = new Number();
        number.setLabel("Numero uno");
        number.setValue("+33 6 05 05 05 05");
        student.getNumberList().add(number);
        //number2s
        Number number2 = new Number();
        number2.setLabel("Numero uno");
        number2.setValue("+33 6 05 05 05 05");
        student.getNumberList().add(number2);
        //numbers
        Number number3 = new Number();
        number3.setLabel("Numero uno");
        number3.setValue("+33 6 05 05 05 05");
        student.getNumberList().add(number3);

        //organization
        Organization organization = new Organization();
        organization.setName("L'entreprise");
        student.getOrganizationList().add(organization);

        dataRepository.saveStudent(student);
    }
}
