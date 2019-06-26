package com.van_hell.app_diario_eletronico;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.van_hell.app_diario_eletronico.Model.Usuario;
import com.van_hell.app_diario_eletronico.Repository.Usuario_Repository;

public class CadastrarActivity extends AppCompatActivity {

    Usuario_Repository usuario_repository;
    EditText et_usuario_nome, et_senha1, et_senha2;
    Button btn_novousuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        et_usuario_nome =(EditText) findViewById(R.id.et_usuario_nome);
        et_senha1 =(EditText) findViewById(R.id.et_senha1);
        et_senha2 =(EditText) findViewById(R.id.et_senha2);

        btn_novousuario = (Button) findViewById(R.id.btn_novousuario);

        usuario_repository =new Usuario_Repository(this);

        btn_novousuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nomeUsuario = et_usuario_nome.getText().toString();
                String s1 = et_senha1.getText().toString();
                String s2 = et_senha2.getText().toString();

                if (nomeUsuario.equals("")){
                    Toast.makeText(CadastrarActivity.this,"Usuario não inserido, tente novamente", Toast.LENGTH_SHORT).show();
                }
                else if ( s1.equals("")|| s2.equals("")){
                    Toast.makeText(CadastrarActivity.this,"Deve preencher o passoword, tente novamente", Toast.LENGTH_SHORT).show();
                }
                else if (!s1.equals(s2)){
                    Toast.makeText(CadastrarActivity.this, "As senhas não correspondem, tente novamente", Toast.LENGTH_SHORT).show();
                }

                Usuario usuario = new Usuario();
                usuario.setUsuario_nome(et_usuario_nome.getText().toString());
                usuario.setSenha(et_senha1.getText().toString());
                usuario.setSenha(et_senha2.getText().toString());

                usuario_repository.Insert(usuario);
                Toast.makeText(CadastrarActivity.this,"Operação Realizada com Sucesso", Toast.LENGTH_LONG).show();

            }
        });
    }

    public void onclikNovoUsuario(View view) {
        Usuario usuario = new Usuario();
        usuario.setUsuario_nome(et_usuario_nome.getText().toString());
        usuario.setSenha(et_senha1.getText().toString());
        usuario.setSenha(et_senha2.getText().toString());

        usuario_repository.Insert(usuario);
        Toast.makeText(this,"Operação Realizada com Sucesso", Toast.LENGTH_LONG).show();
    }
}
