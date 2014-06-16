package com.pearson.qa.bluesky.csg.collections.getCollectionNote.datastructures;

import org.json.simple.JSONAware;
import org.json.simple.JSONObject;
import com.pearson.qa.common.ziggyfw.datastructures.IValidatable;
import com.pearson.qa.common.ziggyfw.datastructures.Validatable;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang3.StringUtils;

public class GetCollectionNoteResponsePayload extends Validatable implements JSONAware {
    private String id;
    private String messageType;
    private String body;
    private String resourceTitle;
    private String user;
    private String created;

    public void fromJSON(JSONObject jsonObject) {
        setId(jsonObject.get("id").toString());
        setMessageType((String) jsonObject.get("messageType").toString());
        setBody((String) jsonObject.get("body").toString());
        setResourceTitle((String) jsonObject.get("resourceTitle").toString());
        setUser((String) jsonObject.get("user").toString());
        setCreated((String) jsonObject.get("created").toString());
    }

    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();

        if (getId() != null)
            jsonObject.put("id", getId());

        if (getMessageType() != null)
            jsonObject.put("messageType", getMessageType());

        if (getBody() != null)
            jsonObject.put("body", getBody());

        if (getResourceTitle() != null)
            jsonObject.put("resourceTitle", getResourceTitle());

        if (getUser() != null)
            jsonObject.put("user", getUser());

        if (getCreated() != null)
            jsonObject.put("created", getCreated());
        return jsonObject;
    }

    @Override
    public String toJSONString() {
        return toJSON().toJSONString();
    }


    public GetCollectionNoteResponsePayload(JSONObject fromObject) {
        this.fromJSON(fromObject);
    }

    @Override
    public boolean isEmpty() {
        return
                StringUtils.isBlank(getId())
                        && StringUtils.isBlank(getMessageType())
                        && StringUtils.isBlank(getBody())
                        && StringUtils.isBlank(getResourceTitle())
                        && StringUtils.isBlank(getUser())
                        && StringUtils.isBlank(getCreated())
                ;
    }

    @Override
    public void validateEquals(IValidatable obj, boolean validateFieldsThatAreNullOnThis) throws ValidationException {
        GetCollectionNoteResponsePayload response = (GetCollectionNoteResponsePayload) obj;
        EqualsBuilder eb = new EqualsBuilder();
        if (validateFieldsThatAreNullOnThis || getId() != null) {
            eb.append(getId(), response.getId());
            if (!eb.isEquals())
                throw new ValidationException("Id", getId(), response.getId());
        }
        if (validateFieldsThatAreNullOnThis || getMessageType() != null) {
            eb.append(getMessageType(), response.getMessageType());
            if (!eb.isEquals())
                throw new ValidationException("MessageType", getMessageType(), response.getMessageType());
        }
        if (validateFieldsThatAreNullOnThis || getBody() != null) {
            eb.append(getBody(), response.getBody());
            if (!eb.isEquals())
                throw new ValidationException("Body", getBody(), response.getBody());
        }
        if (validateFieldsThatAreNullOnThis || getResourceTitle() != null) {
            eb.append(getResourceTitle(), response.getResourceTitle());
            if (!eb.isEquals())
                throw new ValidationException("ResourceTitle", getResourceTitle(), response.getResourceTitle());
        }
        if (validateFieldsThatAreNullOnThis || getUser() != null) {
            eb.append(getUser(), response.getUser());
            if (!eb.isEquals())
                throw new ValidationException("User", getUser(), response.getUser());
        }
        if (validateFieldsThatAreNullOnThis || getCreated() != null) {
            eb.append(getCreated(), response.getCreated());
            if (!eb.isEquals())
                throw new ValidationException("Created", getCreated(), response.getCreated());
        }
    }

    @Override
    public void validateState() throws ValidationException {

        if (StringUtils.isBlank(getId())) {
            throw new ValidationException("Id must be present in the response");
        }

        if (StringUtils.isBlank(getMessageType())) {
            throw new ValidationException("Message Type must be present in the response");
        }

        if (StringUtils.isBlank(getBody())) {
            throw new ValidationException("Body must be present in the response");
        }

        if (StringUtils.isBlank(getResourceTitle())) {
            throw new ValidationException("Resource Title must be present in the response");
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getResourceTitle() {
        return resourceTitle;
    }

    public void setResourceTitle(String resourceTitle) {
        this.resourceTitle = resourceTitle;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }
}
