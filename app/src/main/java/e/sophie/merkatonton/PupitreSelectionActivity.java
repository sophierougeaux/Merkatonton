package e.sophie.merkatonton;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PupitreSelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pupitre_selection);
    }

    public void questions_poulpe (View view) {
        startActivity(new Intent(this, QuestionPoulpeActivity.class));
    }

    public void home (View view) {
        startActivity(new Intent(this, MainActivity.class));
    }
}
