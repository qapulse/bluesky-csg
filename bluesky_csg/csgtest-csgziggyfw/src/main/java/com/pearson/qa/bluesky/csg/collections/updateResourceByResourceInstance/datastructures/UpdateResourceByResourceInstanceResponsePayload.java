package com.pearson.qa.bluesky.csg.collections.updateResourceByResourceInstance.datastructures;


import org.json.simple.JSONAware;
import org.json.simple.JSONObject;
import com.pearson.qa.common.ziggyfw.datastructures.IValidatable;
import com.pearson.qa.common.ziggyfw.datastructures.Validatable;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang3.StringUtils;

public class UpdateResourceByResourceInstanceResponsePayload extends Validatable implements JSONAware {
    private String resourceId;
    private String description;
    private String status;

    public void fromJSON(JSONObject jsonObject) {
        setResourceId((String) jsonObject.get("resourceId"));
        setDescription((String) jsonObject.get("description"));
        setStatus((String) jsonObject.get("status"));
    }

    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();

        if (getResourceId() != null)
            jsonObject.put("resourceId", getResourceId());

        if (getDescription() != null)
            jsonObject.put("description", getDescription());

        if (getStatus() != null)
            jsonObject.put("status", getStatus());
        return jsonObject;
    }

    @Override
    public String toJSONString() {
        return toJSON().toJSONString();
    }


    public UpdateResourceByResourceInstanceResponsePayload(JSONObject fromObject) {
        this.fromJSON(fromObject);
    }

    @Override
    public boolean isEmpty() {
        return
                StringUtils.isBlank(getResourceId())
                        && StringUtils.isBlank(getDescription())
                        && StringUtils.isBlank(getStatus())
                ;
    }

    @Override
    public void validateEquals(IValidatable obj, boolean validateFieldsThatAreNullOnThis) throws ValidationException {
        UpdateResourceByResourceInstanceResponsePayload response = (UpdateResourceByResourceInstanceResponsePayload) obj;
        EqualsBuilder eb = new EqualsBuilder();
        if (validateFieldsThatAreNullOnThis || getResourceId() != null) {
            eb.append(getResourceId(), response.getResourceId());
            if (!eb.isEquals())
                throw new ValidationException("ResourceId", getResourceId(), response.getResourceId());
        }
        if (validateFieldsThatAreNullOnThis || getDescription() != null) {
            eb.append(getDescription(), response.getDescription());
            if (!eb.isEquals())
                throw new ValidationException("Description", getDescription(), response.getDescription());
        }
        if (validateFieldsThatAreNullOnThis || getStatus() != null) {
            eb.append(getStatus(), response.getStatus());
            if (!eb.isEquals())
                throw new ValidationException("Status", getStatus(), response.getStatus());
        }
    }

    @Override
    public void validateState() throws ValidationException {

        if (StringUtils.isBlank(getResourceId())) {
            throw new ValidationException("Resource ID must be present in the response");
        }

        if (StringUtils.isBlank(getDescription())) {
            throw new ValidationException("Description must be present in the response");
        }
        if (StringUtils.isBlank(getStatus())) {
            throw new ValidationException("status must be present in the response");
        }

    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
