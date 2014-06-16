package com.pearson.qa.bluesky.csg.user.createUserResource.datastructures;

import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

public class CreateUserResourceRequestPayload  {
    private String nativeurl;
    private String category;
    private String title;
    private String license;
    private String recordSource;
    private String folder;
    private String sharing;
    private String description;
    private String thumbnail;

    private String json;

    public void fromJSON(JSONObject jsonObject) {
        setNativeurl((String) jsonObject.get("nativeurl"));
        setCategory((String) jsonObject.get("category"));
        setTitle((String) jsonObject.get("title"));
        setLicense((String) jsonObject.get("license"));
        setRecordSource((String) jsonObject.get("recordSource"));
        setFolder((String) jsonObject.get("folder"));
        setSharing((String) jsonObject.get("sharing"));
        setDescription((String) jsonObject.get("description"));
        setThumbnail((String) jsonObject.get("thumbnail"));
    }

    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();


        return jsonObject;
    }

    public String toJSONString() {
        return getJson();
    }

    public String getNativeurl() {
        return nativeurl;
    }

    public void setNativeurl(String nativeurl) {
        this.nativeurl = nativeurl;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getRecordSource() {
        return recordSource;
    }

    public void setRecordSource(String recordSource) {
        this.recordSource = recordSource;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public String getSharing() {
        return sharing;
    }

    public void setSharing(String sharing) {
        this.sharing = sharing;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }
}