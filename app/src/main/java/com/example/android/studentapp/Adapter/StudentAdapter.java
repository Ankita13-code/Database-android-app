package com.example.android.studentapp.Adapter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.studentapp.Model.StudentModel;
import com.example.android.studentapp.R;

import java.util.ArrayList;
import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    private List<StudentModel> student;
    Context context;
    NavController navController;
    Activity activity;

    public StudentAdapter(List<StudentModel> student, Context context, Activity activity) {
        this.student = student;
        this.context = context;
        this.activity = activity;
        navController = Navigation.findNavController(activity, R.id.nav_host_fragment);
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.student_list_item, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        final StudentModel studentModel = student.get(position);
        final List<String> details = new ArrayList<>();

        holder.name_tv.setText(studentModel.getName());
        details.add(studentModel.getName());
        holder.enrollNo_tv.setText(studentModel.getEnrollNo());
        details.add(studentModel.getEnrollNo());
        details.add(studentModel.getBhawan());
        details.add(studentModel.getBranch());
        details.add(studentModel.getPhoneNo());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("Student Name", details.get(0));
                bundle.putString("Enroll No.", details.get(1));
                bundle.putString("Bhawan", details.get(2));
                bundle.putString("Branch", details.get(3));
                bundle.putString("Phone No.", details.get(4));
                navController.navigate(R.id.action_homeFragment_to_studentDetailsFragment, bundle);
            }
        });

    }

    @Override
    public int getItemCount() {
        return student.size();
    }

    class StudentViewHolder extends RecyclerView.ViewHolder{
        private TextView name_tv, enrollNo_tv;

         StudentViewHolder(@NonNull View itemView) {
            super(itemView);

            name_tv = itemView.findViewById(R.id.student_name);
            enrollNo_tv = itemView.findViewById(R.id.enrollment_number);
        }
    }
}
