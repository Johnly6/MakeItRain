package com.example.makeitrain;

import static com.example.makeitrain.R.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.icu.text.NumberFormat;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private Button makeItRain;
    private Button info;
    private TextView moneyValue;
    private int moneyCounter =0;
    private int colorControl=12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
        makeItRain = findViewById(id.buttonMakeItRain);
        moneyValue =findViewById(id.moneyValue);
        info =findViewById(id.buttonInformation);

        makeItRain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumberFormat numberFormat = NumberFormat.getCurrencyInstance();

                moneyCounter+=200;
                moneyValue.setText(String.valueOf(numberFormat.format(moneyCounter)));
                Log.d("MainActivity", "onClick: "+moneyCounter);

                //                    colorControl += 1;
                switch (moneyCounter) {
                    case 1000:
                        moneyValue.setTextColor(ContextCompat.getColor(MainActivity.this, color.black));
                        break;
                    case 2000:
                        moneyValue.setTextColor(ContextCompat.getColor(MainActivity.this,color.purple_500));
                        break;
                    case 3000:
                        moneyValue.setTextColor(ContextCompat.getColor(MainActivity.this,color.red));
                        break;
                    case 4000:
                        moneyValue.setTextColor(Color.DKGRAY);
                        break;
                    default:
                        moneyValue.setTextColor(Color.WHITE);
                }

                if(moneyCounter%1000==0)
                    Snackbar.make(moneyValue, "You are getting richer by the moment",Snackbar.LENGTH_LONG)
                    .show();
            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
                //Toast.makeText(MainActivity.this, "You currently have "+numberFormat.format(moneyCounter),Toast.LENGTH_LONG)
                //.show();

                Snackbar.make(info,"You currently have"+numberFormat.format(moneyCounter),Snackbar.LENGTH_LONG)
                        .show();
            }
        });
    }
}