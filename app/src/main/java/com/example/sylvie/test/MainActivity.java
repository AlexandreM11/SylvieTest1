package com.example.sylvie.test;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mWordInput;
    private Button mPlayButton;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWordInput = (EditText) findViewById (R.id.activity_main_word_input);
        mPlayButton = (Button) findViewById (R.id.activity_main_play_btn);

        mPlayButton.setEnabled(false);

        mWordInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after ) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mPlayButton.setEnabled(s.toString().length() !=0);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });


        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Handler().postDelayed(new Runnable(){
                    @Override
                    public void run() {

                        Toast.makeText(getApplicationContext(), mWordInput.getText().toString(), Toast.LENGTH_SHORT).show();

                        mWordInput.setText("");

                    }
                },5000);

            }
        });

    }
}
