package com.pearson.qa.bluesky.csg.taxonomies.collectionsByTaxonomyCourse.datastructures;


import org.json.simple.JSONAware;
import org.json.simple.JSONObject;
import com.pearson.qa.common.ziggyfw.datastructures.IValidatable;
import com.pearson.qa.common.ziggyfw.datastructures.Validatable;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang3.StringUtils;
public class CollectionsByTaxonomyCourseResponsePayload extends Validatable implements JSONAware{
    private String collections;

    public void fromJSON(JSONObject jsonObject){
        setCollections( jsonObject.get("collections").toString());
    }

    public JSONObject toJSON(){
        JSONObject jsonObject = new JSONObject();

        if (getCollections()!=null)
            jsonObject.put("collections",getCollections());
        return jsonObject;
    }

    @Override
    public String toJSONString() {
        return toJSON().toJSONString();
    }


    public CollectionsByTaxonomyCourseResponsePayload (JSONObject fromObject){
        this.fromJSON(fromObject);
    }

    @Override
    public boolean isEmpty() {
        return
                StringUtils.isBlank(getCollections())
                ;}

    @Override
    public void validateEquals(IValidatable obj, boolean validateFieldsThatAreNullOnThis) throws ValidationException {
        CollectionsByTaxonomyCourseResponsePayload response = (CollectionsByTaxonomyCourseResponsePayload) obj;
        EqualsBuilder eb = new EqualsBuilder();
        if (validateFieldsThatAreNullOnThis || getCollections() != null){
            eb.append(getCollections(), response.getCollections());
            if (!eb.isEquals())
                throw new ValidationException("Collections", getCollections(), response.getCollections());
        }
    }

    @Override
    public void validateState() throws ValidationException {

        if ((StringUtils.isBlank(getCollections()))) {
            throw new ValidationException("Collections must be present in the response");
        }

    }

    public String getCollections() {
        return collections;
    }

    public void setCollections(String collections) {
        this.collections = collections;
    }
}