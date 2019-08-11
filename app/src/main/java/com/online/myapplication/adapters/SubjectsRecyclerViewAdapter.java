package com.online.myapplication.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.online.myapplication.R;
import com.online.myapplication.models.Subject;

import java.util.ArrayList;

public class SubjectsRecyclerViewAdapter extends RecyclerView.Adapter<SubjectsRecyclerViewAdapter.ViewHolder> {

    private LayoutInflater mInflater;
    private ArrayList<Subject> subjects;

    public SubjectsRecyclerViewAdapter(Context context, ArrayList<Subject> subjects){
        mInflater = LayoutInflater.from(context);
        this.subjects = subjects;
    }

    @NonNull
    @Override
    public SubjectsRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.subject_list_row_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull SubjectsRecyclerViewAdapter.ViewHolder viewHolder, int i) {

        Subject subject = subjects.get(i);

        viewHolder.subjectName.setText(subject.getName());
        viewHolder.progressPercent.setText(subject.getProgressPercent()+"%");
        viewHolder.subjectImage.setImageResource(R.drawable.ic_bulb_outline_blue_80dp);

    }

    @Override
    public int getItemCount() {
        return subjects.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView subjectName, progressPercent;
        ImageView subjectImage;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            subjectImage = itemView.findViewById(R.id.subject_image);
            subjectName = itemView.findViewById(R.id.subject_name_text);
            progressPercent = itemView.findViewById(R.id.progress_percent);
        }
    }
}
