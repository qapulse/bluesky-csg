package com.pearson.qa.bluesky.csg.books.updateBookBuild.datastructures;

/**
 * Created by didiercorrales on 3/9/14.
 */

import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

public class UpdateBookBuildRequestPayload implements JSONAware {
    private String bookBuildId;
    private String moduleId;
    private String productId;

    public void fromJSON(JSONObject jsonObject) {
        setBookBuildId((String) jsonObject.get("bookBuildId"));
        setModuleId((String) jsonObject.get("moduleId"));
        setProductId((String) jsonObject.get("productId"));
    }

    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();

        if (getBookBuildId() != null)
            jsonObject.put("bookBuildId", getBookBuildId());

        if (getModuleId() != null)
            jsonObject.put("moduleId", getModuleId());

        if (getProductId() != null)
            jsonObject.put("productId", getProductId());
        return jsonObject;
    }

    @Override
    public String toJSONString() {
        return toJSON().toJSONString();
    }

    public String getBookBuildId() {
        return bookBuildId;
    }

    public void setBookBuildId(String bookBuildId) {
        this.bookBuildId = bookBuildId;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}