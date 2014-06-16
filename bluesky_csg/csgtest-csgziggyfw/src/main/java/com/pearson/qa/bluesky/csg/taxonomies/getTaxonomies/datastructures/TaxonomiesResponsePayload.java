package com.pearson.qa.bluesky.csg.taxonomies.getTaxonomies.datastructures;

import org.json.simple.JSONAware;
import org.json.simple.JSONObject;
import com.pearson.qa.common.ziggyfw.datastructures.IValidatable;
import com.pearson.qa.common.ziggyfw.datastructures.Validatable;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang3.StringUtils;

public class TaxonomiesResponsePayload extends Validatable implements JSONAware {
    private String disciplines;

    public void fromJSON(JSONObject jsonObject) {
        setDisciplines(jsonObject.get("disciplines").toString());
    }

    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();

        if (getDisciplines() != null)
            jsonObject.put("disciplines", getDisciplines());
        return jsonObject;
    }

    @Override
    public String toJSONString() {
        return toJSON().toJSONString();
    }


    public TaxonomiesResponsePayload(JSONObject fromObject) {
        this.fromJSON(fromObject);
    }

    @Override
    public boolean isEmpty() {
        return
                StringUtils.isBlank(getDisciplines())
                ;
    }

    @Override
    public void validateEquals(IValidatable obj, boolean validateFieldsThatAreNullOnThis) throws ValidationException {
        TaxonomiesResponsePayload response = (TaxonomiesResponsePayload) obj;
        EqualsBuilder eb = new EqualsBuilder();
        if (validateFieldsThatAreNullOnThis || getDisciplines() != null) {
            eb.append(getDisciplines(), response.getDisciplines());
            if (!eb.isEquals())
                throw new ValidationException("Disciplines", getDisciplines(), response.getDisciplines());
        }
    }

    @Override
    public void validateState() throws ValidationException {

        if (!getDisciplines().contains("id")) {
            throw new ValidationException("id must be present in the response");
        }
        if (!getDisciplines().contains("name")) {
            throw new ValidationException("name must be present in the response");
        }

        if (!getDisciplines().contains("subDisciplines")) {
            throw new ValidationException("subDisciplines must be present in the response");
        }
    }

    public String getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(String disciplines) {
        this.disciplines = disciplines;
    }
}