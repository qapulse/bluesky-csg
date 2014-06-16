package com.pearson.qa.bluesky.csg.books.territories.datastructures;

import com.pearson.qa.common.ziggyfw.datastructures.IValidatable;
import com.pearson.qa.common.ziggyfw.datastructures.Validatable;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

/**
 * Created by dcorrales on 2/24/14.
 */
public class TerritoriesResponsePayload extends Validatable implements JSONAware {
    private String result;

    public void fromJSON(JSONObject jsonObject){
        setResult( jsonObject.get("result").toString());
    }

    public JSONObject toJSON(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result",getResult());
        return jsonObject;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toJSONString() {
        return toJSON().toJSONString();
    }


    public TerritoriesResponsePayload(JSONObject fromObject){
        this.fromJSON(fromObject);
    }

    @Override
    public boolean isEmpty() {
        return
                StringUtils.isBlank(getResult())
                ;}

    @Override
    public void validateEquals(IValidatable obj, boolean validateFieldsThatAreNullOnThis) throws ValidationException {
        TerritoriesResponsePayload response = (TerritoriesResponsePayload) obj;
        EqualsBuilder eb = new EqualsBuilder();
        if (validateFieldsThatAreNullOnThis || getResult() != null){
            eb.append(getResult(), response.getResult());
            if (!eb.isEquals())
                throw new ValidationException("Result", getResult(), response.getResult());
        }
    }

    @Override
    public void validateState() throws ValidationException {

        if(!getResult().contains("id"))
            throw new ValidationException("Book Name must be returned in the response");
    }
}
