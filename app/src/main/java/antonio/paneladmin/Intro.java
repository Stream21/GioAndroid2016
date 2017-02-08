package antonio.paneladmin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


public class Intro extends Activity {
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        new Handler().postDelayed(new Runnable() {
            public void run() {

                intent = new Intent(Intro.this, media.class);
                startActivity(intent);
                finish();
            }
        }, 5000);
    }

    public void onBackPressed() {

    }
}
