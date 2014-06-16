package com.pearson.qa.bluesky.csg.books.createOrderHeader.datastructures;

import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

/**
 * Created with IntelliJ IDEA.
 * User: dcorrales
 * Date: 2/19/14
 * Time: 9:43 AM
 * To change this template use File | Settings | File Templates.
 */
public class CreateOrderHeaderRequestPayload implements JSONAware {

    String prdAbrv;
    String edInstitution;
    String courseName;
    String startOfTerm;
    String instructorName;
    String courseNumber;
    String acctRefNum;
    String enteredBy;
    String custRefNum;

    @Override
    public String toJSONString() {
        return toJSON().toJSONString();
    }

    public JSONObject toJSON(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("prdAbrv",getPrdAbrv());
        jsonObject.put("edInstitution",getEdInstitution());
        jsonObject.put("courseName",getCourseName());
        jsonObject.put("startOfTerm",getStartOfTerm());
        jsonObject.put("instructorName",getInstructorName());
        jsonObject.put("courseNumber",getCourseNumber());
        jsonObject.put("acctRefNum",getAcctRefNum());
        jsonObject.put("enteredBy",getEnteredBy());
        jsonObject.put("custRefNum",getCustRefNum());

        return jsonObject;
    }
    public void fromJson(JSONObject jsonObject){
        setPrdAbrv((String) jsonObject.get("prdAbrv"));
        setEdInstitution((String) jsonObject.get("edInstitution"));
        setCourseName((String) jsonObject.get("courseName"));
        setStartOfTerm((String) jsonObject.get("startOfTerm"));
        setInstructorName((String) jsonObject.get("instructorName"));
        setCourseNumber((String) jsonObject.get("courseNumber"));
        setAcctRefNum((String) jsonObject.get("acctRefNum"));
        setEnteredBy((String) jsonObject.get("enteredBy"));
        setCustRefNum((String) jsonObject.get("custRefNum"));
    }

    public String getPrdAbrv() {
        return prdAbrv;
    }

    public void setPrdAbrv(String prdAbrv) {
        this.prdAbrv = prdAbrv;
    }

    public String getEdInstitution() {
        return edInstitution;
    }

    public void setEdInstitution(String edInstitution) {
        this.edInstitution = edInstitution;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getStartOfTerm() {
        return startOfTerm;
    }

    public void setStartOfTerm(String startOfTerm) {
        this.startOfTerm = startOfTerm;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getAcctRefNum() {
        return acctRefNum;
    }

    public void setAcctRefNum(String acctRefNum) {
        this.acctRefNum = acctRefNum;
    }

    public String getEnteredBy() {
        return enteredBy;
    }

    public void setEnteredBy(String enteredBy) {
        this.enteredBy = enteredBy;
    }

    public String getCustRefNum() {
        return custRefNum;
    }

    public void setCustRefNum(String custRefNum) {
        this.custRefNum = custRefNum;
    }
}
