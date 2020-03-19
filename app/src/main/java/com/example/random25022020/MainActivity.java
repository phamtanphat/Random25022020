package com.example.random25022020;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText mEdtSomin,mEdtSomax;
    Button mBtnRandom;
    TextView mTvKetqua;
    String mTextmin,mTextmax;
    int mSmin,mSmax,mValue;
    Random mRandom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEdtSomax = findViewById(R.id.edtSomax);
        mEdtSomin = findViewById(R.id.edtSomin);
        mBtnRandom = findViewById(R.id.btnRandom);
        mTvKetqua = findViewById(R.id.tvKetqua);

        mBtnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTextmin = mEdtSomin.getText().toString();
                mTextmax = mEdtSomax.getText().toString();

                if (mTextmin.equals("") || mTextmax.equals("")){
                    Toast.makeText(MainActivity.this, "Bạn nhập thiếu thông tin", Toast.LENGTH_SHORT).show();
                    return;
                }

                mSmin = Integer.parseInt(mTextmin);
                mSmax = Integer.parseInt(mTextmax);

                // Viet dieu kien theo if else
//                if (smin > smax){
//                    smax = smin + 1;
//                }
                // Viet dieu kien theo toan tu 3 ngoi

                mSmax = mSmin > mSmax ? mSmin + 1 : mSmax;

                mEdtSomax.setText(String.valueOf(mSmax));

                mRandom = new Random();

                mValue = mRandom.nextInt(mSmax - mSmin + 1) + mSmin;

                mTvKetqua.setText(String.valueOf(mValue));

            }
        });

    }
}
