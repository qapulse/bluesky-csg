package com.pearson.qa.bluesky.csg.user.createUserResource.datastructures;

import org.json.simple.JSONAware;
import org.json.simple.JSONObject;
import com.pearson.qa.common.ziggyfw.datastructures.IValidatable;
import com.pearson.qa.common.ziggyfw.datastructures.Validatable;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang3.StringUtils;
public class CreateUserResourceResponsePayload extends Validatable implements JSONAware{
    private String resourceId;

    public void fromJSON(JSONObject jsonObject){
        setResourceId((String) jsonObject.get("resourceId"));
    }

    public JSONObject toJSON(){
        JSONObject jsonObject = new JSONObject();

        if (getResourceId()!=null)
            jsonObject.put("resourceId",getResourceId());
        return jsonObject;
    }

    @Override
    public String toJSONString() {
        return toJSON().toJSONString();
    }


    public CreateUserResourceResponsePayload (JSONObject fromObject){
        this.fromJSON(fromObject);
    }

    @Override
    public boolean isEmpty() {
        return
                StringUtils.isBlank(getResourceId())
                ;}

    @Override
    public void validateEquals(IValidatable obj, boolean validateFieldsThatAreNullOnThis) throws ValidationException {
        CreateUserResourceResponsePayload response = (CreateUserResourceResponsePayload) obj;
        EqualsBuilder eb = new EqualsBuilder();
        if (validateFieldsThatAreNullOnThis || getResourceId() != null){
            eb.append(getResourceId(), response.getResourceId());
            if (!eb.isEquals())
                throw new ValidationException("ResourceId", getResourceId(), response.getResourceId());
        }
    }

    @Override
    public void validateState() throws ValidationException {

        if(StringUtils.isBlank(getResourceId())){
            throw new ValidationException("ResourceId must be present in the response");
        }
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }
}