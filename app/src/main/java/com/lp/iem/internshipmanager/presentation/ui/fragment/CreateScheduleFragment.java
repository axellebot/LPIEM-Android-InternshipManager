package com.lp.iem.internshipmanager.presentation.ui.fragment;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.lp.iem.internshipmanager.R;
import com.lp.iem.internshipmanager.presentation.presenter.CreateSchedulePresenter;
import com.lp.iem.internshipmanager.presentation.ui.view.CreateScheduleView;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CreateScheduleFragment extends Fragment implements CreateScheduleView {
    private static final String ARG_STUDENT_ID = "STUDENT_ID";

    private CreateSchedulePresenter presenter;

    @BindView(R.id.form_schedule_spinner_start_date)
    TextView spinnerStartDate;
    @BindView(R.id.form_schedule_spinner_start_time)
    TextView spinnerStartTime;
    @BindView(R.id.form_schedule_spinner_end_date)
    TextView spinnerEndDate;
    @BindView(R.id.form_schedule_spinner_end_time)
    TextView spinnerEndTime;

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

    @OnClick({R.id.form_schedule_spinner_start_date, R.id.form_schedule_spinner_start_time, R.id.form_schedule_spinner_end_date, R.id.form_schedule_spinner_end_time})
    public void onSpinnerDateTimeClick(View view) {
        TextView spinner = (TextView) view;
        Date date = new Date();
        if (spinner == spinnerStartDate) {
            DatePickerDialog datePickerDialog =
                    new DatePickerDialog(
                            getContext(),
                            new DatePickerDialog.OnDateSetListener() {
                                @Override
                                public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

                                }
                            },
                            date.getYear(),
                            date.getMonth(),
                            date.getDay()
                    );
            datePickerDialog.show();
        } else if (spinner == spinnerStartTime) {
            TimePickerDialog timePickerDialog =
                    new TimePickerDialog(
                            getContext(),
                            new TimePickerDialog.OnTimeSetListener() {
                                @Override
                                public void onTimeSet(TimePicker timePicker, int i, int i1) {

                                }
                            },
                            date.getHours(),
                            date.getMinutes(),
                            true

                    );
            timePickerDialog.show();
        } else if (spinner == spinnerEndDate) {
            DatePickerDialog datePickerDialog =
                    new DatePickerDialog(
                            getContext(),
                            new DatePickerDialog.OnDateSetListener() {
                                @Override
                                public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

                                }
                            },
                            date.getYear(),
                            date.getMonth(),
                            date.getDay()
                    );
            datePickerDialog.show();
        } else if (spinner == spinnerEndTime) {
            TimePickerDialog timePickerDialog =
                    new TimePickerDialog(
                            getContext(),
                            new TimePickerDialog.OnTimeSetListener() {
                                @Override
                                public void onTimeSet(TimePicker timePicker, int i, int i1) {

                                }
                            },
                            date.getHours(),
                            date.getMinutes(),
                            true

                    );
            timePickerDialog.show();
        }
    }
}
