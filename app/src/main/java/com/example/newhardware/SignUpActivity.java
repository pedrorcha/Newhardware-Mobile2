package com.example.newhardware;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    EditText fullName;
    EditText email;
    EditText password;
    EditText confirmPassword;
    Button createAccountButton;
    TextView loginText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        fullName = findViewById(R.id.fullName);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.confirmPassword);
        createAccountButton = findViewById(R.id.createAccountButton);
        loginText = findViewById(R.id.loginText);

        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = fullName.getText().toString().trim();
                String emailAddress = email.getText().toString().trim();
                String pwd = password.getText().toString().trim();
                String confirmPwd = confirmPassword.getText().toString().trim();

                if (name.isEmpty() || emailAddress.isEmpty() || pwd.isEmpty() || confirmPwd.isEmpty()) {
                    Toast.makeText(SignUpActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else if (!pwd.equals(confirmPwd)) {
                    Toast.makeText(SignUpActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                } else {
                    // Exemplo: salvar dados em um banco de dados ou serviço
                    // Aqui você deve adicionar sua lógica para salvar os dados do usuário
                    Toast.makeText(SignUpActivity.this, "Account created successfully!", Toast.LENGTH_SHORT).show();

                    // Redirecionar para a tela de login (MainActivity)
                    Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // Limpa todas as atividades anteriores
                    startActivity(intent);
                    finish(); // Finaliza a SignUpActivity para evitar voltar para cá com o botão de voltar
                }
            }
        });

        // Configurar o clique no texto de "Login"
        loginText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abrir a tela de login (MainActivity)
                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // Limpa todas as atividades anteriores
                startActivity(intent);
                finish(); // Finaliza a atividade atual para evitar voltar para cá com o botão de voltar
            }
        });
    }
}
