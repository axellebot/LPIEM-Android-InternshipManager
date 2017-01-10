package com.lp.iem.internshipmanager.data.manager;

import android.support.annotation.NonNull;

import com.lp.iem.internshipmanager.data.entity.StudentEntity;
import com.lp.iem.internshipmanager.data.entity.StudentEntity_Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

import rx.Observable;

public class DBFlowManagerImpl implements DBFlowManager {

    @Override
    public Observable<List<StudentEntity>> getStudents() {
        return Observable.just(
                SQLite.select().
                        from(StudentEntity.class).
                        queryList()
        );
    }

    @Override
    public Observable<StudentEntity> getStudent(@NonNull String id) {
        return Observable.just(
                SQLite.select().
                        from(StudentEntity.class).
                        where(StudentEntity_Table.id.is(id)).
                        querySingle()
        );
    }
}
