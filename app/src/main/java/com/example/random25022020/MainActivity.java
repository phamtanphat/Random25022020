package com.example.random25022020;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText mEdtSomin, mEdtSomax;
    Button mBtnRandom, mButtonAddBound, mBtnReset;
    TextView mTvKetqua;
    String mTextmin, mTextmax;
    int mSmin, mSmax;
    ArrayList<Integer> mArrayNumbers;
    Random mRandom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEdtSomax = findViewById(R.id.edtSomax);
        mEdtSomin = findViewById(R.id.edtSomin);
        mBtnRandom = findViewById(R.id.btnRandom);
        mTvKetqua = findViewById(R.id.tvKetqua);
        mButtonAddBound = findViewById(R.id.buttonAddBound);
        mBtnReset = findViewById(R.id.buttonReset);
        mArrayNumbers = new ArrayList<>();

        // Task 1 : Random các số không được trùng với nhau
        // Tạo mảng chưa các số từ số min tới sô max
        // Thực hiện random lấy số ngẫu nhiên trong mảng
        // Hiển thị số sau khi random
        // Xóa số này trong mảng để không xuất hiện
        // Task 2 : Khi hết sô random thì thông báo

        mButtonAddBound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Tránh tình trạng click nhiều lần giá trị mảng add giá trị cũ cho nen clear để lấy giá trị mới
                mArrayNumbers.clear();

                //
                mTextmin = mEdtSomin.getText().toString();
                mTextmax = mEdtSomax.getText().toString();

                if (mTextmin.equals("") || mTextmax.equals("")) {
                    Toast.makeText(MainActivity.this, "Bạn nhập thiếu thông tin", Toast.LENGTH_SHORT).show();
                    return;
                }
                mSmin = Integer.parseInt(mTextmin);
                mSmax = Integer.parseInt(mTextmax);

                mSmax = mSmin >= mSmax ? mSmin + 1 : mSmax;
//                mEdtSomax.setText(String.valueOf(mSmax));

                // int count = mSmin;
                //                while (count <= mSmax){
                //                    mArrayNumbers.add(count++);
                //                }
                for (int i = mSmin; i <= mSmax; i++) {
                    mArrayNumbers.add(i);
                }
                if (mArrayNumbers.size() > 1){
                    mEdtSomin.setEnabled(false);
                    mEdtSomax.setEnabled(false);
                    mButtonAddBound.setEnabled(false);
                    Toast.makeText(MainActivity.this, "Thêm sô thành công", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Thêm só thất bại", Toast.LENGTH_SHORT).show();
                }

            }
        });
        mBtnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Reset thành công", Toast.LENGTH_SHORT).show();
                mEdtSomin.setEnabled(true);
                mEdtSomax.setEnabled(true);
                mButtonAddBound.setEnabled(true);
                mEdtSomin.setText("");
                mEdtSomax.setText("");
                mArrayNumbers.clear();
                mTvKetqua.setText("");
                mEdtSomin.requestFocus();
            }
        });

        mBtnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mArrayNumbers.size() > 0 ){
                    mRandom = new Random();
                    int index = mRandom.nextInt(mArrayNumbers.size());
                    int value = mArrayNumbers.get(index);
                    if (mArrayNumbers.size() == 1){
                        mTvKetqua.append(value+"");
                    }else{
                        mTvKetqua.append(value + " - ");
                    }

                    mArrayNumbers.remove(index);
                }else{
                    Toast.makeText(MainActivity.this, "Hết số random", Toast.LENGTH_SHORT).show();
                }

                // Task 2 : Vẽ thêm 1 button ResetBound
//                + Clear dữ liệu trong mảng
//                + Clear dữ liệu trong 2 edittext
//                + Bật enable cho mButtonAddBound , mEdtSomax , mEdtSomin
            }
        });

    }
}
