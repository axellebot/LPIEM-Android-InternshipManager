package com.lp.iem.internshipmanager.presentation.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lp.iem.internshipmanager.R;

import java.util.List;

/**
 * Created by romai on 09/01/2017.
 */

public class StudentEmailsAdapter extends RecyclerView.Adapter<StudentEmailsAdapter.EmailViewHolder> {

    private List<String> emailList;

    public StudentEmailsAdapter(List<String> emailList) {
        this.emailList = emailList;
    }

    @Override
    public EmailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_email, parent, false);
        return new EmailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EmailViewHolder holder, int position) {
        holder.email.setText(emailList.get(position));
    }

    @Override
    public int getItemCount() {
        return emailList.size();
    }

    static class EmailViewHolder extends RecyclerView.ViewHolder {
        TextView email;
        TextView type;

        public EmailViewHolder(View itemView) {
            super(itemView);
            email = (TextView) itemView.findViewById(R.id.item_email_email);
            type = (TextView) itemView.findViewById(R.id.item_email_type);
        }
    }
}
