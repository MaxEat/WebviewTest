package com.example.max.webviewtest;

import android.util.Log;
import android.webkit.JavascriptInterface;

import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import static com.example.max.webviewtest.CustomeWebview.pdw;
import static com.example.max.webviewtest.MainActivity.wv;

/**
 * Created by max on 2018/4/17.
 */

public class BorrowedItem {

    private String itemTag;
    private int error = -1;
    private String borrowedTimeStamp;
    private String borrowedLocation;
    private String imageURL;
    private String classification;
    private String returnDate;


    BorrowedItem() {}

    BorrowedItem(String tag) {

        itemTag = tag;
    }

    public void setItemTag(String item) {
        itemTag = item;
    }

    public String getItemTag() {
        return itemTag;
    }

    public int getError() {
        return error;
    }

    public void setError(int e) {
        error = e;
    }

    public void setBorrowedTimeStamp(String borrowedTimeStamp) {
        this.borrowedTimeStamp = borrowedTimeStamp;
    }

    public void setBorrowedLocation(String borrowedLocation) {
        this.borrowedLocation = borrowedLocation;
    }

    public String getBorrowedTimeStamp() {
        return borrowedTimeStamp;
    }

    public String getBorrowedLocation() {
        return borrowedLocation;
    }


    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL( String url) {
        imageURL = url;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }


    public byte[] createJsonBorrowItems(String cardID) throws IOException {
        JSONObject postdata = new JSONObject();
        try {
            postdata.put("cardID", cardID);
            postdata.put("itemTag",  getItemTag());
            postdata.put("borrowLocation",getBorrowedLocation() );
        } catch (JSONException e) {
            e.printStackTrace();
        }
        StringEntity se = new StringEntity(postdata.toString(),"UTF-8");
        se.setContentType("application/json");
        byte[] array = EntityUtils.toByteArray(se);
        return array;
    }

    @JavascriptInterface
    public int parseBorrowItem(String htmlSource) {
        Log.i("HTML", htmlSource);
        try {
            Log.i("error before", Integer.toString(error));
            JSONObject json = new JSONObject(htmlSource);
            error = json.getInt("error_message");
            Log.i("error after",Integer.toString(error));
            return error;


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public String toString() {
        return "Item{" +
                "Location=" + borrowedLocation +
                ", BoughTime=" + borrowedTimeStamp +
                ", Classification="+ classification +
                ", imageUrl=" + imageURL +
                '}';
    }
}
