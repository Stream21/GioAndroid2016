package antonio.paneladmin;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class media extends Activity implements View.OnClickListener {
    private Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);

        b = (Button) findViewById(R.id.saltar);
        VideoView videoView = (VideoView) findViewById(R.id.video);
        b.setOnClickListener(this);

        Uri path = Uri.parse("android.resource://antonio.paneladmin/"
                + R.raw.introsample);

        MediaController mc = new MediaController(this);

        videoView.setMediaController(mc);
        videoView.setVideoURI(path);
        videoView.start();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.saltar) {
            Intent i = new Intent(this, Loggin.class);
            startActivity(i);
            this.finish();
        }
    }
}
