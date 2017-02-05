package antonio.paneladmin;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends Activity implements View.OnClickListener{

    private Button insertar;
    private Button eliminar;
    private Button modificar;
    private Button salir;
    private TextView estado;
    private Bundle datosConexion;
    private Intent paso, paso2;

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

        paso = new Intent(this, Insertar.class);
        paso2 = new Intent(this, BorrarRegistro.class);
        paso.putExtras(datosConexion);
        paso2.putExtras(datosConexion);

        if(usuario.equals("Arnaudis")){
            estado.setText("LOGGIN: [" + usuario + " ] - AMARILLO ES SU COLOR");
        }else{
            estado.setText("LOGGIN: [" + usuario + " ]");
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.insertar:
                startActivity(paso);
                this.finish();
                break;
            case R.id.borrar:
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
