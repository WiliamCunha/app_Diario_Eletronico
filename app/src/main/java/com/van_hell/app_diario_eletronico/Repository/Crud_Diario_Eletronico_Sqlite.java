package com.van_hell.app_diario_eletronico.Repository;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Crud_Diario_Eletronico_Sqlite extends SQLiteOpenHelper {

    private static final String DB_name="db_CrudDiario_Eletronico";
    private static final int version = 1;
    private Context _contexto;

    public Crud_Diario_Eletronico_Sqlite( Context context) {
        super(context, DB_name, null, version);
        _contexto=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Aluno_Repository.TB_ALUNO);

        db.execSQL(Professor_Repository.TB_PROFESSOR);

        db.execSQL(Usuario_Repository.TB_Usuario);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String TB_ALUNO = "DROP TABLE IF EXISTS tb_aluno";
        db.execSQL(Aluno_Repository.TB_ALUNO);

        String TB_PROFESSOR = "DROP TABLE IF EXISTS tb_professor";
        db.execSQL(Professor_Repository.TB_PROFESSOR);

        String TB_Usuario = "DROP TABLE IF EXISTS tb_usuario";
        db.execSQL(Usuario_Repository.TB_Usuario);
    }
}
