package com.lp.iem.internshipmanager.presentation.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lp.iem.internshipmanager.R;
import com.lp.iem.internshipmanager.model.Contact;
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

    private StudentDetailsPresenter presenter;
    private StudentDetailsAdapter studentDetailsAdapter;

    @BindView(R.id.fragment_studentdetails_recyclerview) RecyclerView recyclerView;

    public static StudentDetailsFragment newInstance() {
        StudentDetailsFragment fragment = new StudentDetailsFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_student_details, container, false);
        ButterKnife.bind(this, view);
        initializeInjection();

        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Students");

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        studentDetailsAdapter = new StudentDetailsAdapter(new Contact("Marty", "MacFly"), presenter);
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
    public void displayDetails(Contact student) {
        studentDetailsAdapter = new StudentDetailsAdapter(student, presenter);
        recyclerView.setAdapter(studentDetailsAdapter);
    }

    public boolean isItemIsFocused() {
        return studentDetailsAdapter.isItemIsFocused();
    }

    private void initializeInjection() {
        presenter = new StudentDetailsPresenter(getActivity(), this, new Contact("Marty", "MacFly"));
    }
}
