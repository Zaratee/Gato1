package com.example.zarate.gato;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button pvp;
    private Button pvia;
    private Button ajustes;


    public void Actpvp()
    {
        pvp = (Button) findViewById(R.id.btn_pvp);
        pvp.setOnClickListener(   new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bar = new Intent(MainActivity.this,Act_pvp.class);
                startActivity(bar);
            }
        });
    }

    public void Actpvia()
    {
        pvia = (Button) findViewById(R.id.btn_pvia);
        pvia.setOnClickListener(   new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bar = new Intent(MainActivity.this,Act_pvia.class);
                startActivity(bar);
            }
        });
    }
    public void Actajust()
    {
        ajustes = (Button) findViewById(R.id.btn_ajust);
        ajustes.setOnClickListener(   new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bar = new Intent(MainActivity.this,Act_ajust.class);
                startActivity(bar);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Actpvp();
        Actajust();
        Actpvia();

    }


}
