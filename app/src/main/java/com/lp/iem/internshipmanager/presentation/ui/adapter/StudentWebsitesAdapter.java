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

public class StudentWebsitesAdapter extends RecyclerView.Adapter<StudentWebsitesAdapter.WebsiteViewHolder> {

    private List<String> websiteList;

    public StudentWebsitesAdapter(List<String> websiteList) {
        this.websiteList = websiteList;
    }

    @Override
    public WebsiteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_website, parent, false);
        return new WebsiteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WebsiteViewHolder holder, int position) {
        holder.website.setText(websiteList.get(position));
    }

    @Override
    public int getItemCount() {
        return websiteList.size();
    }

    static class WebsiteViewHolder extends RecyclerView.ViewHolder {
        TextView website;
        TextView type;

        public WebsiteViewHolder(View itemView) {
            super(itemView);
            website = (TextView) itemView.findViewById(R.id.item_website_website);
            type = (TextView) itemView.findViewById(R.id.item_website_type);
        }
    }
}
