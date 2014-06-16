package com.pearson.qa.bluesky.csg.books.createOrderDetail.datastructures;

/**
 * Created by didiercorrales on 2/26/14.
 */
import org.json.simple.JSONAware;
import org.json.simple.JSONObject;
import com.pearson.qa.common.ziggyfw.datastructures.IValidatable;
import com.pearson.qa.common.ziggyfw.datastructures.Validatable;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang3.StringUtils;

public class CreateOrderDetailResponsePayload extends Validatable implements JSONAware{
    private String tempOrderDetailId;
    private String mode;

    public void fromJSON(JSONObject jsonObject){
        setTempOrderDetailId((String) jsonObject.get("tempOrderDetailId").toString());
        setMode((String) jsonObject.get("mode"));
    }

    public JSONObject toJSON(){
        JSONObject jsonObject = new JSONObject();

        if (getTempOrderDetailId()!=null)
            jsonObject.put("tempOrderDetailId",getTempOrderDetailId());

        if (getMode()!=null)
            jsonObject.put("mode",getMode());
        return jsonObject;
    }

    @Override
    public String toJSONString() {
        return toJSON().toJSONString();
    }


    public CreateOrderDetailResponsePayload(JSONObject fromObject){
        this.fromJSON(fromObject);
    }

    @Override
    public boolean isEmpty() {
        return
                StringUtils.isBlank(getTempOrderDetailId())
                        && StringUtils.isBlank(getMode())
                ;}

    @Override
    public void validateEquals(IValidatable obj, boolean validateFieldsThatAreNullOnThis) throws ValidationException {
        CreateOrderDetailResponsePayload response = (CreateOrderDetailResponsePayload) obj;
        EqualsBuilder eb = new EqualsBuilder();
        if (validateFieldsThatAreNullOnThis || getTempOrderDetailId() != null){
            eb.append(getTempOrderDetailId(), response.getTempOrderDetailId());
            if (!eb.isEquals())
                throw new ValidationException("TempOrderDetailId", getTempOrderDetailId(), response.getTempOrderDetailId());
        }
        if (validateFieldsThatAreNullOnThis || getMode() != null){
            eb.append(getMode(), response.getMode());
            if (!eb.isEquals())
                throw new ValidationException("Mode", getMode(), response.getMode());
        }
    }

    @Override
    public void validateState() throws ValidationException {

        if(StringUtils.isBlank(getTempOrderDetailId()))
        {
            throw new ValidationException("Create order Details API: TempOrderDetailId Id must be present in the response");
        }
        if(StringUtils.isBlank(getMode()))
        {
            throw new ValidationException("Create order Details API: Mode must be present in the response");
        }
    }

    public String getTempOrderDetailId() {
        return tempOrderDetailId;
    }

    public void setTempOrderDetailId(String tempOrderDetailId) {
        this.tempOrderDetailId = tempOrderDetailId;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}
