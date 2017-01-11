package com.lp.iem.internshipmanager.presentation.ui.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.lp.iem.internshipmanager.R;
import com.lp.iem.internshipmanager.presentation.model.Student;
import com.lp.iem.internshipmanager.presentation.ui.listener.ClickCallbackListener;
import com.lp.iem.internshipmanager.presentation.ui.viewmodel.StudentViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by romai on 09/01/2017.
 */

public class StudentDetailsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int CARD_NUMBER = 5;

    private static final int CARD_TITLE = 0;
    private static final int CARD_CONTACT = 1;
    private static final int CARD_ABOUT = 2;
    private static final int CARD_SCHEDULES = 3;
    private static final int CARD_FILES = 4;

    private Student student;

    private Context context;

    private ClickCallbackListener clickCallbackListener;

    private boolean itemIsFocused = false;

    public StudentDetailsAdapter(Student student, ClickCallbackListener clickCallbackListener) {
        this.student = student;
        this.clickCallbackListener= clickCallbackListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = null;
        switch (viewType) {
            case CARD_TITLE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student_details_title, parent, false);
                return new TitleViewHolder(view);
            case CARD_CONTACT:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student_details_contact_infos, parent, false);
                return new ContactInfosViewHolder(view);
            case CARD_ABOUT:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student_details_about, parent, false);
                return new AboutViewHolder(view);
            case CARD_SCHEDULES:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student_details_schedulelist, parent, false);
                return new ScheduleListViewHolder(view);
            case CARD_FILES:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student_details_filelist, parent, false);
                return new FileListViewHolder(view);
            default:
                return null;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(student != null) {
            StudentViewModel studentViewModel = new StudentViewModel(student);
            switch (holder.getItemViewType()) {
                case CARD_TITLE:
                    TitleViewHolder titleViewHolder = (TitleViewHolder) holder;
                    titleViewHolder.title.setText(studentViewModel.getFullName());
                    break;
                case CARD_CONTACT:

                    ContactInfosViewHolder contactInfosViewHolder = (ContactInfosViewHolder) holder;
                    // PHONES
                    LinearLayoutManager phonesLayoutManager = new LinearLayoutManager(context) {
                        @Override
                        public boolean canScrollVertically() {
                            return false;
                        }
                    };
                    phonesLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                    contactInfosViewHolder.phoneNumberList.setLayoutManager(phonesLayoutManager);
                    StudentPhonesAdapter studentPhonesAdapter = new StudentPhonesAdapter(student.getNumberList(), clickCallbackListener);
                    contactInfosViewHolder.phoneNumberList.setAdapter(studentPhonesAdapter);

                    //EMAILS
                    if(student.getEmailList().isEmpty()) {
                        ((ContactInfosViewHolder) holder).emailListDivider.setVisibility(View.GONE);
                    }
                    LinearLayoutManager emailsLayoutManager = new LinearLayoutManager(context) {
                        @Override
                        public boolean canScrollVertically() {
                            return false;
                        }
                    };
                    emailsLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                    contactInfosViewHolder.emailList.setLayoutManager(emailsLayoutManager);
                    StudentEmailsAdapter studentEmailsAdapter = new StudentEmailsAdapter(student.getEmailList(), clickCallbackListener);
                    contactInfosViewHolder.emailList.setAdapter(studentEmailsAdapter);

                    //ADDRESS
                    if(student.getAddressList().isEmpty()) {
                        ((ContactInfosViewHolder) holder).addressListDivider.setVisibility(View.GONE);
                    }
                    LinearLayoutManager addressLayoutManager = new LinearLayoutManager(context) {
                        @Override
                        public boolean canScrollVertically() {
                            return false;
                        }
                    };
                    addressLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                    contactInfosViewHolder.addressList.setLayoutManager(addressLayoutManager);
                    StudentAddressAdapter studentAddressAdapter = new StudentAddressAdapter(student.getAddressList(), clickCallbackListener);
                    contactInfosViewHolder.addressList.setAdapter(studentAddressAdapter);
                    break;
                case CARD_ABOUT:
                    final AboutViewHolder aboutViewHolder = (AboutViewHolder) holder;
                    aboutViewHolder.title.setText(context.getString(R.string.student_details_about_title) + studentViewModel.getFullName());

                    LinearLayoutManager websiteLayoutManager = new LinearLayoutManager(context) {
                        @Override
                        public boolean canScrollVertically() {
                            return false;
                        }
                    };
                    websiteLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                    aboutViewHolder.websiteList.setLayoutManager(websiteLayoutManager);
                    StudentWebsitesAdapter studentWebsitesAdapter = new StudentWebsitesAdapter(student.getWebSites(), clickCallbackListener);
                    aboutViewHolder.websiteList.setAdapter(studentWebsitesAdapter);

                    aboutViewHolder.note.setText(student.getNotes());
                    aboutViewHolder.note.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            aboutViewHolder.note.setVisibility(View.GONE);
                            aboutViewHolder.noteEdit.setVisibility(View.VISIBLE);
                            aboutViewHolder.noteEdit.setText(aboutViewHolder.note.getText());
                            aboutViewHolder.applyButton.setVisibility(View.VISIBLE);
                            aboutViewHolder.closeButton.setVisibility(View.VISIBLE);
                            itemIsFocused = true;
                        }
                    });
                    aboutViewHolder.applyButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            aboutViewHolder.noteEdit.setVisibility(View.GONE);
                            aboutViewHolder.note.setText(aboutViewHolder.noteEdit.getText());
                            aboutViewHolder.note.setVisibility(View.VISIBLE);
                            aboutViewHolder.applyButton.setVisibility(View.GONE);
                            aboutViewHolder.closeButton.setVisibility(View.GONE);
                            itemIsFocused = false;
                        }
                    });
                    aboutViewHolder.closeButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            aboutViewHolder.noteEdit.setVisibility(View.GONE);
                            aboutViewHolder.note.setVisibility(View.VISIBLE);
                            aboutViewHolder.applyButton.setVisibility(View.GONE);
                            aboutViewHolder.closeButton.setVisibility(View.GONE);
                            itemIsFocused = false;
                        }
                    });
                    break;
                case CARD_SCHEDULES:
                    ScheduleListViewHolder scheduleListViewHolder = (ScheduleListViewHolder) holder;
                    LinearLayoutManager schedulesLayoutManager = new LinearLayoutManager(context) {
                        @Override
                        public boolean canScrollVertically() {
                            return false;
                        }
                    };
                    schedulesLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                    scheduleListViewHolder.scheduleList.setLayoutManager(schedulesLayoutManager);
                    StudentSchedulesAdapter studentSchedulesAdapter = new StudentSchedulesAdapter(student.getScheduleList());
                    scheduleListViewHolder.scheduleList.setAdapter(studentSchedulesAdapter);
                    break;
                case CARD_FILES:
                    FileListViewHolder fileListViewHolder = (FileListViewHolder) holder;
                    LinearLayoutManager filesLayoutManager = new LinearLayoutManager(context) {
                        @Override
                        public boolean canScrollVertically() {
                            return false;
                        }
                    };
                    filesLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                    fileListViewHolder.fileList.setLayoutManager(filesLayoutManager);
                    StudentFilesAdapter studentFilesAdapter = new StudentFilesAdapter(student.getFileList());
                    fileListViewHolder.fileList.setAdapter(studentFilesAdapter);
                    break;
            }
        }
    }

    @Override
    public int getItemCount() {
        return CARD_NUMBER;
    }

    public boolean isItemIsFocused() {
        return itemIsFocused;
    }

    static class TitleViewHolder extends RecyclerView.ViewHolder {
        TextView title;

        public TitleViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.item_studentdetails_title_name);
        }
    }

    static class ContactInfosViewHolder extends RecyclerView.ViewHolder {
        RecyclerView phoneNumberList;
        View emailListDivider;
        RecyclerView emailList;
        View addressListDivider;
        RecyclerView addressList;

        public ContactInfosViewHolder(View itemView) {
            super(itemView);
            phoneNumberList = (RecyclerView) itemView.findViewById(R.id.item_studentdetails_contactinfos_phonenumberlist);
            emailListDivider = itemView.findViewById(R.id.item_studentdetails_contactinfos_emaillist_divider);
            emailList = (RecyclerView) itemView.findViewById(R.id.item_studentdetails_contactinfos_emaillist);
            addressListDivider = itemView.findViewById(R.id.item_studentdetails_contactinfos_addresslist_divider);
            addressList = (RecyclerView) itemView.findViewById(R.id.item_studentdetails_contactinfos_addresslist);
        }
    }

    static class AboutViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        RecyclerView websiteList;
        TextView note;
        EditText noteEdit;
        ImageView applyButton;
        ImageView closeButton;

        public AboutViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.item_studentdetails_about_title);
            websiteList = (RecyclerView) itemView.findViewById(R.id.item_studentdetails_about_websitelist);
            note = (TextView) itemView.findViewById(R.id.item_studentdetails_about_note);
            noteEdit = (EditText) itemView.findViewById(R.id.item_studentdetails_about_note_edit);
            applyButton = (ImageView) itemView.findViewById(R.id.item_studentdetails_about_note_edit_apply_button);
            closeButton = (ImageView) itemView.findViewById(R.id.item_studentdetails_about_note_edit_close_button);
        }
    }

    static class ScheduleListViewHolder extends RecyclerView.ViewHolder {
        RecyclerView scheduleList;
        TextView moreButton;

        public ScheduleListViewHolder(View itemView) {
            super(itemView);
            scheduleList = (RecyclerView) itemView.findViewById(R.id.item_studentdetails_schedulelist_recyclerview);
            moreButton = (TextView) itemView.findViewById(R.id.item_studentdetails_schedulelist_morebutton);
        }
    }

    static class FileListViewHolder extends RecyclerView.ViewHolder {
        RecyclerView fileList;
        TextView moreButton;

        public FileListViewHolder(View itemView) {
            super(itemView);
            fileList = (RecyclerView) itemView.findViewById(R.id.item_studentdetails_filelist_recyclerview);
            moreButton = (TextView) itemView.findViewById(R.id.item_studentdetails_filelist_morebutton);
        }
    }
}
