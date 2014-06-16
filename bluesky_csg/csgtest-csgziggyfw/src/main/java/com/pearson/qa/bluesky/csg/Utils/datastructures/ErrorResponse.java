package com.pearson.qa.bluesky.csg.Utils.datastructures;

import com.pearson.qa.common.ziggyfw.datastructures.IValidatable;
import com.pearson.qa.common.ziggyfw.datastructures.Validatable;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

/**
 * Created with IntelliJ IDEA.
 * User: dcorrales
 * Date: 2/10/14
 * Time: 1:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class ErrorResponse extends Validatable implements JSONAware {

    private String status;
    private String errorCode;
    private String message;

    public ErrorResponse(JSONObject fromJson)
    {
        this.fromJSON(fromJson);
    }
    public void fromJSON(JSONObject jsonObject){
        setStatus((String) jsonObject.get("status"));
        setErrorCode((String) jsonObject.get("errorCode"));
        setMessage((String) jsonObject.get("message"));
    }

    public JSONObject toJSON(){
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("status",getStatus());
        jsonObject.put("errorCode",getErrorCode());
        jsonObject.put("message",getMessage());

        return jsonObject;
    }


    @Override
    public String toJSONString() {
        return toJSON().toJSONString();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean isEmpty() {
        return StringUtils.isBlank(getErrorCode()) && StringUtils.isBlank(getMessage()) &&  StringUtils.isBlank(getStatus());
    }

    @Override
    public void validateEquals(IValidatable obj, boolean validateFieldsThatAreNullOnThis) throws ValidationException {


    }

    @Override
    public void validateState() throws ValidationException {
        //To change body of implemented methods use File | Settings | File Templates.
        if(StringUtils.isBlank(getMessage()))
            throw new ValidationException("When endnpoint call fail the error message  is expected in the response.");

        if (getErrorCode() == null )
            throw new ValidationException("The endpoint must return an error message");

        if (getErrorCode().equals("500"))
            throw new ValidationException("The endpoint returned an unexpected result, Error Code: " +getErrorCode() );

        if (!getStatus().equals("error"))
            throw new ValidationException("The endpoint must return a error message");
    }
}
