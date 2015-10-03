package id.ac.uad.achmad1300018083webmail.pammeme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.sql.SQLException;

import static id.ac.uad.achmad1300018083webmail.pammeme.LoginDataBaseAdapter.*;

public class Daftar extends AppCompatActivity implements View.OnClickListener {

    Button bdaftar;
    ImageButton bfb;
    ImageButton bgoo;
    EditText etNama, etUsername, etEmail, etPassword;

    LoginDataBaseAdapter loginDataBaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        loginDataBaseAdapter = new LoginDataBaseAdapter(this);
        try {
            loginDataBaseAdapter.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        etNama = (EditText) findViewById(R.id.etNama);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        bdaftar = (Button) findViewById(R.id.bdaftar);
        bfb = (ImageButton) findViewById(R.id.bfb);
        bgoo = (ImageButton) findViewById(R.id.bfb);

        bdaftar.setOnClickListener(this);
        bfb.setOnClickListener(this);
        bgoo.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.bdaftar:
                String nama=etNama.getText().toString();
                String userName=etUsername.getText().toString();
                String email=etEmail.getText().toString();
                String password=etPassword.getText().toString();
                // check if any of the fields are vaccant
                if(nama.equals("")|userName.equals("")||email.equals("")||password.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Field Empty", Toast.LENGTH_LONG).show();
                    return;
                }
                else
                {
                    // Save the Data in Database
                    loginDataBaseAdapter.insertEntry(nama, userName, email, password);
                    Toast.makeText(getApplicationContext(), "Account Successfully Created ", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(this, Login.class));
                }
                break;

            case  R.id.bfb:
                    Toast.makeText(Daftar.this, "Not Available!", Toast.LENGTH_LONG).show();
                    //startActivity(new Intent(this, Tes.class));
                break;

            case  R.id.bgoo:
                    Toast.makeText(Daftar.this, "Not Available!", Toast.LENGTH_LONG).show();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();

        loginDataBaseAdapter.close();
    }
}
