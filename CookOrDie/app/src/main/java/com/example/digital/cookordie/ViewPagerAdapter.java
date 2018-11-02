package com.example.digital.cookordie;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> fragments;
    private List <Receta> datos;

    public ViewPagerAdapter(FragmentManager fm, List<Fragment> fragments, List<Receta> datos) {
        super(fm);
        this.fragments = new ArrayList<>();
        for (Receta receta : datos) {
            RecetaView recetaView = RecetaView.fabrica(receta);

        }
        this.datos = datos;
    }

    @Override
    public Fragment getItem(int position) {
        return this.fragments.get(position);
    }

    @Override
    public int getCount() {
        return this.fragments.size();
    }


}
