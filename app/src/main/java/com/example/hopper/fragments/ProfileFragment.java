package com.example.hopper.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hopper.PostsAdapter;
import com.example.hopper.R;

import java.util.ArrayList;

public class ProfileFragment extends Fragment {
    public static final String TAG = "ProfileFragment";

    private TextView tvContact;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        tvContact = getActivity().findViewById(R.id.tvContact);

        tvContact.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                tvContact.setMovementMethod(LinkMovementMethod.getInstance());
                String text = "<a href='https://github.com/team-blanco/hopper'> Contact Us </a>";
                tvContact.setText(Html.fromHtml(text));
            }
        });
    }

}
