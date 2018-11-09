package e.sophie.merkatonton;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InscriptionActivity extends AppCompatActivity {
    private Button mFbButton;
    private Button mMailButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        mFbButton = (Button) findViewById(R.id.buttonConnexionFb);
        mMailButton = (Button) findViewById(R.id.buttonConnexionMail);

        mMailButton.setOnClickListener(MailClickListener);
    }

    private View.OnClickListener MailClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent inscription_activity = new Intent(InscriptionActivity.this, FormulaireActivity.class);
            startActivity(inscription_activity);
        }
    };
}
