package com.van_hell.app_diario_eletronico.Repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.van_hell.app_diario_eletronico.Model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Usuario_Repository {

    private final String TABLE_NAME = "tb_usuario";
    private  final String[] COLUNAS = new String[]{"id", "usuario_nome", "senha"};
    //serve para padronizar e facilitar correção de erros
    public  static  final String TB_Usuario ="CREATE TABLE tb_usuario (\n" +
            "    id           INTEGER NOT NULL\n" +
            "                         UNIQUE\n" +
            "                         PRIMARY KEY AUTOINCREMENT,\n" +
            "    usuario_nome TEXT    NOT NULL\n" +
            "                         UNIQUE,\n" +
            "    senha        TEXT    NOT NULL\n" +
            ");";

    private Crud_Diario_Eletronico_Sqlite dataBaseHelper;
    SQLiteDatabase dataBase;
    private Context _context;

    public Usuario_Repository(Context context) {
        this.dataBaseHelper = new Crud_Diario_Eletronico_Sqlite(context);
        this.dataBase = dataBaseHelper.getWritableDatabase();
        this._context = context;

    }

    public long Insert(Usuario usuario)
    {
        try {
            ContentValues values = getContentValues(usuario);
            long id = this.dataBase.insert(TABLE_NAME, null, values);
            return id;
        }
        catch (SQLException e){
            Log.e("DiarioEletronico", e.toString());
            Toast.makeText(_context, "Erro ao Inserir usuario:"+ e.getMessage(),Toast.LENGTH_LONG).show();
            return -1;
        }
    }
    //public void Update(Usuario usuario)
    //{
       // ContentValues values =  getContentValues(usuario);
       // String[] argumentos = new String[]{
              //  String.valueOf(usuario.getId())
        //};
       // this.dataBase.update(TABLE_NAME,values,"id?",new String[]{String.valueOf(usuario.getId())});
  // }
    //public void Delete(Usuario usuario)
   // {
       // this.dataBase.delete(TABLE_NAME,"id?",new String[]{String.valueOf(usuario.getId())});
    //}
    // Select id,nomeUsuario,senha from tb_usuario where id=1
   // public Usuario Select(int id)
   // {
        //Usuario usuario = new Usuario();
        //Cursor serve para acessar o banco de dados
       // Cursor cursor = this.dataBase.query(TABLE_NAME,COLUNAS ,"id=?",
         //       new String[]{String.valueOf(id)},null, null, "id");
        //if (cursor.moveToFirst()){
        //    usuario = setUsuarioValues(cursor);
       // }
      //  return usuario;
    //}

   // public List<Usuario> Select()
   // {
    ///    List<Usuario>usuarios = new ArrayList<Usuario>();
     //   Cursor cursor = this.dataBase.query(TABLE_NAME, COLUNAS, null, null,
     //           null, null,"id");
     //   while (cursor.moveToNext()){
      //     usuarios.add(setUsuarioValues(cursor));
       // }
      //  return usuarios;
   // }

    private Usuario setUsuarioValues(Cursor cursor)
    {
        Usuario usuario = new Usuario();
        usuario.setId(cursor.getInt(cursor.getColumnIndex("id")));
        usuario.setUsuario_nome(cursor.getString(cursor.getColumnIndex("usuario_nome")));
        usuario.setSenha(cursor.getString(cursor.getColumnIndex("senha")));
        return usuario;
    }

    //Método criado
    private ContentValues getContentValues(Usuario usuario)
    {
        ContentValues values = new ContentValues();
        values.put("usuario_nome",usuario.getUsuario_nome());
        values.put("senha",usuario.getSenha());
        return values;
    }

    public void FecharConexoes() {
    }

}
