package com.lp.iem.internshipmanager.presentation.model;

import android.content.ContentValues;

import java.util.List;
import java.util.UUID;

public class Student {
    private UUID id;
    private String fname;
    private String lname;
    private String notes;
    private ContentValues emails;
    private ContentValues numbers;
    private ContentValues addresses;
    private List<String> organizations;
    private ContentValues webSites;

    private List<File> files;
    private List<Schedule> schedules;
}
