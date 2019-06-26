package com.van_hell.app_diario_eletronico.Repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.van_hell.app_diario_eletronico.Model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class Aluno_Repository {
    private final String TABLE_NAME = "tb_aluno";
    private  final String[] COLUNAS = new String[]{"id", "nome","cpf","rg","matricula","datanascimento","pai","mae","endereco","numero","bairro","telefone","email"};
    //serve para padronizar e facilitar correção de erros
    public  static  final String TB_ALUNO ="CREATE TABLE tb_aluno (\n" +
            "    id             INTEGER PRIMARY KEY AUTOINCREMENT\n" +
            "                           UNIQUE\n" +
            "                           NOT NULL,\n" +
            "    nome           TEXT    NOT NULL,\n" +
            "    cpf            TEXT    NOT NULL,\n" +
            "    rg             TEXT NOT NULL,\n" +
            "    matricula      TEXT    NOT NULL\n" +
            "                           UNIQUE,\n" +
            "    datanascimento REAL    NOT NULL,\n" +
            "    pai            TEXT,\n" +
            "    mae            TEXT    NOT NULL,\n" +
            "    endereco        TEXT    NOT NULL,\n" +
            "    numero         NUMERIC,\n" +
            "    bairro         TEXT    NOT NULL,\n" +
            "    telefone       NUMERIC NOT NULL,\n" +
            "    email          TEXT\n" +
            ");";

    private Crud_Diario_Eletronico_Sqlite dataBaseHelper;
    SQLiteDatabase dataBase;
    private Context _context;

    public Aluno_Repository(Context context) {
        this.dataBaseHelper = new Crud_Diario_Eletronico_Sqlite(context);
        this.dataBase = dataBaseHelper.getWritableDatabase();
        this._context = context;
    }
    public long Insert(Aluno aluno)
    {
        try {
            ContentValues values = getContentValues(aluno);
            long id = this.dataBase.insert(TABLE_NAME, null, values);
            return id;
        }
        catch (SQLException e){
            Log.e("Diario_Eletronico", e.toString());
            Toast.makeText(_context, "Erro ao Inserir aluno:"+ e.getMessage(),Toast.LENGTH_LONG).show();
            return -1;        }
    }
    public void Update(Aluno aluno)
    {
        ContentValues values =  getContentValues(aluno);
        String[] argumentos = new String[]{
                String.valueOf(aluno.getId())
        };
        this.dataBase.update(TABLE_NAME,values,"id?",new String[]{String.valueOf(aluno.getId())});
    }
    public void Delete(Aluno aluno)
    {
        this.dataBase.delete(TABLE_NAME,"id?",new String[]{String.valueOf(aluno.getId())});
    }
    // Select id,nome,email,idade from tb_aluno where id=1
    public Aluno Select(int id)
    {
        Aluno aluno = new Aluno();
        //Cursor serve para acessar o banco de dados
        Cursor cursor = this.dataBase.query(TABLE_NAME,COLUNAS ,"id=?",
                new String[]{String.valueOf(id)},null, null, "id");
        if (cursor.moveToFirst()){
            aluno = setAlunoValues(cursor);
        }
        return aluno;
    }
    public List<Aluno> Select()
    {
        List<Aluno>alunos = new ArrayList<Aluno>();
        Cursor cursor = this.dataBase.query(TABLE_NAME, COLUNAS, null, null,
                null, null,"id");
        while (cursor.moveToNext()){
            alunos.add(setAlunoValues(cursor));
        }
        return alunos;
    }
    private Aluno setAlunoValues(Cursor cursor)
    {
        Aluno aluno = new Aluno();
        aluno.setId(cursor.getInt(cursor.getColumnIndex("id")));
        aluno.setNome(cursor.getString(cursor.getColumnIndex("nome")));
        aluno.setCpf(cursor.getString(cursor.getColumnIndex("cpf")));
        aluno.setRg(cursor.getString(cursor.getColumnIndex("rg")));
        aluno.setMatricula(cursor.getString(cursor.getColumnIndex("matricula")));
        aluno.setDatanascimento(cursor.getString(cursor.getColumnIndex("datanascimento")));
        aluno.setPai(cursor.getString(cursor.getColumnIndex("pai")));
        aluno.setMae(cursor.getString(cursor.getColumnIndex("mae")));
        aluno.setEndereco(cursor.getString(cursor.getColumnIndex("endereco")));
        aluno.setNumero(cursor.getInt(cursor.getColumnIndex("numero")));
        aluno.setBairro(cursor.getString(cursor.getColumnIndex("bairro")));
        aluno.setTelefone(cursor.getInt(cursor.getColumnIndex("telefone")));
        aluno.setEmail(cursor.getString(cursor.getColumnIndex("email")));
        return aluno;
    }
    //Método criado
    private ContentValues getContentValues(Aluno aluno)
    {
        ContentValues values = new ContentValues();
        values.put("nome",aluno.getNome());
        values.put("cpf",aluno.getCpf());
        values.put("rg",aluno.getRg());
        values.put("matricula",aluno.getMatricula());
        values.put("datanascimento",aluno.getDatanascimento());
        values.put("pai",aluno.getPai());
        values.put("mae",aluno.getMae());
        values.put("endereco",aluno.getEndereco());
        values.put("numero",aluno.getNumero());
        values.put("bairro",aluno.getBairro());
        values.put("telefone",aluno.getTelefone());
        values.put("email",aluno.getEmail());
        return values;
    }
    public void FecharConexoes() {
    }
}
