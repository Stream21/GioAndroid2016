package antonio.paneladmin;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

public class BorrarRegistro extends AppCompatActivity {
    private String result[][];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrar_registro);


        //Declarar un objeto del tipo base de datos.
        BDHelper abd = new BDHelper(this);
        SQLiteDatabase db = abd.getWritableDatabase();

        String [] datos = new String[]{"id","nombre","clave"};
        Cursor c = db.query("usuario", datos ,null,null,null,null,null);
        int registros = c.getCount();

        //Resultados Vector bidimensional
        result  = new String [registros][3];


        //Nos aseguramos de que existe al menos un registro
        int i = 0;
        if (c.moveToFirst()) {
            //Recorremos el cursor hasta que no haya más registros
            do {
                String nombre= c.getString(1);
                String url = c.getString(3);
                result[i][1] = nombre;
                i++;
            } while(c.moveToNext());
        }


        String [] tmp = new String[registros];

        for(int h = 0;h<registros;h++){
            tmp[h] = result[h][0];
        }

        /*
        PENDIENTE DE CONFIGURAR LISTVIEW
        ArrayAdapter adaptadorMedia = new ArrayAdapter <String> (this, android.R.layout.simple_spinner_dropdown_item, tmp);
        sp.setAdapter(adaptadorMedia);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int position = i;
                String ruta = result[i][1];
                playVideo(ruta);

            }
            */
    }
}
