package com.lp.iem.internshipmanager.presentation.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lp.iem.internshipmanager.R;
import com.lp.iem.internshipmanager.model.Contact;
import com.lp.iem.internshipmanager.presentation.ui.listener.ClickCallbackListener;

import java.util.List;

/**
 * Created by romai on 09/01/2017.
 */

public class StudentPhonesAdapter extends RecyclerView.Adapter<StudentPhonesAdapter.PhoneViewHolder> {

    private List<String> phoneList;
    private ClickCallbackListener clickCallbackListener;

    public StudentPhonesAdapter(List<String> phoneList, ClickCallbackListener clickCallbackListener) {
        this.phoneList = phoneList;
        this.clickCallbackListener = clickCallbackListener;
    }

    @Override
    public StudentPhonesAdapter.PhoneViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_phonenumber, parent, false);
        return new PhoneViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StudentPhonesAdapter.PhoneViewHolder holder, final int position) {
        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickCallbackListener.callPhoneNumber(phoneList.get(position));
            }
        });
        holder.phone.setText(phoneList.get(position));
        holder.messageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickCallbackListener.sendMessageToPhoneNumber(phoneList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return phoneList.size();
    }

    static class PhoneViewHolder extends RecyclerView.ViewHolder {
        LinearLayout item;
        TextView phone;
        TextView type;
        ImageView messageButton;

        public PhoneViewHolder(View itemView) {
            super(itemView);
            item = (LinearLayout) itemView.findViewById(R.id.item_phonenumber_item);
            phone = (TextView) itemView.findViewById(R.id.item_phonenumber_number);
            type = (TextView) itemView.findViewById(R.id.item_phonenumber_type);
            messageButton = (ImageView) itemView.findViewById(R.id.item_phonenumber_message_button);
        }
    }
}
