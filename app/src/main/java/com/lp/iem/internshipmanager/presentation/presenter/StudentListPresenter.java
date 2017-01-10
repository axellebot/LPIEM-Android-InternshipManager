package com.lp.iem.internshipmanager.presentation.presenter;

import com.lp.iem.internshipmanager.model.Contact;
import com.lp.iem.internshipmanager.presentation.ui.activity.BaseActivityLifeCycle;
import com.lp.iem.internshipmanager.presentation.ui.listener.StudentSelectedListener;
import com.lp.iem.internshipmanager.presentation.ui.view.StudentListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by romai on 09/01/2017.
 */

public class StudentListPresenter implements BaseActivityLifeCycle {

    private StudentListView studentListView;
    private List<Contact> studentList;

    private StudentSelectedListener studentSelectedListener;

    public StudentListPresenter(StudentListView studentListView, StudentSelectedListener studentSelectedListener) {
        this.studentListView = studentListView;
        this.studentSelectedListener = studentSelectedListener;
    }

    @Override
    public void start() {
        getStudentListMock();
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

    public void getStudentList() {
        //todo get student list
        /*List<Contact> studentList = dataRepository.getStudentList();
        studentListView.displayStudentList(studentList);*/
    }

    public void itemClicked(int position) {
        studentSelectedListener.studentSelected(studentList.get(position));
    }

    public void filterList(String query) {
        studentListView.displayFilteredStudentList(filter(studentList, query));
    }

    private void getStudentListMock() {
        studentList = new ArrayList<>();
        studentList.add(new Contact("Marty", "MacFly"));
        studentList.add(new Contact("José", "Garcia"));
        studentList.add(new Contact("Jean-Marie", "Lepen"));
        studentListView.displayStudentList(sortList(studentList));
    }

    private List<Contact> sortList(List<Contact> list) {
        Collections.sort(list, new Comparator<Contact>() {
            @Override
            public int compare(Contact contact1, Contact contact2) {
                return contact1.getName().compareTo(contact2.getName());
            }
        });
        return list;
    }

    private List<Contact> filter(List<Contact> contacts, String query) {
        query = query.toLowerCase();
        final List<Contact> filteredModelList = new ArrayList<>();
        for (Contact contact : contacts) {
            final String text = contact.getName().toLowerCase();
            if (text.contains(query)) {
                filteredModelList.add(contact);
            }
        }
        return filteredModelList;
    }

}
