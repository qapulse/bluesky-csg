package com.pearson.qa.bluesky.csg.books.commitOrderDetail.datastructures;

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


public class CommitOrderDetailResponsePayload extends Validatable implements JSONAware {
    private String detailId;
    private String cancelled;
    private String invoiced;
    private String right;
    private String terms;
    private String fee;
    private String mode;

    public void fromJSON(JSONObject jsonObject) {
        setDetailId((String) jsonObject.get("detailId").toString());
        setCancelled((String) jsonObject.get("cancelled"));
        setInvoiced((String) jsonObject.get("invoiced"));
        setRight((String) jsonObject.get("right"));
        setTerms((String) jsonObject.get("terms"));
        setFee((String) jsonObject.get("fee").toString());
        setMode((String) jsonObject.get("mode"));
    }

    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();

        if (getDetailId() != null)
            jsonObject.put("detailId", getDetailId());

        if (getCancelled() != null)
            jsonObject.put("cancelled", getCancelled());

        if (getInvoiced() != null)
            jsonObject.put("invoiced", getInvoiced());

        if (getRight() != null)
            jsonObject.put("right", getRight());

        if (getTerms() != null)
            jsonObject.put("terms", getTerms());

        if (getFee() != null)
            jsonObject.put("fee", getFee());

        if (getMode() != null)
            jsonObject.put("mode", getMode());
        return jsonObject;
    }

    @Override
    public String toJSONString() {
        return toJSON().toJSONString();
    }


    public CommitOrderDetailResponsePayload(JSONObject fromObject) {
        this.fromJSON(fromObject);
    }

    @Override
    public boolean isEmpty() {
        return
                StringUtils.isBlank(getDetailId())
                        && StringUtils.isBlank(getCancelled())
                        && StringUtils.isBlank(getInvoiced())
                        && StringUtils.isBlank(getRight())
                        && StringUtils.isBlank(getTerms())
                        && StringUtils.isBlank(getFee())
                        && StringUtils.isBlank(getMode())
                ;
    }

    @Override
    public void validateEquals(IValidatable obj, boolean validateFieldsThatAreNullOnThis) throws ValidationException {
        CommitOrderDetailResponsePayload response = (CommitOrderDetailResponsePayload) obj;
        EqualsBuilder eb = new EqualsBuilder();
        if (validateFieldsThatAreNullOnThis || getDetailId() != null) {
            eb.append(getDetailId(), response.getDetailId());
            if (!eb.isEquals())
                throw new ValidationException("DetailId", getDetailId(), response.getDetailId());
        }
        if (validateFieldsThatAreNullOnThis || getCancelled() != null) {
            eb.append(getCancelled(), response.getCancelled());
            if (!eb.isEquals())
                throw new ValidationException("Cancelled", getCancelled(), response.getCancelled());
        }
        if (validateFieldsThatAreNullOnThis || getInvoiced() != null) {
            eb.append(getInvoiced(), response.getInvoiced());
            if (!eb.isEquals())
                throw new ValidationException("Invoiced", getInvoiced(), response.getInvoiced());
        }
        if (validateFieldsThatAreNullOnThis || getRight() != null) {
            eb.append(getRight(), response.getRight());
            if (!eb.isEquals())
                throw new ValidationException("Right", getRight(), response.getRight());
        }
        if (validateFieldsThatAreNullOnThis || getTerms() != null) {
            eb.append(getTerms(), response.getTerms());
            if (!eb.isEquals())
                throw new ValidationException("Terms", getTerms(), response.getTerms());
        }
        if (validateFieldsThatAreNullOnThis || getFee() != null) {
            eb.append(getFee(), response.getFee());
            if (!eb.isEquals())
                throw new ValidationException("Fee", getFee(), response.getFee());
        }
        if (validateFieldsThatAreNullOnThis || getMode() != null) {
            eb.append(getMode(), response.getMode());
            if (!eb.isEquals())
                throw new ValidationException("Mode", getMode(), response.getMode());
        }
    }

    @Override
    public void validateState() throws ValidationException {

//*********************//////////////////////**********************//
      // TODO  ADD YOR CODE HERE
//*********************//////////////////////**********************//

    }

    public String getDetailId() {
        return detailId;
    }

    public void setDetailId(String detailId) {
        this.detailId = detailId;
    }

    public String getCancelled() {
        return cancelled;
    }

    public void setCancelled(String cancelled) {
        this.cancelled = cancelled;
    }

    public String getInvoiced() {
        return invoiced;
    }

    public void setInvoiced(String invoiced) {
        this.invoiced = invoiced;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}


