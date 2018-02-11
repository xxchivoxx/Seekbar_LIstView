package com.example.carlos.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView lst;
    SeekBar skb;
    ArrayAdapter<String> adaptador;
    int tabla;
    String[] contenido = new String[10];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fnCalularTabla(1);
        tabla=1;
        lst = findViewById(R.id.lst);
        skb = findViewById(R.id.seekBar);
        skb.setMax(20);
        skb.setProgress(tabla);
        adaptador = new ArrayAdapter<String>(
                this,R.layout.support_simple_spinner_dropdown_item,contenido);
        lst.setAdapter(adaptador);

        skb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tabla=i;
                fnCalularTabla(tabla);
                lst.setAdapter(adaptador);
                Toast.makeText(MainActivity.this, ""+contenido[0], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
    public void fnCalularTabla(int t){
        String row="";
        for(int i=1;i<=10;i++){
            row = t+"X"+i+"="+(t*i);
            contenido[i-1]=row+"\n";
        }
    }
}
