package id.ac.uad.achmad1300018083webmail.pammeme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Awal extends AppCompatActivity implements View.OnClickListener {

    Button Bmasuk, Blangsung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_awal);

        Bmasuk = (Button) findViewById(R.id.Bmasuk);
        Blangsung = (Button) findViewById(R.id.Blangsung);

        Bmasuk.setOnClickListener(this);
        Blangsung.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Bmasuk:
                startActivity(new Intent(this, Login1.class));
                break;

            case R.id.Blangsung:
                Toast.makeText(Awal.this, "Not Available!", Toast.LENGTH_LONG).show();
                break;
        }
    }
}
