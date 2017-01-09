package com.lp.iem.internshipmanager.model;

import java.net.URI;


public class File extends java.io.File {

    private String fileName;
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
        String[] listOfValues = pathname.split("/");
        this.fileName = listOfValues[listOfValues.length - 1];
    }

    /**
     *
     * @param uri
     */
    public File(URI uri) {
        super(uri);
        String[] listOfValues = uri.getPath().split("/");
        this.fileName = listOfValues[listOfValues.length - 1];
    }
}
