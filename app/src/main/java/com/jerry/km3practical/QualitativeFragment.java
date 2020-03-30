package com.jerry.km3practical;

import android.content.Context;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import java.util.ArrayList;


public class QualitativeFragment extends Fragment {


    private RecyclerView recyclerView;
    private ArrayList<PreliminaryTest> preliminaryContent = new ArrayList<>();;
    Context context;





    public QualitativeFragment() {
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
        View view = inflater.inflate(R.layout.fragment_qualitative, container, false);

        recyclerView = view.findViewById(R.id.recyclrViewPriliminaryTable);


        // method that initalise the adapter
        addContent();

        initializeAdapter();

        WebView webview = view.findViewById(R.id.flameWeb);

        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview.getSettings().setBuiltInZoomControls(true);
        webSettings.setAppCacheEnabled(true);
        webview.loadUrl("file:///android_asset/flame.html");


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView.setHasFixedSize(true);

        LinearLayoutManager lineManger = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(lineManger);






    }

    private void initializeAdapter() {
        PreliminaryRecyclerAdapter  recyclerAdapter = new PreliminaryRecyclerAdapter(preliminaryContent);
        recyclerView.setAdapter(recyclerAdapter);
    }

    private void addContent() {


        preliminaryContent.add(new PreliminaryTest("Blue Substance", "Indicate the presence copper (II) salt."));
        preliminaryContent.add(new PreliminaryTest("Black Substance", "Indicate the presence of an oxide or a sulphide"));
        preliminaryContent.add(new PreliminaryTest("Yellow Substance", "indicate the presence of Lead (II) or iron (III) salt"));
        preliminaryContent.add(new PreliminaryTest("Green Substance", "Indicate the presence of iron (II) or Copper (II) salt."));
        preliminaryContent.add(new PreliminaryTest("Substance Sublimes", " most probably an ammonium halide (e.g., NH4Cl)."));
        preliminaryContent.add(new PreliminaryTest(" Substance is deliquescent", "probably chloride or nitrate is present."));





    }



}
