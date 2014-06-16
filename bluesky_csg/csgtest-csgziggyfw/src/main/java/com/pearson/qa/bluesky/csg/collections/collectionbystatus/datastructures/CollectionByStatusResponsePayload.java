package com.pearson.qa.bluesky.csg.collections.collectionbystatus.datastructures;

/**
 * Created by brian on 3/22/14.
 */
import org.apache.commons.lang.StringUtils;
import org.json.simple.JSONAware;
import org.json.simple.JSONObject;
import com.pearson.qa.common.ziggyfw.datastructures.IValidatable;
import com.pearson.qa.common.ziggyfw.datastructures.Validatable;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import org.apache.commons.lang.builder.EqualsBuilder;


public class CollectionByStatusResponsePayload extends Validatable implements JSONAware{
    private String totalItems;

    public void fromJSON(JSONObject jsonObject) {
        settotalItems((String) jsonObject.get("totalItems").toString());
        //setCollectionId((String) jsonObject.get("collectionId").toString());
    }

    public JSONObject toJSON(){
        JSONObject jsonObject = new JSONObject();

        if (gettotalItems()!=null)
            jsonObject.put("totalItems",gettotalItems());
        return jsonObject;
    }

    @Override
    public String toJSONString() {
        return toJSON().toJSONString();
    }


    public CollectionByStatusResponsePayload (JSONObject fromObject){
        this.fromJSON(fromObject);
    }

    @Override
    public boolean isEmpty() {
        return
                StringUtils.isBlank(gettotalItems())
                ;}

    @Override
    public void validateEquals(IValidatable obj, boolean validateFieldsThatAreNullOnThis) throws ValidationException {
        CollectionByStatusResponsePayload response = (CollectionByStatusResponsePayload) obj;
        EqualsBuilder eb = new EqualsBuilder();
        if (validateFieldsThatAreNullOnThis || gettotalItems() != null){
            eb.append(gettotalItems(), response.gettotalItems());
            if (!eb.isEquals())
                throw new ValidationException("totalItems", gettotalItems(), response.gettotalItems());
        }
    }

    @Override
    public void validateState() throws ValidationException {

//*********************//////////////////////**********************//
        if (StringUtils.isBlank(totalItems))
            throw new ValidationException("totalItems must be returned in the response");

    }

    public void settotalItems(String totalItems) {
        this.totalItems = totalItems;
    }

    public String gettotalItems() {
        return totalItems;
    }

    public String getStatus() {
        return totalItems;
    }
}