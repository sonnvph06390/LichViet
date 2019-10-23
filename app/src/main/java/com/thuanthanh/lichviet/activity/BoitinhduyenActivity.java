package com.thuanthanh.lichviet.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.thuanthanh.lichviet.R;

import java.util.Calendar;

public class BoitinhduyenActivity extends AppCompatActivity {
    private EditText edName_female, edName_male, edBirthday_female, edBirthday_male;
    private Button btResuilt, btkq;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boitinhduyen);
        initView();

    }

    private void initView() {
        edName_female = findViewById(R.id.edName_female);
        edName_male = findViewById(R.id.edNam_male);
        edBirthday_female = findViewById(R.id.edBirday_female);
        edBirthday_male = findViewById(R.id.edBirday_female);
        btkq = findViewById(R.id.btKq);
        edBirthday_female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
    }

    public void showDialog() {
        Calendar c = Calendar.getInstance();
        int day = c.get(Calendar.DAY_OF_WEEK);
        int month = c.get(Calendar.MONTH);
        int year = c.get(Calendar.DATE);

        dialog = new Dialog(BoitinhduyenActivity.this);
        dialog.setContentView(R.layout.dialog_chonngaysinh_tinhduyen);
        btResuilt = findViewById(R.id.btChonngay);
        final NumberPicker np1 = (NumberPicker) dialog.findViewById(R.id.np1);
        if (np1 != null) {

            np1.setMaxValue(1);
            np1.setMinValue(0);
            final String lunisolar[] = {"Dương", "Âm"};
            np1.setDisplayedValues(lunisolar);
            np1.setWrapSelectorWheel(true);
            np1.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                @Override
                public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                    String text = "Bạn đã chọn: " + lunisolar[i1];
                    Toast.makeText(BoitinhduyenActivity.this, text, Toast.LENGTH_SHORT).show();
                }
            });
        }
        final NumberPicker npDay = (NumberPicker) dialog.findViewById(R.id.npDay);

        npDay.setMinValue(0);
        final String Day[] = {"T.Ba,1", "T.Tư,2", "T.Năm,5", "T.Sáu,6", "T.Bảy,7", "C.Nhật,8"};
        npDay.setMaxValue(Day.length-1);
        npDay.setDisplayedValues(Day);
        npDay.setWrapSelectorWheel(true);

        final NumberPicker npMonth = (NumberPicker) dialog.findViewById(R.id.npMonth);


        final String Month[] = {"Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12"};
        npMonth.setMinValue(0);
        npMonth.setMaxValue(Month.length-1);
        npMonth.setDisplayedValues(Month);

        npMonth.setWrapSelectorWheel(true);

        final NumberPicker npYear = (NumberPicker) dialog.findViewById(R.id.npYear);
        npYear.setMaxValue(2099);
        npYear.setMinValue(1900);
        npYear.setWrapSelectorWheel(true);
//        btResuilt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                edBirthday_female.setText(npDay.getD);
//               dialog.dismiss();
//            }
//        });
        dialog.show();

    }
}
