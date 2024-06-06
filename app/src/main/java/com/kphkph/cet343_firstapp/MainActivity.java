package com.kphkph.cet343_firstapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView tvMainDesc;
    Button btn2,btn3,btn4;

    RadioGroup rdgMain;
    RadioButton radioButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initLoad();
        fetchIntentData();

    }

    private void fetchIntentData(){
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            String passedValue = bundle.getString(getApplicationContext().getString(R.string.key_passed_value));
            tvMainDesc.setText(passedValue);
        }
    }


    @SuppressLint("SetTextI18n")
    private void initLoad(){

        tvMainDesc = (TextView) findViewById(R.id.tvMainDescription);

        btn2 = (Button) findViewById(R.id.btnMainTo2);
        btn3 = (Button) findViewById(R.id.btnMainTo3);
        btn4 = (Button) findViewById(R.id.btnMainTo4);


        rdgMain = (RadioGroup) findViewById(R.id.rdgMainActivity);

        rdgMain.setOnCheckedChangeListener((group, checkedId) -> {
            radioButton = findViewById(checkedId);
//            tvMainDesc.setText("Main Activity Value : "+radioButton.getText().toString());
        });

        btn2.setOnClickListener(v -> {
            setNewActivity(SecondActivity.class);
        });

        btn3.setOnClickListener(v -> {
            setNewActivity(ThirdActivity.class);
        });

        btn4.setOnClickListener(v -> {
            setNewActivity(FourthActivity.class);
        });

    }

    private void setNewActivity(Class<?> newActivity){
        Intent intent = new Intent(getApplicationContext(),newActivity);
        intent.putExtra(getApplicationContext().getString(R.string.key_passed_value),"Passed data from second activity : " + radioButton.getText().toString());
        startActivity(intent);
    }

}