package com.kphkph.cet343_firstapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class FourthActivity extends AppCompatActivity {

    TextView tvFourthDesc;
    Button btnMain,btn2,btn3;

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    Spinner spinFourth;
    String selectedItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fourth);
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
            tvFourthDesc.setText(passedValue);
        }
    }


    @SuppressLint("SetTextI18n")
    private void initLoad(){

        tvFourthDesc = (TextView) findViewById(R.id.tvFourthDescription);

        btnMain = (Button) findViewById(R.id.btn4ToMain);
        btn2 = (Button) findViewById(R.id.btn4To2);
        btn3 = (Button) findViewById(R.id.btn4To3);


        spinFourth = (Spinner) findViewById(R.id.spinFourth);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.planets_array,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinFourth.setAdapter(adapter);

        spinFourth.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedItem =  parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnMain.setOnClickListener(v -> {
            setNewActivity(MainActivity.class);
        });

        btn2.setOnClickListener(v -> {
            setNewActivity(SecondActivity.class);
        });

        btn3.setOnClickListener(v -> {
            setNewActivity(FourthActivity.class);
        });

    }

    private void setNewActivity(Class<?> newActivity){
        Intent intent = new Intent(getApplicationContext(),newActivity);
        intent.putExtra(getApplicationContext().getString(R.string.key_passed_value),"Passed data from fourth activity : " + selectedItem);
        startActivity(intent);
    }
}