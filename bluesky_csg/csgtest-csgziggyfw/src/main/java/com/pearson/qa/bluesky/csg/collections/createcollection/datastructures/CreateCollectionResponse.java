package com.pearson.qa.bluesky.csg.collections.createcollection.datastructures;

import com.pearson.qa.common.ziggyfw.datastructures.IValidatable;
import com.pearson.qa.common.ziggyfw.datastructures.Validatable;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

/**
 * Created with IntelliJ IDEA.
 * User: dcorrales
 * Date: 2/10/14
 * Time: 3:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class CreateCollectionResponse extends Validatable implements JSONAware {

    private String collectionId;

    public CreateCollectionResponse(JSONObject fromJson)
    {
        this.fromJSON(fromJson);
    }

    public String getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(String collectionId) {
        this.collectionId = collectionId;
    }
    @Override
    public String toJSONString() {
        return toJSON().toJSONString();
    }

    @Override
    public boolean isEmpty() {
        return StringUtils.isBlank(getCollectionId());
    }

    @Override
    public void validateEquals(IValidatable obj, boolean validateFieldsThatAreNullOnThis) throws ValidationException {

        CreateCollectionResponse response = (CreateCollectionResponse) obj;
        EqualsBuilder eb = new EqualsBuilder();

        if (validateFieldsThatAreNullOnThis || getCollectionId() != null)
        {
            eb.append(getCollectionId(), response.getCollectionId());
            if (!eb.isEquals())
                throw new ValidationException("collectionId", getCollectionId(), response.getCollectionId());
        }
    }

    @Override
    public void validateState() throws ValidationException {

        if (StringUtils.isBlank(getCollectionId()))
            throw new ValidationException("Collection Id must be returned in the response");
    }

    public void fromJSON(JSONObject jsonObject){

        setCollectionId((String) jsonObject.get("collectionId"));
    }

    public JSONObject toJSON(){
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("collectionId",getCollectionId());

        return jsonObject;
    }
}
