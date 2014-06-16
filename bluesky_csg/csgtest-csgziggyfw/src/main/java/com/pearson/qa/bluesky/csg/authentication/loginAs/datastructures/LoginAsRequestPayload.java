package com.pearson.qa.bluesky.csg.authentication.loginAs.datastructures;

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

public class LoginAsRequestPayload extends Validatable implements JSONAware {
    private String collectionId;

    public void fromJSON(JSONObject jsonObject) {
        setCollectionId((String) jsonObject.get("collectionId"));
    }

    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();

        if (getCollectionId() != null)
            jsonObject.put("collectionId", getCollectionId());
        return jsonObject;
    }

    @Override
    public String toJSONString() {
        return toJSON().toJSONString();
    }

    @Override
    public boolean isEmpty() {
        return
                StringUtils.isBlank(getCollectionId())
                ;
    }

    @Override
    public void validateEquals(IValidatable obj, boolean validateFieldsThatAreNullOnThis) throws ValidationException {
        LoginAsRequestPayload response = (LoginAsRequestPayload) obj;
        EqualsBuilder eb = new EqualsBuilder();
        if (validateFieldsThatAreNullOnThis || getCollectionId() != null) {
            eb.append(getCollectionId(), response.getCollectionId());
            if (!eb.isEquals())
                throw new ValidationException("CollectionId", getCollectionId(), response.getCollectionId());
        }
    }

    @Override
    public void validateState() throws ValidationException {

//*********************//////////////////////**********************//
        // TODO   ADD YOR CODE HERE
//*********************//////////////////////**********************//

    }

    public String getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(String collectionId) {
        this.collectionId = collectionId;
    }
}
