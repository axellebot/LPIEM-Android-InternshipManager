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

public class StudentFilesAdapter extends RecyclerView.Adapter<StudentFilesAdapter.FilesViewHolder> {

    private List<String> fileList;

    public StudentFilesAdapter(List<String> fileList) {
        this.fileList = fileList;
    }

    @Override
    public FilesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_file_card, parent, false);
        return new FilesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FilesViewHolder holder, int position) {
        holder.name.setText(fileList.get(position));
    }

    @Override
    public int getItemCount() {
        return fileList.size();
    }

    static class FilesViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView description;

        public FilesViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.item_file_name);
            description = (TextView) itemView.findViewById(R.id.item_file_description);
        }
    }
}
