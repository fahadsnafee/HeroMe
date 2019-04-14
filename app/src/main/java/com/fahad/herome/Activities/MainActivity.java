package com.fahad.herome.Activities;

import android.net.Uri;
import android.os.Handler;
import android.support.constraint.solver.widgets.ConstraintAnchor;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.fahad.herome.Fragments.BackStory;
import com.fahad.herome.Fragments.MainFragment;
import com.fahad.herome.Fragments.PickPowerFragment;
import com.fahad.herome.R;

public class MainActivity extends AppCompatActivity implements MainFragment.MainFragmentInteractionListener, PickPowerFragment.PickPowerInteractionListener, BackStory.BackStoryFragmentListener {


    public String POWER_HOW = "Came by Accident";
    public String POWER_PICKED = "Flight";
    public String POWER_ACTUAL = "Flight";
    public String POWER_SECONDARY = "Strength";
    public String HERO_NAME = "Superman";
    public int HERO_STORY = 0;
    public int POWER_SRC = 0;
    public int POWER_SRC_SECONDARY = 0;
    public int HERO_IMG = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager manager = getSupportFragmentManager();

        Fragment fragment = manager.findFragmentById(R.id.fragment_container);

        if (fragment == null) {
            fragment = new MainFragment();
            manager.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
    }

    public void loadPickPowerScreen() {
        PickPowerFragment pickPowerFragment = new PickPowerFragment();
        this.getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, pickPowerFragment)
                .addToBackStack(null).commit();
    }

    public void loadStory() {
        BackStory backStoryFragment = new BackStory();
        this.getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, backStoryFragment)
                .addToBackStack(null).commit();
    }

    public void loadMainScreen() {
        MainFragment mainFragment = new MainFragment();
        this.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, mainFragment).addToBackStack(null).commit();
    }

    @Override
    public void onMainFragmentInteraction(Uri uri) {

    }

    @Override
    public void onPickPowerFragmentInteraction(Uri uri) {

    }

    @Override
    public void onBackStoryFragment(Uri uri) {

    }
}
