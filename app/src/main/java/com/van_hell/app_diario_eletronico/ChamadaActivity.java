package com.van_hell.app_diario_eletronico;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import com.van_hell.app_diario_eletronico.Repository.Aluno_Repository;
import com.van_hell.app_diario_eletronico.Repository.Professor_Repository;

public class ChamadaActivity extends AppCompatActivity {
    Aluno_Repository aluno_repository;
    Professor_Repository professor_repository;

    CheckBox cbx1p,cbx2p,cbx3p,cbx4p,cbx5p,cbx6p,cbx7p,
                cbx1f,cbx2f,cbx3f,cbx4f,cbx5f,cbx6f,cbx7f;

    TextView txv1, txv2, txv3, txv4,txv5, txv6,txv7;

    Button btn_salvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chamada);

        cbx1p = (CheckBox) findViewById(R.id.cbx1p);
        cbx2p = (CheckBox) findViewById(R.id.cbx2p);
        cbx3p = (CheckBox) findViewById(R.id.cbx3p);
        cbx4p = (CheckBox) findViewById(R.id.cbx4p);
        cbx5p = (CheckBox) findViewById(R.id.cbx5p);
        cbx6p = (CheckBox) findViewById(R.id.cbx6p);
        cbx7p = (CheckBox) findViewById(R.id.cbx7p);
        cbx1f = (CheckBox) findViewById(R.id.cbx1f);
        cbx2f = (CheckBox) findViewById(R.id.cbx2f);
        cbx3f = (CheckBox) findViewById(R.id.cbx3f);
        cbx4f = (CheckBox) findViewById(R.id.cbx4f);
        cbx5f = (CheckBox) findViewById(R.id.cbx5f);
        cbx6f = (CheckBox) findViewById(R.id.cbx6f);
        cbx7f = (CheckBox) findViewById(R.id.cbx7f);

        txv1 = (TextView) findViewById(R.id.txv1);
        txv2 = (TextView) findViewById(R.id.txv2);
        txv3 = (TextView) findViewById(R.id.txv3);
        txv4 = (TextView) findViewById(R.id.txv4);
        txv5 = (TextView) findViewById(R.id.txv5);
        txv6 = (TextView) findViewById(R.id.txv6);
        txv7 = (TextView) findViewById(R.id.txv7);

        btn_salvar = (Button)findViewById(R.id.btn_salvar);

        btn_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    public void onClick_salvar_chamada(View view) {
    }
}
