package com.pearson.qa.bluesky.csg.books.owrContentFee.datastructures;

/**
 * Created by didiercorrales on 3/9/14.
 */

import org.json.simple.JSONAware;
import org.json.simple.JSONObject;
import com.pearson.qa.common.ziggyfw.datastructures.IValidatable;
import com.pearson.qa.common.ziggyfw.datastructures.Validatable;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang3.StringUtils;

public class OwrContentFeeResponsePayload extends Validatable implements JSONAware {
    private String terms;
    private String fee;
    private String flatfee;
    private String pearpagefee;
    private String chapterarticlefee;
    private String right;

    public void fromJSON(JSONObject jsonObject) {
        if (jsonObject.get("terms").toString() != null)
            setTerms(jsonObject.get("terms").toString());

        if (jsonObject.get("fee").toString() != null)
            setFee(jsonObject.get("fee").toString());

        if (jsonObject.get("flatfee").toString() != null)
            setFlatfee(jsonObject.get("flatfee").toString());

        if (jsonObject.get("pearpagefee").toString() != null)
            setPearpagefee(jsonObject.get("pearpagefee").toString());

        if (jsonObject.get("chapterarticlefee").toString() != null)
            setChapterarticlefee(jsonObject.get("chapterarticlefee").toString());

        if (jsonObject.get("right").toString() != null)
            setRight(jsonObject.get("right").toString());
    }

    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();

        if (getTerms() != null)
            jsonObject.put("terms", getTerms());

        if (getFee() != null)
            jsonObject.put("fee", getFee());

        if (getFlatfee() != null)
            jsonObject.put("flatfee", getFlatfee());

        if (getPearpagefee() != null)
            jsonObject.put("pearpagefee", getPearpagefee());

        if (getChapterarticlefee() != null)
            jsonObject.put("chapterarticlefee", getChapterarticlefee());

        if (getRight() != null)
            jsonObject.put("right", getRight());
        return jsonObject;
    }

    @Override
    public String toJSONString() {
        return toJSON().toJSONString();
    }


    public OwrContentFeeResponsePayload(JSONObject fromObject) {
        this.fromJSON(fromObject);
    }

    @Override
    public boolean isEmpty() {
        return
                StringUtils.isBlank(getTerms())
                        && StringUtils.isBlank(getFee())
                        && StringUtils.isBlank(getFlatfee())
                        && StringUtils.isBlank(getPearpagefee())
                        && StringUtils.isBlank(getChapterarticlefee())
                        && StringUtils.isBlank(getRight())
                ;
    }

    @Override
    public void validateEquals(IValidatable obj, boolean validateFieldsThatAreNullOnThis) throws ValidationException {
        OwrContentFeeResponsePayload response = (OwrContentFeeResponsePayload) obj;
        EqualsBuilder eb = new EqualsBuilder();
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
        if (validateFieldsThatAreNullOnThis || getFlatfee() != null) {
            eb.append(getFlatfee(), response.getFlatfee());
            if (!eb.isEquals())
                throw new ValidationException("Flatfee", getFlatfee(), response.getFlatfee());
        }
        if (validateFieldsThatAreNullOnThis || getPearpagefee() != null) {
            eb.append(getPearpagefee(), response.getPearpagefee());
            if (!eb.isEquals())
                throw new ValidationException("Pearpagefee", getPearpagefee(), response.getPearpagefee());
        }
        if (validateFieldsThatAreNullOnThis || getChapterarticlefee() != null) {
            eb.append(getChapterarticlefee(), response.getChapterarticlefee());
            if (!eb.isEquals())
                throw new ValidationException("Chapterarticlefee", getChapterarticlefee(), response.getChapterarticlefee());
        }
        if (validateFieldsThatAreNullOnThis || getRight() != null) {
            eb.append(getRight(), response.getRight());
            if (!eb.isEquals())
                throw new ValidationException("Right", getRight(), response.getRight());
        }
    }

    @Override
    public void validateState() throws ValidationException {
        if (StringUtils.isBlank(getTerms()))
            throw new ValidationException("Terms must be returned in the response");

        if (StringUtils.isBlank(getFee()))
            throw new ValidationException("Fee must be returned in the response");


        if (StringUtils.isBlank(getPearpagefee())) {
            throw new ValidationException("pearpagefee must be returned in the response");
        }

        if (StringUtils.isBlank(getRight())) {
            throw new ValidationException("Right must be returned in the response");
        }
              /*
        if (getChapterarticlefee()!= null)
        if (StringUtils.isBlank(getChapterarticlefee())) {
            throw new ValidationException("Chapter Articule Fee must be returned in the response");
        }

        if (getFlatfee()!= null)
        if (StringUtils.isBlank(getFlatfee()))
            throw new ValidationException("Flat Fee must be returned in the response");
            */
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

    public String getFlatfee() {
        return flatfee;
    }

    public void setFlatfee(String flatfee) {
        this.flatfee = flatfee;
    }

    public String getPearpagefee() {
        return pearpagefee;
    }

    public void setPearpagefee(String pearpagefee) {
        this.pearpagefee = pearpagefee;
    }

    public String getChapterarticlefee() {
        return chapterarticlefee;
    }

    public void setChapterarticlefee(String chapterarticlefee) {
        this.chapterarticlefee = chapterarticlefee;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }
}
