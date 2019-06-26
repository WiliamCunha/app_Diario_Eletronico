package com.van_hell.app_diario_eletronico;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.van_hell.app_diario_eletronico.Repository.Usuario_Repository;

public class MainActivity extends AppCompatActivity {
    Usuario_Repository usuario_repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario_repository = new Usuario_Repository(this);

        Button btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MenuActivity.class);
                startActivity(intent);

                TextView tLogin = (TextView) findViewById(R.id.tLogin);
                TextView tSenha = (TextView) findViewById(R.id.tSenha);

                String login = tLogin.getText().toString();
                String senha = tSenha.getText().toString();

                if (login.equals("")&&senha.equals("")){
                    alert("Login realizado com sucesso");
                }else{
                    alert("Login ou Senha incorreto ou Cadastrar!");
                }
            }
        });

        Button btn_cadastrar = (Button) findViewById(R.id.btn_cadastrar);
        btn_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),CadastrarActivity.class);
                startActivity(intent);
            }
        });;
    }

    private void alert (String s){
        Toast.makeText(this,s,Toast.LENGTH_LONG).show();
    }

    public void cadastrar(View view) {
    }

    public void login(View view) {

    }
}
