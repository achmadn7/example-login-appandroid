package id.ac.uad.achmad1300018083webmail.pammeme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;

public class Login1 extends AppCompatActivity implements View.OnClickListener {

    Button bmasuk;
    EditText etUsername, etPassword;
    TextView tvDaftarLink;

    LoginDatabaseAdapter1 loginDatabaseAdapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);

        loginDatabaseAdapter1 = new LoginDatabaseAdapter1(this);
        try {
            loginDatabaseAdapter1 = loginDatabaseAdapter1.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        tvDaftarLink = (TextView) findViewById(R.id.tvDaftarlink);
        bmasuk = (Button) findViewById(R.id.bmasuk);


        bmasuk.setOnClickListener(this);
        tvDaftarLink.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.bmasuk:
                String userName = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                String storedPassword = loginDatabaseAdapter1.getSinlgeEntry(userName);
                if(password.equals(storedPassword))
                {
                    Toast.makeText(Login1.this, "Congrats: Login Successfull", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(this, Tes.class));
                }
                if(userName.equals("")||password.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Field Empty", Toast.LENGTH_LONG).show();
                    return;
                }
                else
                {
                    Toast.makeText(Login1.this, "User Name or Password does not match", Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.tvDaftarlink:
                startActivity(new Intent(this, Daftar1.class));
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
