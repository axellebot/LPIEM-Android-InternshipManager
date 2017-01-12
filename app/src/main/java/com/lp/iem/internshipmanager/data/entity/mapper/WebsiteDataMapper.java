package com.lp.iem.internshipmanager.data.entity.mapper;

import com.lp.iem.internshipmanager.data.entity.WebsiteEntity;
import com.lp.iem.internshipmanager.presentation.model.Website;

import java.util.ArrayList;
import java.util.List;

public class WebsiteDataMapper {
    public List<Website> transform(List<WebsiteEntity> websiteEntityList) {
        List<Website> websiteList = new ArrayList<>();
        for (WebsiteEntity websiteEntity : websiteEntityList) {
            websiteList.add(transform(websiteEntity));
        }
        return websiteList;
    }

    public Website transform(WebsiteEntity websiteEntity) {
        Website website = new Website();
        website.setId(websiteEntity.id);
        website.setStudentId(websiteEntity.student.id);
        return website;
    }

    /**
     * Does not take into account the relationships
     */
    public List<WebsiteEntity> transformReverse(List<Website> websiteList) {
        List<WebsiteEntity> websiteEntityList = new ArrayList<>();
        for (Website website : websiteList) {
            websiteEntityList.add(transformReverse(website));
        }
        return websiteEntityList;
    }

    /**
     * Does not take into account the relationships
     */
    public WebsiteEntity transformReverse(Website website) {
        WebsiteEntity websiteEntity = new WebsiteEntity();
        websiteEntity.id = website.getId();
        websiteEntity.label = website.getLabel();
        websiteEntity.value = website.getValue();
        return websiteEntity;
    }
}
