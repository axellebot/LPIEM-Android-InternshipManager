package com.lp.iem.internshipmanager.presentation.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Schedule {
    private UUID id;
    private String label;
    private String description;
    private Date date;
    private ArrayList<File> files;
}
