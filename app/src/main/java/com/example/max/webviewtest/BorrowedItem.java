package com.example.max.webviewtest;

import android.util.Log;
import android.webkit.JavascriptInterface;

import org.json.JSONException;
import org.json.JSONObject;

import static com.example.max.webviewtest.CustomeWebview.pdw;
import static com.example.max.webviewtest.MainActivity.wv;

/**
 * Created by max on 2018/4/17.
 */

public class BorrowedItem {

    private String itemTag;
    private String borrowedTimeStamp;
    private String borrowedLocation;
    private String imageURL;
    private String classification;
    private String returnDate;


    BorrowedItem() {}

    BorrowedItem(String tag) {

        itemTag = tag;
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


    @JavascriptInterface
    public void parseBorrowItem(String htmlSource) {
        Log.i("HTML", htmlSource);
        try {
            JSONObject json = new JSONObject(htmlSource);
            int error = json.getInt("error_message");
            Log.i("error", Integer.toString(error));
        } catch (JSONException e) {
            e.printStackTrace();
        }
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
