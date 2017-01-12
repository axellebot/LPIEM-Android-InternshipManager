package com.lp.iem.internshipmanager.presentation.presenter;

import com.lp.iem.internshipmanager.data.repository.DataRepository;
import com.lp.iem.internshipmanager.IMApplication;
import com.lp.iem.internshipmanager.presentation.model.Student;
import com.lp.iem.internshipmanager.presentation.ui.activity.BaseActivityLifeCycle;
import com.lp.iem.internshipmanager.presentation.ui.listener.StudentSelectedListener;
import com.lp.iem.internshipmanager.presentation.ui.view.StudentListView;
import com.lp.iem.internshipmanager.presentation.ui.viewmodel.StudentViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by romai on 09/01/2017.
 */

public class StudentListPresenter implements BaseActivityLifeCycle {

    private StudentListView studentListView;
    private StudentSelectedListener studentSelectedListener;

    private List<Student> studentList;

    private DataRepository dataRepository;

    public StudentListPresenter(StudentListView studentListView, StudentSelectedListener studentSelectedListener) {
        this.studentListView = studentListView;
        this.studentSelectedListener = studentSelectedListener;
        dataRepository = IMApplication.app().getDataRepository();
    }

    @Override
    public void start() {
        getStudentList();
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
        dataRepository.getStudents()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Student>>() {
                               @Override
                               public void onCompleted() {

                               }

                               @Override
                               public void onError(Throwable e) {
                                    e.printStackTrace();
                               }

                               @Override
                               public void onNext(List<Student> students) {
                                   studentList = students;
                                   studentListView.displayStudentList(sortList(studentList));
                               }
                           });
    }

    public void itemClicked(int position) {
        studentSelectedListener.studentSelected(studentList.get(position).getId());
    }

    public void filterList(String query) {
        studentListView.displayFilteredStudentList(filter(studentList, query));
    }

    private List<Student> sortList(List<Student> list) {
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student contact1, Student contact2) {
                StudentViewModel studentViewModel1 = new StudentViewModel(contact1);
                StudentViewModel studentViewModel2 = new StudentViewModel(contact2);
                return studentViewModel1.getFullName().compareTo(studentViewModel2.getFullName());
            }
        });
        return list;
    }

    private List<Student> filter(List<Student> contacts, String query) {
        query = query.toLowerCase();
        final List<Student> filteredModelList = new ArrayList<>();
        for (Student contact : contacts) {
            StudentViewModel studentViewModel1 = new StudentViewModel(contact);
            final String text = studentViewModel1.getFullName().toLowerCase();
            if (text.contains(query)) {
                filteredModelList.add(contact);
            }
        }
        return filteredModelList;
    }

}
