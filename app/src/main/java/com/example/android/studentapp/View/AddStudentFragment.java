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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.studentapp.Model.StudentModel;
import com.example.android.studentapp.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;


public class AddStudentFragment extends Fragment {
    private EditText name, enrollNo, branch, bhawan, phone;
    private DatabaseReference databaseReference;
    Button add ;


    public AddStudentFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_student, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        name = view.findViewById(R.id.student_name);
        enrollNo = view.findViewById(R.id.enrollment_number);
        branch = view.findViewById(R.id.branch);
        bhawan = view.findViewById(R.id.bhawan);
        phone = view.findViewById(R.id.phone);
        add = view.findViewById(R.id.add_bn);



        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                databaseReference = FirebaseDatabase.getInstance().getReference().child("Student").push();
                Map<String, Object> students = new HashMap<>();
                students.put("name", name.getText().toString().trim());
                students.put("enrollNo", enrollNo.getText().toString().trim());
                students.put("branch", branch.getText().toString().trim());
                students.put("bhawan", bhawan.getText().toString().trim());
                students.put("phoneNo", phone.getText().toString().trim() );

                databaseReference.setValue(students).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(getContext(), "Student added ", Toast.LENGTH_LONG).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getContext(), "error occured ", Toast.LENGTH_LONG).show();

                    }
                });
            }
        });



    }


}
