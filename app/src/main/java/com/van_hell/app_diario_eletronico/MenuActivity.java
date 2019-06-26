package com.van_hell.app_diario_eletronico;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MenuActivity extends AppCompatActivity {

    ListView ltv_opcoes_menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ltv_opcoes_menu=findViewById(R.id.opcoes_menu_main);
        ltv_opcoes_menu.setOnItemClickListener(escutador_de_clicks);
    }
    AdapterView.OnItemClickListener escutador_de_clicks = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent;
            if (position==0)
            {
                intent = new Intent(MenuActivity.this,ChamadaActivity.class); startActivity(intent);
            }
            else if (position==1)
            {
                intent = new Intent(MenuActivity.this,Novo_Aluno_Activity.class); startActivity(intent);
            }
            else if (position==2)
            {
                intent = new Intent(MenuActivity.this,Novo_Professor_Activity.class); startActivity(intent);
            }
            else if (position==3)
            {
               intent = new Intent(MenuActivity.this,List_View_Aluno_Activity.class); startActivity(intent);
           }
            else if (position==4)
            {
                intent = new Intent(MenuActivity.this,List_View_Professor_Activity.class); startActivity(intent);
            }
            else if (position==5)
            {
                intent = new Intent(MenuActivity.this,Editar_Professor_Activity.class); startActivity(intent);
            }
        }
    };


}
