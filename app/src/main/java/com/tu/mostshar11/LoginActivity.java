package com.tu.mostshar11;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    private EditText emailTV, passwordTV;
    private Button loginBtn;
    private ProgressBar progressBar;
    private Spinner spinner;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        initializeUI();
       ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.usertype,R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item=spinner.getSelectedItem().toString();
                if(item.equals("دكتور"))
                        {
                            Toast.makeText(getApplicationContext(), "تم تسجيل الدخول للدكتور بنجاح!", Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);

                            Intent intent = new Intent(LoginActivity.this, DoctorActivity.class);
                            startActivity(intent);

                        }
                else if(item.equals("مستخدم عادي")){
                loginUserAccount();
               }
            }
        });



        Button btn = (Button)findViewById(R.id.btn_sign);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,SignupActivity.class));
                finish();

            }
        });
    }

    private void loginUserAccount() {
        progressBar.setVisibility(View.VISIBLE);

        String email, password;
        email = emailTV.getText().toString();
        password = passwordTV.getText().toString();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(), "ادخل البريد الالكتروني...", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "ادخل كلمة المرور!", Toast.LENGTH_LONG).show();
            return;
        }

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "تم تسجيل الدخول بنجاح!", Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);

                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                        }
                       /* else if()
                        {
                            Toast.makeText(getApplicationContext(), "تم تسجيل الدخول للدكتور بنجاح!", Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);

                            Intent intent = new Intent(LoginActivity.this, DoctorActivity.class);
                            startActivity(intent);

                        }*/
                        else {
                            Toast.makeText(getApplicationContext(), "فشل تسجيل الدخول ! حاول مرة اخرى", Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });

    }

    private void initializeUI() {


        emailTV = findViewById(R.id.email);
        passwordTV = findViewById(R.id.password);
        spinner=findViewById(R.id.spinner1);
        loginBtn = findViewById(R.id.btn_login);
        progressBar = findViewById(R.id.progressBar);
    }
}
