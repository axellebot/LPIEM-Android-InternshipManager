package com.lp.iem.internshipmanager.presentation.ui.listener;

/**
 * Created by romai on 10/01/2017.
 */
public interface ClickCallbackListener {
    void callPhoneNumber(String phoneNumber);
    void sendMessageToPhoneNumber(String phoneNumber);
    void sendMessageToEmail(String email);
    void openMapAtAddress(String address);
    void routeToAddress(String address);
    void openWebsite(String website);
    void openNoteEditor();
    void openScheduleDetails();
    void openFileDetails();
}
