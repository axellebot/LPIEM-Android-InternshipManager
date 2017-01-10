package com.lp.iem.internshipmanager.presentation.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lp.iem.internshipmanager.R;
import com.lp.iem.internshipmanager.presentation.ui.listener.ClickCallbackListener;

import java.util.List;

/**
 * Created by romai on 09/01/2017.
 */

public class StudentAddressAdapter extends RecyclerView.Adapter<StudentAddressAdapter.AddressViewHolder> {

    private List<String> addressList;
    private ClickCallbackListener clickCallbackListener;

    public StudentAddressAdapter(List<String> addressList, ClickCallbackListener clickCallbackListener) {
        this.addressList = addressList;
        this.clickCallbackListener = clickCallbackListener;
    }

    @Override
    public AddressViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_address, parent, false);
        return new AddressViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AddressViewHolder holder, final int position) {
        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickCallbackListener.openMapAtAddress(addressList.get(position));
            }
        });
        holder.address.setText(addressList.get(position));
        holder.routeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickCallbackListener.routeToAddress(addressList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return addressList.size();
    }

    static class AddressViewHolder extends RecyclerView.ViewHolder {
        LinearLayout item;
        TextView address;
        TextView type;
        ImageView routeButton;

        public AddressViewHolder(View itemView) {
            super(itemView);
            item = (LinearLayout) itemView.findViewById(R.id.item_address_item);
            address = (TextView) itemView.findViewById(R.id.item_address_address);
            type = (TextView) itemView.findViewById(R.id.item_address_type);
            routeButton = (ImageView) itemView.findViewById(R.id.item_address_route_button);
        }
    }
}
