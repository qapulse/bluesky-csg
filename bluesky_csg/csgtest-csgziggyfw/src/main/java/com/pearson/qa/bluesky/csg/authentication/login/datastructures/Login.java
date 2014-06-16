package com.pearson.qa.bluesky.csg.authentication.login.datastructures;

import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

/**
 * Created with IntelliJ IDEA.
 * User: dcorrales
 * Date: 2/5/14
 * Time: 4:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class Login implements JSONAware {

    private String userName;

    private String password;

    private String authSystem;

    private String okUrl;

    private String errUrl;

    public void fromJson(JSONObject jsonObject){
        setUserName((String) jsonObject.get("username"));
        setPassword((String) jsonObject.get("password"));
        setAuthSystem((String) jsonObject.get("authSystem"));
        setOkUrl((String) jsonObject.get("okurl"));
        setErrUrl((String) jsonObject.get("errurl"));
    }

    public JSONObject toJSON(){
        JSONObject jsonObject = new JSONObject();

        if (getUserName()!=null)
        jsonObject.put("username",getUserName());

        if (getPassword()!=null)
        jsonObject.put("password",getPassword());

        if (getAuthSystem()!=null)
        jsonObject.put("authSystem",getAuthSystem());

        if (getOkUrl()!=null)
        jsonObject.put("okurl",getOkUrl());

        if (getErrUrl()!=null)
        jsonObject.put("errurl",getErrUrl());

        return jsonObject;
    }

    @Override
    public String toJSONString() {
        return toJSON().toJSONString();
    }

    public String getOkUrl() {
        return okUrl;
    }

    public void setOkUrl(String okUrl) {
        this.okUrl = okUrl;
    }

    public String getErrUrl() {
        return errUrl;
    }


    public void setErrUrl(String errUrl) {
        this.errUrl = errUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuthSystem() {
        return authSystem;
    }

    public void setAuthSystem(String authSystem) {
        this.authSystem = authSystem;
    }
}

