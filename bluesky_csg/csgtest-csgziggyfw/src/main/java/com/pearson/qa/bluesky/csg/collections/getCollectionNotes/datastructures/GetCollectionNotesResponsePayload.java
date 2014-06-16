package com.pearson.qa.bluesky.csg.collections.getCollectionNotes.datastructures;

import org.json.simple.JSONAware;
import org.json.simple.JSONObject;
import com.pearson.qa.common.ziggyfw.datastructures.IValidatable;
import com.pearson.qa.common.ziggyfw.datastructures.Validatable;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang3.StringUtils;

public class GetCollectionNotesResponsePayload extends Validatable implements JSONAware {
    private String totalItems;
    private String pageNumber;
    private String pageSize;
    private String items;

    public void fromJSON(JSONObject jsonObject) {
        setTotalItems(jsonObject.get("totalItems").toString());
        setPageNumber(jsonObject.get("pageNumber").toString());
        setPageSize(jsonObject.get("pageSize").toString());
        setItems(jsonObject.get("items").toString());
    }

    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();

        if (getTotalItems() != null)
            jsonObject.put("totalItems", getTotalItems());

        if (getPageNumber() != null)
            jsonObject.put("pageNumber", getPageNumber());

        if (getPageSize() != null)
            jsonObject.put("pageSize", getPageSize());

        if (getItems() != null)
            jsonObject.put("items", getItems());
        return jsonObject;
    }

    @Override
    public String toJSONString() {
        return toJSON().toJSONString();
    }


    public GetCollectionNotesResponsePayload(JSONObject fromObject) {
        this.fromJSON(fromObject);
    }

    @Override
    public boolean isEmpty() {
        return
                StringUtils.isBlank(getTotalItems())
                        && StringUtils.isBlank(getPageNumber())
                        && StringUtils.isBlank(getPageSize())
                        && StringUtils.isBlank(getItems())
                ;
    }

    @Override
    public void validateEquals(IValidatable obj, boolean validateFieldsThatAreNullOnThis) throws ValidationException {
        GetCollectionNotesResponsePayload response = (GetCollectionNotesResponsePayload) obj;
        EqualsBuilder eb = new EqualsBuilder();
        if (validateFieldsThatAreNullOnThis || getTotalItems() != null) {
            eb.append(getTotalItems(), response.getTotalItems());
            if (!eb.isEquals())
                throw new ValidationException("TotalItems", getTotalItems(), response.getTotalItems());
        }
        if (validateFieldsThatAreNullOnThis || getPageNumber() != null) {
            eb.append(getPageNumber(), response.getPageNumber());
            if (!eb.isEquals())
                throw new ValidationException("PageNumber", getPageNumber(), response.getPageNumber());
        }
        if (validateFieldsThatAreNullOnThis || getPageSize() != null) {
            eb.append(getPageSize(), response.getPageSize());
            if (!eb.isEquals())
                throw new ValidationException("PageSize", getPageSize(), response.getPageSize());
        }
        if (validateFieldsThatAreNullOnThis || getItems() != null) {
            eb.append(getItems(), response.getItems());
            if (!eb.isEquals())
                throw new ValidationException("Items", getItems(), response.getItems());
        }
    }

    @Override
    public void validateState() throws ValidationException {

        if (StringUtils.isBlank(getTotalItems())) {
            throw new ValidationException("total items must be present in the response");
        }
        if (StringUtils.isBlank(getPageNumber())) {
            throw new ValidationException("Page number must be present in the response");
        }

        if (StringUtils.isBlank(getPageSize())) {
            throw new ValidationException("Page Size must be present in the response");
        }

        if (StringUtils.isBlank(getItems())) {
            throw new ValidationException("Items must be present in the response");
        }
    }

    public String getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(String totalItems) {
        this.totalItems = totalItems;
    }

    public String getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(String pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }
}