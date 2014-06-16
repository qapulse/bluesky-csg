package com.pearson.qa.bluesky.csg.books.isbnByNumberOrStatus.datastructures;

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

public class IsbnByNumberOrStatusResponsePayload extends Validatable implements JSONAware {
    private String result;
    private String olpUrl;
    private String purchaseLandingPage;

    public void fromJSON(JSONObject jsonObject) {
        setResult((String) jsonObject.get("result").toString());
        setOlpUrl((String) jsonObject.get("olpUrl").toString());
        setPurchaseLandingPage((String) jsonObject.get("purchaseLandingPage").toString());
    }

    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();

        if (getResult() != null)
            jsonObject.put("result", getResult());

        if (getOlpUrl() != null)
            jsonObject.put("olpUrl", getOlpUrl());

        if (getPurchaseLandingPage() != null)
            jsonObject.put("purchaseLandingPage", getPurchaseLandingPage());
        return jsonObject;
    }

    @Override
    public String toJSONString() {
        return toJSON().toJSONString();
    }


    public IsbnByNumberOrStatusResponsePayload(JSONObject fromObject) {
        this.fromJSON(fromObject);
    }

    @Override
    public boolean isEmpty() {
        return
                StringUtils.isBlank(getResult())
                        && StringUtils.isBlank(getOlpUrl())
                        && StringUtils.isBlank(getPurchaseLandingPage())
                ;
    }

    @Override
    public void validateEquals(IValidatable obj, boolean validateFieldsThatAreNullOnThis) throws ValidationException {
        IsbnByNumberOrStatusResponsePayload response = (IsbnByNumberOrStatusResponsePayload) obj;
        EqualsBuilder eb = new EqualsBuilder();
        if (validateFieldsThatAreNullOnThis || getResult() != null) {
            eb.append(getResult(), response.getResult());
            if (!eb.isEquals())
                throw new ValidationException("Result", getResult(), response.getResult());
        }
        if (validateFieldsThatAreNullOnThis || getOlpUrl() != null) {
            eb.append(getOlpUrl(), response.getOlpUrl());
            if (!eb.isEquals())
                throw new ValidationException("OlpUrl", getOlpUrl(), response.getOlpUrl());
        }
        if (validateFieldsThatAreNullOnThis || getPurchaseLandingPage() != null) {
            eb.append(getPurchaseLandingPage(), response.getPurchaseLandingPage());
            if (!eb.isEquals())
                throw new ValidationException("PurchaseLandingPage", getPurchaseLandingPage(), response.getPurchaseLandingPage());
        }
    }

    @Override
    public void validateState() throws ValidationException {

        if(StringUtils.isBlank(getOlpUrl()))
            throw new ValidationException("OlpUrl must be returned in the response");

        if(StringUtils.isBlank(getPurchaseLandingPage()))
            throw new ValidationException("PurchaseLandingPage must be returned in the response");

        if( getResult().contains("isbn"))
            throw new ValidationException("ISBN must be returned in the response");
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getOlpUrl() {
        return olpUrl;
    }

    public void setOlpUrl(String olpUrl) {
        this.olpUrl = olpUrl;
    }

    public String getPurchaseLandingPage() {
        return purchaseLandingPage;
    }

    public void setPurchaseLandingPage(String purchaseLandingPage) {
        this.purchaseLandingPage = purchaseLandingPage;
    }
}
