package com.alexandre_mateus.github.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alexandre_mateus.github.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class UploadsFragment extends Fragment {

    public UploadsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_uploads, container, false);

        return view;
    }
}
