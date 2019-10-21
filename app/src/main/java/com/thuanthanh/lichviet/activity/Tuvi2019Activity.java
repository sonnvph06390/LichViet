package com.thuanthanh.lichviet.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.thuanthanh.lichviet.R;

public class Tuvi2019Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuvi2019);
        anhxa();
        NumberPicker picker1 = (NumberPicker) findViewById(R.id.np1);
        picker1.setMaxValue(2);
        String[] strs1 = {"Nam","Nữ" };
        picker1.setDisplayedValues(strs1);
        picker1.setWrapSelectorWheel(true);
        NumberPicker numberPicker = findViewById(R.id.np2);

        if (numberPicker != null) {
            numberPicker.setMinValue(0);
            numberPicker.setMaxValue(10);
            numberPicker.setWrapSelectorWheel(true);
            numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                @Override
                public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                    String text = "Changed from " + oldVal + " to " + newVal;
                    Toast.makeText(Tuvi2019Activity.this, text, Toast.LENGTH_SHORT).show();
                }
            });
        }
//
    }

    private void anhxa() {

    }
}
