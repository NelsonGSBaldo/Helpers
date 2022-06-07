package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class ProjetoPrincipal extends AppCompatActivity {

    private CardView card_ajustes;
    private CardView card_help;
    private CardView card_deslogar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projeto_principal);

        getSupportActionBar().hide();
        IniciarComponentes();

        card_ajustes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProjetoPrincipal.this,TelaAjustes.class);
                startActivity(intent);
            }
        });


        card_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ProjetoPrincipal.this,TelaAjuda.class);
                startActivity(intent);
            }
        });

        card_deslogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(ProjetoPrincipal.this,FormLogin.class);
                startActivity(intent);
                finish();
            }
        });

    }


    private void IniciarComponentes(){

        card_help = findViewById(R.id.card_ajuda);
        card_deslogar = findViewById(R.id.card_sair);
        card_ajustes = findViewById(R.id.card_ajustes);
    }
}