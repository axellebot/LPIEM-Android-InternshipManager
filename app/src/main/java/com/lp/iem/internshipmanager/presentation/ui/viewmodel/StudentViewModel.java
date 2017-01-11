package com.lp.iem.internshipmanager.presentation.ui.viewmodel;

import com.lp.iem.internshipmanager.presentation.model.Student;

/**
 * Created by romai on 11/01/2017.
 */

public class StudentViewModel {
    private Student student;

    public StudentViewModel(Student student) {
        this.student = student;
    }

    public String getFullName() {
        return student.getFname() + " " + student.getLname();
    }

    public String getFname() {
        return student.getFname();
    }

    public String getLname() {
        return student.getLname();
    }

    public String getNotes() {
        return student.getNotes();
    }

}
