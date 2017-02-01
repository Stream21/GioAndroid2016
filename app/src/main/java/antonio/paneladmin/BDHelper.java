package antonio.paneladmin;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class BDHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "shop.db";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_CREATE_USUARIOS = "CREATE TABLE usuario IF NOT EXISTS (id NUMERIC(6) NOT NULL, nombre VARCHAR(25) NOT NULL, clave VARCHAR(25) NOT NULL, CONSTRAINT PK_USUARIOS PRIMARY KEY (id));";


    public BDHelper(Context context){
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sql) {

        sql.execSQL(DATABASE_CREATE_USUARIOS);

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
            datos_user.put("password", password);
            rst = db.insert("usuario", null, datos_user);
        }
        return rst;

    }


    }

