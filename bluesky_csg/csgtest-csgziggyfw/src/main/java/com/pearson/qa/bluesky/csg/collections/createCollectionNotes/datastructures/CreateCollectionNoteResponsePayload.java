package com.pearson.qa.bluesky.csg.collections.createCollectionNotes.datastructures;

import org.json.simple.JSONAware;
import org.json.simple.JSONObject;
import com.pearson.qa.common.ziggyfw.datastructures.IValidatable;
import com.pearson.qa.common.ziggyfw.datastructures.Validatable;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang3.StringUtils;
public class CreateCollectionNoteResponsePayload extends Validatable implements JSONAware{
    private String response;
    private String noteId;

    public void fromJSON(JSONObject jsonObject){
        setResponse((String) jsonObject.get("response"));
        setNoteId((String) jsonObject.get("noteId"));
    }

    public JSONObject toJSON(){
        JSONObject jsonObject = new JSONObject();

        if (getResponse()!=null)
            jsonObject.put("response",getResponse());

        if (getNoteId()!=null)
            jsonObject.put("noteId",getNoteId());
        return jsonObject;
    }

    @Override
    public String toJSONString() {
        return toJSON().toJSONString();
    }


    public CreateCollectionNoteResponsePayload(JSONObject fromObject){
        this.fromJSON(fromObject);
    }

    @Override
    public boolean isEmpty() {
        return
                StringUtils.isBlank(getResponse())
                        && StringUtils.isBlank(getNoteId())
                ;}

    @Override
    public void validateEquals(IValidatable obj, boolean validateFieldsThatAreNullOnThis) throws ValidationException {
        CreateCollectionNoteResponsePayload response = (CreateCollectionNoteResponsePayload) obj;
        EqualsBuilder eb = new EqualsBuilder();
        if (validateFieldsThatAreNullOnThis || getResponse() != null){
            eb.append(getResponse(), response.getResponse());
            if (!eb.isEquals())
                throw new ValidationException("Response", getResponse(), response.getResponse());
        }
        if (validateFieldsThatAreNullOnThis || getNoteId() != null){
            eb.append(getNoteId(), response.getNoteId());
            if (!eb.isEquals())
                throw new ValidationException("NoteId", getNoteId(), response.getNoteId());
        }
    }

    @Override
    public void validateState() throws ValidationException {
        if (StringUtils.isBlank(getResponse()))
            throw new ValidationException("response must be returned in the response");

        if (StringUtils.isBlank(getNoteId()))
            throw new ValidationException("Note Id must be returned in the response");
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getNoteId() {
        return noteId;
    }

    public void setNoteId(String noteId) {
        this.noteId = noteId;
    }
}
