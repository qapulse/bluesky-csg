package com.pearson.qa.bluesky.csg.collections.createcollection.datastructures;

import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

/**
 * Created with IntelliJ IDEA.
 * User: dcorrales
 * Date: 2/10/14
 * Time: 3:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class CreateCollectionPayload implements JSONAware {

    private String title;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void fromJson(JSONObject jsonObject){
        setTitle((String) jsonObject.get("title"));
    }

    public JSONObject toJSON(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("title", getTitle());

        return jsonObject;
    }


    @Override
    public String toJSONString() {
        return toJSON().toJSONString();
    }
}
