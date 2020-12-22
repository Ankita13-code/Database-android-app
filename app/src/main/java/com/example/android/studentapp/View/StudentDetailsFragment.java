package com.example.android.studentapp.View;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.studentapp.R;


public class StudentDetailsFragment extends Fragment {



    public StudentDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_student_details, container, false);

        TextView name, enrollNo, branch, bhawan, phone;

        name = view.findViewById(R.id.student_name);
        enrollNo = view.findViewById(R.id.enrollment_number);
        branch = view.findViewById(R.id.branch);
        bhawan = view.findViewById(R.id.bhawan);
        phone = view.findViewById(R.id.phone);

        name.setText(getArguments().getString("Student Name"));
        enrollNo.setText(getArguments().getString("Enroll No."));
        branch.setText(getArguments().getString("Branch"));
        bhawan.setText(getArguments().getString("Bhawan"));
        phone.setText(getArguments().getString("Phone No."));

        return view;
    }




}
