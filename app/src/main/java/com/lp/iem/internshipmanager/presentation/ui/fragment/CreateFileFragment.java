package com.lp.iem.internshipmanager.presentation.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.lp.iem.internshipmanager.presentation.presenter.CreateFilePresenter;
import com.lp.iem.internshipmanager.presentation.ui.view.CreateFileView;

public class CreateFileFragment extends Fragment implements CreateFileView {
    private static final String ARG_STUDENT_ID = "STUDENT_ID";

    private CreateFilePresenter presenter;

    public static CreateFileFragment newInstance(String studentId) {
        CreateFileFragment fragment = new CreateFileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_STUDENT_ID, studentId);
        fragment.setArguments(args);
        return fragment;
    }
}
