package com.lp.iem.internshipmanager.presentation.model.student_property;

import java.util.UUID;

/**
 * Created by axellebot on 09/01/2017.
 */

public class OrganizationProperty {
    private UUID id;
    private String name;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
