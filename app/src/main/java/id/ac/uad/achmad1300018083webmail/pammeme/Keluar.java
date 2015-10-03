package id.ac.uad.achmad1300018083webmail.pammeme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Keluar extends AppCompatActivity implements View.OnClickListener {

    Button bkeluar;
    EditText etNama, etUsername, etEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keluar);

        etNama = (EditText) findViewById(R.id.etNama);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etEmail = (EditText) findViewById(R.id.etEmail);
        bkeluar = (Button) findViewById(R.id.bkeluar);

        bkeluar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bkeluar:
                startActivity(new Intent(this, Login.class));
                break;
        }
    }
}
