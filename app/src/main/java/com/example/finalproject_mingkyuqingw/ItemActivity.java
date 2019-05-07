package com.example.finalproject_mingkyuqingw;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ItemActivity extends AppCompatActivity {


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        ActionBar actionBar = getSupportActionBar();
        TextView mDetailTv = findViewById(R.id.item_text_view);

        Intent intent = getIntent();
        String mActionBarTitle = intent.getStringExtra("actionBarTitle");
        String mContent = intent.getStringExtra("contentTv");

        actionBar.setTitle(mActionBarTitle);
        mDetailTv.setText(mContent);
        Button mSubmit = (Button)findViewById(R.id.submit);

        mSubmit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                EditText mEdit = findViewById(R.id.user_comments);
                String value = mEdit.getText().toString();
                TextView mComments = findViewById(R.id.comments_text_view);
                String original = mComments.getText().toString();
                String update = original+" "+value;
                mComments.setText(update);
                Toast.makeText(ItemActivity.this,"Your comments have been submitted!",Toast.LENGTH_SHORT).show();
            }
        });



    }

    public void getDirection(View view){
        Uri gmmIntentUri = Uri.parse("geo:0,0?q=restaurants");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }
}

