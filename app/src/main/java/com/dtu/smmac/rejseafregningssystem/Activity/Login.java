package com.dtu.smmac.rejseafregningssystem.Activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.dtu.smmac.rejseafregningssystem.Logic.API;
import com.dtu.smmac.rejseafregningssystem.R;

import java.io.IOException;

/**
 * Created by Roos on 03/05/16.
 */
public class Login extends Activity {

    private Intent bruger;
    private TextView txtBrugernavn, txtKode;
    private EditText brugernavn, kode;
    private ProgressBar progress;
    private Runnable r;
    private boolean click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.getActionBar().setTitle("   Rejseafregningssystem");

        this.bruger = new Intent(this, Bruger.class);

        this.progress = (ProgressBar) findViewById(R.id.pronew);
        this.progress.setVisibility(View.INVISIBLE);

        this.click = true;

        this.r = new Runnable() {
            public void run() {
                Toast.makeText(getApplicationContext(), "Forkert brugernavn eller kodeord", Toast.LENGTH_SHORT).show();
            }
        };

        this.txtBrugernavn = (TextView) findViewById(R.id.txtBrugernavn);
        this.txtBrugernavn.setText("Brugernavn:");
        this.txtBrugernavn.setTypeface(null, Typeface.BOLD);
        this.txtBrugernavn.setTextSize(20);
        this.txtBrugernavn.setTextColor(Color.BLACK);

        this.txtKode = (TextView) findViewById(R.id.txtKode);
        this.txtKode.setText("Kode:");
        this.txtKode.setTypeface(null, Typeface.BOLD);
        this.txtKode.setTextSize(20);
        this.txtKode.setTextColor(Color.BLACK);

        this.brugernavn = (EditText) findViewById(R.id.brugernavn);
        this.brugernavn.setText("");

        this.kode = (EditText) findViewById(R.id.kode);
        this.kode.setText("");
        this.kode.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.login_topbar, menu);

        return super.onCreateOptionsMenu(menu);
    }

    public void login(MenuItem item)
    {
        if (this.click) {
            this.click = false;
            this.progress.setVisibility(View.VISIBLE);

            final String strBrugernavn = this.brugernavn.getText().toString();
            final String strKode = this.kode.getText().toString();

            new AsyncTask() {
                @Override
                protected Object doInBackground(Object[] params) {
                    try {
                        String strApi = Splash.api.login(strBrugernavn, strKode);
                        if (strApi.substring(0, 3).equals("Vel")) {
                            bruger.putExtra("brugernavn", strBrugernavn);
                            bruger.putExtra("kode", strKode);
                            bruger.putExtra("api", strApi);
                            startActivity(bruger);
                            finish();
                        } else {
                            runOnUiThread(r);
                            hideSoftKeyboard(Login.this);
                            reset();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return null;
                }

                @Override
                protected void onPostExecute(Object resultat) {
                    progress.setVisibility(View.INVISIBLE);
                    click = true;
                }
            }.execute();
        }
    }

    public void reset() {
        this.brugernavn.setText("");
        this.kode.setText("");
    }

    public void hideSoftKeyboard(Activity activity)
    {
        InputMethodManager inputMethodManager = (InputMethodManager)  activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
    }
}
