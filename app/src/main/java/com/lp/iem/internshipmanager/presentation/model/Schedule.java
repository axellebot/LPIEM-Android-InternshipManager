package com.lp.iem.internshipmanager.presentation.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Schedule {
    private String id;
    private String label;
    private String description;
    private Date date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
