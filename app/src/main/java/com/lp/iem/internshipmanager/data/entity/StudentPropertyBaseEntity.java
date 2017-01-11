package com.lp.iem.internshipmanager.data.entity;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.structure.BaseModel;

public abstract class StudentPropertyBaseEntity extends BaseModel {
    @Column
    @PrimaryKey
    public String id;

    @Column
    public String label;

    @Column
    public String value;

    @ForeignKey(stubbedRelationship = true)
    public StudentEntity student;
}
