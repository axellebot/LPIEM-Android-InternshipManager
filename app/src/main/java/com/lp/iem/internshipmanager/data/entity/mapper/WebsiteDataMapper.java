package com.lp.iem.internshipmanager.data.entity.mapper;

import com.lp.iem.internshipmanager.data.entity.WebsiteEntity;
import com.lp.iem.internshipmanager.presentation.model.student_property.Website;

import java.util.ArrayList;
import java.util.List;

public class WebsiteDataMapper {
    public List<Website> transform(List<WebsiteEntity> websiteEnityList){
        List<Website> websiteList = new ArrayList<>();
        for(WebsiteEntity websiteEntity : websiteEnityList){
            websiteList.add(transform(websiteEntity));
        }
        return websiteList;
    }

    public Website transform(WebsiteEntity websiteEntity){
        Website website = new Website();
        website.setId(websiteEntity.id);
        website.setStudentId(websiteEntity.student.id);
        return website;
    }
}
