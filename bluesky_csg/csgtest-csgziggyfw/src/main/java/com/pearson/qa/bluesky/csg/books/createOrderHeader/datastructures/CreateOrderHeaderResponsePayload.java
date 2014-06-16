package com.pearson.qa.bluesky.csg.books.createOrderHeader.datastructures;

import com.pearson.qa.common.ziggyfw.datastructures.IValidatable;
import com.pearson.qa.common.ziggyfw.datastructures.Validatable;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONObject;
import org.json.simple.JSONAware;

/**
 * Created with IntelliJ IDEA.
 * User: dcorrales
 * Date: 2/19/14
 * Time: 9:43 AM
 * To change this template use File | Settings | File Templates.
 */
public class CreateOrderHeaderResponsePayload extends Validatable implements JSONAware {


    String headerId;
    String mode;

    public CreateOrderHeaderResponsePayload(JSONObject fromObject){

        this.fromJSON(fromObject);
    }

    public void fromJSON(JSONObject jsonObject){
        setHeaderId((String) jsonObject.get("headerId").toString());
        setMode((String) jsonObject.get("mode"));
    }

    public JSONObject toJSON(){
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("headerId",getHeaderId().toString());
        jsonObject.put("mode",getMode());

        return jsonObject;
    }


    @Override
    public boolean isEmpty() {
        return StringUtils.isBlank(getHeaderId())  && StringUtils.isBlank(getMode());
    }

    @Override
    public void validateEquals(IValidatable obj, boolean validateFieldsThatAreNullOnThis) throws ValidationException {
        CreateOrderHeaderResponsePayload response = (CreateOrderHeaderResponsePayload) obj;
        EqualsBuilder eb = new EqualsBuilder();

        if (validateFieldsThatAreNullOnThis || getHeaderId() != null)
        {
            eb.append(getHeaderId(), response.getHeaderId());
            if (!eb.isEquals())
                throw new ValidationException("Header Id", getHeaderId(), response.getHeaderId());
        }
        if (validateFieldsThatAreNullOnThis || getMode() != null)
        {
            eb.append(getMode(), response.getMode());
            if (!eb.isEquals())
                throw new ValidationException("Mode", getMode(), response.getMode());
        }
    }

    @Override
    public void validateState() throws ValidationException {
        if(StringUtils.isBlank(getHeaderId()))
        {
            throw new ValidationException("Create order header API: Header Id must be present in the response");
        }
        if(StringUtils.isBlank(getMode()))
        {
            throw new ValidationException("Create order header API: Mode must be present in the response");
        }
    }

    @Override
    public String toJSONString() {
        return toJSON().toJSONString();
    }
    public String getHeaderId() {
        return headerId;
    }

    public void setHeaderId(String headerId) {
        this.headerId = headerId;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}
