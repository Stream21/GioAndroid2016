package antonio.paneladmin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


public class Insertar extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout tablas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar);

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
                EditText textId = new EditText(this);
                textId.setGravity(Gravity.CENTER);
                textId.setLayoutParams(params);
                tablas.addView(textId);

                TextView labelnombre = new TextView(this);
                labelnombre.setText("Nombre");
                labelnombre.setGravity(Gravity.CENTER);
                labelnombre.setLayoutParams(params);
                tablas.addView(labelnombre);
                EditText textNombre = new EditText(this);
                textNombre.setGravity(Gravity.CENTER);
                textNombre.setLayoutParams(params);
                tablas.addView(textNombre);

                TextView labelpassword = new TextView(this);
                labelpassword.setText("Password");
                labelpassword.setGravity(Gravity.CENTER);
                labelpassword.setLayoutParams(params);
                tablas.addView(labelpassword);
                EditText textPassword = new EditText(this);
                textPassword.setGravity(Gravity.CENTER);
                textPassword.setLayoutParams(params);
                tablas.addView(textPassword);
                break;
            case R.id.tableArticulos:
                break;
            default:
                break;
        }
    }
}
