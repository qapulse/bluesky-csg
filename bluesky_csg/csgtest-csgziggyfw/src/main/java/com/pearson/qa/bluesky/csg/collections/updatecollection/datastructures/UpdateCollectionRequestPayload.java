package com.pearson.qa.bluesky.csg.collections.updatecollection.datastructures;

import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

public class  UpdateCollectionRequestPayload implements JSONAware {
    private String description;

    public void fromJSON(JSONObject jsonObject){
        setCollectionId((String) jsonObject.get("description"));
    }

    public JSONObject toJSON(){
        JSONObject jsonObject = new JSONObject();

        if (getCollectionId()!=null)
            jsonObject.put("description",getCollectionId());
        return jsonObject;
    }

    @Override
    public String toJSONString() {
        return toJSON().toJSONString();
    }

    public String getCollectionId() {
        return description;
    }

    public String getResult() {
        return description;
    }

    public void setStatus(String description) {
        this.description = description;
    }

    public void setCollectionId(String description) {
        this.description = description;
    }
}
