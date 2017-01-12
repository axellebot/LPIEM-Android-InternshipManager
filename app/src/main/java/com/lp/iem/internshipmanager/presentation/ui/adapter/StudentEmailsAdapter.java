package com.lp.iem.internshipmanager.presentation.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lp.iem.internshipmanager.R;
import com.lp.iem.internshipmanager.presentation.model.Email;
import com.lp.iem.internshipmanager.presentation.ui.listener.ClickCallbackListener;

import java.util.List;

/**
 * Created by romai on 09/01/2017.
 */

public class StudentEmailsAdapter extends RecyclerView.Adapter<StudentEmailsAdapter.EmailViewHolder> {

    private List<Email> emailList;
    private ClickCallbackListener clickCallbackListener;

    public StudentEmailsAdapter(List<Email> emailList, ClickCallbackListener clickCallbackListener) {
        this.emailList = emailList;
        this.clickCallbackListener = clickCallbackListener;
    }

    @Override
    public EmailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_email, parent, false);
        return new EmailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EmailViewHolder holder, final int position) {
        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickCallbackListener.sendMessageToEmail(emailList.get(position).getValue());
            }
        });
        if(position == 0) {
            holder.emailIcon.setVisibility(View.VISIBLE);
        }
        holder.email.setText(emailList.get(position).getValue());
        holder.type.setText(emailList.get(position).getLabel());
    }

    @Override
    public int getItemCount() {
        return emailList.size();
    }

    static class EmailViewHolder extends RecyclerView.ViewHolder {
        LinearLayout item;
        ImageView emailIcon;
        TextView email;
        TextView type;

        public EmailViewHolder(View itemView) {
            super(itemView);
            item = (LinearLayout) itemView.findViewById(R.id.item_email_item);
            emailIcon = (ImageView) itemView.findViewById(R.id.item_email_email_icon);
            email = (TextView) itemView.findViewById(R.id.item_email_email);
            type = (TextView) itemView.findViewById(R.id.item_email_type);
        }
    }
}
