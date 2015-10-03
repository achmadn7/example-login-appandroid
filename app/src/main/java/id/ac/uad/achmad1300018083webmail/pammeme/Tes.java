package id.ac.uad.achmad1300018083webmail.pammeme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.sql.SQLException;

public class Tes extends AppCompatActivity implements View.OnClickListener {

    TextView tvBack;
    LoginDatabaseAdapter1 loginDatabaseAdapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tes);

        loginDatabaseAdapter1 = new LoginDatabaseAdapter1(this);
        try {
            loginDatabaseAdapter1 = loginDatabaseAdapter1.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        tvBack = (TextView) findViewById(R.id.tvBack);

        tvBack.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tvBack:
                    startActivity(new Intent(this, Awal.class));
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
