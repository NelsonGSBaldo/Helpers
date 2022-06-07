package com.example.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class TelaAjuda extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajuda);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().setTitle("Voltar");     //Titulo para ser exibido na sua Action Bar em frente à seta

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //Botão adicional na ToolBar
        switch (item.getItemId()) {
            case android.R.id.home:  //ID do seu botão (gerado automaticamente pelo android, usando como está, deve funcionar
                startActivity(new Intent(TelaAjuda.this, ProjetoPrincipal.class));  //O efeito ao ser pressionado do botão (no caso abre a activity)
                finishAffinity();  //Método para matar a activity e não deixa-lá indexada na pilhagem
                break;
            default:break;
        }
        return true;
    }

    public void bt_dh(View v){
        Uri uri = Uri.parse("tel:100");
        Intent intent;
        intent = new Intent(Intent.ACTION_CALL,uri);
        // startActivity(intent);

        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);

        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},1);
        } else {
            startActivity(intent);
        }
    }

    public void bt_cvv(View v){
        Uri uri = Uri.parse("tel:188");
        Intent intent;
        intent = new Intent(Intent.ACTION_CALL,uri);
        // startActivity(intent);

        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);

        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},1);
        } else {
            startActivity(intent);
        }
    }

    public void bt_cam(View v){
        Uri uri = Uri.parse("tel:180");
        Intent intent;
        intent = new Intent(Intent.ACTION_CALL,uri);
        // startActivity(intent);

        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);

        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},1);
        } else {
            startActivity(intent);
        }
    }

    public void bt_den(View v){
        Uri uri = Uri.parse("tel:181");
        Intent intent;
        intent = new Intent(Intent.ACTION_CALL,uri);
        // startActivity(intent);

        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);

        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},1);
        } else {
            startActivity(intent);
        }
    }

    public void bt_pm(View v){
        Uri uri = Uri.parse("tel:190");
        Intent intent;
        intent = new Intent(Intent.ACTION_CALL,uri);
        // startActivity(intent);

        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);

        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},1);
        } else {
            startActivity(intent);
        }
    }

    public void bt_samu(View v){
        Uri uri = Uri.parse("tel:192");
        Intent intent;
        intent = new Intent(Intent.ACTION_CALL,uri);
        // startActivity(intent);

        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);

        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},1);
        } else {
            startActivity(intent);
        }
    }

    public void bt_cb(View v){
        Uri uri = Uri.parse("tel:193");
        Intent intent;
        intent = new Intent(Intent.ACTION_CALL,uri);
        // startActivity(intent);

        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);

        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},1);
        } else {
            startActivity(intent);
        }
    }

}
