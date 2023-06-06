package com.example.time_date_pikker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.example.time_date_pikker.databinding.ActivityMainBinding;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    int hour, min,day,month,year;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Calendar calendar = Calendar.getInstance();
        hour = Calendar.HOUR_OF_DAY;
        min = Calendar.MINUTE;


        binding.timesetbtn.setOnClickListener(view -> {
            TimePickerDialog dialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    hour = hourOfDay;
                    min = minute;
                    String am_pm;
//                    if(calendar.get()){
//                        am_pm="am";
//                    }else{
//                        am_pm="pm";
//                    }
                    binding.time.setText("" + hour + ":" + min + ":");
                }
            }, hour, min, false);
            dialog.show();
        });

        binding.datesetbtn.setOnClickListener(view -> {
            DatePickerDialog dialog= new DatePickerDialog (MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                    day=i2;
                    month=i1;
                    year=i;
                    binding.date.setText(day+"/"+month+"/"+year);
                }
            },year,month,day);
            dialog.show();

        });



    }
}