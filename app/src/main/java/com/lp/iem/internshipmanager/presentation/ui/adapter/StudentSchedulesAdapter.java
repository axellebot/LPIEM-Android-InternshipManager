package com.lp.iem.internshipmanager.presentation.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lp.iem.internshipmanager.R;
import com.lp.iem.internshipmanager.presentation.model.Schedule;

import java.util.List;

/**
 * Created by romai on 09/01/2017.
 */

public class StudentSchedulesAdapter extends RecyclerView.Adapter<StudentSchedulesAdapter.ScheduleViewHolder> {

    private List<Schedule> scheduleList;

    public StudentSchedulesAdapter(List<Schedule> scheduleList) {
        this.scheduleList = scheduleList;
    }

    @Override
    public ScheduleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_schedule_card, parent, false);
        return new ScheduleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ScheduleViewHolder holder, int position) {
        holder.date.setText(scheduleList.get(position).getLabel());
        holder.description.setText(scheduleList.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return scheduleList.size();
    }

    static class ScheduleViewHolder extends RecyclerView.ViewHolder {
        TextView date;
        TextView description;

        public ScheduleViewHolder(View itemView) {
            super(itemView);
            date = (TextView) itemView.findViewById(R.id.item_schedule_date);
            description = (TextView) itemView.findViewById(R.id.item_schedule_description);
        }
    }
}
