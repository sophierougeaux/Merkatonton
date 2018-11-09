package e.sophie.merkatonton;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import java.io.IOException;

import android.support.design.widget.Snackbar;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class QuestionPoulpeActivity extends AppCompatActivity implements Callback {

    boolean Q1b1false;
    boolean Q1b2true;
    boolean Q2b1false;
    boolean Q2b2true;
    boolean Q3b1true;
    boolean Q3b2false;


    public SharedPreferences prefs;
    private String urlom = "http://192.168.43.234:8080/~/in-cse/in-name";
    private Snackbar snackbar;
    private final OkHttpClient client = new OkHttpClient();
    private TextView resultsTextViewn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        resultsTextViewn = new TextView(this);
        setContentView(R.layout.activity_question_poulpe);
        resultsTextViewn = findViewById(R.id.textView7);
        ;
        snackbar = Snackbar.make(findViewById(android.R.id.content), "Requête en cours d'exécution",
                Snackbar.LENGTH_INDEFINITE);


        Context context = getApplicationContext();
        prefs = PreferenceManager.getDefaultSharedPreferences(context);

        Chronometer simpleChronometer = (Chronometer) findViewById(R.id.simpleChronometer); // initiate a chronometer

        simpleChronometer.start(); // start a chronometer



/*

        CheckBox Q1b1 = findViewById(R.id.checkBox1);
        Q1b1false = prefs.getBoolean("Q1b1false", false);  //default is true
        if (Q1b1false == true) {
            Q1b1.setChecked(true);
        } else {
            Q1b1.setChecked(false);
        }

        CheckBox Q1b2 = findViewById(R.id.checkBox2);
        Q1b2true = prefs.getBoolean("Q1b2true", false);  //default is true
        if (Q1b2true == true) {
            Q1b2.setChecked(true);
        } else {
            Q1b2.setChecked(false);
        }


        CheckBox Q2b1 = findViewById(R.id.checkBox3);
        Q2b1false = prefs.getBoolean("Q2b1false", false);  //default is true
        if (Q2b1false == true) {
            Q2b1.setChecked(true);
        } else {
            Q2b1.setChecked(false);
        }

        CheckBox Q2b2 = findViewById(R.id.checkBox4);
        Q2b2true = prefs.getBoolean("Q2b2true", false);  //default is true
        if (Q2b2true == true) {
            Q2b2.setChecked(true);
        } else {
            Q2b2.setChecked(false);
        }

        CheckBox Q3b1 = findViewById(R.id.checkBox5);
        Q3b1true = prefs.getBoolean("Q3b1true", false);  //default is true
        if (Q3b1true == true) {
            Q3b1.setChecked(true);
        } else {
            Q3b1.setChecked(false);
        }

        CheckBox Q3b2 = findViewById(R.id.checkBox6);
        Q3b2false = prefs.getBoolean("Q3b2false", false);  //default is true
        if (Q3b2false == true) {
            Q3b2.setChecked(true);
        } else {
            Q3b2.setChecked(false);
        }

*/

    }

    public void Q1b1false(View view) {
        if (!isConnected()) {
            Snackbar.make(view, "Aucune connexion à internet.", Snackbar.LENGTH_LONG).show();
            return;
        }

        // LED1 is on
        snackbar.show();
        String urlomMOTSO = urlom + "/LED1/DATA";
        MediaType XML = MediaType.parse("application/xml;ty=4");
        RequestBody body = RequestBody.create(XML, "<m2m:cin xmlns:m2m=\"http://www.onem2m.org/xml/protocols\">\n" +
                "    <cnf>message</cnf>\n" +
                "    <con>\n" +
                "      &lt;obj&gt;\n" +
                "        &lt;str name=&quot;appId&quot; val=&quot;MOTOR1&quot;/&gt;\n" +
                "        &lt;str name=&quot;category&quot; val=&quot;Servomotor &quot;/&gt;\n" +
                "        &lt;int name=&quot;data&quot; val=&quot;1&quot;/&gt;\n" +
                "        &lt;int name=&quot;unit&quot; val=&quot;1ON&quot;/&gt;\n" +
                "      &lt;/obj&gt;\n" +
                "    </con>\n" +
                "</m2m:cin>");

        Request request = new Request.Builder()
                .url(urlomMOTSO)
                .header("X-M2M-Origin", "admin:admin")
                .addHeader("Content-Type", "application/xml;ty=4")
                .post(body)
                .build();

        client.newCall(request).enqueue(this);


        // LED2 is off
        snackbar.show();
        urlomMOTSO = urlom + "/LED2/DATA";
        XML = MediaType.parse("application/xml;ty=4");
        body = RequestBody.create(XML, "<m2m:cin xmlns:m2m=\"http://www.onem2m.org/xml/protocols\">\n" +
                "    <cnf>message</cnf>\n" +
                "    <con>\n" +
                "      &lt;obj&gt;\n" +
                "        &lt;str name=&quot;appId&quot; val=&quot;MOTOR1&quot;/&gt;\n" +
                "        &lt;str name=&quot;category&quot; val=&quot;Servomotor &quot;/&gt;\n" +
                "        &lt;int name=&quot;data&quot; val=&quot;0&quot;/&gt;\n" +
                "        &lt;int name=&quot;unit&quot; val=&quot;0OFF&quot;/&gt;\n" +
                "      &lt;/obj&gt;\n" +
                "    </con>\n" +
                "</m2m:cin>");

        request = new Request.Builder()
                .url(urlomMOTSO)
                .header("X-M2M-Origin", "admin:admin")
                .addHeader("Content-Type", "application/xml;ty=4")
                .post(body)
                .build();

        client.newCall(request).enqueue(this);
    }


    public void Q1b2true(View view) {
        if (!isConnected()) {
            Snackbar.make(view, "Aucune connexion à internet.", Snackbar.LENGTH_LONG).show();
            return;
        }

        // LED1 is off
        snackbar.show();
        String urlomMOTSO = urlom + "/LED1/DATA";
        MediaType XML = MediaType.parse("application/xml;ty=4");
        RequestBody body = RequestBody.create(XML, "<m2m:cin xmlns:m2m=\"http://www.onem2m.org/xml/protocols\">\n" +
                "    <cnf>message</cnf>\n" +
                "    <con>\n" +
                "      &lt;obj&gt;\n" +
                "        &lt;str name=&quot;appId&quot; val=&quot;MOTOR1&quot;/&gt;\n" +
                "        &lt;str name=&quot;category&quot; val=&quot;Servomotor &quot;/&gt;\n" +
                "        &lt;int name=&quot;data&quot; val=&quot;0&quot;/&gt;\n" +
                "        &lt;int name=&quot;unit&quot; val=&quot;0OFF&quot;/&gt;\n" +
                "      &lt;/obj&gt;\n" +
                "    </con>\n" +
                "</m2m:cin>");

        Request request = new Request.Builder()
                .url(urlomMOTSO)
                .header("X-M2M-Origin", "admin:admin")
                .addHeader("Content-Type", "application/xml;ty=4")
                .post(body)
                .build();

        client.newCall(request).enqueue(this);


        // LED2 is on
        snackbar.show();
        urlomMOTSO = urlom + "/LED2/DATA";
        XML = MediaType.parse("application/xml;ty=4");
        body = RequestBody.create(XML, "<m2m:cin xmlns:m2m=\"http://www.onem2m.org/xml/protocols\">\n" +
                "    <cnf>message</cnf>\n" +
                "    <con>\n" +
                "      &lt;obj&gt;\n" +
                "        &lt;str name=&quot;appId&quot; val=&quot;MOTOR1&quot;/&gt;\n" +
                "        &lt;str name=&quot;category&quot; val=&quot;Servomotor &quot;/&gt;\n" +
                "        &lt;int name=&quot;data&quot; val=&quot;1&quot;/&gt;\n" +
                "        &lt;int name=&quot;unit&quot; val=&quot;1ON&quot;/&gt;\n" +
                "      &lt;/obj&gt;\n" +
                "    </con>\n" +
                "</m2m:cin>");

        request = new Request.Builder()
                .url(urlomMOTSO)
                .header("X-M2M-Origin", "admin:admin")
                .addHeader("Content-Type", "application/xml;ty=4")
                .post(body)
                .build();

        client.newCall(request).enqueue(this);

    }

    public void Q2b1false(View view) {
        if (!isConnected()) {
            Snackbar.make(view, "Aucune connexion à internet.", Snackbar.LENGTH_LONG).show();
            return;
        }

        // LED3 is on
        snackbar.show();
        String urlomMOTSO = urlom + "/LED3/DATA";
        MediaType XML = MediaType.parse("application/xml;ty=4");
        RequestBody body = RequestBody.create(XML, "<m2m:cin xmlns:m2m=\"http://www.onem2m.org/xml/protocols\">\n" +
                "    <cnf>message</cnf>\n" +
                "    <con>\n" +
                "      &lt;obj&gt;\n" +
                "        &lt;str name=&quot;appId&quot; val=&quot;MOTOR1&quot;/&gt;\n" +
                "        &lt;str name=&quot;category&quot; val=&quot;Servomotor &quot;/&gt;\n" +
                "        &lt;int name=&quot;data&quot; val=&quot;1&quot;/&gt;\n" +
                "        &lt;int name=&quot;unit&quot; val=&quot;1ON&quot;/&gt;\n" +
                "      &lt;/obj&gt;\n" +
                "    </con>\n" +
                "</m2m:cin>");

        Request request = new Request.Builder()
                .url(urlomMOTSO)
                .header("X-M2M-Origin", "admin:admin")
                .addHeader("Content-Type", "application/xml;ty=4")
                .post(body)
                .build();

        client.newCall(request).enqueue(this);


        // LED4 is off
        snackbar.show();
        urlomMOTSO = urlom + "/LED4/DATA";
        XML = MediaType.parse("application/xml;ty=4");
        body = RequestBody.create(XML, "<m2m:cin xmlns:m2m=\"http://www.onem2m.org/xml/protocols\">\n" +
                "    <cnf>message</cnf>\n" +
                "    <con>\n" +
                "      &lt;obj&gt;\n" +
                "        &lt;str name=&quot;appId&quot; val=&quot;MOTOR1&quot;/&gt;\n" +
                "        &lt;str name=&quot;category&quot; val=&quot;Servomotor &quot;/&gt;\n" +
                "        &lt;int name=&quot;data&quot; val=&quot;0&quot;/&gt;\n" +
                "        &lt;int name=&quot;unit&quot; val=&quot;0OFF&quot;/&gt;\n" +
                "      &lt;/obj&gt;\n" +
                "    </con>\n" +
                "</m2m:cin>");

        request = new Request.Builder()
                .url(urlomMOTSO)
                .header("X-M2M-Origin", "admin:admin")
                .addHeader("Content-Type", "application/xml;ty=4")
                .post(body)
                .build();

        client.newCall(request).enqueue(this);
    }



    public void Q2b2true(View view) {
        if (!isConnected()) {
            Snackbar.make(view, "Aucune connexion à internet.", Snackbar.LENGTH_LONG).show();
            return;
        }

        // LED3 is off
        snackbar.show();
        String urlomMOTSO = urlom + "/LED3/DATA";
        MediaType XML = MediaType.parse("application/xml;ty=4");
        RequestBody body = RequestBody.create(XML, "<m2m:cin xmlns:m2m=\"http://www.onem2m.org/xml/protocols\">\n" +
                "    <cnf>message</cnf>\n" +
                "    <con>\n" +
                "      &lt;obj&gt;\n" +
                "        &lt;str name=&quot;appId&quot; val=&quot;MOTOR1&quot;/&gt;\n" +
                "        &lt;str name=&quot;category&quot; val=&quot;Servomotor &quot;/&gt;\n" +
                "        &lt;int name=&quot;data&quot; val=&quot;0&quot;/&gt;\n" +
                "        &lt;int name=&quot;unit&quot; val=&quot;0OFF&quot;/&gt;\n" +
                "      &lt;/obj&gt;\n" +
                "    </con>\n" +
                "</m2m:cin>");

        Request request = new Request.Builder()
                .url(urlomMOTSO)
                .header("X-M2M-Origin", "admin:admin")
                .addHeader("Content-Type", "application/xml;ty=4")
                .post(body)
                .build();

        client.newCall(request).enqueue(this);


        // LED4 is on
        snackbar.show();
        urlomMOTSO = urlom + "/LED4/DATA";
        XML = MediaType.parse("application/xml;ty=4");
        body = RequestBody.create(XML, "<m2m:cin xmlns:m2m=\"http://www.onem2m.org/xml/protocols\">\n" +
                "    <cnf>message</cnf>\n" +
                "    <con>\n" +
                "      &lt;obj&gt;\n" +
                "        &lt;str name=&quot;appId&quot; val=&quot;MOTOR1&quot;/&gt;\n" +
                "        &lt;str name=&quot;category&quot; val=&quot;Servomotor &quot;/&gt;\n" +
                "        &lt;int name=&quot;data&quot; val=&quot;1&quot;/&gt;\n" +
                "        &lt;int name=&quot;unit&quot; val=&quot;1ON&quot;/&gt;\n" +
                "      &lt;/obj&gt;\n" +
                "    </con>\n" +
                "</m2m:cin>");

        request = new Request.Builder()
                .url(urlomMOTSO)
                .header("X-M2M-Origin", "admin:admin")
                .addHeader("Content-Type", "application/xml;ty=4")
                .post(body)
                .build();

        client.newCall(request).enqueue(this);
    }


    public void Q3b1true(View view) {
        if (!isConnected()) {
            Snackbar.make(view, "Aucune connexion à internet.", Snackbar.LENGTH_LONG).show();
            return;
        }

        // LED5 is on
        snackbar.show();
        String urlomMOTSO = urlom + "/LED5/DATA";
        MediaType XML = MediaType.parse("application/xml;ty=4");
        RequestBody body = RequestBody.create(XML, "<m2m:cin xmlns:m2m=\"http://www.onem2m.org/xml/protocols\">\n" +
                "    <cnf>message</cnf>\n" +
                "    <con>\n" +
                "      &lt;obj&gt;\n" +
                "        &lt;str name=&quot;appId&quot; val=&quot;MOTOR1&quot;/&gt;\n" +
                "        &lt;str name=&quot;category&quot; val=&quot;Servomotor &quot;/&gt;\n" +
                "        &lt;int name=&quot;data&quot; val=&quot;1&quot;/&gt;\n" +
                "        &lt;int name=&quot;unit&quot; val=&quot;1ON&quot;/&gt;\n" +
                "      &lt;/obj&gt;\n" +
                "    </con>\n" +
                "</m2m:cin>");

        Request request = new Request.Builder()
                .url(urlomMOTSO)
                .header("X-M2M-Origin", "admin:admin")
                .addHeader("Content-Type", "application/xml;ty=4")
                .post(body)
                .build();

        client.newCall(request).enqueue(this);


        // LED6 is off
        snackbar.show();
        urlomMOTSO = urlom + "/LED6/DATA";
        XML = MediaType.parse("application/xml;ty=4");
        body = RequestBody.create(XML, "<m2m:cin xmlns:m2m=\"http://www.onem2m.org/xml/protocols\">\n" +
                "    <cnf>message</cnf>\n" +
                "    <con>\n" +
                "      &lt;obj&gt;\n" +
                "        &lt;str name=&quot;appId&quot; val=&quot;MOTOR1&quot;/&gt;\n" +
                "        &lt;str name=&quot;category&quot; val=&quot;Servomotor &quot;/&gt;\n" +
                "        &lt;int name=&quot;data&quot; val=&quot;0&quot;/&gt;\n" +
                "        &lt;int name=&quot;unit&quot; val=&quot;0OFF&quot;/&gt;\n" +
                "      &lt;/obj&gt;\n" +
                "    </con>\n" +
                "</m2m:cin>");

        request = new Request.Builder()
                .url(urlomMOTSO)
                .header("X-M2M-Origin", "admin:admin")
                .addHeader("Content-Type", "application/xml;ty=4")
                .post(body)
                .build();

        client.newCall(request).enqueue(this);
    }

    public void Q3b2false(View view) {
        if (!isConnected()) {
            Snackbar.make(view, "Aucune connexion à internet.", Snackbar.LENGTH_LONG).show();
            return;
        }

        // LED5 is off
        snackbar.show();
        String urlomMOTSO = urlom + "/LED5/DATA";
        MediaType XML = MediaType.parse("application/xml;ty=4");
        RequestBody body = RequestBody.create(XML, "<m2m:cin xmlns:m2m=\"http://www.onem2m.org/xml/protocols\">\n" +
                "    <cnf>message</cnf>\n" +
                "    <con>\n" +
                "      &lt;obj&gt;\n" +
                "        &lt;str name=&quot;appId&quot; val=&quot;MOTOR1&quot;/&gt;\n" +
                "        &lt;str name=&quot;category&quot; val=&quot;Servomotor &quot;/&gt;\n" +
                "        &lt;int name=&quot;data&quot; val=&quot;0&quot;/&gt;\n" +
                "        &lt;int name=&quot;unit&quot; val=&quot;0OFF&quot;/&gt;\n" +
                "      &lt;/obj&gt;\n" +
                "    </con>\n" +
                "</m2m:cin>");

        Request request = new Request.Builder()
                .url(urlomMOTSO)
                .header("X-M2M-Origin", "admin:admin")
                .addHeader("Content-Type", "application/xml;ty=4")
                .post(body)
                .build();

        client.newCall(request).enqueue(this);


        // LED6 is on
        snackbar.show();
        urlomMOTSO = urlom + "/LED6/DATA";
        XML = MediaType.parse("application/xml;ty=4");
        body = RequestBody.create(XML, "<m2m:cin xmlns:m2m=\"http://www.onem2m.org/xml/protocols\">\n" +
                "    <cnf>message</cnf>\n" +
                "    <con>\n" +
                "      &lt;obj&gt;\n" +
                "        &lt;str name=&quot;appId&quot; val=&quot;MOTOR1&quot;/&gt;\n" +
                "        &lt;str name=&quot;category&quot; val=&quot;Servomotor &quot;/&gt;\n" +
                "        &lt;int name=&quot;data&quot; val=&quot;1&quot;/&gt;\n" +
                "        &lt;int name=&quot;unit&quot; val=&quot;1ON&quot;/&gt;\n" +
                "      &lt;/obj&gt;\n" +
                "    </con>\n" +
                "</m2m:cin>");

        request = new Request.Builder()
                .url(urlomMOTSO)
                .header("X-M2M-Origin", "admin:admin")
                .addHeader("Content-Type", "application/xml;ty=4")
                .post(body)
                .build();

        client.newCall(request).enqueue(this);
    }

        public void home (View view) {
            startActivity(new Intent(this, MainActivity.class));
        }

        public void activs (View view) {
            startActivity(new Intent(this, PupitreSelectionActivity.class));
        }


    ////////////////////////////////////////
    ////REPONSES REQUETES
    ///
    private boolean isConnected() {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    @Override
    public void onFailure(Call call, IOException e) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                resultsTextViewn.setText("Erreur");
                snackbar.dismiss();
            }
        });
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        if (!response.isSuccessful()) {
            throw new IOException(response.toString());
        }

        final String body = response.body().string();

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                resultsTextViewn.setText(body);
                snackbar.dismiss();
            }
        });
    }
}
