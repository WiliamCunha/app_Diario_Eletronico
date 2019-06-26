package com.van_hell.app_diario_eletronico;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class UsuarioActivity extends AppCompatActivity {
    RadioButton rd_pais, rd_professor;
    Button bt_entrar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);

        rd_pais = (RadioButton) findViewById(R.id.rd_pais);
        rd_professor = (RadioButton)findViewById(R.id.rd_professor);

        bt_entrar = (Button) findViewById(R.id.btn_entrar);


        bt_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rd_pais.isChecked()){
                    Intent intent = new Intent(getApplicationContext(),List_View_Aluno_Activity.class);
                    startActivity(intent);

                }
                else if (rd_professor.isChecked()){
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                }
            }
        });

    }

    public void entrarUsuario(View view) {
    }
}
