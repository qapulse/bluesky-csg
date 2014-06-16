package com.pearson.qa.bluesky.csg.collections.resourcescollection.datastructures;

import com.pearson.qa.common.ziggyfw.datastructures.IValidatable;
import com.pearson.qa.common.ziggyfw.datastructures.Validatable;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

/**
 * Created by brian on 2/26/14.
 */
public class ResourcesByCollectionResponse extends Validatable implements JSONAware {

    private String collectionId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String title;

    public ResourcesByCollectionResponse(JSONObject fromJson)
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

        ResourcesByCollectionResponse response = (ResourcesByCollectionResponse) obj;
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

        setCollectionId((String) jsonObject.get("collectionId").toString());
        setTitle(jsonObject.get("title").toString());
    }

    public JSONObject toJSON(){
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("collectionId",getCollectionId());

        return jsonObject;
    }

}
