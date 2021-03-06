package com.lp.iem.internshipmanager.data.entity;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.Date;

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

    @ForeignKey(stubbedRelationship = true)
    public StudentEntity student;
}
