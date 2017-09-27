package com.example.multiplescreen.actividades;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import com.example.multiplescreen.R;
import com.example.multiplescreen.fragmento.DetailsFragment;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondactivity_main);

        Bundle extras = getIntent().getExtras ();

        DetailsFragment detailsFragment = extras != null ? DetailsFragment.newInstance (extras) : DetailsFragment.newInstance (null);

         getSupportFragmentManager()
                .beginTransaction()
                 .replace(R.id.container2,detailsFragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();

    }
}