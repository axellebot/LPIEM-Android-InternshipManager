package com.lp.iem.internshipmanager.presentation.model;

import java.util.UUID;

/**
 * Created by axellebot on 09/01/2017.
 */

public class Organization {
    private String id;
    private String name;
    private String studentId;

    public Organization() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}
