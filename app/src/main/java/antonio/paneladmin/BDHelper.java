package antonio.paneladmin;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class BDHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "shop.db";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_CREATE_USUARIOS = "CREATE TABLE IF NOT EXISTS usuario (id NUMERIC(6) NOT NULL, nombre VARCHAR(25) NOT NULL, clave VARCHAR(25) NOT NULL, CONSTRAINT PK_USUARIOS PRIMARY KEY(id));";
    private static final String DATABASE_CREATE_ARTICULOS = "CREATE TABLE IF NOT EXISTS articulo (sku NUMERIC(8) NOT NULL, nombre VARCHAR(25) NOT NULL, img VARCHAR(100) NOT NULL, precio NUMERIC(3,1) NOT NULL,stock NUMERIC(3) NOT NULL, CONSTRAINT PK_ARTICULOS PRIMARY KEY(sku));";

    public BDHelper(Context context){
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sql) {

        sql.execSQL(DATABASE_CREATE_USUARIOS);
        sql.execSQL(DATABASE_CREATE_ARTICULOS);

    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long insertarUsuarios(SQLiteDatabase db, int id, String usuario, String password){

        long rst = 0;
        if(db!=null) {
            ContentValues datos_user = new ContentValues();
            datos_user.put("id", id);
            datos_user.put("nombre", usuario);
            datos_user.put("clave", password);
            rst = db.insert("usuario", null, datos_user);
        }
        return rst;

    }
    public long insertarArticulos(SQLiteDatabase db, int sku, String nombre, String img, double precio, int stock){
        long rst2 = 0;
        if(db!=null){
            ContentValues datos_Articulos = new ContentValues();
            datos_Articulos.put("sku",sku);
            datos_Articulos.put("nombre",nombre);
            datos_Articulos.put("img",img);
            datos_Articulos.put("precio",precio);
            datos_Articulos.put("stock",stock);
            rst2 = db.insert("articulo",null,datos_Articulos);
        }
        return rst2;
    }


    }

