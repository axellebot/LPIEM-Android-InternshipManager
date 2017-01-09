package com.lp.iem.internshipmanager.presentation.model;

import android.content.ContentValues;

import java.util.List;
import java.util.UUID;

public class Student {
    private UUID id;
    private String givenName;
    private String familyName;
    private String notes;
    private ContentValues emails;
    private ContentValues phones;
    private ContentValues addresses;
    private ContentValues organizations;
    private ContentValues webSites;

    private ContentValues files;
    private List<Schedule> schedules;

    public Student() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return this.givenName + ' ' + this.familyName;
    }
}
