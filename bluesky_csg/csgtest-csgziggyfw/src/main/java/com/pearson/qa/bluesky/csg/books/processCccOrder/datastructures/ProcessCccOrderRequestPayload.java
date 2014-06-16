package com.pearson.qa.bluesky.csg.books.processCccOrder.datastructures;

/**
 * Created by didiercorrales on 3/9/14.
 */

import org.codehaus.jettison.json.JSONArray;
import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

public class ProcessCccOrderRequestPayload implements JSONAware {
    private String bookBuildContentId;
    private String issns;
    private String productType;
    private String userInformation;

    public void fromJSON(JSONObject jsonObject) {
        setBookBuildContentId((String) jsonObject.get("bookBuildContentId"));
        setIssns((String) jsonObject.get("issns"));
        setProductType((String) jsonObject.get("productType"));
        setUserInformation((String) jsonObject.get("userInformation"));
    }

    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();

        if (getBookBuildContentId() != null)
            jsonObject.put("bookBuildContentId", getBookBuildContentId());

        if (getIssns() != null && setIsbns() != null) {

            jsonObject.put("issns", setIsbns());
        }
        if (getProductType() != null)
            jsonObject.put("productType", getProductType());

        if (getUserInformation() != null)
            jsonObject.put("userInformation", getUserInformation());
        return jsonObject;
    }

    @Override
    public String toJSONString() {
        return toJSON().toJSONString();
    }

    public String getBookBuildContentId() {
        return bookBuildContentId;
    }

    public void setBookBuildContentId(String bookBuildContentId) {
        this.bookBuildContentId = bookBuildContentId;
    }

    public String getIssns() {
        return issns;
    }

    public void setIssns(String issns) {
        this.issns = issns;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getUserInformation() {
        return userInformation;
    }

    public void setUserInformation(String userInformation) {
        this.userInformation = userInformation;
    }

    public JSONArray setIsbns() {

        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(getIssns().toString());
        } catch (Exception e) {
        }
        return jsonArray;
    }
}
