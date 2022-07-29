package com.tu.mostshar11.ui.home1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.tu.mostshar11.R;

public class HomeFragment1 extends Fragment {

    private HomeViewModel1 homeViewModel1;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel1 =
                ViewModelProviders.of(this).get(HomeViewModel1.class);
        View root = inflater.inflate(R.layout.fragment_home1, container, false);
       // final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel1.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
               // textView.setText(s);
            }
        });
        return root;
    }
}
