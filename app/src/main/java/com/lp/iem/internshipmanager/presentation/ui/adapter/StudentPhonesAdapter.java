package com.lp.iem.internshipmanager.presentation.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lp.iem.internshipmanager.R;
import com.lp.iem.internshipmanager.model.Contact;

import java.util.List;

/**
 * Created by romai on 09/01/2017.
 */

public class StudentPhonesAdapter extends RecyclerView.Adapter<StudentPhonesAdapter.PhoneViewHolder> {

    private List<String> phoneList;

    public StudentPhonesAdapter(List<String> phoneList) {
        this.phoneList = phoneList;
    }

    @Override
    public StudentPhonesAdapter.PhoneViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_phonenumber, parent, false);
        return new PhoneViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StudentPhonesAdapter.PhoneViewHolder holder, int position) {
        holder.phone.setText(phoneList.get(position));
    }

    @Override
    public int getItemCount() {
        return phoneList.size();
    }

    static class PhoneViewHolder extends RecyclerView.ViewHolder {
        TextView phone;
        TextView type;

        public PhoneViewHolder(View itemView) {
            super(itemView);
            phone = (TextView) itemView.findViewById(R.id.item_phonenumber_number);
            type = (TextView) itemView.findViewById(R.id.item_phonenumber_type);
        }
    }
}
