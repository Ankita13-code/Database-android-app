package com.example.android.studentapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.studentapp.Adapter.StudentAdapter;
import com.example.android.studentapp.Model.StudentModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private DatabaseReference databaseReference;
    private StudentAdapter studentAdapter;
    private FloatingActionButton floatingActionButton;

    public HomeFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        floatingActionButton = view.findViewById(R.id.fab);
        recyclerView = view.findViewById(R.id.student_recycler_view);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Student");
        ViewModelStudent viewModelStudent = ViewModelProviders.of(this).get(ViewModelStudent.class);
        LiveData<DataSnapshot> liveData = viewModelStudent.getDataSnapshotLiveData();
        liveData.observe(getViewLifecycleOwner(), new Observer<DataSnapshot>() {
            @Override
            public void onChanged(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {

                    databaseReference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                             List<StudentModel> list = new ArrayList<>();
                             for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                                 StudentModel s = dataSnapshot1.getValue(StudentModel.class);
                                 list.add(s);
                             }
                             studentAdapter = new StudentAdapter(list, getContext(),getActivity());

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });


                    RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setAdapter(studentAdapter);
                }
            }


        });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.action_homeFragment_to_addStudentFragment);

            }
        });

        return view;
    }
    }


