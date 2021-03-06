package com.lp.iem.internshipmanager.presentation.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arlib.floatingsearchview.FloatingSearchView;
import com.lp.iem.internshipmanager.R;
import com.lp.iem.internshipmanager.presentation.model.Student;
import com.lp.iem.internshipmanager.presentation.presenter.StudentListPresenter;
import com.lp.iem.internshipmanager.presentation.ui.activity.MainActivity;
import com.lp.iem.internshipmanager.presentation.ui.adapter.StudentListAdapter;
import com.lp.iem.internshipmanager.presentation.ui.view.StudentListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by romai on 09/01/2017.
 */

public class StudentListFragment extends Fragment implements StudentListView {

    private StudentListPresenter presenter;
    private StudentListAdapter studentListAdapter;

    @BindView(R.id.fragment_studentlist_recyclerview) RecyclerView recyclerView;
    @BindView(R.id.fragment_studentlist_searchview) FloatingSearchView searchView;

    public static StudentListFragment newInstance() {
        StudentListFragment fragment = new StudentListFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_student_list, container, false);
        ButterKnife.bind(this, view);
        initializeInjection();

        setActionBar();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        studentListAdapter = new StudentListAdapter(new ArrayList<Student>());
        recyclerView.setAdapter(studentListAdapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        searchView.setOnQueryChangeListener(new FloatingSearchView.OnQueryChangeListener() {
            @Override
            public void onSearchTextChanged(String oldQuery, String newQuery) {
                presenter.filterList(newQuery);
            }
        });

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
    public void displayStudentList(List<Student> studentList) {
        studentListAdapter = new StudentListAdapter(studentList);
        studentListAdapter.setClickListener(new StudentListAdapter.ClickListener() {
            @Override
            public void ItemClicked(View v, int position) {
                presenter.itemClicked(position);
            }
        });
        recyclerView.setAdapter(studentListAdapter);
    }

    @Override
    public void displayFilteredStudentList(List<Student> studentList) {
        displayStudentList(studentList);
    }

    public void setActionBar() {
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Students");
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(false);
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    private void initializeInjection() {
        presenter = new StudentListPresenter(this, (MainActivity) getActivity());
    }

}
