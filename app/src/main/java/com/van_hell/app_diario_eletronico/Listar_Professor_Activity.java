package com.van_hell.app_diario_eletronico;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.van_hell.app_diario_eletronico.Model.Professor;
import com.van_hell.app_diario_eletronico.Repository.Professor_Repository;

public class Listar_Professor_Activity extends Activity {

    Professor_Repository professor_repository;
    ListView ltvProfessor;

    ArrayAdapter<Professor> listadeProfessor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar__professor_);

        ltvProfessor = findViewById(R.id.ListView_professor);

        professor_repository = new Professor_Repository(this);

        listadeProfessor = new ArrayAdapter<Professor>(this, android.R.layout.simple_list_item_1, professor_repository.Select());

        ltvProfessor.setAdapter(listadeProfessor);
    }
}
