package com.lp.iem.internshipmanager.presentation.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lp.iem.internshipmanager.R;
import com.lp.iem.internshipmanager.model.Contact;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by romai on 09/01/2017.
 */

public class StudentListAdapter extends RecyclerView.Adapter<StudentListAdapter.StudentViewHolder> {

    private List<Contact> studentList;

    public StudentListAdapter(List<Contact> studentList) {
        this.studentList = studentList;
    }

    @Override
    public StudentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_student_list, parent, false);
        StudentViewHolder studentViewHolder = new StudentViewHolder(view);
        return studentViewHolder;
    }

    @Override
    public void onBindViewHolder(final StudentViewHolder holder, int position) {
        holder.studentName.setText(studentList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public List<Contact> getStudentList() {
        return studentList;
    }

    public void setFilteredList(List<Contact> countryModels) {
        studentList = new ArrayList<>();
        studentList.addAll(countryModels);
        notifyDataSetChanged();
    }

    static class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView studentName;

        public StudentViewHolder(View itemView) {
            super(itemView);
            studentName = (TextView) itemView.findViewById(R.id.item_student_list_student_name);
        }
    }
}
