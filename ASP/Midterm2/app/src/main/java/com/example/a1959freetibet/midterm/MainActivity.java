package com.example.a1959freetibet.midterm;

        import android.os.Bundle;
        import android.app.Activity;
        import android.view.Menu;
        import android.view.View;
        import android.view.View.OnClickListener;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;

public class LoginActivity extends Activity {
    // User name
    private EditText Username;
    // Password
    private EditText Password;
    // Sign In
    private Button SignIn;
    // Message
    private TextView Message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialization
        Username = (EditText) findViewById(R.id.Username);
        Password = (EditText) findViewById(R.id.Password);
        SignIn = (Button) findViewById(R.id.SignIn);
        Message = (TextView) findViewById(R.id.Message);

        SignIn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                // Stores User name
                String username = String.valueOf(Username.getText());
                // Stores Password
                String password = String.valueOf(Password.getText());

                // Validates the User name and Password for admin, admin
                if (username.equals("admin") && password.equals("admin")) {
                    Message.setText("Login Successful!");
                } else {
                    Message.setText("Login Unsuccessful!");
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login, menu);
        return true;
    }

}
