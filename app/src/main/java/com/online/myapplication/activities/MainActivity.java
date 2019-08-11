package com.online.myapplication.activities;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.Menu;
import android.widget.TextView;

import com.online.myapplication.R;
import com.online.myapplication.adapters.SubjectsRecyclerViewAdapter;
import com.online.myapplication.models.Subject;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private Toolbar mDashboardToolbar;
    private ArrayList<Subject> subjectArrayList;
    private TextView trialPeriodWarning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpToolbar();

        setTrialPeriodWarning("29 Jan 2019");

        prepareSubjectsList();

        setUpSubjectList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;
    }

    private void setTrialPeriodWarning(String date){

        trialPeriodWarning = findViewById(R.id.trial_period_expired_warning_text);

        String warning_1 = "Your free trial expired on ";
        String warning_2 = "\nPlease upgrade now to get full access";
        String warning = warning_1 + date + warning_2;
        Spannable spannable = new SpannableString(warning);
        spannable.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.colorPrimary)),warning_1.length(),(warning_1+date).length(),Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannable.setSpan(new StyleSpan(Typeface.BOLD),warning_1.length(),(warning_1+date).length(),Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        trialPeriodWarning.setText(spannable,TextView.BufferType.SPANNABLE);

    }

    private void setUpToolbar() {
        mDashboardToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mDashboardToolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        mDashboardToolbar.setNavigationIcon(R.drawable.ic_menu_white_24dp);

    }

    private void prepareSubjectsList(){

        subjectArrayList = new ArrayList<>();
        subjectArrayList.add(
                new Subject(
                        "Mental Ability",
                        "",
                        0
                )
        );
        subjectArrayList.add(
                new Subject(
                        "Physics",
                        "",
                        0
                )
        );
        subjectArrayList.add(
                new Subject(
                        "Chemistry",
                        "",
                        0.71
                )
        );
        subjectArrayList.add(
                new Subject(
                        "Mathematics",
                        "",
                        0
                )
        );
        subjectArrayList.add(
                new Subject(
                        "Biology",
                        "",
                        0
                )
        );

    }

    private void setUpSubjectList(){

        RecyclerView recyclerView = findViewById(R.id.subjects_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SubjectsRecyclerViewAdapter cartItemsRecyclerViewAdapter = new SubjectsRecyclerViewAdapter(getApplicationContext(), subjectArrayList);
        recyclerView.setAdapter(cartItemsRecyclerViewAdapter);
        recyclerView.setNestedScrollingEnabled(false);

    }
}
