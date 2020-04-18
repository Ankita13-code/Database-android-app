package com.example.android.studentapp;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ViewModelStudent extends ViewModel{
    private static final DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Student");

    private final FireBaseQueryLiveData liveData = new FireBaseQueryLiveData(reference);

    @NonNull
    public LiveData<DataSnapshot> getDataSnapshotLiveData() {
        return liveData;
    }
}
