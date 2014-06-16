package com.pearson.qa.bluesky.csg.books.updateIsbnStatus.datastructures;

import org.json.simple.JSONAware;
import org.json.simple.JSONObject;
import com.pearson.qa.common.ziggyfw.datastructures.IValidatable;
import com.pearson.qa.common.ziggyfw.datastructures.Validatable;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang3.StringUtils;
public class UpdateIsbnStatusResponsePayload extends Validatable implements JSONAware{
    private String result;

    public void fromJSON(JSONObject jsonObject){
        setResult((String) jsonObject.get("result"));
    }

    public JSONObject toJSON(){
        JSONObject jsonObject = new JSONObject();

        if (getResult()!=null)
            jsonObject.put("result", getResult());
        return jsonObject;
    }

    @Override
    public String toJSONString() {
        return toJSON().toJSONString();
    }


    public UpdateIsbnStatusResponsePayload (JSONObject fromObject){
        this.fromJSON(fromObject);
    }

    @Override
    public boolean isEmpty() {
        return
                StringUtils.isBlank(getResult())
                ;}

    @Override
    public void validateEquals(IValidatable obj, boolean validateFieldsThatAreNullOnThis) throws ValidationException {
        UpdateIsbnStatusResponsePayload response = (UpdateIsbnStatusResponsePayload) obj;
        EqualsBuilder eb = new EqualsBuilder();
        if (validateFieldsThatAreNullOnThis || getResult() != null){
            eb.append(getResult(), response.getResult());
            if (!eb.isEquals())
                throw new ValidationException("Response", getResult(), response.getResult());
        }
    }

    @Override
    public void validateState() throws ValidationException {

        if(StringUtils.isBlank(getResult()))
            throw new ValidationException("Response must be returned in the result");

    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}