package com.shareTools.entity;

public class BookMarkTreeEntity {

    private boolean isFolder;

    private String  name;

    private String fname;

    private String href;

    private long Fid;

    private long id;

    public boolean isFolder() {
        return isFolder;
    }

    public void setFolder(boolean folder) {
        isFolder = folder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public long getFid() {
        return Fid;
    }

    public void setFid(long fid) {
        Fid = fid;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
