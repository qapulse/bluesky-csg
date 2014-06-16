package com.pearson.qa.bluesky.csg.books.generateSalesRepReport.datastructures;

/**
 * Created by dcorrales on 2/27/14.
 */
import org.json.simple.JSONAware;
import org.json.simple.JSONObject;
import com.pearson.qa.common.ziggyfw.datastructures.IValidatable;
import com.pearson.qa.common.ziggyfw.datastructures.Validatable;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang3.StringUtils;
public class GenerateSalesRepReportResponsePayload extends Validatable implements JSONAware{
    private String result;

    public void fromJSON(JSONObject jsonObject){
        setResult((String) jsonObject.get("result").toString());
    }

    public JSONObject toJSON(){
        JSONObject jsonObject = new JSONObject();

        if (getResult()!=null)
            jsonObject.put("result",getResult().toString());
        return jsonObject;
    }

    @Override
    public String toJSONString() {
        return toJSON().toJSONString();
    }


    public GenerateSalesRepReportResponsePayload (JSONObject fromObject){
        this.fromJSON(fromObject);
    }

    @Override
    public boolean isEmpty() {
        return
                StringUtils.isBlank(getResult())
                ;}

    @Override
    public void validateEquals(IValidatable obj, boolean validateFieldsThatAreNullOnThis) throws ValidationException {
        GenerateSalesRepReportResponsePayload response = (GenerateSalesRepReportResponsePayload) obj;
        EqualsBuilder eb = new EqualsBuilder();
        if (validateFieldsThatAreNullOnThis || getResult() != null){
            eb.append(getResult(), response.getResult());
            if (!eb.isEquals())
                throw new ValidationException("Result", getResult(), response.getResult());
        }
    }

    @Override
    public void validateState() throws ValidationException {

//*********************//////////////////////**********************//
        // TODO ADD YOR CODE HERE
//*********************//////////////////////**********************//

    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
