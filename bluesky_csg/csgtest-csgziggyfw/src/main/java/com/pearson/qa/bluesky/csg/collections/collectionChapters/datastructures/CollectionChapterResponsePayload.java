package com.pearson.qa.bluesky.csg.collections.collectionChapters.datastructures;

import org.json.simple.JSONAware;
import org.json.simple.JSONObject;
import com.pearson.qa.common.ziggyfw.datastructures.IValidatable;
import com.pearson.qa.common.ziggyfw.datastructures.Validatable;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang3.StringUtils;

public class CollectionChapterResponsePayload extends Validatable implements JSONAware {
    private String collectionChapter;

    public void fromJSON(JSONObject jsonObject) {
        setCollectionChapter(jsonObject.get("collectionChapter").toString());
    }

    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();

        if (getCollectionChapter() != null)
            jsonObject.put("collectionChapter", getCollectionChapter());
        return jsonObject;
    }

    @Override
    public String toJSONString() {
        return toJSON().toJSONString();
    }


    public CollectionChapterResponsePayload(JSONObject fromObject) {
        this.fromJSON(fromObject);
    }

    @Override
    public boolean isEmpty() {
        return
                StringUtils.isBlank(getCollectionChapter())
                ;
    }

    @Override
    public void validateEquals(IValidatable obj, boolean validateFieldsThatAreNullOnThis) throws ValidationException {
        CollectionChapterResponsePayload response = (CollectionChapterResponsePayload) obj;
        EqualsBuilder eb = new EqualsBuilder();
        if (validateFieldsThatAreNullOnThis || getCollectionChapter() != null) {
            eb.append(getCollectionChapter(), response.getCollectionChapter());
            if (!eb.isEquals())
                throw new ValidationException("CollectionChapter", getCollectionChapter(), response.getCollectionChapter());
        }
    }

    @Override
    public void validateState() throws ValidationException {

        if (StringUtils.isBlank(getCollectionChapter())) {
            throw new ValidationException("CollecitonChapter must be present in the response");
        }
    }

    public String getCollectionChapter() {
        return collectionChapter;
    }

    public void setCollectionChapter(String collectionChapter) {
        this.collectionChapter = collectionChapter;
    }
}
