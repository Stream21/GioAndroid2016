package antonio.paneladmin;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends Activity implements View.OnClickListener{

    private Button insertar;
    private Button eliminar;
    private Button modificar;
    private Button salir;
    private TextView estado;
    private Bundle datosConexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        datosConexion = getIntent().getExtras();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        insertar = (Button)findViewById(R.id.insertar);
        eliminar = (Button)findViewById(R.id.borrar);
        modificar = (Button)findViewById(R.id.modificar);
        salir = (Button)findViewById(R.id.salir);
        estado = (TextView)findViewById(R.id.userConex);

        insertar.setOnClickListener(this);
        eliminar.setOnClickListener(this);
        modificar.setOnClickListener(this);
        salir.setOnClickListener(this);

        String usuario = datosConexion.getString("usuario");
        estado.setText("LOGGIN: [" + usuario + " ]");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.insertar:
                Intent paso = new Intent(this, Insertar.class);
                startActivity(paso);
                this.finish();
                break;
            case R.id.borrar:
                Intent paso2 = new Intent(this, BorrarRegistro.class);
                startActivity(paso2);
                this.finish();
                break;
            case R.id.modificar:
                break;
            case R.id.salir:
                this.finish();
                break;
        }
    }
}
