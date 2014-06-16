package com.pearson.qa.bluesky.csg.books.bookPrice.datastructures;

import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

/**
 * Created by dcorrales on 2/21/14.
 */
public class BookPricePayload  implements JSONAware {

    private String bookPrice;

    public void fromJson(JSONObject jsonObject){
        setBookPrice((String) jsonObject.get("bookPrice"));
    }

    public JSONObject toJSON(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("bookPrice",getBookPrice());
        return jsonObject;
    }

    @Override
    public String toJSONString() {
        return toJSON().toJSONString();
    }

    public String getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(String bookPrice) {
        this.bookPrice = bookPrice;
    }
}
