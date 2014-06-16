package com.pearson.qa.bluesky.csg.books.updateIsbnStatus.datastructures;

/**
 * Created by didiercorrales on 3/9/14.
 */

import org.json.simple.JSONAware;
import org.json.simple.JSONObject;
public class  UpdateIsbnStatusRequestPayload implements JSONAware {
    private String isbn;
    private String status;
    private String statusModifier;

    public void fromJSON(JSONObject jsonObject){
        setIsbn((String) jsonObject.get("isbn"));
        setStatus((String) jsonObject.get("status"));
        setStatusModifier((String) jsonObject.get("statusModifier"));
    }

    public JSONObject toJSON(){
        JSONObject jsonObject = new JSONObject();

        if (getIsbn()!=null)
            jsonObject.put("isbn",getIsbn());

        if (getStatus()!=null)
            jsonObject.put("status",getStatus());

        if (getStatusModifier()!=null)
            jsonObject.put("statusModifier", getStatusModifier());
        return jsonObject;
    }

    @Override
    public String toJSONString() {
        return toJSON().toJSONString();
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusModifier() {
        return statusModifier;
    }

    public void setStatusModifier(String statusModifier) {
        this.statusModifier = statusModifier;
    }
}

