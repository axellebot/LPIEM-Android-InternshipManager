package com.lp.iem.internshipmanager.presentation.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.lp.iem.internshipmanager.presentation.presenter.CreateSchedulePresenter;
import com.lp.iem.internshipmanager.presentation.ui.view.CreateScheduleView;

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
}
