package antonio.paneladmin;

import android.content.Intent;
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
    private Button insertar,usuario,articulos,atras;
    private BDHelper bd;
    private EditText textId, textNombre, textPassword;
    private EditText textSku, textName, textImg, textPrecio,textStock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar);
        bd = new BDHelper(this);

        insertar = (Button)findViewById(R.id.insertar);
        usuario = (Button)findViewById(R.id.tableUser);
        articulos = (Button)findViewById(R.id.tableArticulos);
        atras = (Button)findViewById(R.id.atras);
        tablas = (LinearLayout)findViewById(R.id.panelData);

        atras.setOnClickListener(this);
        insertar.setOnClickListener(this);
        usuario.setOnClickListener(this);
        articulos.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tableUser:
                usuario.setEnabled(false);
                articulos.setEnabled(true);
                tablas.removeAllViews();
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
                usuario.setEnabled(true);
                articulos.setEnabled(false);
                tablas.removeAllViews();
                LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
                params2.weight=1.0f;

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

                TextView labelImg = new TextView(this);
                labelImg.setLayoutParams(params2);
                labelImg.setText("RUTA");
                labelImg.setGravity(Gravity.CENTER);
                tablas.addView(labelImg);

                textImg = new EditText(this);
                textImg.setGravity(Gravity.CENTER);
                textImg.setLayoutParams(params2);
                tablas.addView(textImg);


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


                break;
            case R.id.insertar:
               SQLiteDatabase sql = bd.getWritableDatabase();

                if(articulos.isActivated()==true){
                    long rst =  bd.insertarUsuarios(sql,Integer.parseInt(textId.getText().toString()),textNombre.getText().toString(), textPassword.getText().toString());
                    Toast.makeText(this, "Registro introducido en la tabla Usuarios con exito", Toast.LENGTH_SHORT).show();
                }else{
                    long rst2 =  bd.insertarArticulos(sql,Integer.parseInt(textSku.getText().toString()),textName.getText().toString(), textImg.getText().toString(), Double.parseDouble(textPrecio.getText().toString()),Integer.parseInt(textStock.getText().toString()));
                    Toast.makeText(this, "Registro introducido en la tabla Articulos con exito", Toast.LENGTH_SHORT).show();
                }
            case R.id.atras:
                Intent back = new Intent(this,MainActivity.class);
                startActivity(back);
                this.finish();
            default:
                break;
        }
    }
}
