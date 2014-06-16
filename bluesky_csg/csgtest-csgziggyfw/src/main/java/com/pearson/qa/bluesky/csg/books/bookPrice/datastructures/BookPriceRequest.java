package com.pearson.qa.bluesky.csg.books.bookPrice.datastructures;

import com.pearson.qa.common.ziggyfw.datastructures.IValidatable;
import com.pearson.qa.common.ziggyfw.datastructures.Validatable;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

/**
 * Created by dcorrales on 2/21/14.
 */
public class BookPriceRequest extends Validatable implements JSONAware {

    private String price;

    public BookPriceRequest(JSONObject fromJson)
    {
        this.fromJSON(fromJson);
    }

    public void fromJSON(JSONObject jsonObject) {
        setPrice((String) jsonObject.get("price").toString());
    }

    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("price", getPrice());
        return jsonObject;
    }

    @Override
    public String toJSONString() {
        return toJSON().toJSONString();
    }

    @Override
    public boolean isEmpty() {
        return
                StringUtils.isBlank(getPrice());
    }

    @Override
    public void validateEquals(IValidatable obj, boolean validateFieldsThatAreNullOnThis) throws ValidationException {
        BookPriceRequest response = (BookPriceRequest) obj;
        EqualsBuilder eb = new EqualsBuilder();
        if (validateFieldsThatAreNullOnThis || getPrice() != null) {
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
