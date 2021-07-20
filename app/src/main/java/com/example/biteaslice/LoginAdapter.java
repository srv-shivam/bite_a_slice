package com.example.biteaslice;

import android.content.ComponentCallbacks;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import org.jetbrains.annotations.NotNull;


public class LoginAdapter extends FragmentPagerAdapter {

    Context context;
    int totalTabs;

    public LoginAdapter(@NonNull @NotNull FragmentManager fm, Context context, int totalTabs) {
        super(fm);
        this.context = context;
        this.totalTabs = totalTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new LoginTabFragment();
            case 1:
                return new SignupTabFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
