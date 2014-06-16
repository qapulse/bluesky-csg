package com.pearson.qa.bluesky.csg.books.approveISBNs.datastructures;

/**
 * Created by didiercorrales on 3/9/14.
 */

import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

public class ApproveISBNRequestPayload implements JSONAware {
    private String approvedISBNsXML;

    public void fromJSON(JSONObject jsonObject) {
        setApprovedISBNsXML((String) jsonObject.get("approvedISBNsXML"));
    }

    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();

        if (getApprovedISBNsXML() != null)
            jsonObject.put("approvedISBNsXML", getApprovedISBNsXML().replace("/",""));
        return jsonObject;
    }

    @Override
    public String toJSONString() {
        return toJSON().toJSONString();
    }

    public String getApprovedISBNsXML() {
        return approvedISBNsXML;
    }

    public void setApprovedISBNsXML(String approvedISBNsXML) {
        this.approvedISBNsXML = approvedISBNsXML;
    }
}