package com.pearson.qa.bluesky.csg.books.createOrderDetail.datastructures;

import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

public class CreateOrderDetailRequestPayload implements JSONAware {
    private String orderHeaderId;
    private String cccWorkInst;
    private String publicationYear;
    private String numCopiesStdnts;
    private String numPages;
    private String fromPage;
    private String toPage;
    private String stdnum;
    private String title;
    private String publisherName;
    private String author;
    private String dateOfIssue;
    private String volume;
    private String edition;
    private String chapterArticle;
    private String customerRefNum;

    public void fromJSON(JSONObject jsonObject) {
        setOrderHeaderId((String) jsonObject.get("orderHeaderId"));
        setCccWorkInst((String) jsonObject.get("cccWorkInst"));
        setPublicationYear((String) jsonObject.get("publicationYear"));
        setNumCopiesStdnts((String) jsonObject.get("numCopiesStdnts"));
        setNumPages((String) jsonObject.get("numPages"));
        setFromPage((String) jsonObject.get("fromPage"));
        setToPage((String) jsonObject.get("toPage"));
        setStdnum((String) jsonObject.get("stdnum"));
        setTitle((String) jsonObject.get("title"));
        setPublisherName((String) jsonObject.get("publisherName"));
        setAuthor((String) jsonObject.get("author"));
        setDateOfIssue((String) jsonObject.get("dateOfIssue"));
        setVolume((String) jsonObject.get("volume"));
        setEdition((String) jsonObject.get("edition"));
        setChapterArticle((String) jsonObject.get("chapterArticle"));
        setCustomerRefNum((String) jsonObject.get("customerRefNum"));
    }

    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();
        if (getOrderHeaderId() != null)
            jsonObject.put("orderHeaderId", getOrderHeaderId());
        if (getCccWorkInst() != null)
            jsonObject.put("cccWorkInst", getCccWorkInst());
        if (getPublicationYear() != null)
            jsonObject.put("publicationYear", getPublicationYear());
        if (getNumCopiesStdnts() != null)
            jsonObject.put("numCopiesStdnts", getNumCopiesStdnts());
        if (getNumPages() != null)
            jsonObject.put("numPages", getNumPages());
        if (getFromPage() != null)
            jsonObject.put("fromPage", getFromPage());
        if (getToPage() != null)
            jsonObject.put("toPage", getToPage());
        if (getStdnum() != null)
            jsonObject.put("stdnum", getStdnum());
        if (getTitle() != null)
            jsonObject.put("title", getTitle());
        if (getPublisherName() != null)
            jsonObject.put("publisherName", getPublisherName());
        if (getAuthor() != null)
            jsonObject.put("author", getAuthor());
        if (getDateOfIssue() != null)
            jsonObject.put("dateOfIssue", getDateOfIssue());
        if (getVolume() != null)
            jsonObject.put("volume", getVolume());
        if (getEdition() != null)
            jsonObject.put("edition", getEdition());
        if (getChapterArticle() != null)
            jsonObject.put("chapterArticle", getChapterArticle());
        if (getCustomerRefNum() != null)
            jsonObject.put("customerRefNum", getCustomerRefNum());
        return jsonObject;
    }

    @Override
    public String toJSONString() {
        return toJSON().toJSONString();
    }

    public String getOrderHeaderId() {
        return orderHeaderId;
    }

    public void setOrderHeaderId(String orderHeaderId) {
        this.orderHeaderId = orderHeaderId;
    }

    public String getCccWorkInst() {
        return cccWorkInst;
    }

    public void setCccWorkInst(String cccWorkInst) {
        this.cccWorkInst = cccWorkInst;
    }

    public String getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(String publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getNumCopiesStdnts() {
        return numCopiesStdnts;
    }

    public void setNumCopiesStdnts(String numCopiesStdnts) {
        this.numCopiesStdnts = numCopiesStdnts;
    }

    public String getNumPages() {
        return numPages;
    }

    public void setNumPages(String numPages) {
        this.numPages = numPages;
    }

    public String getFromPage() {
        return fromPage;
    }

    public void setFromPage(String fromPage) {
        this.fromPage = fromPage;
    }

    public String getToPage() {
        return toPage;
    }

    public void setToPage(String toPage) {
        this.toPage = toPage;
    }

    public String getStdnum() {
        return stdnum;
    }

    public void setStdnum(String stdnum) {
        this.stdnum = stdnum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(String dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getChapterArticle() {
        return chapterArticle;
    }

    public void setChapterArticle(String chapterArticle) {
        this.chapterArticle = chapterArticle;
    }

    public String getCustomerRefNum() {
        return customerRefNum;
    }

    public void setCustomerRefNum(String customerRefNum) {
        this.customerRefNum = customerRefNum;
    }
}
