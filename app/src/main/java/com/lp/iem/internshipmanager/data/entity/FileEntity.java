package com.lp.iem.internshipmanager.data.entity;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(database = MyDatabase.class)
public class FileEntity extends BaseModel {
    @Column
    @PrimaryKey
    public String id;

    @Column
    public String filePath;

    @Column
    public String description;

    @ForeignKey(stubbedRelationship = true)
    public StudentEntity student;
}
