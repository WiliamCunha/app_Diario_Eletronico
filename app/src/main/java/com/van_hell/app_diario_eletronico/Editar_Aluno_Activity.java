package com.van_hell.app_diario_eletronico;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.van_hell.app_diario_eletronico.Model.Aluno;
import com.van_hell.app_diario_eletronico.Repository.Aluno_Repository;

public class Editar_Aluno_Activity extends Activity {

    EditText edtnome, edtcpf, edtrg, edtmatricula, edtdatanascimento, edtpai, edtmae, edtendereco, edtnumero, edtbairro, edttelefone, edtemail;

    private Aluno_Repository aluno_repository;
    private int alunoid;
    private Aluno aluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar__aluno_);

        edtnome=findViewById(R.id.edtaluno_nome);
        edtcpf=findViewById(R.id.edtaluno_cpf);
        edtrg=findViewById(R.id.edtaluno_rg);
        edtmatricula=findViewById(R.id.edtaluno_matricula);
        edtdatanascimento=findViewById(R.id.edtaluno_datanascimento);
        edtpai=findViewById(R.id.edtaluno_pai);
        edtmae=findViewById(R.id.edtaluno_mae);
        edtendereco=findViewById(R.id.edtaluno_enderco);
        edtnumero=findViewById(R.id.edtaluno_numero);
        edtbairro=findViewById(R.id.edtaluno_bairro);
        edttelefone=findViewById(R.id.edtaluno_telefone);
        edtemail=findViewById(R.id.editaraluno_email);

        aluno_repository = new Aluno_Repository(this);
        Intent iddoalunoparaeditar = getIntent();
        alunoid = iddoalunoparaeditar.getExtras().getInt("alunoid");

        aluno =   aluno_repository.Select(alunoid);
        preencherAluno(aluno);

    }

    private void preencherAluno(Aluno aluno){

        edtnome.setText(aluno.getNome());
        edtcpf.setText(aluno.getCpf());
        edtrg.setText(aluno.getRg());
        edtmatricula.setText(aluno.getMatricula());
        edtdatanascimento.setText(aluno.getDatanascimento());
        edtpai.setText(aluno.getPai());
        edtmae.setText(aluno.getMae());
        edtendereco.setText(aluno.getEndereco());
        edtnumero.setText(aluno.getNumero());
        edtbairro.setText(aluno.getBairro());
        edttelefone.setText(aluno.getTelefone());
        edtemail.setText(aluno.getEmail());

    }
    public void onclickEditarAluno(View view) {

        aluno.setNome(edtnome.getText().toString());
        aluno.setCpf(edtcpf.getText().toString());
        aluno.setRg(edtrg.getText().toString());
        aluno.setMatricula(edtmatricula.getText().toString());
        aluno.setDatanascimento(edtdatanascimento.getText().toString());
        aluno.setPai(edtpai.getText().toString());
        aluno.setMae(edtmae.getText().toString());
        aluno.setEndereco(edtendereco.getText().toString());
        aluno.setNumero(Integer.parseInt(edtnumero.getText().toString()));
        aluno.setBairro(edtbairro.getText().toString());
        aluno.setTelefone(Integer.parseInt(edttelefone.getText().toString()));
        aluno.setEmail(edtemail.getText().toString());

        aluno_repository.Update(aluno);

        Toast.makeText(this,"Operação realizada com sucesso", Toast.LENGTH_LONG).show();
        Intent listaalunointent = new Intent(this, Listar_Aluno_Activity.class);
        startActivity(listaalunointent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        aluno = null;
        aluno_repository.FecharConexoes();
    }

}
