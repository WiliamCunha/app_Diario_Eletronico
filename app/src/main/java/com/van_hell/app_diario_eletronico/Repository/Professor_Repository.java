package com.van_hell.app_diario_eletronico.Repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.van_hell.app_diario_eletronico.Model.Professor;

import java.util.ArrayList;
import java.util.List;

public class Professor_Repository {
    private final String TABLE_NAME = "tb_professor";
    private  final String[] COLUNAS = new String[]{"id", "nome","cpf","matricula","datanascimento","endereco","numero","bairro","telefone","email","salario","disciplina"};
    //serve para padronizar e facilitar correção de erros
    public  static  final String TB_PROFESSOR ="CREATE TABLE tb_professor (\n" +
            "    id             INTEGER PRIMARY KEY AUTOINCREMENT\n" +
            "                           NOT NULL\n" +
            "                           UNIQUE,\n" +
            "    nome           TEXT    NOT NULL,\n" +
            "    cpf            TEXT    NOT NULL\n" +
            "                           UNIQUE,\n" +
            "    matricula      TEXT    NOT NULL\n" +
            "                           UNIQUE,\n" +
            "    datanascimento REAL    NOT NULL,\n" +
            "    endereco       TEXT    NOT NULL,\n" +
            "    numero         NUMERIC,\n" +
            "    bairro         TEXT    NOT NULL,\n" +
            "    telefone       NUMERIC NOT NULL,\n" +
            "    email          TEXT    NOT NULL,\n" +
            "    salario        REAL    NOT NULL,\n" +
            "    disciplina     TEXT    NOT NULL\n" +
            ");";
    private Crud_Diario_Eletronico_Sqlite dataBaseHelper;
    SQLiteDatabase dataBase;
    private Context _context;

    public Professor_Repository(Context context) {
        this.dataBaseHelper = new Crud_Diario_Eletronico_Sqlite(context);
        this.dataBase = dataBaseHelper.getWritableDatabase();
        this._context = context;

    }

    public long Insert(Professor professor)
    {
        try {
            ContentValues values = getContentValues(professor);
            long id = this.dataBase.insert(TABLE_NAME, null, values);
            return id;
        }
        catch (SQLException e){
            Log.e("DiarioEletronico", e.toString());
            Toast.makeText(_context, "Erro ao Inserir professor:"+ e.getMessage(),Toast.LENGTH_LONG).show();
            return -1;
        }
    }
    public void Update(Professor professor)
    {
        ContentValues values =  getContentValues(professor);
        String[] argumentos = new String[]{
                String.valueOf(professor.getId())
        };
        this.dataBase.update(TABLE_NAME,values,"id?",new String[]{String.valueOf(professor.getId())});
    }
    public void Delete(Professor professor)
    {
        this.dataBase.delete(TABLE_NAME,"id?",new String[]{String.valueOf(professor.getId())});
    }
    // Select id,nome,email,idade from tb_professor where id=1
    public Professor Select(int id)
    {
        Professor professor = new Professor();
        //Cursor serve para acessar o banco de dados
        Cursor cursor = this.dataBase.query(TABLE_NAME,COLUNAS ,"id=?",
                new String[]{String.valueOf(id)},null, null, "id");
        if (cursor.moveToFirst()){
            professor= setProfessorValues(cursor);
        }
        return professor;
    }

    public List<Professor> Select()
    {
        List<Professor>professor = new ArrayList<Professor>();
        Cursor cursor = this.dataBase.query(TABLE_NAME, COLUNAS, null, null,
                null, null,"id");
        while (cursor.moveToNext()){
            professor.add(setProfessorValues(cursor));
        }
        return professor;
    }

    private Professor setProfessorValues(Cursor cursor)
    {
        Professor professor = new Professor();
        professor.setId(cursor.getInt(cursor.getColumnIndex("id")));
        professor.setNome(cursor.getString(cursor.getColumnIndex("nome")));
        professor.setCpf(cursor.getString(cursor.getColumnIndex("cpf")));
        professor.setMatricula(cursor.getString(cursor.getColumnIndex("matricula")));
        professor.setDatanascimento(cursor.getString(cursor.getColumnIndex("datanascimento")));
        professor.setEndereco(cursor.getString(cursor.getColumnIndex("endereco")));
        professor.setNumero(cursor.getInt(cursor.getColumnIndex("numero")));
        professor.setBairro(cursor.getString(cursor.getColumnIndex("bairro")));
        professor.setTelefone(cursor.getInt(cursor.getColumnIndex("telefone")));
        professor.setEmail(cursor.getString(cursor.getColumnIndex("email")));
        return professor;
    }

    //Método criado
    private ContentValues getContentValues(Professor professor)
    {
        ContentValues values = new ContentValues();
        values.put("nome",professor.getNome());
        values.put("cpf",professor.getCpf());
        values.put("matricula",professor.getMatricula());
        values.put("datanascimento",professor.getDatanascimento());
        values.put("endereco",professor.getEndereco());
        values.put("numero",professor.getNumero());
        values.put("bairro",professor.getBairro());
        values.put("telefone",professor.getTelefone());
        values.put("email",professor.getEmail());
        values.put("salario",professor.getSalario());
        values.put("disciplina",professor.getDisciplina());
        return values;
    }

    public void FecharConexoes() {
    }
}
