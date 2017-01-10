package com.lp.iem.internshipmanager.data.entity.mapper;

import com.lp.iem.internshipmanager.data.entity.AddressEntity;
import com.lp.iem.internshipmanager.presentation.model.Address;

import java.util.ArrayList;
import java.util.List;

public class AddressDataMapper {
    public List<Address> transform(List<AddressEntity> addressEntities){
        List<Address> addressList = new ArrayList<>();
        for(AddressEntity addressEntity : addressEntities){
            addressList.add(transform(addressEntity));
        }
        return addressList;
    }
    public Address transform(AddressEntity addressEntity){
        Address address = new Address();
        address.setId(addressEntity.id);
        address.setLabel(addressEntity.label);
        address.setValue(addressEntity.value);
        address.setStudentId(addressEntity.student.id);
        return address;
    }
}
