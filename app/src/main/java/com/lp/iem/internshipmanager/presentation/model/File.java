package com.lp.iem.internshipmanager.presentation.model;

import java.net.URI;
import java.util.UUID;


public class File extends java.io.File {
    private UUID id;
    private String description;

    /**
     *
     * @param pathname
     * @param description
     */
    public File(String pathname, String description) {
        this(pathname);
        this.description = description;
    }

    /**
     *
     * @param uri
     * @param description
     */
    public File(URI uri, String description) {
        this(uri);
        this.description = description;
    }

    /**
     *
     * @param pathname
     */
    public File(String pathname) {
        super(pathname);
    }

    /**
     *
     * @param uri
     */
    public File(URI uri) {
        super(uri);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
