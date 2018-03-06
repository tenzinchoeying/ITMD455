package com.example.a1959freetibet.mid18;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button loginb;
    EditText User, Pass;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Login();
    }
        public void Login(){

        loginb = (Button)findViewById(R.id.login);
        User = (EditText)findViewById(R.id.username);
        Pass = (EditText)findViewById(R.id.password);

        loginb.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), my2nd.class);
                if(Pass.getText().toString().equals("abc123")){
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "Invalid Login: " + ++count, Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
