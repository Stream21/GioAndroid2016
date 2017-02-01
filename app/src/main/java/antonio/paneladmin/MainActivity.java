package antonio.paneladmin;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity implements View.OnClickListener{

    private Button insertar;
    private Button eliminar;
    private Button modificar;
    private Button salir;
    private BDHelper bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        insertar = (Button)findViewById(R.id.insertar);
        eliminar = (Button)findViewById(R.id.borrar);
        modificar = (Button)findViewById(R.id.modificar);
        salir = (Button)findViewById(R.id.salir);

        insertar.setOnClickListener(this);
        eliminar.setOnClickListener(this);
        modificar.setOnClickListener(this);
        salir.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.insertar:
                Intent paso = new Intent(this, Insertar.class);
                startActivity(paso);
                break;
            case R.id.borrar:
                break;
            case R.id.modificar:
                break;
            case R.id.salir:
                break;
        }
    }
}
