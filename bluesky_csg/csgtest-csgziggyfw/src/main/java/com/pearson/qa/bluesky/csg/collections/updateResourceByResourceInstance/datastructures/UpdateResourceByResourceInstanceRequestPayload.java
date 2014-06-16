package com.pearson.qa.bluesky.csg.collections.updateResourceByResourceInstance.datastructures;


import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

public class UpdateResourceByResourceInstanceRequestPayload implements JSONAware {
    private String description;
    private String status;

    public void fromJSON(JSONObject jsonObject) {
        setDescription((String) jsonObject.get("description"));
        setStatus((String) jsonObject.get("status"));
    }

    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();

        if (getDescription() != null)
            jsonObject.put("description", getDescription());

        if (getStatus() != null)
            jsonObject.put("status", getStatus());
        return jsonObject;
    }

    @Override
    public String toJSONString() {
        return toJSON().toJSONString();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

