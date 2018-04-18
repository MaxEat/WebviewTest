package com.example.max.webviewtest;

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

import org.json.JSONObject;

import java.io.IOException;

import static com.example.max.webviewtest.CustomeWebview.pdw;


public class BlankFragment extends Fragment {



    public BlankFragment() {

    }
    public static BlankFragment newInstance() {
        BlankFragment fragment = new BlankFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public void login(WebView wv){
        wv.loadUrl("https://labtools.groept.be/inventory/secure");
    }

    public void getAllItems(WebView wv) throws IOException {
        byte[] array = pdw.createJsonGetItems();
        wv.postUrl(CustomeWebview.getAllBorrowedItemsURL,array);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        WebView wv  = MainActivity.wv;


        login(wv);

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
