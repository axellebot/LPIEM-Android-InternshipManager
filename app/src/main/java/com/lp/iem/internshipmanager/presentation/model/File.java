package com.lp.iem.internshipmanager.presentation.model;

import java.net.URI;
import java.util.UUID;


public class File extends java.io.File {
    private String id;
    private String description;
    private String studentId;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}
