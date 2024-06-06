package com.kphkph.cet343_firstapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ThirdActivity extends AppCompatActivity {

    TextView tvThirdDesc;
    Button btnMain,btn2,btn4;

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    Switch swThird;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_third);
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
            tvThirdDesc.setText(passedValue);
        }
    }


    @SuppressLint("SetTextI18n")
    private void initLoad(){

        tvThirdDesc = (TextView) findViewById(R.id.tvThirdDescription);

        btnMain = (Button) findViewById(R.id.btn3ToMain);
        btn2 = (Button) findViewById(R.id.btn3To2);
        btn4 = (Button) findViewById(R.id.btn3To4);


        swThird = (Switch) findViewById(R.id.swThird);

        btnMain.setOnClickListener(v -> {
            setNewActivity(MainActivity.class);
        });

        btn2.setOnClickListener(v -> {
            setNewActivity(SecondActivity.class);
        });

        btn4.setOnClickListener(v -> {
            setNewActivity(FourthActivity.class);
        });

    }

    private void setNewActivity(Class<?> newActivity){
        Intent intent = new Intent(getApplicationContext(),newActivity);
        intent.putExtra(getApplicationContext().getString(R.string.key_passed_value),"Passed data from third activity : " + swThird.isChecked());
        startActivity(intent);
    }
}