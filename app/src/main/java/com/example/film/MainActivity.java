package com.example.film;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;

import com.example.film.mainfragment.SearchFragment;
import com.example.film.mainfragment.homeFragment;
import com.example.film.mainfragment.messageFragment;
import com.example.film.mainfragment.notificationFragment;
import com.example.film.mainfragment.personFragment;


import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView navigation;
    private Fragment homeFragment, searchFragment, messageFragment, notificationFragment, personFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        overridePendingTransition(R.anim.fade_inad, R.anim.fade_out);
        navigation = findViewById(R.id.bottom_nav);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        initFragment();
        loadFirstFragment();
    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                loadFragment(homeFragment);
                backStackFragment(homeFragment);
                return true;
            case R.id.navigation_search:
                loadFragment(searchFragment);
                backStackFragment(searchFragment);
                return true;
            case R.id.navigation_message:
                loadFragment(messageFragment);
                backStackFragment(messageFragment);
                return true;
            case R.id.navigation_notification:
                loadFragment(notificationFragment);
                backStackFragment(notificationFragment);
                return true;
            case R.id.navigation_person:
                loadFragment(personFragment);
                backStackFragment(personFragment);
                return true;
        }
        return false;
    };

    private void backStackFragment(Fragment fragment) {
        fragment = getSupportFragmentManager().findFragmentByTag(fragment.getClass().getSimpleName());
        if (fragment != null && fragment.isVisible()) {
            getSupportFragmentManager().popBackStack();
        }
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, fragment, fragment.getClass().getSimpleName());
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void loadFirstFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, homeFragment);
        transaction.commit();
    }

    private void initFragment() {
        homeFragment = new homeFragment();
        searchFragment = new SearchFragment();
        messageFragment = new messageFragment();
        notificationFragment = new notificationFragment();
        personFragment = new personFragment();
    }

    @Override
    public void onBackPressed() {
        if (navigation.getSelectedItemId() == R.id.navigation_home) {
            getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            super.onBackPressed();
        } else {
            navigation.setSelectedItemId(R.id.navigation_home);

        }
    }

}