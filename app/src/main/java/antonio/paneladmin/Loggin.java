package antonio.paneladmin;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Loggin extends AppCompatActivity implements View.OnClickListener {
    private EditText userLog, passLog;
    private Button salir, login;
    private BDHelper bd;
    private SQLiteDatabase sql;
    private boolean coincidencia = false;
    private Bundle datosUser;
    private Intent paso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggin);

        datosUser = new Bundle();
        paso = new Intent(this, MainActivity.class);

        userLog = (EditText)findViewById(R.id.userLog);
        passLog = (EditText)findViewById(R.id.passWordLog);
        salir = (Button)findViewById(R.id.exit);
        login = (Button)findViewById(R.id.loguear);

        salir.setOnClickListener(this);
        login.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {


        switch (v.getId()){
            case R.id.exit:
                this.finish();
                break;
            case R.id.loguear:
                bd = new BDHelper(this);
                sql = bd.getWritableDatabase();

                String[] datos = new String[]{"nombre", "clave"};
                Cursor c = sql.query("usuario", datos, null, null, null, null, null);
                int registros = c.getCount();

                //Nos aseguramos de que existe al menos un registro
                int i = 0;
                String valor1 = userLog.getText().toString().trim();
                String valor2 = passLog.getText().toString().trim();
                if (c.moveToFirst()) {
                    //Recorremos el cursor hasta que no haya más registros
                    do {
                        String nombre = c.getString(0);
                        String password = c.getString(1);
                        if (nombre.equals(valor1) && password.equals(valor2)) {
                            coincidencia = true;
                            datosUser.putString("usuario", valor1);
                            paso.putExtras(datosUser);
                            startActivity(paso);
                            this.finish();
                        } else {
                        }
                        i++;
                    } while (c.moveToNext());
                }
                if(coincidencia == false){
                    Toast.makeText(this, "No existe el Usuario o Contraseña Incorrecta", Toast.LENGTH_SHORT).show();
                }


                break;
            default:
                break;
        }
    }
}
