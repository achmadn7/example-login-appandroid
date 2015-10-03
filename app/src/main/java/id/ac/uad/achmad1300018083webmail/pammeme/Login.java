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

public class Login extends AppCompatActivity implements View.OnClickListener {

    Button bmasuk;
    EditText etUsername, etPassword;
    TextView tvDaftarLink;

    LoginDataBaseAdapter loginDataBaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginDataBaseAdapter = new LoginDataBaseAdapter(this);
        try {
            loginDataBaseAdapter = loginDataBaseAdapter.open();
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

                String storedPassword=loginDataBaseAdapter.getSinlgeEntry(userName);
                if(password.equals(storedPassword))
                {
                    Toast.makeText(Login.this, "Congrats: Login Successfull", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(this, Tes.class));
                }
                if(userName.equals("")||password.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Field Empty", Toast.LENGTH_LONG).show();
                    return;
                }
                else
                {
                    Toast.makeText(Login.this, "User Name or Password does not match", Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.tvDaftarlink:
                startActivity(new Intent(this, Daftar.class));
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Close The Database
        loginDataBaseAdapter.close();
    }
}
