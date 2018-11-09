package e.sophie.merkatonton;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mCommencerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCommencerButton = (Button) findViewById(R.id.buttonCommencer);
        mCommencerButton.setOnClickListener(CommencerClickListener);
            }


    private View.OnClickListener CommencerClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent inscription_activity = new Intent(MainActivity.this, InscriptionActivity.class);
            startActivity(inscription_activity);
        }
    };
}
