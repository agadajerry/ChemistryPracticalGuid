package com.jerry.km3practical;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class QualitativeAnalysis extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{


    SectionPageAdapter secttionAdapter;
    private ViewPager viewPager;
    TabItem tabQualitative,metallicTab, acidicTab, introTab, labRuleTab, quantitativeTab,volumetricTab;
    Toolbar toolbar;
    ActionBarDrawerToggle actionToggle;
    NavigationView navigationView;
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qualitative_analysis);
        toolbar = findViewById(R.id.toolbar);
        tabQualitative = findViewById(R.id.qualitativeTab);
        metallicTab = findViewById(R.id.metallicRadical);
        acidicTab = findViewById(R.id.acidicRadical);
        introTab = findViewById(R.id.introductionPart);
        labRuleTab = findViewById(R.id.rulesAndRegulation);
        quantitativeTab = findViewById(R.id.quantitativePart);
        volumetricTab = findViewById(R.id.volumetricTab);
        viewPager = findViewById(R.id.container);
        drawer =  findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigate);
        final TabLayout tabLayout = findViewById(R.id.tabLayout);


        setSupportActionBar(toolbar);


        //*********************************************************************************

        actionToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.open, R.string.close);
        drawer.addDrawerListener(actionToggle);
        actionToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
       // getSupportActionBar().setTitle("Chemistry Practical");


      secttionAdapter = new  SectionPageAdapter(getSupportFragmentManager(),tabLayout.getTabCount());

      viewPager.setAdapter(secttionAdapter);

       /// viewPager.setOffscreenPageLimit(secttionAdapter.getCount()>1? secttionAdapter.getCount()-1:1);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){

        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            viewPager.setCurrentItem(tab.getPosition());
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    });

        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));


      //********************************************************************************************************************************

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {


        switch(menuItem.getItemId()){

            case R.id.about:

               Intent aboutIntent = new Intent(QualitativeAnalysis.this, AboutAppAboutApp.class);
               startActivity(aboutIntent);
                break;
            case R.id.exit:

                break;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else{

            super.onBackPressed();

        }
    }

}
