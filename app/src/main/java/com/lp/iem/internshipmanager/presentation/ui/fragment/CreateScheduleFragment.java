package com.lp.iem.internshipmanager.presentation.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lp.iem.internshipmanager.R;
import com.lp.iem.internshipmanager.presentation.presenter.CreateSchedulePresenter;
import com.lp.iem.internshipmanager.presentation.ui.view.CreateScheduleView;

import butterknife.ButterKnife;

public class CreateScheduleFragment extends Fragment implements CreateScheduleView {
    private static final String ARG_STUDENT_ID = "STUDENT_ID";

    private CreateSchedulePresenter presenter;

    public static CreateScheduleFragment newInstance(String studentId) {
        CreateScheduleFragment fragment = new CreateScheduleFragment();
        Bundle args = new Bundle();
        args.putString(ARG_STUDENT_ID, studentId);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_create_schedule, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
}
