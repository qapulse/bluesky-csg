package com.pearson.qa.bluesky.csg.books.chapterPrice.datastructures;

import com.pearson.qa.common.ziggyfw.datastructures.IValidatable;
import com.pearson.qa.common.ziggyfw.datastructures.Validatable;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

/**
 * Created by Game on 2/23/14.
 */
public class ChapterPriceResponsePayload extends Validatable implements JSONAware {
    private String price;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void fromJSON(JSONObject jsonObject){
        setPrice((String) jsonObject.get("price").toString());
    }

    public JSONObject toJSON(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("price",getPrice());
        return jsonObject;
    }

    @Override
    public String toJSONString() {
        return toJSON().toJSONString();
    }


    public ChapterPriceResponsePayload(JSONObject fromObject){
        this.fromJSON(fromObject);
    }

    @Override
    public boolean isEmpty() {
        return
                StringUtils.isBlank(getPrice())
                ;}

    @Override
    public void validateEquals(IValidatable obj, boolean validateFieldsThatAreNullOnThis) throws ValidationException {
        ChapterPriceResponsePayload response = (ChapterPriceResponsePayload) obj;
        EqualsBuilder eb = new EqualsBuilder();
        if (validateFieldsThatAreNullOnThis || getPrice() != null){
            eb.append(getPrice(), response.getPrice());
            if (!eb.isEquals())
                throw new ValidationException("Price", getPrice(), response.getPrice());
        }
    }

    @Override
    public void validateState() throws ValidationException {
        if(StringUtils.isBlank(getPrice()))
            throw new ValidationException("Price must be returned in the response");
    }
}
