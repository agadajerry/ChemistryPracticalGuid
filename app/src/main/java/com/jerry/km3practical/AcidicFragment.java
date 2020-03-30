package com.jerry.km3practical;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;


public class AcidicFragment extends Fragment {

    public AcidicFragment() {
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
        View view = inflater.inflate(R.layout.fragment_acidic, container, false);
        WebView webview = view.findViewById(R.id.acidicWeb);
        webview.getSettings().setBuiltInZoomControls(true);
        WebSettings webSettings = webview.getSettings();
        webSettings.setAppCacheEnabled(true);
        webSettings.setJavaScriptEnabled(true);
        webview.loadUrl("file:///android_asset/acidic.html");

        return view;
    }

}
