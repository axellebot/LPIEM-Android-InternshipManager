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

public class StudentAddressAdapter extends RecyclerView.Adapter<StudentAddressAdapter.AddressViewHolder> {

    private List<String> addressList;

    public StudentAddressAdapter(List<String> addressList) {
        this.addressList = addressList;
    }

    @Override
    public AddressViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_address, parent, false);
        return new AddressViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AddressViewHolder holder, int position) {
        holder.address.setText(addressList.get(position));
    }

    @Override
    public int getItemCount() {
        return addressList.size();
    }

    static class AddressViewHolder extends RecyclerView.ViewHolder {
        TextView address;
        TextView type;

        public AddressViewHolder(View itemView) {
            super(itemView);
            address = (TextView) itemView.findViewById(R.id.item_address_address);
            type = (TextView) itemView.findViewById(R.id.item_address_type);
        }
    }
}
