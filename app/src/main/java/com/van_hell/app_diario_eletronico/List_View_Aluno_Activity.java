package com.van_hell.app_diario_eletronico;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.van_hell.app_diario_eletronico.Model.Aluno;
import com.van_hell.app_diario_eletronico.Repository.Aluno_Repository;

public class List_View_Aluno_Activity extends ListActivity {

   Aluno_Repository aluno_repository;

    ArrayAdapter<Aluno> lista_de_alunos;
    ListView ltvAlunos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        aluno_repository = new Aluno_Repository(this);

        lista_de_alunos = new ArrayAdapter<Aluno>(this,android.R.layout.simple_list_item_1,aluno_repository.Select());

        ltvAlunos =  getListView();
        ltvAlunos.setAdapter(lista_de_alunos);

        ltvAlunos.setOnItemLongClickListener(escutadorLong_declisck);
    }


    AdapterView.OnItemLongClickListener escutadorLong_declisck = new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id)
        {
            Aluno aluno = lista_de_alunos.getItem(position);
            lista_de_alunos.remove(aluno);
            aluno_repository.Delete(aluno);
            lista_de_alunos.notifyDataSetChanged();
            return false;
        }
    };


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Aluno aluno = lista_de_alunos.getItem(position);
        Intent alterarInte = new Intent (List_View_Aluno_Activity.this, Editar_Aluno_Activity.class);
        alterarInte.putExtra("alunoid",aluno.getId());
        startActivity(alterarInte);

    }
}
