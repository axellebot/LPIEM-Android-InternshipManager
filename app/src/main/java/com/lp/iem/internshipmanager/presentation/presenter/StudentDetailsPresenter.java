package com.lp.iem.internshipmanager.presentation.presenter;

import com.lp.iem.internshipmanager.model.Contact;
import com.lp.iem.internshipmanager.presentation.ui.activity.BaseActivityLifeCycle;
import com.lp.iem.internshipmanager.presentation.ui.view.StudentDetailsView;
import com.lp.iem.internshipmanager.presentation.ui.view.StudentListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by romai on 09/01/2017.
 */

public class StudentDetailsPresenter implements BaseActivityLifeCycle {

    private StudentDetailsView studentDetailsView;
    Contact student;

    public StudentDetailsPresenter(StudentDetailsView studentDetailsView, Contact student) {
        this.studentDetailsView = studentDetailsView;
        this.student = student;
    }

    @Override
    public void start() {
        studentDetailsView.displayDetails(student);
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {

    }
}
