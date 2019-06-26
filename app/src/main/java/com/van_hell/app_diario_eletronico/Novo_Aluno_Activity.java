package com.van_hell.app_diario_eletronico;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.van_hell.app_diario_eletronico.Model.Aluno;
import com.van_hell.app_diario_eletronico.Repository.Aluno_Repository;

public class Novo_Aluno_Activity extends Activity {

    Aluno_Repository aluno_repository;
    private EditText edtnome, edtcpf, edtrg, edtmatricula, edtdatanascimento, edtpai, edtmae, edtendereco, edtnumero, edtbairro, edttelefone, edtemail;
    Button btnSalvarAluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo__aluno_);

        edtnome=findViewById(R.id.edt_aluno_nome);
        edtcpf=findViewById(R.id.edt_aluno_cpf);
        edtrg=findViewById(R.id.edt_aluno_rg);
        edtmatricula=findViewById(R.id.edt_aluno_matricula);
        edtdatanascimento=findViewById(R.id.edt_aluno_datanascimento);
        edtpai=findViewById(R.id.edt_aluno_pai);
        edtmae=findViewById(R.id.edt_aluno_mae);
        edtendereco=findViewById(R.id.edt_aluno_endereco);
        edtnumero=findViewById(R.id.edt_aluno_numero);
        edtbairro=findViewById(R.id.edt_aluno_bairro);
        edttelefone=findViewById(R.id.edt_aluno_telefone);
        edtemail=findViewById(R.id.edt_aluno_email);

        btnSalvarAluno=findViewById(R.id.btn_novoaluno);

        aluno_repository=new Aluno_Repository(this);
    }
    public void addNovoAluno(View view) {
         Aluno aluno = new Aluno();
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

        aluno_repository.Insert(aluno);
        Toast.makeText(this,"Operação Realizada com SUCESSO" ,Toast.LENGTH_LONG).show();
    }
}
