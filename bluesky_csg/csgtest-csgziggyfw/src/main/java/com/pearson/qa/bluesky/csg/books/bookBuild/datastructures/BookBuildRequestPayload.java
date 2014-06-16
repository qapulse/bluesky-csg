package com.pearson.qa.bluesky.csg.books.bookBuild.datastructures;

import org.codehaus.jettison.json.JSONObject;

/**
 * Created by dcorrales on 2/27/14.
 */




public class BookBuildRequestPayload {
    private String TitleDetails;

    public void fromJSON(JSONObject jsonObject) throws Exception{
        setTitleDetails((String) jsonObject.get("TitleDetails"));
    }



    public String toJSONString() throws Exception {


        return getTitleDetails();
    }

    public String getTitleDetails() {
        return TitleDetails;
    }

    public void setTitleDetails(String titleDetails) {
        TitleDetails = titleDetails;
    }
}
