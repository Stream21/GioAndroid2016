package antonio.paneladmin;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

public class BorrarRegistro extends AppCompatActivity implements View.OnClickListener {
    private Button bArticulos, bUsuarios, bAtras, bSalir;
    private static String result[][];
    private static ListView listDates;
    private BDHelper abd;
    private SQLiteDatabase db;
    private static int indicador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrar_registro);

        //Declarar Botones
        bArticulos = (Button) findViewById(R.id.bArticulos);
        bUsuarios = (Button) findViewById(R.id.bUsuarios);
        bSalir = (Button) findViewById(R.id.bSalir);
        bAtras = (Button) findViewById(R.id.bAtras);

        //Declarar ListView
        listDates = (ListView) findViewById(R.id.ListView_listado);

        //Escuchas
        bArticulos.setOnClickListener(this);
        bUsuarios.setOnClickListener(this);
        bAtras.setOnClickListener(this);
        bSalir.setOnClickListener(this);

        //Eventos Del ListView
        listDates.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                indicador = position;

            }
        });

    }
        @Override
        public void onClick (View v){
            switch (v.getId()) {
                case R.id.bUsuarios:
                    bUsuarios.setEnabled(false);
                    bArticulos.setEnabled(true);
                    //resultadoPreparado();
                    cargarUsuarios();
                    break;
                case R.id.bArticulos:
                    break;
                case R.id.bAtras:
                    Intent paso = new Intent(this, MainActivity.class);
                    startActivity(paso);
                    this.finish();
                    break;
                case R.id.bSalir:
                    this.finish();
                    break;
            }
        }

        public void cargarUsuarios() {
            ArrayList<Lista_entrada> p1 = new ArrayList<Lista_entrada>();
            abd = new BDHelper(this);
            db = abd.getWritableDatabase();

            String[] datos = new String[]{"id", "nombre", "clave"};
            Cursor c = db.query("usuario", datos, null, null, null, null, null);
            int registros = c.getCount();

            //Resultados Vector bidimensional
            result = new String[registros][3];


            //Nos aseguramos de que existe al menos un registro
            int i = 0;
            if (c.moveToFirst()) {
                //Recorremos el cursor hasta que no haya más registros
                do {
                    String id = c.getString(0);
                    String nombre = c.getString(1);
                    String password = c.getString(2);
                    result[i][0] = id;
                    result[i][1] = nombre;
                    result[i][2] = password;
                    p1.add(new Lista_entrada(R.drawable.foto, result[i][1], result[i][2]));
                    i++;
                } while (c.moveToNext());
            }

            listDates= (ListView) findViewById(R.id.ListView_listado);
            listDates.setAdapter(new Lista_adaptador(this, R.layout.entrada, p1){
                @Override
                public void onEntrada(Object entrada, View view) {
                    if (entrada != null) {
                        TextView texto_superior_entrada = (TextView) view.findViewById(R.id.textView_superior);
                        if (texto_superior_entrada != null)
                            texto_superior_entrada.setText("Usuario: " + ((Lista_entrada) entrada).get_textoEncima());

                        TextView texto_inferior_entrada = (TextView) view.findViewById(R.id.textView_inferior);
                        if (texto_inferior_entrada != null)
                            texto_inferior_entrada.setText("PassWord: "+ ((Lista_entrada) entrada).get_textoDebajo());

                        ImageView imagen_entrada = (ImageView) view.findViewById(R.id.imageView_imagen);
                        if (imagen_entrada != null)
                            imagen_entrada.setImageResource(((Lista_entrada) entrada).get_idImagen());
                    }
                }
            });
            listDates.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> pariente, View view, int posicion, long id) {
                    Lista_entrada elegido = (Lista_entrada) pariente.getItemAtPosition(posicion);

                    String [] dateId = new String[]{result[posicion][0]};
                    db.execSQL("DELETE FROM usuario WHERE id=?", dateId);
                    db.close();
                    abd.close();;
                    cargarUsuarios();
                    Toast.makeText(BorrarRegistro.this, "BORRADO", Toast.LENGTH_SHORT).show();

                }
            });

        }
    public void cargarArtículo() {
        ArrayList<Lista_entrada> p1 = new ArrayList<Lista_entrada>();
        abd = new BDHelper(this);
        db = abd.getWritableDatabase();

        String[] datos = new String[]{"sku", "nombre", "img","precio","stock"};
        Cursor c = db.query("usuario", datos, null, null, null, null, null);
        int registros = c.getCount();

        //Resultados Vector bidimensional
        result = new String[registros][3];


        //Nos aseguramos de que existe al menos un registro
        int i = 0;
        if (c.moveToFirst()) {
            //Recorremos el cursor hasta que no haya más registros
            do {
                String id = c.getString(0);
                String nombre = c.getString(1);
                String password = c.getString(2);
                result[i][0] = id;
                result[i][1] = nombre;
                result[i][2] = password;
                p1.add(new Lista_entrada(R.drawable.foto, result[i][1], result[i][2]));
                i++;
            } while (c.moveToNext());
        }

        listDates= (ListView) findViewById(R.id.ListView_listado);
        listDates.setAdapter(new Lista_adaptador(this, R.layout.entrada, p1){
            @Override
            public void onEntrada(Object entrada, View view) {
                if (entrada != null) {
                    TextView texto_superior_entrada = (TextView) view.findViewById(R.id.textView_superior);
                    if (texto_superior_entrada != null)
                        texto_superior_entrada.setText("Usuario: " + ((Lista_entrada) entrada).get_textoEncima());

                    TextView texto_inferior_entrada = (TextView) view.findViewById(R.id.textView_inferior);
                    if (texto_inferior_entrada != null)
                        texto_inferior_entrada.setText("PassWord: "+ ((Lista_entrada) entrada).get_textoDebajo());

                    ImageView imagen_entrada = (ImageView) view.findViewById(R.id.imageView_imagen);
                    if (imagen_entrada != null)
                        imagen_entrada.setImageResource(((Lista_entrada) entrada).get_idImagen());
                }
            }
        });
        listDates.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> pariente, View view, int posicion, long id) {
                Lista_entrada elegido = (Lista_entrada) pariente.getItemAtPosition(posicion);

                String [] dateId = new String[]{result[posicion][0]};
                db.execSQL("DELETE FROM usuario WHERE id=?", dateId);
                db.close();
                abd.close();;
                cargarUsuarios();
                Toast.makeText(BorrarRegistro.this, "BORRADO", Toast.LENGTH_SHORT).show();

            }
        });

    }
}


