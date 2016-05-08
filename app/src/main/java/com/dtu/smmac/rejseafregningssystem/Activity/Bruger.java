package com.dtu.smmac.rejseafregningssystem.Activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.dtu.smmac.rejseafregningssystem.Logic.API;
import com.dtu.smmac.rejseafregningssystem.R;

/**
 * Created by Roos on 03/05/16.
 */
public class Bruger extends Activity implements View.OnClickListener {

    private Intent login;
    private String brugernavn, kode, strApi;
    private TextView txtApi;
    private EditText tlf;
    private Button btnTlf;
    private String change, save;
    private ProgressBar progress;
    private boolean click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bruger);

        this.getActionBar().setTitle("   Rejseafregningssystem");

        this.login = new Intent(this, Login.class);

        this.brugernavn = getIntent().getStringExtra("brugernavn");
        this.kode = getIntent().getStringExtra("kode");
        this.strApi = getIntent().getStringExtra("api");

        this.progress = (ProgressBar) findViewById(R.id.pronew);
        this.progress.setVisibility(View.INVISIBLE);

        this.click = true;

        this.change = "Ændre telefonnummer";
        this.save = "Gem";

        this.txtApi = (TextView) findViewById(R.id.txtApi);
        this.txtApi.setText(this.strApi);
        this.txtApi.setTextSize(20);
        this.txtApi.setTextColor(Color.BLACK);

        this.tlf = (EditText) findViewById(R.id.tlf);
        this.tlf.setText("");
        this.tlf.setHint("Nyt telefonnummer");
        this.tlf.setVisibility(View.INVISIBLE);

        this.btnTlf = (Button) findViewById(R.id.btnTlf);
        this.btnTlf.setText(change);
        this.btnTlf.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.logout_topbar, menu);

        return super.onCreateOptionsMenu(menu);
    }

    public void logout(MenuItem item)
    {
        startActivity(login);
        finish();
    }

    @Override
    public void onClick(View v) {
        if (this.btnTlf.getText().toString().equals(change)) {
            this.btnTlf.setText(save);
            this.tlf.setVisibility(View.VISIBLE);
        } else if (this.btnTlf.getText().toString().equals(save)) {

            final String strTlf = tlf.getText().toString();

            if (TextUtils.isDigitsOnly(strTlf) && !strTlf.isEmpty()) {
                if (this.click) {
                    this.click = false;
                    this.progress.setVisibility(View.VISIBLE);

                    new AsyncTask() {
                        @Override
                        protected Object doInBackground(Object[] params) {
                            Splash.api.changeTlf(brugernavn, kode, strTlf);
                            strApi = Splash.api.login(brugernavn, kode);
                            hideSoftKeyboard(Bruger.this);
                            return null;
                        }

                        @Override
                        protected void onPostExecute(Object resultat) {
                            btnTlf.setText(change);
                            txtApi.setText(strApi);
                            tlf.setVisibility(View.INVISIBLE);
                            tlf.setText("");
                            progress.setVisibility(View.INVISIBLE);
                            click = true;
                        }
                    }.execute();
                }
            } else {
                Toast.makeText(getApplicationContext(), "Telefonnummeret skal være tal", Toast.LENGTH_SHORT).show();
            }
        }
    }


    public void hideSoftKeyboard(Activity activity)
    {
        InputMethodManager inputMethodManager = (InputMethodManager)  activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
    }
}
