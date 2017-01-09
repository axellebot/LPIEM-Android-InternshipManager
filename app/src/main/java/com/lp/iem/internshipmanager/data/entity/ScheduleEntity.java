package com.lp.iem.internshipmanager.data.entity;

import com.lp.iem.internshipmanager.presentation.model.Student;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.sql.Date;
import java.util.List;

@Table(database = MyDatabase.class)
public class ScheduleEntity extends BaseModel {
    @Column
    @PrimaryKey
    public String id;

    @Column
    public String label;

    @Column
    public String description;

    @Column
    public Date date;

    @ForeignKey
    public Student student;
}
