package com.lp.iem.internshipmanager.presentation.model;

import android.content.ContentValues;

import com.lp.iem.internshipmanager.presentation.model.student_property.AddressProperty;
import com.lp.iem.internshipmanager.presentation.model.student_property.EmailProperty;
import com.lp.iem.internshipmanager.presentation.model.student_property.NumberProperty;
import com.lp.iem.internshipmanager.presentation.model.student_property.OrganizationProperty;
import com.lp.iem.internshipmanager.presentation.model.student_property.WebsiteProperty;

import java.util.List;
import java.util.UUID;

public class Student {
    private UUID id;
    private String fname;
    private String lname;
    private String notes;
    private List<EmailProperty> emailList;
    private List<NumberProperty> numberList;
    private List<AddressProperty> addressList;
    private List<OrganizationProperty> organizationList;
    private List<WebsiteProperty> webSites;

    private List<File> fileList;
    private List<Schedule> scheduleList;
}
