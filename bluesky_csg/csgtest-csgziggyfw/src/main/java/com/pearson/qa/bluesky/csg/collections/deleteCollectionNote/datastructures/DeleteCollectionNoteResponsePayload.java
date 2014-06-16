package com.pearson.qa.bluesky.csg.collections.deleteCollectionNote.datastructures;

import org.json.simple.JSONAware;
import org.json.simple.JSONObject;
import com.pearson.qa.common.ziggyfw.datastructures.IValidatable;
import com.pearson.qa.common.ziggyfw.datastructures.Validatable;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang3.StringUtils;

public class DeleteCollectionNoteResponsePayload extends Validatable implements JSONAware {
    private String response;

    public void fromJSON(JSONObject jsonObject) {
        setResponse((String) jsonObject.get("response"));
    }

    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();

        if (getResponse() != null)
            jsonObject.put("response", getResponse());
        return jsonObject;
    }

    @Override
    public String toJSONString() {
        return toJSON().toJSONString();
    }


    public DeleteCollectionNoteResponsePayload(JSONObject fromObject) {
        this.fromJSON(fromObject);
    }

    @Override
    public boolean isEmpty() {
        return
                StringUtils.isBlank(getResponse())
                ;
    }

    @Override
    public void validateEquals(IValidatable obj, boolean validateFieldsThatAreNullOnThis) throws ValidationException {
        DeleteCollectionNoteResponsePayload response = (DeleteCollectionNoteResponsePayload) obj;
        EqualsBuilder eb = new EqualsBuilder();
        if (validateFieldsThatAreNullOnThis || getResponse() != null) {
            eb.append(getResponse(), response.getResponse());
            if (!eb.isEquals())
                throw new ValidationException("Response", getResponse(), response.getResponse());
        }
    }

    @Override
    public void validateState() throws ValidationException {

        if (StringUtils.isBlank(getResponse())) {
            throw new ValidationException("Response must be present in the response");
        }
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}