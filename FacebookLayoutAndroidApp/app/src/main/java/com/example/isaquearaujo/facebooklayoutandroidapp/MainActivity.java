package com.example.isaquearaujo.facebooklayoutandroidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText Login;
    EditText PassWord;
    EditText ConfirmPassword;
    Button ButtonLogin;
    Button ButtonRegister;
    TextView textView;
    boolean registerorlogin;
    int cont = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Login = (EditText)findViewById(R.id.Login);
        PassWord = (EditText)findViewById(R.id.PassWord);
        ConfirmPassword = (EditText)findViewById(R.id.ConfirmPassword);
        ButtonLogin = (Button)findViewById(R.id.ButtonLogin);
        ButtonRegister = (Button)findViewById(R.id.RegisterButton);
        textView = (TextView)findViewById(R.id.textView);
        ConfirmPassword.setVisibility(View.INVISIBLE);
        ButtonRegister.setVisibility(View.INVISIBLE);

        ButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cont == 0 || cont == 2) {
                    if (Login.getText().toString().equals("milho") && PassWord.getText().toString().equals("cozido")) {
                        Toast.makeText(MainActivity.this,
                                "Logou com sucesso!", Toast.LENGTH_LONG).show();
                        Login.setText("");
                        PassWord.setText("");
                    } else {
                        Toast.makeText(MainActivity.this,
                                "Tente Novamente!", Toast.LENGTH_LONG).show();
                        Login.setText("");
                        PassWord.setText("");
                    }
                }

            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cont++;
                if (cont == 1  ) {
                    ButtonLogin.setVisibility(View.INVISIBLE);
                    ButtonRegister.setVisibility(View.VISIBLE);
                    ConfirmPassword.setVisibility(View.VISIBLE);
                    textView.setText("Sign In For Facebook");
                    Login.setText("");
                    PassWord.setText("");


                }
                else  if(cont == 2){
                    cont = 0;
                    ButtonLogin.setVisibility(View.VISIBLE);
                    ButtonRegister.setVisibility(View.INVISIBLE);
                    ConfirmPassword.setVisibility(View.INVISIBLE);
                    Login.setText("");
                    PassWord.setText("");
                    textView.setText("Sign Up For Facebook");

                }
            }
        });
        ButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 if(!Login.getText().toString().matches("") && PassWord.getText().toString().matches(ConfirmPassword.getText().toString()))
                {
                    ButtonRegister.setVisibility(View.INVISIBLE);
                    Toast.makeText(MainActivity.this,
                            "Registro realizado!", Toast.LENGTH_LONG).show();
                    cont = 0;
                    ButtonLogin.setVisibility(View.VISIBLE);
                    ConfirmPassword.setVisibility(View.INVISIBLE);
                    Login.setText("");
                    PassWord.setText("");
                    ConfirmPassword.setText("");
                    textView.setText("Sign Up For Facebook");
                }
                else
                {
                    Toast.makeText(MainActivity.this,
                            "Tente Novamente!", Toast.LENGTH_LONG).show();
                }
            }
        });



    }
}
