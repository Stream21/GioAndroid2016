package antonio.paneladmin;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class Insertar extends AppCompatActivity implements View.OnClickListener {
    private String[] imagenes = {"afarcry", "afinalfantasy", "aipad", "amac", "apes", "aresidentseven", "astreet"
    };
    private String check;
    private Spinner fotos;
    private LinearLayout tablas, tablas2, tablas3;
    private Button insertar, usuario, articulos, atras;
    private BDHelper bd;
    private int swap = 3;
    private EditText textId, textNombre, textPassword;
    private EditText textSku, textName, textImg, textPrecio, textStock;
    private Bundle datosConexion;
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar);
        bd = new BDHelper(this);

        insertar = (Button) findViewById(R.id.insertar);
        usuario = (Button) findViewById(R.id.tableUser);
        articulos = (Button) findViewById(R.id.tableArticulos);
        atras = (Button) findViewById(R.id.atras);
        tablas = (LinearLayout) findViewById(R.id.panelData);
        tablas2 = (LinearLayout) findViewById(R.id.infoSpinner);
        tablas3 = (LinearLayout) findViewById(R.id.preview);


        atras.setOnClickListener(this);
        insertar.setOnClickListener(this);
        usuario.setOnClickListener(this);
        articulos.setOnClickListener(this);

        datosConexion = getIntent().getExtras();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tableUser:
                tablas.removeAllViews();
                tablas2.removeAllViews();
                tablas3.removeAllViews();
                usuario.setEnabled(false);
                articulos.setEnabled(true);
                swap = 1;

                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
                params.weight = 1.0f;

                TextView labelId = new TextView(this);
                labelId.setText("ID");
                labelId.setGravity(Gravity.CENTER);
                labelId.setLayoutParams(params);
                tablas.addView(labelId);

                textId = new EditText(this);
                textId.setGravity(Gravity.CENTER);
                textId.setLayoutParams(params);
                tablas.addView(textId);

                TextView labelnombre = new TextView(this);
                labelnombre.setText("Nombre");
                labelnombre.setGravity(Gravity.CENTER);
                labelnombre.setLayoutParams(params);
                tablas.addView(labelnombre);

                textNombre = new EditText(this);
                textNombre.setGravity(Gravity.CENTER);
                textNombre.setLayoutParams(params);
                tablas.addView(textNombre);

                TextView labelpassword = new TextView(this);
                labelpassword.setText("Password");
                labelpassword.setGravity(Gravity.CENTER);
                labelpassword.setLayoutParams(params);
                tablas.addView(labelpassword);

                textPassword = new EditText(this);
                textPassword.setGravity(Gravity.CENTER);
                textPassword.setLayoutParams(params);
                tablas.addView(textPassword);
                break;
            case R.id.tableArticulos:
                tablas.removeAllViews();
                usuario.setEnabled(true);
                articulos.setEnabled(false);
                swap = 2;
                LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
                params2.weight = 1.0f;

                TextView labelSku = new TextView(this);
                labelSku.setLayoutParams(params2);
                labelSku.setText("SKU");
                labelSku.setGravity(Gravity.CENTER);
                tablas.addView(labelSku);

                textSku = new EditText(this);
                textSku.setGravity(Gravity.CENTER);
                textSku.setLayoutParams(params2);
                tablas.addView(textSku);


                TextView labelName = new TextView(this);
                labelName.setLayoutParams(params2);
                labelName.setText("NOMBRE");
                labelName.setGravity(Gravity.CENTER);
                tablas.addView(labelName);

                textName = new EditText(this);
                textName.setGravity(Gravity.CENTER);
                textName.setLayoutParams(params2);
                tablas.addView(textName);


                TextView labelPrecio = new TextView(this);
                labelPrecio.setLayoutParams(params2);
                labelPrecio.setText("PRECIO");
                labelPrecio.setGravity(Gravity.CENTER);
                tablas.addView(labelPrecio);

                textPrecio = new EditText(this);
                textPrecio.setGravity(Gravity.CENTER);
                textPrecio.setLayoutParams(params2);
                tablas.addView(textPrecio);


                TextView labelStock = new TextView(this);
                labelStock.setLayoutParams(params2);
                labelStock.setText("STOCK");
                labelStock.setGravity(Gravity.CENTER);
                tablas.addView(labelStock);

                textStock = new EditText(this);
                textStock.setGravity(Gravity.CENTER);
                textStock.setLayoutParams(params2);
                tablas.addView(textStock);


                LinearLayout.LayoutParams params4 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
                params4.weight = 1.0f;
                params4.gravity = Gravity.CENTER_HORIZONTAL;

                tablas2.setLayoutParams(params4);
                TextView labelImg = new TextView(this);
                labelImg.setLayoutParams(params2);
                labelImg.setText("IMAGEN");
                tablas2.addView(labelImg);

                fotos = new Spinner(this);
                ArrayAdapter imagenesLista = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, imagenes);
                fotos.setAdapter(imagenesLista);
                fotos.setGravity(Gravity.CENTER);
                fotos.setLayoutParams(params4);
                tablas2.addView(fotos);

                fotos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        int position = i;
                        check = imagenes[position];
                        tablas3.removeAllViews();

                        int resID = getResources().getIdentifier(check, "drawable", getPackageName());
                        iv.setImageResource(resID);
                        tablas3.addView(iv);
                    }

                    public void onNothingSelected(AdapterView<?> adapterView) {
                        return;
                    }
                });

                iv = new ImageView(this);
                iv.setLayoutParams(params4);
                tablas3.addView(iv);
                break;
            case R.id.insertar:
                SQLiteDatabase sql = bd.getWritableDatabase();
                if (swap == 1) {
                    bd.insertarUsuarios(sql, Integer.parseInt(textId.getText().toString()), textNombre.getText().toString(), textPassword.getText().toString());
                    Toast.makeText(this, "Registro introducido en la tabla Usuarios con exito", Toast.LENGTH_SHORT).show();
                } else {
                    bd.insertarArticulos(sql, Integer.parseInt(textSku.getText().toString()), textName.getText().toString(), check, Double.parseDouble(textPrecio.getText().toString()), Integer.parseInt(textStock.getText().toString()));
                    Toast.makeText(this, "Registro introducido en la tabla Articulos con exito", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.atras:
                Intent back = new Intent(this, MainActivity.class);
                back.putExtras(datosConexion);
                startActivity(back);
                this.finish();
            default:
                break;
        }
    }

    public void onBackPressed() {

    }
}
