package com.pearson.qa.bluesky.csg.user.userResources.datastructures;

import org.json.simple.JSONAware;
import org.json.simple.JSONObject;
import com.pearson.qa.common.ziggyfw.datastructures.IValidatable;
import com.pearson.qa.common.ziggyfw.datastructures.Validatable;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang3.StringUtils;

public class UserResourcesResponsePayload extends Validatable implements JSONAware {
    private String Pending;

    public void fromJSON(JSONObject jsonObject) {
        setPending((String) jsonObject.get("Pending"));
    }

    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();

        if (getPending() != null)
            jsonObject.put("Pending", getPending());
        return jsonObject;
    }

    @Override
    public String toJSONString() {
        return toJSON().toJSONString();
    }


    public UserResourcesResponsePayload(JSONObject fromObject) {
        this.fromJSON(fromObject);
    }

    @Override
    public boolean isEmpty() {
        return
                StringUtils.isBlank(getPending())
                ;
    }

    @Override
    public void validateEquals(IValidatable obj, boolean validateFieldsThatAreNullOnThis) throws ValidationException {
        UserResourcesResponsePayload response = (UserResourcesResponsePayload) obj;
        EqualsBuilder eb = new EqualsBuilder();
        if (validateFieldsThatAreNullOnThis || getPending() != null) {
            eb.append(getPending(), response.getPending());
            if (!eb.isEquals())
                throw new ValidationException("Pending", getPending(), response.getPending());
        }
    }

    @Override
    public void validateState() throws ValidationException {

        if (StringUtils.isBlank(getPending())) {
            throw new ValidationException("Pending  must be present in the response");
        }
    }

    public String getPending() {
        return Pending;
    }

    public void setPending(String pending) {
        Pending = pending;
    }
}