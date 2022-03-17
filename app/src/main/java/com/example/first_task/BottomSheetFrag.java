package com.example.first_task;

import static com.google.android.material.tabs.TabLayout.GRAVITY_FILL;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.first_task.fragments.CalFragment;
import com.example.first_task.fragments.VideoFragment;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class BottomSheetFrag extends BottomSheetDialogFragment {
    FragmentManager context;

    public BottomSheetFrag(FragmentManager context) {
        super();
        this.context = context;
    }

    @SuppressLint({"RestrictedApi", "ResourceType"})
    @Override
    public void setupDialog(Dialog dialog, int style) {
        super.setupDialog(dialog, style);

        //Set the custom view
        ViewGroup activity = null;

        @SuppressLint("InflateParams") View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_bottom_sheet, activity);
        dialog.setContentView(view);
        TabLayout tabLayout;
        ViewPager viewPager;


        viewPager = view.findViewById(R.id.viewPagero);

        tabLayout = view.findViewById(R.id.tabLayout);


        tabLayout.setupWithViewPager(viewPager);

        Adapterom adapterom = new Adapterom(getChildFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        adapterom.addfragment(new CalFragment(), "Calender");
        adapterom.addfragment(new VideoFragment(), "Video picker");
        viewPager.setAdapter(adapterom);

//        //
//
////        tabLayout.addTab(tabLayout.newTab().setCustomView(R.id.itemsa));
//        tabLayout.addTab(tabLayout.newTab().setText("Play"));
//        tabLayout.addTab(tabLayout.newTab().setText("Favourite"));
////        tabLayout.addView(view.findViewById(R.id.itemsa));
//        tabLayout.setTabGravity(GRAVITY_FILL);


//        viewPager.setAdapter(new DemoCollectionPagerAdapter(context));

//        tabLayout.addView(  bottomSheetView = LayoutInflater.from(this.getContext())
//                .inflate(R.layout.tab_first_iem,null
//                    ));
//        final DemoCollectionPagerAdapter adapter = new DemoCollectionPagerAdapter(context);
//        viewPager.setAdapter(adapter);
//        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
//        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                viewPager.setCurrentItem(tab.getPosition());
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//            }
//
//            @Override
//            public void onTabReselected(
//                    TabLayout.Tab tab) {
//            }
//        });


    }


}