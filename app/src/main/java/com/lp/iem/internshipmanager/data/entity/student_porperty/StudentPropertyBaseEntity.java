package com.lp.iem.internshipmanager.data.entity.student_porperty;

import com.lp.iem.internshipmanager.data.entity.StudentEntity;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

public abstract class StudentPropertyBaseEntity extends BaseModel {
    @Column
    @PrimaryKey
    String id;

    @Column
    String label;

    @Column
    String value;

    @ForeignKey
    StudentEntity student;
}
