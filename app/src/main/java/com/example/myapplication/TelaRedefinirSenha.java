package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class TelaRedefinirSenha extends AppCompatActivity {

    private EditText digite_email;
    private Button bt_recuperar;

    String[] mensage = {"Preencha o Email","Email enviado com sucesso!"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_redefinir_senha);

        IniciarComponentes();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().setTitle("Voltar");     //Titulo para ser exibido na sua Action Bar em frente à seta

    bt_recuperar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String digite = digite_email.getText().toString();

            if (digite.isEmpty() ){
                Snackbar snackbar = Snackbar.make(v,mensage[0],Snackbar.LENGTH_SHORT);
                snackbar.setBackgroundTint(Color.WHITE);
                snackbar.setTextColor(Color.BLACK);
                snackbar.show();
            }else{
                Snackbar snackbar = Snackbar.make(v,mensage[1],Snackbar.LENGTH_SHORT);
                snackbar.setBackgroundTint(Color.WHITE);
                snackbar.setTextColor(Color.BLACK);
                snackbar.show();
            }

        }
    });

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //Botão adicional na ToolBar
        switch (item.getItemId()) {
            case android.R.id.home:  //ID do seu botão (gerado automaticamente pelo android, usando como está, deve funcionar
                startActivity(new Intent(TelaRedefinirSenha.this, FormLogin.class));  //O efeito ao ser pressionado do botão (no caso abre a activity)
                finishAffinity();  //Método para matar a activity e não deixa-lá indexada na pilhagem
                break;
            default:break;
        }
        return true;
    }


    private void IniciarComponentes(){
        digite_email = findViewById(R.id.digite_email);
        bt_recuperar = findViewById(R.id.bt_cadastrar);
    }
}
