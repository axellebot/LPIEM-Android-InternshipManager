package com.lp.iem.internshipmanager.presentation.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lp.iem.internshipmanager.R;
import com.lp.iem.internshipmanager.presentation.model.Student;
import com.lp.iem.internshipmanager.presentation.presenter.StudentDetailsPresenter;
import com.lp.iem.internshipmanager.presentation.ui.activity.MainActivity;
import com.lp.iem.internshipmanager.presentation.ui.adapter.StudentDetailsAdapter;
import com.lp.iem.internshipmanager.presentation.ui.view.StudentDetailsView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by romai on 09/01/2017.
 */

public class StudentDetailsFragment extends Fragment implements StudentDetailsView {
    private static final String ARG_STUDENT_ID = "STUDENT_ID";

    private StudentDetailsPresenter presenter;
    private StudentDetailsAdapter studentDetailsAdapter;

    @BindView(R.id.fragment_studentdetails_recyclerview) RecyclerView recyclerView;

    public static StudentDetailsFragment newInstance(String studentId) {
        StudentDetailsFragment fragment = new StudentDetailsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_STUDENT_ID, studentId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_student_details, container, false);
        ButterKnife.bind(this, view);
        initializeInjection(getArguments().getString(ARG_STUDENT_ID));

        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Student Details");

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        studentDetailsAdapter = new StudentDetailsAdapter(new Student(), presenter);
        recyclerView.setAdapter(studentDetailsAdapter);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.start();
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.pause();
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.stop();
    }

    @Override
    public void displayDetails(Student student) {
        studentDetailsAdapter = new StudentDetailsAdapter(student, presenter);
        recyclerView.setAdapter(studentDetailsAdapter);
    }

    public boolean isItemIsFocused() {
        return studentDetailsAdapter.isItemIsFocused();
    }

    private void initializeInjection(String studentId) {
        presenter = new StudentDetailsPresenter(getActivity(), this, studentId);
    }
}
