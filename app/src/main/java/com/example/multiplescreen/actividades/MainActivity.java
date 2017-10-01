package com.example.multiplescreen.actividades;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.multiplescreen.fragmento.DetailsFragment;
import com.example.multiplescreen.fragmento.FragmentIco;
import com.example.multiplescreen.interfaz.OnIconSelected;
import com.example.multiplescreen.R;


public class MainActivity extends AppCompatActivity implements OnIconSelected {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Fragment FragmentIco = new FragmentIco();

        transaction.replace(R.id.container, FragmentIco);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.commit();

    }


    @Override
    public void onIconItemSelected(String name) {
        Toast.makeText(this, name, Toast.LENGTH_LONG).show();
    }


    @Override
    public void onIconItemSelectedDetails(int icon, String text) { //aqui cambie

        View v = findViewById(R.id.container2); // validar container 2 en la vista original

        if (v == null) {
            Intent intent = new Intent(this, SecondActivity.class);

            intent.putExtra(DetailsFragment.ICON_KEY, icon); //aqui cambie
            intent.putExtra(DetailsFragment.TEXT_KEY, text);

            startActivity(intent);

        } else {

            Bundle bundle = new Bundle ();
            bundle.putInt(DetailsFragment.ICON_KEY, icon);
            bundle.putString(DetailsFragment.TEXT_KEY, text);

            DetailsFragment detailsFragment = DetailsFragment.newInstance(bundle);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            transaction.replace(R.id.container2, detailsFragment);
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            transaction.commit();

        }
    }
}

