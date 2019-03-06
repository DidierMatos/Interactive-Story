package com.nohochdevelopers.interactivestory.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.nohochdevelopers.interactivestory.R;
import com.nohochdevelopers.interactivestory.model.Page;
import com.nohochdevelopers.interactivestory.model.Story;

public class StoryActivity extends AppCompatActivity {

    public static final String TAG = StoryActivity.class.getSimpleName();
    private Story story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        Intent intent = getIntent();
        String name = intent.getStringExtra(getString(R.string.key_name));
        if(name == null && name.isEmpty()){
            name = "Friend";
        }
        Log.d(TAG, name);
        //Toast.makeText(this,name, Toast.LENGTH_SHORT).show();

        story = new Story();
        loadPage(0);



    }

    private void loadPage(int pageNumber) {
        Page page = story.getPage(pageNumber);


    }
}
