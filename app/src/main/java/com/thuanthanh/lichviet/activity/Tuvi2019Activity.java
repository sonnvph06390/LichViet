package com.thuanthanh.lichviet.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import com.thuanthanh.lichviet.R;

public class Tuvi2019Activity extends AppCompatActivity {
    private Toolbar toolbar;
    private ImageView imgToolbar;
    private TextView tvToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuvi2019);
        anhxa();
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        imgToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        NumberPicker picker1 = (NumberPicker) findViewById(R.id.np1);
        if (picker1 != null) {


            picker1.setMinValue(0);
            picker1.setMaxValue(1);
            final String[] strs1 = {"Nam", "Nữ"};
            picker1.setDisplayedValues(strs1);
            picker1.setWrapSelectorWheel(true);
            picker1.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                @Override
                public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                    String text = "Bạn đã chọn: " + strs1[i1];
                    Toast.makeText(Tuvi2019Activity.this, text, Toast.LENGTH_SHORT).show();
                }
            });
        }
        NumberPicker numberPicker = findViewById(R.id.np2);
        if (numberPicker != null) {
            numberPicker.setMinValue(1970);
            numberPicker.setMaxValue(2003);
            numberPicker.setWrapSelectorWheel(true);
            numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                @Override
                public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                    String text = "Bạn đã chọn: " + newVal;
                    Toast.makeText(Tuvi2019Activity.this, text, Toast.LENGTH_SHORT).show();
                }
            });
        }

    }

    private void anhxa() {
        imgToolbar = findViewById(R.id.imgtoolbar);
        tvToolbar = findViewById(R.id.tvToolbar);
    }
}
