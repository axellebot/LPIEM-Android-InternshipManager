package com.lp.iem.internshipmanager.presentation.presenter;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;

import com.lp.iem.internshipmanager.data.repository.DataRepository;
import com.lp.iem.internshipmanager.presentation.IMApplication;
import com.lp.iem.internshipmanager.presentation.model.Student;
import com.lp.iem.internshipmanager.presentation.ui.activity.BaseActivityLifeCycle;
import com.lp.iem.internshipmanager.presentation.ui.listener.ClickCallbackListener;
import com.lp.iem.internshipmanager.presentation.ui.view.StudentDetailsView;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by romai on 09/01/2017.
 */

public class StudentDetailsPresenter implements BaseActivityLifeCycle, ClickCallbackListener {

    private Context context;
    private StudentDetailsView studentDetailsView;

    private String studentId;
    private Student student;

    private DataRepository dataRepository;

    public StudentDetailsPresenter(Context context, StudentDetailsView studentDetailsView, String studentId) {
        this.context = context;
        this.studentDetailsView = studentDetailsView;
        dataRepository = IMApplication.app().getDataRepository();
        this.studentId = studentId;
    }

    @Override
    public void start() {
        getStudentById(studentId);
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

    @Override
    public void callPhoneNumber(String phoneNumber) {
        Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNumber));
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.CALL_PHONE}, 0);
        }
        else {
            context.startActivity(callIntent);
        }
    }

    @Override
    public void sendMessageToPhoneNumber(String phoneNumber) {
        Intent sendIntent = new Intent(Intent.ACTION_VIEW);
        sendIntent.setData(Uri.parse("sms:" + phoneNumber));
        context.startActivity(sendIntent);
    }

    @Override
    public void sendMessageToEmail(String email) {
        Intent sendIntent = new Intent(Intent.ACTION_VIEW);
        sendIntent.setData(Uri.parse("mailto:" + email));
        context.startActivity(sendIntent);
    }

    @Override
    public void openMapAtAddress(String address) {
        Intent mapIntent = new Intent(Intent.ACTION_VIEW);
        mapIntent.setData(Uri.parse("geo:0,0?q=" + address.replaceAll(" ", "+")));
        context.startActivity(mapIntent);
    }

    @Override
    public void routeToAddress(String address) {
        Intent mapIntent = new Intent(Intent.ACTION_VIEW);
        mapIntent.setData(Uri.parse("google.navigation:q=" + address.replaceAll(" ", "+")));
        context.startActivity(mapIntent);
    }

    @Override
    public void openWebsite(String website) {
        if(!website.contains("http://")) {
            website = "http://" + website;
        }
        Intent browserIntent = new Intent(Intent.ACTION_VIEW);
        browserIntent.setData(Uri.parse(website));
        context.startActivity(browserIntent);
    }

    @Override
    public void openNoteEditor() {

    }

    @Override
    public void openScheduleDetails() {

    }

    @Override
    public void openFileDetails() {

    }

    private void getStudentById(final String studentId) {
        dataRepository.getStudent(studentId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Student>() {
                    @Override
                    public void onCompleted() {
                        studentDetailsView.displayDetails(student);
                    }
                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }
                    @Override
                    public void onNext(Student s) {
                        student = s;
                    }
                });
    }
}
