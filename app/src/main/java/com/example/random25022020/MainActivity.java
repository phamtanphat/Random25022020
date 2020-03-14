package com.example.random25022020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.regex.Matcher;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Math
        // Lam tron
//        Double a = 1.99;
//        long value = Math.round(a);
        // Lam tron len
//        double value1 = Math.ceil(a);
        //Lam tron xuong
//        double value2 = Math.floor(a);
//        Log.d("BBB",String.valueOf(value2));
        // Can hai
//        double b = 9;
//        double value = Math.sqrt(b);
//        Log.d("BBB",String.valueOf(value));
        // Tinh so max va min
//        int a  = 5;
//        int b = 6;
//        int value = Math.max(a,b);
//        Log.d("BBB",String.valueOf(value));
        double value = Math.floor(Math.random()  * 6);
        Log.d("BBB",String.valueOf(value));

    }
}
