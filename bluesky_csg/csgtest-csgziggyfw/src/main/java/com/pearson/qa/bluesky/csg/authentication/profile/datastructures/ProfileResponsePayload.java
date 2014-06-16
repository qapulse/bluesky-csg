package com.pearson.qa.bluesky.csg.authentication.profile.datastructures;

import com.pearson.qa.common.ziggyfw.datastructures.IValidatable;
import com.pearson.qa.common.ziggyfw.datastructures.Validatable;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

/**
 * Created with IntelliJ IDEA.
 * User: dcorrales
 * Date: 2/5/14
 * Time: 4:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class ProfileResponsePayload extends Validatable implements JSONAware
{

    private String sessionToken;

    private String authSystemSessionKey;

    private String userId;

    private String authSystemUserId;

    private String userRoles;

    private String apiConsumerApplications;

    private String authenticationType;


    public ProfileResponsePayload(JSONObject fromJson)
    {
        this.fromJSON(fromJson);
    }

    public void fromJSON(JSONObject jsonObject){

        setSessionToken((String) jsonObject.get("sessionToken"));
        setAuthSystemSessionKey((String) jsonObject.get("authSystemSessionKey"));
        setUserId((String) jsonObject.get("userId"));
        setAuthSystemUserId((String) jsonObject.get("authSystemUserId"));
        setUserRoles(( jsonObject.get("userRoles")).toString());
        setApiConsumerApplications(jsonObject.get("apiConsumerApplications").toString());
        setAuthenticationType((String) jsonObject.get("authenticationType"));
    }

    public JSONObject toJSON(){
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("sessionToken",getSessionToken());
        jsonObject.put("authSystemSessionKey",getAuthSystemSessionKey());
        jsonObject.put("authSystemUserId",getAuthSystemUserId());
        jsonObject.put("userId",getUserId());
        jsonObject.put("userRoles",getUserRoles());
        jsonObject.put("apiConsumerApplications",getApiConsumerApplications());
        jsonObject.put("authenticationType",getAuthenticationType());

        return jsonObject;
    }

    @Override
    public String toJSONString() {
        return toJSON().toJSONString();
    }


    @Override
    public boolean isEmpty() {
        return StringUtils.isBlank(getSessionToken()) && StringUtils.isBlank(getAuthSystemSessionKey()) &&
               StringUtils.isBlank(getAuthSystemUserId()) && StringUtils.isBlank(getUserId()) &&
               StringUtils.isBlank(getUserRoles()) && StringUtils.isBlank(getApiConsumerApplications()) &&
               StringUtils.isBlank(getAuthenticationType());
    }

    @Override
    public void validateEquals(IValidatable obj, boolean validateFieldsThatAreNullOnThis) throws ValidationException {

        ProfileResponsePayload response = (ProfileResponsePayload) obj;
        EqualsBuilder eb = new EqualsBuilder();

        if (validateFieldsThatAreNullOnThis || getSessionToken() != null)
        {
            eb.append(getSessionToken(), response.getSessionToken());
            if (!eb.isEquals())
                throw new ValidationException("SessionToken", getSessionToken(), response.getSessionToken());
        }
        if (validateFieldsThatAreNullOnThis || getAuthSystemSessionKey() != null)
        {
            eb.append(getAuthSystemSessionKey(), response.getAuthSystemSessionKey());
            if (!eb.isEquals())
                throw new ValidationException("AuthSystemSessionKey", getAuthSystemSessionKey(), response.getAuthSystemSessionKey());
        }
        if (validateFieldsThatAreNullOnThis || getAuthSystemUserId() != null)
        {
            eb.append(getAuthSystemUserId(), response.getAuthSystemUserId());
            if (!eb.isEquals())
                throw new ValidationException("AuthSystemUserId", getAuthSystemUserId(), response.getAuthSystemUserId());
        }
        if (validateFieldsThatAreNullOnThis || getUserId() != null)
        {
            eb.append(getUserId(), response.getUserId());
            if (!eb.isEquals())
                throw new ValidationException("UserId", getUserId(), response.getUserId());
        }
        if (validateFieldsThatAreNullOnThis || getUserRoles() != null)
        {
            eb.append(getUserRoles(), response.getUserRoles());
            if (!eb.isEquals())
                throw new ValidationException("UserRoles", getUserRoles(), response.getUserRoles());
        }
        if (validateFieldsThatAreNullOnThis || getApiConsumerApplications() != null)
        {
            eb.append(getApiConsumerApplications(), response.getApiConsumerApplications());
            if (!eb.isEquals())
                throw new ValidationException("ApiConsumerApplications", getApiConsumerApplications(), response.getApiConsumerApplications());
        }
        if (validateFieldsThatAreNullOnThis || getAuthenticationType() != null)
        {
            eb.append(getAuthenticationType(), response.getAuthenticationType());
            if (!eb.isEquals())
                throw new ValidationException("AuthenticationType", getAuthenticationType(), response.getAuthenticationType());
        }


    }

    @Override
    public void validateState() throws ValidationException {

        if(!StringUtils.isBlank(getSessionToken()))
        {
            if (StringUtils.isBlank(getAuthSystemSessionKey()))
                throw new ValidationException("When session token is returned the authSystemSession is expected in the response.");

            if (StringUtils.isBlank(getUserId()))
                throw new ValidationException("When session token is returned the user id is expected in the response.");

            if (StringUtils.isBlank(getAuthenticationType()))
                throw new ValidationException("When session token is returned the AuthenticationType is expected in the response.");

             if (StringUtils.isBlank(getAuthSystemUserId()))
                 throw new ValidationException(String.format("When session token is returned the AuthSystemUserId is expected in the response. "));


            if (StringUtils.isBlank(getUserRoles())) {
                throw new ValidationException("When session token is returned the user roles is expected in the response.");
            }

            if (StringUtils.isBlank(getApiConsumerApplications())) {
                throw new ValidationException("When session token is returned the ApiConsumerApplications is expected in the response.");
            }
        }
}

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    public String getAuthSystemSessionKey() {
        return authSystemSessionKey;
    }

    public void setAuthSystemSessionKey(String authSystemSessionKey) {
        this.authSystemSessionKey = authSystemSessionKey;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAuthSystemUserId() {
        return authSystemUserId;
    }

    public void setAuthSystemUserId(String authSystemUserId) {
        this.authSystemUserId = authSystemUserId;
    }

    public String getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(String userRoles) {
        this.userRoles = userRoles;
    }

    public String getApiConsumerApplications() {
        return apiConsumerApplications;
    }

    public void setApiConsumerApplications(String apiConsumerApplications) {
        this.apiConsumerApplications = apiConsumerApplications;
    }

    public String getAuthenticationType() {
        return authenticationType;
    }

    public void setAuthenticationType(String authenticationType) {
        this.authenticationType = authenticationType;
    }
}
