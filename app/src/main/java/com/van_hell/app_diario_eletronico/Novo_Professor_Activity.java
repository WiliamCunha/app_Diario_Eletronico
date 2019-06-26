package com.van_hell.app_diario_eletronico;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.van_hell.app_diario_eletronico.Model.Professor;
import com.van_hell.app_diario_eletronico.Repository.Professor_Repository;

public class Novo_Professor_Activity extends AppCompatActivity {

    Professor_Repository professor_repository;
    EditText edtnome, edtcpf, edtmatricula, edtdatanascimento, edtendereco, edtnumero, edtbairro, edttelefone, edtemail, edtsalario, edtdisciplina;
    Button btn_novoprofessor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo__professor_);

        edtnome=findViewById(R.id.edt_professor_nome);
        edtcpf=findViewById(R.id.edt_professor_cpf);
        edtmatricula=findViewById(R.id.edt_professor_matricula);
        edtdatanascimento=findViewById(R.id.edt_professor_datanascimento);
        edtendereco=findViewById(R.id.edt_professor_endereco);
        edtnumero=findViewById(R.id.edt_professor_numero);
        edtbairro=findViewById(R.id.edt_professor_bairro);
        edttelefone=findViewById(R.id.edt_professor_telefone);
        edtemail=findViewById(R.id.edt_professor_email);
        edtsalario=findViewById(R.id.edt_professor_salario);
        edtdisciplina=findViewById(R.id.edt_professor_disciplina);

        btn_novoprofessor=findViewById(R.id.btn_novoprofessor);

        professor_repository=new Professor_Repository(this);
    }

    public void onclikNovoProfessor(View view) {
        Professor professor=new Professor();
        professor.setNome(edtnome.getText().toString());
        professor.setCpf(edtcpf.getText().toString());
        professor.setMatricula(edtmatricula.getText().toString());
        professor.setDatanascimento(edtdatanascimento.getText().toString());
        professor.setEndereco(edtendereco.getText().toString());
        professor.setNumero(Integer.parseInt(edtnumero.getText().toString()));
        professor.setBairro(edtbairro.getText().toString());
        professor.setTelefone(Integer.parseInt(edttelefone.getText().toString()));
        professor.setEmail(edtemail.getText().toString());
        professor.setSalario(edtsalario.getText().toString());
        professor.setDisciplina(edtdisciplina.getText().toString());

        professor_repository.Insert(professor);
        Toast.makeText(this,"Operação Realizada com Sucesso", Toast.LENGTH_LONG).show();
    }
}
