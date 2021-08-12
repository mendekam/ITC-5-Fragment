package com.example.itctugasfragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int activeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment1 fragment1 = new Fragment1();
        Fragment fragment = fragmentManager.findFragmentByTag(Fragment1.class.getSimpleName());

        if(!(fragment instanceof Fragment1)){
            fragmentManager.beginTransaction()
                    .add(R.id.fl_mainFrame, fragment1, Fragment1.class.getSimpleName()).commit();
            activeFragment = 1;
        }

        ArrayList<Button> buttons = new ArrayList<>();
        int[] btnId = {
                R.id.btn_fragment1,
                R.id.btn_fragment2,
        };

        for(int i = 0; i < btnId.length; i++){
            buttons.add(findViewById(btnId[i]));
            buttons.get(i).setOnClickListener(this);
        }


    }

    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        switch (v.getId()) {
            case R.id.btn_fragment1:
                if (activeFragment != 1) {
                    fragmentManager.beginTransaction()
                            .replace(R.id.fl_mainFrame, new Fragment1(), Fragment1.class.getSimpleName()).commit();
                    activeFragment = 1;
                }
                break;

            case R.id.btn_fragment2:
                if (activeFragment != 2) {
                    fragmentManager.beginTransaction()
                            .replace(R.id.fl_mainFrame, new Fragment2(), Fragment2.class.getSimpleName()).commit();
                    activeFragment = 2;
                }
                break;
        }
    }
}