package com.pearson.qa.bluesky.csg.collections.updatecollection.datastructures;

import org.json.simple.JSONAware;
import org.json.simple.JSONObject;
import com.pearson.qa.common.ziggyfw.datastructures.IValidatable;
import com.pearson.qa.common.ziggyfw.datastructures.Validatable;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang3.StringUtils;

public class UpdateCollectionResponsePayload extends Validatable implements JSONAware{
    private String collection;

    public void fromJSON(JSONObject jsonObject){
        setCollection((String) jsonObject.get("collection"));
    }

    public JSONObject toJSON(){
        JSONObject jsonObject = new JSONObject();

        if (getCollection()!=null)
            jsonObject.put("collection",getCollection());
        return jsonObject;
    }

    @Override
    public String toJSONString() {
        return toJSON().toJSONString();
    }


    public UpdateCollectionResponsePayload (JSONObject fromObject){
        this.fromJSON(fromObject);
    }

    @Override
    public boolean isEmpty() {
        return
                StringUtils.isBlank(getCollection())
                ;}

    @Override
    public void validateEquals(IValidatable obj, boolean validateFieldsThatAreNullOnThis) throws ValidationException {
        UpdateCollectionResponsePayload response = (UpdateCollectionResponsePayload) obj;
        EqualsBuilder eb = new EqualsBuilder();
        if (validateFieldsThatAreNullOnThis || getCollection() != null){
            eb.append(getCollection(), response.getCollection());
            if (!eb.isEquals())
                throw new ValidationException("Collection", getCollection(), response.getCollection());
        }
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public String getResult() {
        return collection;
    }

    @Override
    public void validateState() throws ValidationException {

        if(StringUtils.isBlank(getResult()))
            throw new ValidationException("Response must be returned in the result");

    }
}
