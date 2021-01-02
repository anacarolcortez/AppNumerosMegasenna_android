package com.example.pickmyluckynumbers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
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

        for (int i = 0; i < 6; i++){
            sortearNumero(numeros);
        }

        TextView txtnum1 = findViewById(R.id.num1);
        txtnum1.setText(""+ numeros.get(0));

        TextView txtnum2 = findViewById(R.id.num2);
        txtnum2.setText(""+numeros.get(1));

        TextView txtnum3 = findViewById(R.id.num3);
        txtnum3.setText(""+numeros.get(2));

        TextView txtnum4 = findViewById(R.id.num4);
        txtnum4.setText(""+numeros.get(3));

        TextView txtnum5 = findViewById(R.id.num5);
        txtnum5.setText(""+numeros.get(4));

        TextView txtnum6 = findViewById(R.id.num6);
        txtnum6.setText(""+numeros.get(5));
    }

    public void sortearNumero(List<Integer> numbers){
        Iterator<Integer> n;
        Random rand = new Random();
        int magicNumber = rand.nextInt(61)+1;

        try {
            for(n = numbers.iterator(); n.hasNext();){
                if (n.next() == magicNumber){
                    sortearNumero(numbers);
                }
            }
            numbers.add(magicNumber); //adiciona no caso da lista estar vazia
        } catch (ConcurrentModificationException e){
            System.out.println("exceção");
        }
    }
}