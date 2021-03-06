package com.jerry.km3practical;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;


public class LabRules extends Fragment {

    public LabRules() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lab_rules, container, false);
        WebView webView = view.findViewById(R.id.labWeb);
        webView.getSettings().setBuiltInZoomControls(true);
        WebSettings webSetting = webView.getSettings();
        webSetting.setAppCacheEnabled(true);
        webSetting.setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/lab-Rule.html");
        return view;
    }



}
