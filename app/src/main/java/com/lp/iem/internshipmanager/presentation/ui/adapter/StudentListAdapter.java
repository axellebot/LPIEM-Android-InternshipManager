package com.lp.iem.internshipmanager.presentation.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lp.iem.internshipmanager.R;
import com.lp.iem.internshipmanager.presentation.model.Student;
import com.lp.iem.internshipmanager.presentation.ui.viewmodel.StudentViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by romai on 09/01/2017.
 */

public class StudentListAdapter extends RecyclerView.Adapter<StudentListAdapter.StudentViewHolder> {

    private List<Student> studentList;
    private ClickListener clickListener;;

    public StudentListAdapter(List<Student> studentList) {
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
    public void onBindViewHolder(final StudentViewHolder holder, final int position) {
        StudentViewModel studentViewModel = new StudentViewModel(studentList.get(position));
        holder.studentName.setText(studentViewModel.getFullName());
        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(clickListener != null) {
                    clickListener.ItemClicked(view, position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setFilteredList(List<Student> countryModels) {
        studentList = new ArrayList<>();
        studentList.addAll(countryModels);
        notifyDataSetChanged();
    }

    static class StudentViewHolder extends RecyclerView.ViewHolder {
        LinearLayout item;
        TextView studentName;

        public StudentViewHolder(View itemView) {
            super(itemView);
            item = (LinearLayout) itemView.findViewById(R.id.item_student_list_student_item);
            studentName = (TextView) itemView.findViewById(R.id.item_student_list_student_name);
        }
    }

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public interface ClickListener {
        void ItemClicked(View v, int position);
    }
}
