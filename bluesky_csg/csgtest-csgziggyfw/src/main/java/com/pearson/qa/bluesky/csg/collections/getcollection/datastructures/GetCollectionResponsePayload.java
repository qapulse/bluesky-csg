package com.pearson.qa.bluesky.csg.collections.getcollection.datastructures;

import org.json.simple.JSONAware;
import org.json.simple.JSONObject;
import com.pearson.qa.common.ziggyfw.datastructures.IValidatable;
import com.pearson.qa.common.ziggyfw.datastructures.Validatable;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang3.StringUtils;
public class GetCollectionResponsePayload extends Validatable implements JSONAware{
    private String collectionId;
    private String title;

    public void fromJSON(JSONObject jsonObject){
        setCollection((String) jsonObject.get("collectionId"));
        setTitle(jsonObject.get("title").toString());
    }

    public JSONObject toJSON(){
        JSONObject jsonObject = new JSONObject();

        if (getCollection()!=null)
            jsonObject.put("collectionId",getCollection());
        return jsonObject;
    }

    @Override
    public String toJSONString() {
        return toJSON().toJSONString();
    }


    public GetCollectionResponsePayload (JSONObject fromObject){
        this.fromJSON(fromObject);
    }

    @Override
    public boolean isEmpty() {
        return
                StringUtils.isBlank(getCollection())
                ;}

    @Override
    public void validateEquals(IValidatable obj, boolean validateFieldsThatAreNullOnThis) throws ValidationException {
        GetCollectionResponsePayload response = (GetCollectionResponsePayload) obj;
        EqualsBuilder eb = new EqualsBuilder();
        if (validateFieldsThatAreNullOnThis || getCollection() != null){
            eb.append(getCollection(), response.getCollection());
            if (!eb.isEquals())
                throw new ValidationException("collectionId", getCollection(), response.getCollection());
        }
    }

    public String getCollection() {
        return collectionId;
    }

    public void setCollection(String collection) {
        this.collectionId = collection;
    }

    @Override
    public void validateState() throws ValidationException {

        if (StringUtils.isBlank(collectionId))
            throw new ValidationException("Collection must be returned in the response");
    }

    public String getCollectionId() {
        return collectionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}