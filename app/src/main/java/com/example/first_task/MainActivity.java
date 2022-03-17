package com.example.first_task;

import static com.google.android.material.tabs.TabLayout.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    BottomSheetFrag fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         fragment = new BottomSheetFrag(getSupportFragmentManager());
        textView=findViewById(R.id.textView2);
//        textView.setText("hello world");
        FloatingActionButton fab = findViewById(R.id.floatingbutton);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

//                Toast.makeText(getApplicationContext(), " HELLO ", Toast.LENGTH_SHORT).show();
                fragment.show(getSupportFragmentManager(), "TAG");

            }


        });







    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d("/////", "///////// hello halfa");
        if (resultCode == RESULT_OK) {
            if (requestCode == 1) {

                Log.d("/////", "///////// hello halfa 22");

                Uri selectedImageUri = data.getData();

                // OI FILE Manager
//                        filemanagerstring = selectedImageUri.getPath();

                // MEDIA GALLERY
                String selectedImagePath = getPath(selectedImageUri);
                if (selectedImagePath != null) {
                    Log.d("/////", "///////// hello halfa33333");

                    Toast.makeText(getApplicationContext(), selectedImagePath, Toast.LENGTH_LONG).show();
                } else {
                    Log.d("/////", "///////// hello halfa its null");

                }
            }
        } Log.d("/////", "///////// hello halfa empty11");
//        fragment.dismiss();
//        fragment.show(getSupportFragmentManager(), "TAG");

//        textView.setText("hello world");



    }

    public String getPath(Uri uri) {

        String[] projection = {MediaStore.Video.Media.DATA};
        try (Cursor cursor = getContentResolver().query(uri, projection, null, null, null)) {
            if (cursor != null) {
                // HERE YOU WILL GET A NULLPOINTER IF CURSOR IS NULL
                // THIS CAN BE, IF YOU USED OI FILE MANAGER FOR PICKING THE MEDIA
                int column_index = cursor
                        .getColumnIndexOrThrow(MediaStore.Video.Media.DATA);
                cursor.moveToFirst();
                return cursor.getString(column_index);
            } else
                return null;
        }
    }



}



