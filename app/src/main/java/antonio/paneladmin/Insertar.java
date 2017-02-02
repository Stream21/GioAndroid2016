package antonio.paneladmin;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.id;
import static android.R.attr.text;


public class Insertar extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout tablas;
    private Button insertar;
    private BDHelper bd;
    private EditText textId, textNombre, textPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar);
        bd = new BDHelper(this);


        Button usuario = (Button)findViewById(R.id.tableUser);
        Button articulos = (Button)findViewById(R.id.tableArticulos);
        tablas = (LinearLayout)findViewById(R.id.panelData);


        usuario.setOnClickListener(this);
        articulos.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tableUser:
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
                params.weight=1.0f;

                TextView labelId = new TextView(this);
                labelId.setText("ID");
                labelId.setGravity(Gravity.CENTER);
                labelId.setLayoutParams(params);
                tablas.addView(labelId);
                textId= new EditText(this);;
                textId.setGravity(Gravity.CENTER);
                textId.setLayoutParams(params);
                textId.setId ('1');
                tablas.addView(textId);

                TextView labelnombre = new TextView(this);
                labelnombre.setText("Nombre");
                labelnombre.setGravity(Gravity.CENTER);
                labelnombre.setLayoutParams(params);
                tablas.addView(labelnombre);
                textNombre = new EditText(this);
                textNombre.setId('2');
                textNombre.setGravity(Gravity.CENTER);
                textNombre.setLayoutParams(params);
                tablas.addView(textNombre);

                TextView labelpassword = new TextView(this);
                labelpassword.setText("Password");
                labelpassword.setGravity(Gravity.CENTER);
                labelpassword.setLayoutParams(params);
                tablas.addView(labelpassword);
                textPassword = new EditText(this);
                textPassword.setId('3');
                textPassword.setGravity(Gravity.CENTER);
                textPassword.setLayoutParams(params);
                tablas.addView(textPassword);

                insertar = new Button(this);
                insertar.setText("Insertar");
                insertar.setId(R.id.insertar);
                insertar.setGravity(Gravity.CENTER);
                insertar.setLayoutParams(params);
                tablas.addView(insertar);
                insertar.setOnClickListener(this);



                break;
            case R.id.tableArticulos:
                tablas.removeAllViews();
                LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
                params2.weight=1.0f;

                TextView labelSku = new TextView(this);
                labelSku.setLayoutParams(params2);
                labelSku.setText("SKU");
                labelSku.setGravity(Gravity.CENTER);
                tablas.addView(labelSku);


                TextView labelName = new TextView(this);
                labelName.setLayoutParams(params2);
                labelName.setText("NOMBRE");
                labelName.setGravity(Gravity.CENTER);
                tablas.addView(labelName);

                TextView labelImg = new TextView(this);
                labelImg.setLayoutParams(params2);
                labelImg.setText("RUTA IMAGEN");
                labelImg.setGravity(Gravity.CENTER);
                tablas.addView(labelImg);


                TextView labelPrecio = new TextView(this);
                labelPrecio.setLayoutParams(params2);
                labelPrecio.setText("PRECIO");
                labelPrecio.setGravity(Gravity.CENTER);
                tablas.addView(labelPrecio);

                TextView labelStock = new TextView(this);
                labelStock.setLayoutParams(params2);
                labelImg.setText("DISPONIBLES");
                labelStock.setGravity(Gravity.CENTER);
                tablas.addView(labelStock);

                break;
            case R.id.insertar:
               SQLiteDatabase sql = bd.getWritableDatabase();
               long rst =  bd.insertarUsuarios(sql,Integer.parseInt(textId.getText().toString()),textNombre.getText().toString(), textPassword.getText().toString());
                Toast.makeText(this, "Registro introducido en la base de datos con exito", Toast.LENGTH_SHORT).show();
            default:
                break;
        }
    }
}
