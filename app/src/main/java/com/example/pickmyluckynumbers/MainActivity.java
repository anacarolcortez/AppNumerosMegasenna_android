package com.example.pickmyluckynumbers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionarBotao(View v){
        List<Integer> numeros = new ArrayList<Integer>();

        TextView txtnum1 = findViewById(R.id.num1);
        txtnum1.setText(""+sortearNumero(numeros));

        TextView txtnum2 = findViewById(R.id.num2);
        txtnum2.setText(""+sortearNumero(numeros));

        TextView txtnum3 = findViewById(R.id.num3);
        txtnum3.setText(""+sortearNumero(numeros));

        TextView txtnum4 = findViewById(R.id.num4);
        txtnum4.setText(""+sortearNumero(numeros));

        TextView txtnum5 = findViewById(R.id.num5);
        txtnum5.setText(""+sortearNumero(numeros));

        TextView txtnum6 = findViewById(R.id.num6);
        txtnum6.setText(""+sortearNumero(numeros));
    }

    public int sortearNumero( List<Integer> numbers){
        Random rand = new Random();
        int magicNumber = rand.nextInt(61)+1;

        for(int num: numbers){
            if (magicNumber != num){
                numbers.add(num);
            } else {
                sortearNumero(numbers);
            }
        }

        return magicNumber;
    }
}