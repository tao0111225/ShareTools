package com.shareTools.entity;

import java.util.ArrayList;
import java.util.List;

public class TreeEntity {

    private boolean isFolder;

    private String  name;

    private String href;

    private String fname;

    private long Fid;

    private long id;

    private List<TreeEntity> childList = new ArrayList<TreeEntity>();

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

    public  void addNode(TreeEntity childNode){
        childList.add(childNode);
    }

    public long getNodeSize(){
        return childList.size();
    }

    public List<TreeEntity> getChildList() {
        return childList;
    }

    public void setChildList(List<TreeEntity> childList) {
        this.childList = childList;
    }
}
