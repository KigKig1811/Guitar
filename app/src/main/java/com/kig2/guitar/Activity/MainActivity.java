package com.kig2.guitar.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListView;

import android.widget.ViewFlipper;

import com.google.android.material.navigation.NavigationView;
import com.kig2.guitar.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    ViewFlipper viewFlipper;
    RecyclerView recyclerViewHome;
    NavigationView navigationViewHome;
    ListView listViewHome;
    DrawerLayout drawerLayoutHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Mapping();
        ActionBar();
        ActionViewFlipper();
    }

    private void ActionViewFlipper() {
        ArrayList<String> mangQuangCao = new ArrayList<>();
        mangQuangCao.add("https://i.pinimg.com/originals/12/5f/24/125f240406307e86944af329408638c8.jpg");
        mangQuangCao.add("http://pianominhthanh.vn/upload/image/danh%20muc/banner-dan-guitar-01-jpg.jpg");
        mangQuangCao.add("https://guitardaklak.com/wp-content/uploads/2020/06/shop-mua-ban-dan-guitar-banner-02.jpg");
        mangQuangCao.add("https://www.itl.cat/pngfile/big/238-2386430_guitar-youtube-banner.jpg");
        for (int i=0;i<mangQuangCao.size();i++){
            ImageView imageView = new ImageView(getApplicationContext());
            Picasso.get().load(mangQuangCao.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(3000);
        viewFlipper.setAutoStart(true);

        Animation animation_slide_in =AnimationUtils.loadAnimation(getApplicationContext(),R.anim.silde_in_right );
        Animation animation_slide_out =AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_out_right );
        viewFlipper.setInAnimation(animation_slide_in);
        viewFlipper.setOutAnimation(animation_slide_out);
    }

    private void ActionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 drawerLayoutHome.openDrawer(GravityCompat.START);
            }
        });
    }



    private void Mapping() {
        toolbar = (androidx.appcompat.widget.Toolbar)findViewById(R.id.toolbarhome);
        viewFlipper = findViewById(R.id.viewFlipper);
        recyclerViewHome = findViewById(R.id.recyclerView);
        navigationViewHome = findViewById(R.id.navigationViewHome);
        listViewHome = findViewById(R.id.listViewHome);
        drawerLayoutHome = findViewById(R.id.drawerLayoutHome);

    }
}