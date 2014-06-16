package com.pearson.qa.bluesky.csg.books.bookBuild.datastructures;

/**
 * Created by dcorrales on 2/27/14.
 */

import org.json.simple.JSONAware;
import org.json.simple.JSONObject;
import com.pearson.qa.common.ziggyfw.datastructures.IValidatable;
import com.pearson.qa.common.ziggyfw.datastructures.Validatable;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang3.StringUtils;

public class BookBuildResponsePayload extends Validatable implements JSONAware {
    private String status;
    private String xml;

    public void fromJSON(JSONObject jsonObject) {
        setStatus((String) jsonObject.get("status").toString());
        setXml((String) jsonObject.get("xml").toString());
    }

    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();

        if (getStatus() != null)
            jsonObject.put("status", getStatus());

        if (getXml() != null)
            jsonObject.put("xml", getXml());
        return jsonObject;
    }

    @Override
    public String toJSONString() {
        return toJSON().toJSONString();
    }


    public BookBuildResponsePayload(JSONObject fromObject) {
        this.fromJSON(fromObject);
    }

    @Override
    public boolean isEmpty() {
        return
                StringUtils.isBlank(getStatus())
                        && StringUtils.isBlank(getXml())
                ;
    }

    @Override
    public void validateEquals(IValidatable obj, boolean validateFieldsThatAreNullOnThis) throws ValidationException {
        BookBuildResponsePayload response = (BookBuildResponsePayload) obj;
        EqualsBuilder eb = new EqualsBuilder();
        if (validateFieldsThatAreNullOnThis || getStatus() != null) {
            eb.append(getStatus(), response.getStatus());
            if (!eb.isEquals())
                throw new ValidationException("Status", getStatus(), response.getStatus());
        }
        if (validateFieldsThatAreNullOnThis || getXml() != null) {
            eb.append(getXml(), response.getXml());
            if (!eb.isEquals())
                throw new ValidationException("Xml", getXml(), response.getXml());
        }
    }

    @Override
    public void validateState() throws ValidationException {

//*********************//////////////////////**********************//
        // TODO     ADD YOR CODE HERE
//*********************//////////////////////**********************//

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getXml() {
        return xml;
    }

    public void setXml(String xml) {
        this.xml = xml;
    }
}
