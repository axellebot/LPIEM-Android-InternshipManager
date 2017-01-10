package com.lp.iem.internshipmanager.presentation.ui.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.lp.iem.internshipmanager.R;
import com.lp.iem.internshipmanager.model.Contact;

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

    private Contact student;

    private Context context;

    public StudentDetailsAdapter(Contact student) {
        this.student = student;
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
        switch (holder.getItemViewType()) {
            case CARD_TITLE:
                TitleViewHolder titleViewHolder = (TitleViewHolder) holder;
                titleViewHolder.title.setText(student.getName());
                break;
            case CARD_CONTACT:
                ContactInfosViewHolder contactInfosViewHolder = (ContactInfosViewHolder) holder;
                // PHONES
                LinearLayoutManager phonesLayoutManager = new LinearLayoutManager(context){
                    @Override
                    public boolean canScrollVertically() {
                        return false;
                    }
                };
                phonesLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                contactInfosViewHolder.phoneNumberList.setLayoutManager(phonesLayoutManager);
                // todo get phones
                // MOCK
                List<String> phones = new ArrayList<>();
                phones.add("0678451265");
                phones.add("0678451266");
                StudentPhonesAdapter studentPhonesAdapter = new StudentPhonesAdapter(phones);
                contactInfosViewHolder.phoneNumberList.setAdapter(studentPhonesAdapter);

                //EMAILS
                LinearLayoutManager emailsLayoutManager = new LinearLayoutManager(context){
                    @Override
                    public boolean canScrollVertically() {
                        return false;
                    }
                };
                emailsLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                contactInfosViewHolder.emailList.setLayoutManager(emailsLayoutManager);
                // todo get emails
                // MOCK
                List<String> emails = new ArrayList<>();
                emails.add("exemple.1@etu.fr");
                emails.add("exemple.2@etu.fr");
                StudentEmailsAdapter studentEmailsAdapter = new StudentEmailsAdapter(emails);
                contactInfosViewHolder.emailList.setAdapter(studentEmailsAdapter);

                //ADDRESS
                LinearLayoutManager addressLayoutManager = new LinearLayoutManager(context){
                    @Override
                    public boolean canScrollVertically() {
                        return false;
                    }
                };
                addressLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                contactInfosViewHolder.addressList.setLayoutManager(addressLayoutManager);
                // todo get addresses
                // MOCK
                List<String> address = new ArrayList<>();
                address.add("21th Jump Street");
                address.add("23th Jump Street");
                StudentAddressAdapter studentAddressAdapter = new StudentAddressAdapter(address);
                contactInfosViewHolder.addressList.setAdapter(studentAddressAdapter);
                break;
            case CARD_ABOUT:
                AboutViewHolder aboutViewHolder = (AboutViewHolder) holder;
                // PHONES
                LinearLayoutManager websiteLayoutManager = new LinearLayoutManager(context){
                    @Override
                    public boolean canScrollVertically() {
                        return false;
                    }
                };
                websiteLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                aboutViewHolder.websiteList.setLayoutManager(websiteLayoutManager);
                // todo get websites
                // MOCK
                List<String> websites = new ArrayList<>();
                websites.add("exemple.com");
                websites.add("exemple.fr");
                StudentWebsitesAdapter studentWebsitesAdapter = new StudentWebsitesAdapter(websites);
                aboutViewHolder.websiteList.setAdapter(studentWebsitesAdapter);

                // todo set note
                aboutViewHolder.note.setText("CECI est une note \nblablabla");
                break;
            case CARD_SCHEDULES:

                break;
            case CARD_FILES:

                break;
        }
    }

    @Override
    public int getItemCount() {
        return CARD_NUMBER;
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
        RecyclerView emailList;
        RecyclerView addressList;

        public ContactInfosViewHolder(View itemView) {
            super(itemView);
            phoneNumberList = (RecyclerView) itemView.findViewById(R.id.item_studentdetails_contactinfos_phonenumberlist);
            emailList = (RecyclerView) itemView.findViewById(R.id.item_studentdetails_contactinfos_emaillist);
            addressList = (RecyclerView) itemView.findViewById(R.id.item_studentdetails_contactinfos_addresslist);
        }
    }

    static class AboutViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        RecyclerView websiteList;
        TextView note;

        public AboutViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.item_studentdetails_about_title);
            websiteList = (RecyclerView) itemView.findViewById(R.id.item_studentdetails_about_websitelist);
            note = (TextView) itemView.findViewById(R.id.item_studentdetails_about_note);
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
