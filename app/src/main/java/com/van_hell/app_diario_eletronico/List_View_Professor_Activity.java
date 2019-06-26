package com.van_hell.app_diario_eletronico;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.van_hell.app_diario_eletronico.Model.Professor;
import com.van_hell.app_diario_eletronico.Repository.Professor_Repository;

public class List_View_Professor_Activity extends ListActivity {

    Professor_Repository professor_repository;

    ArrayAdapter<Professor> lista_de_Professores;
    ListView ltvProfessores;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        professor_repository = new Professor_Repository(this);

        lista_de_Professores = new ArrayAdapter<Professor>(this,android.R.layout.simple_list_item_1,professor_repository.Select());

        ltvProfessores =  getListView();
        ltvProfessores.setAdapter(lista_de_Professores);

        ltvProfessores.setOnItemLongClickListener(escutadorLong_declisck);
    }
    AdapterView.OnItemLongClickListener escutadorLong_declisck = new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id)
        {
            Professor professor = lista_de_Professores.getItem(position);
           lista_de_Professores.remove(professor);
            professor_repository.Delete(professor);
            lista_de_Professores.notifyDataSetChanged();
            return false;
        }
    };

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Professor professor = lista_de_Professores.getItem(position);
        Intent alterarInte = new Intent (List_View_Professor_Activity.this, Editar_Professor_Activity.class);
        alterarInte.putExtra("professorid",professor.getId());
        startActivity(alterarInte);

    }
}
