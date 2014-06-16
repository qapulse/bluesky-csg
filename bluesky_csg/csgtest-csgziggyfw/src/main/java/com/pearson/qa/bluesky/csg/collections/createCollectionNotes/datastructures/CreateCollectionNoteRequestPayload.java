package com.pearson.qa.bluesky.csg.collections.createCollectionNotes.datastructures;

import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

public class CreateCollectionNoteRequestPayload implements JSONAware {
    private String body;
    private String resourceTitle;

    public void fromJSON(JSONObject jsonObject) {
        setBody((String) jsonObject.get("body"));
        setResourceTitle((String) jsonObject.get("resourceTitle"));
    }

    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();

        if (getBody() != null)
            jsonObject.put("body", getBody());

        if (getResourceTitle() != null)
            jsonObject.put("resourceTitle", getResourceTitle());
        return jsonObject;
    }

    @Override
    public String toJSONString() {
        return toJSON().toJSONString();
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getResourceTitle() {
        return resourceTitle;
    }

    public void setResourceTitle(String resourceTitle) {
        this.resourceTitle = resourceTitle;
    }
}

