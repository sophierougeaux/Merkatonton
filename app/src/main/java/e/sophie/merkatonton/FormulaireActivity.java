package e.sophie.merkatonton;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FormulaireActivity extends AppCompatActivity {
    private Button mValiderButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulaire);

        mValiderButton = (Button) findViewById(R.id.buttonValiderFormulaire);
        mValiderButton.setOnClickListener(ValiderClickListener);
    }

    private View.OnClickListener ValiderClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent inscription_activity = new Intent(FormulaireActivity.this, PupitreSelectionActivity.class);
            startActivity(inscription_activity);
        }
    };

    public void home (View view) {
        startActivity(new Intent(this, MainActivity.class));
    }
}
