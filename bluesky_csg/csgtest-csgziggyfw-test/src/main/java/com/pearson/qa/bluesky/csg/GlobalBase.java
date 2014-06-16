package com.pearson.qa.bluesky.csg;

import com.google.inject.Injector;
import com.pearson.qa.common.configuration.Configuration;
import org.codehaus.jettison.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dcorrales on 2/28/14.
 */
public class GlobalBase {

    // General Global Variables
    public static Injector injector;
    public static String authToken;
    public static String userId;
    public static String sessionTokenToTest="";



    // Collection section Global variables
    public static String collectionIdGlobal;
    public static String collectionNoteId;
    public static String taxonomyCourseId;

    public static String collectionChapterId; // TODO Brian add here the collection ID that was created in the add collection chapter API test



    // Book section global variables
    public static JSONObject territoriesJSON;
    public static JSONObject schoolByTerritoriesJSON;
    public static List<String> territoriesList = new ArrayList<>();
    public static List<List<String>> schoolsByTerritoriesList = new ArrayList<>();

    // Books - Create Order global variables
    public static String orderHeaderId;
    public static String orderDetailId;


    // Users Global Variables
    public static String newUserResourceId="";

}
