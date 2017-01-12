package com.lp.iem.internshipmanager.presentation.ui.view;

import com.lp.iem.internshipmanager.presentation.model.Student;

import java.util.List;

/**
 * Created by romai on 09/01/2017.
 */

public interface StudentListView {
    void displayStudentList(List<Student> studentList);
    void displayFilteredStudentList(List<Student> studentList);
}
