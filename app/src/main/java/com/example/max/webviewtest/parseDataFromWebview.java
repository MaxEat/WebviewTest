package com.example.max.webviewtest;

import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;

import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by max on 2018/4/17.
 */

public class parseDataFromWebview {



    @JavascriptInterface
    public void parseGetAllItems(String htmlSource){

        Log.i("HTML", htmlSource);
        try {

            JSONObject jsonObject = new JSONObject(htmlSource);
            JSONArray jsonArray = jsonObject.getJSONArray("list");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject json = jsonArray.getJSONObject(i);
                BorrowedItem item = new BorrowedItem(json.getString("itemTag"));
                item.setBorrowedTimeStamp(json.getString("borrowTimestamp").substring(0,10));
                item.setBorrowedLocation(json.getString("borrowLocation"));
                item.setImageURL(json.getString("borrowLocation"));
                item.setClassification(json.getString("itemClassification"));
                Log.i(Integer.toString(i),item.toString());

            }
            MainActivity.wv.hide();
        } catch (Throwable t) {
            Log.e("My info", "Could not parse malformed JSON: \"" + htmlSource + "\"");
        }
    }

    @JavascriptInterface
    public void login(String htmlSource){
        Log.i("Js: login", htmlSource);
        try {

            JSONObject obj = new JSONObject(htmlSource);
            String userName = obj.getString("email").split("@")[0].replace(".", " ");
            String studentNumber = obj.getString("user").split("@")[0]; Log.i("user", studentNumber);
            String email = obj.getString("email");
            //TestJson.getUser().setUserName(userName);
//            TestJson.getUser().setEmail(email);
//            TestJson.getUser().setKuleuvenID(studentNumber);
//            TestJson.getUser().register();

        } catch (Throwable t) {
            Log.e("My info", "Could not parse malformed JSON: \"" + htmlSource + "\"");
        }
    }



    public void addToJson(JSONObject postdata, String key, String value) {

        try {
            postdata.put(key, value);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public byte[] createJsonBorrowItems() throws IOException {
        JSONObject postdata = new JSONObject();
        addToJson(postdata,"cardID", "0000");
        addToJson(postdata, "itemTag", "AAA" );
        addToJson(postdata,"borrowLocation","my home" );
        StringEntity se = new StringEntity(postdata.toString(),"UTF-8");
        se.setContentType("application/json");
        byte[] array = EntityUtils.toByteArray(se);
        return array;
    }

    public byte[] createJsonGetItems() throws IOException {
        JSONObject postdata = new JSONObject();
        addToJson(postdata,"kuleuvenID", "r0609260");

        StringEntity se = new StringEntity(postdata.toString(),"UTF-8");
        se.setContentType("application/json");
        byte[] array = EntityUtils.toByteArray(se);
        return array;
    }
}
