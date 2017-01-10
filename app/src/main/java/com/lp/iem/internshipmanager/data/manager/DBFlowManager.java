package com.lp.iem.internshipmanager.data.manager;

import android.support.annotation.NonNull;

import com.lp.iem.internshipmanager.data.entity.StudentEntity;

import java.util.List;

import rx.Observable;

public interface DBFlowManager {
    Observable<List<StudentEntity>> getStudents();
    Observable<StudentEntity> getStudent(@NonNull String id);
}
