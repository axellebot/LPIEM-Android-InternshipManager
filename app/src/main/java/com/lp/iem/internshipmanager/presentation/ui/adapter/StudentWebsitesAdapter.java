package com.lp.iem.internshipmanager.presentation.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lp.iem.internshipmanager.R;
import com.lp.iem.internshipmanager.presentation.model.Website;
import com.lp.iem.internshipmanager.presentation.ui.listener.ClickCallbackListener;

import java.util.List;

/**
 * Created by romai on 09/01/2017.
 */

public class StudentWebsitesAdapter extends RecyclerView.Adapter<StudentWebsitesAdapter.WebsiteViewHolder> {

    private List<Website> websiteList;
    private ClickCallbackListener clickCallbackListener;

    public StudentWebsitesAdapter(List<Website> websiteList, ClickCallbackListener clickCallbackListener) {
        this.websiteList = websiteList;
        this.clickCallbackListener = clickCallbackListener;
    }

    @Override
    public WebsiteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_website, parent, false);
        return new WebsiteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WebsiteViewHolder holder, final int position) {
        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickCallbackListener.openWebsite(websiteList.get(position).getValue());
            }
        });
        holder.website.setText(websiteList.get(position).getValue());
        holder.type.setText(websiteList.get(position).getLabel());
    }

    @Override
    public int getItemCount() {
        return websiteList.size();
    }

    static class WebsiteViewHolder extends RecyclerView.ViewHolder {
        LinearLayout item;
        TextView website;
        TextView type;

        public WebsiteViewHolder(View itemView) {
            super(itemView);
            item = (LinearLayout) itemView.findViewById(R.id.item_website_item);
            website = (TextView) itemView.findViewById(R.id.item_website_website);
            type = (TextView) itemView.findViewById(R.id.item_website_type);
        }
    }
}
