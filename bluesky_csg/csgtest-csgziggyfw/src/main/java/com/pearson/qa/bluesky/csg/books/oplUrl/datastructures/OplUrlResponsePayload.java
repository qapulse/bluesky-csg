package com.pearson.qa.bluesky.csg.books.oplUrl.datastructures;

/**
 * Created by didiercorrales on 3/9/14.
 */

import org.json.simple.JSONAware;
import org.json.simple.JSONObject;
import com.pearson.qa.common.ziggyfw.datastructures.IValidatable;
import com.pearson.qa.common.ziggyfw.datastructures.Validatable;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang3.StringUtils;

public class OplUrlResponsePayload extends Validatable implements JSONAware {
    private String url;

    public void fromJSON(JSONObject jsonObject) {
        setUrl((String) jsonObject.get("url"));
    }

    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();

        if (getUrl() != null)
            jsonObject.put("url", getUrl());
        return jsonObject;
    }

    @Override
    public String toJSONString() {
        return toJSON().toJSONString();
    }


    public OplUrlResponsePayload(JSONObject fromObject) {
        this.fromJSON(fromObject);
    }

    @Override
    public boolean isEmpty() {
        return
                StringUtils.isBlank(getUrl())
                ;
    }

    @Override
    public void validateEquals(IValidatable obj, boolean validateFieldsThatAreNullOnThis) throws ValidationException {
        OplUrlResponsePayload response = (OplUrlResponsePayload) obj;
        EqualsBuilder eb = new EqualsBuilder();
        if (validateFieldsThatAreNullOnThis || getUrl() != null) {
            eb.append(getUrl(), response.getUrl());
            if (!eb.isEquals())
                throw new ValidationException("Url", getUrl(), response.getUrl());
        }
    }

    @Override
    public void validateState() throws ValidationException {
        if (StringUtils.isBlank(getUrl()))
            throw new ValidationException("URL must be returned in the response");

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
