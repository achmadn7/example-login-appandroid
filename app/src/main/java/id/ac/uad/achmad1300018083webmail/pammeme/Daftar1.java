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

public class Daftar1 extends AppCompatActivity implements View.OnClickListener {

    Button bdaftar;
    ImageButton bfb;
    ImageButton bgoo;
    EditText etUsername, etPassword, etRepassword;

    LoginDatabaseAdapter1 loginDatabaseAdapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar1);

        loginDatabaseAdapter1 = new LoginDatabaseAdapter1(this);
        try {
            loginDatabaseAdapter1 = loginDatabaseAdapter1.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etRepassword = (EditText) findViewById(R.id.etRepassword);

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
                String userName=etUsername.getText().toString();
                String password=etPassword.getText().toString();
                String repassword=etRepassword.getText().toString();
                // check if any of the fields are vaccant
                if(userName.equals("")||password.equals("")||repassword.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Field Empty", Toast.LENGTH_LONG).show();
                    return;
                }
                // check if both password matches
                if(!password.equals(repassword))
                {
                    Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_LONG).show();
                    return;
                }
                else
                {
                    // Save the Data in Database
                    loginDatabaseAdapter1.insertEntry(userName, password);
                    Toast.makeText(getApplicationContext(), "Account Successfully Created ", Toast.LENGTH_LONG).show();
                }
                    startActivity(new Intent(this, Login.class));
                break;

            case  R.id.bfb:
                Toast.makeText(Daftar1.this, "Not Available!", Toast.LENGTH_LONG).show();
                //startActivity(new Intent(this, Tes.class));
                break;

            case  R.id.bgoo:
                Toast.makeText(Daftar1.this, "Not Available!", Toast.LENGTH_LONG).show();
                break;
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Close The Database
        loginDatabaseAdapter1.close();
    }
}
