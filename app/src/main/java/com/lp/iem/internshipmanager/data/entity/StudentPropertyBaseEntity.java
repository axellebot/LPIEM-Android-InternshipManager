package com.lp.iem.internshipmanager.data.entity;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

public abstract class StudentPropertyBaseEntity extends BaseModel {
    @Column
    @PrimaryKey(autoincrement = true)
    String id;

    @Column
    String label;

    @Column
    String value;

    @ForeignKey
    StudentEntity student;
}
