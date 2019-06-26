package com.van_hell.app_diario_eletronico;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.van_hell.app_diario_eletronico.Model.Aluno;
import com.van_hell.app_diario_eletronico.Repository.Aluno_Repository;

public class Listar_Aluno_Activity extends Activity {

    Aluno_Repository aluno_repository;
    ListView ltvAluno;

    ArrayAdapter<Aluno> listadeAlnos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar__aluno_);

        ltvAluno = findViewById(R.id.ListView_alunos);

        aluno_repository = new Aluno_Repository(this);

        listadeAlnos = new ArrayAdapter<Aluno>(this, android.R.layout.simple_list_item_1, aluno_repository.Select());

        ltvAluno.setAdapter(listadeAlnos);
    }

}
