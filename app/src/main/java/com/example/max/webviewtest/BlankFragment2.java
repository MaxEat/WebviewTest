package com.example.max.webviewtest;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import static com.example.max.webviewtest.CustomeWebview.pdw;


public class BlankFragment2 extends Fragment{

    public BlankFragment2() {

    }

    public static BlankFragment2 newInstance() {
        BlankFragment2 fragment = new BlankFragment2();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }



    public void borrowItems(WebView wv) throws IOException {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        WebView wv  = MainActivity.wv;

        try {
            BorrowedItem a = new BorrowedItem();
            a.setItemTag("AAAA");
            a.setBorrowedLocation("here");
            a.setError(100);
            byte[] array = a.createJsonBorrowItems("0000");
            wv.postUrl(CustomeWebview.borrowItemURL,array);

        } catch (IOException e) {
            e.printStackTrace();
        }


        return view;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


}
