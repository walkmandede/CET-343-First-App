package com.kphkph.cet343_firstapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    TextView tvSecondDesc;
    Button btnMain,btn3,btn4;

    EditText etSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
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
            tvSecondDesc.setText(passedValue);
        }
    }


    @SuppressLint("SetTextI18n")
    private void initLoad(){

        tvSecondDesc = (TextView) findViewById(R.id.tvSecondDescription);

        btnMain = (Button) findViewById(R.id.btn2ToMain);
        btn3 = (Button) findViewById(R.id.btn2To3);
        btn4 = (Button) findViewById(R.id.btn2To4);


        etSecond = (EditText) findViewById(R.id.etSecond);

        btnMain.setOnClickListener(v -> {
            setNewActivity(MainActivity.class);
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
        intent.putExtra(getApplicationContext().getString(R.string.key_passed_value),"Passed data from second activity : " + etSecond.getText().toString());
        startActivity(intent);
    }
}