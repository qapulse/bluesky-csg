package com.pearson.qa.bluesky.csg.collections.resourcescollection.datastructures;

import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

/**
 * Created by brian on 2/26/14.
 */
public class ResourcesByCollectionPayload implements JSONAware {

    private String collectionid;

    public void fromJson(JSONObject jsonObject){
        setCollectionid((String) jsonObject.get("collectionid"));
    }

    public JSONObject toJSON(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("collectionid", getCollectionid());

        return jsonObject;
    }


    @Override
    public String toJSONString() {
        return toJSON().toJSONString();
    }

    public String getCollectionid() {
        return collectionid;
    }

    public void setCollectionid(String collectionid) {
        this.collectionid = collectionid;
    }
}


