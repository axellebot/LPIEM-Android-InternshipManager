package com.lp.iem.internshipmanager.presentation.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arlib.floatingsearchview.FloatingSearchView;
import com.lp.iem.internshipmanager.R;
import com.lp.iem.internshipmanager.presentation.presenter.StudentListPresenter;
import com.lp.iem.internshipmanager.presentation.ui.view.StudentListView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by romai on 09/01/2017.
 */

public class StudentListFragment extends Fragment implements StudentListView {

    private StudentListPresenter presenter;

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

        /*LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        comicsListRecyclerView.setLayoutManager(layoutManager);
        ComicsListAdapter comicsListAdapter = new ComicsListAdapter(getActivity(), this, new ArrayList<ComicsViewModel>());
        comicsListRecyclerView.setAdapter(comicsListAdapter);*/

        return view;
    }

    private void initializeInjection() {
        presenter = new StudentListPresenter(this);
    }
}
