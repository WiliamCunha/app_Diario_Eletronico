package com.van_hell.app_diario_eletronico;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.van_hell.app_diario_eletronico.Model.Professor;
import com.van_hell.app_diario_eletronico.Repository.Professor_Repository;

public class Editar_Professor_Activity extends Activity {

    EditText edtnome, edtcpf,  edtmatricula, edtdatanascimento, edtendereco, edtnumero, edtbairro, edttelefone, edtemail, edtsalario, edtdisciplina;

    private Professor_Repository professor_repository;
    private int professorid;
    private Professor professor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar__professor_);

        edtnome=findViewById(R.id.edprofessor_nome);
        edtcpf=findViewById(R.id.edprofessor_cpf);
        edtmatricula=findViewById(R.id.edprofessor_matricula);
        edtdatanascimento=findViewById(R.id.edprofessor_datanascimento);
        edtendereco=findViewById(R.id.edprofessor_endereco);
        edtnumero=findViewById(R.id.edprofessor_numero);
        edtbairro=findViewById(R.id.edprofessor_bairro);
        edttelefone=findViewById(R.id.edprofessor_telefone);
        edtemail=findViewById(R.id.edprofessor_email);
        edtsalario=findViewById(R.id.edprofessor_salario);
        edtdisciplina=findViewById(R.id.edprofessor_disciplina);

        professor_repository = new Professor_Repository(this);
        Intent iddoprofessorparaeditar = getIntent();
        professorid = iddoprofessorparaeditar.getExtras().getInt("professorid");

        professor =   professor_repository.Select(professorid);
        preencherProfessor(professor);
    }
    private void preencherProfessor(Professor professor){

        edtnome.setText(professor.getNome());
        edtcpf.setText(professor.getCpf());
        edtmatricula.setText(professor.getMatricula());
        edtdatanascimento.setText(professor.getDatanascimento());
        edtendereco.setText(professor.getEndereco());
        edtnumero.setText(professor.getNumero());
        edtbairro.setText(professor.getBairro());
        edttelefone.setText(professor.getTelefone());
        edtemail.setText(professor.getEmail());
        edtsalario.setText(professor.getSalario());
        edtdisciplina.setText(professor.getDisciplina());

    }

    public void onclickEditarProfessor(View view) {
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

        professor_repository.Update(professor);

        Toast.makeText(this,"Operação realizada com sucesso", Toast.LENGTH_LONG).show();
        Intent listaprofessorintent = new Intent(this, Listar_Professor_Activity.class);
        startActivity(listaprofessorintent);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();

        professor = null;
        professor_repository.FecharConexoes();
    }
}
