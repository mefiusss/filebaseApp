package com.alexandre_mateus.github;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private Button btnCadastrar;
    private Button btnLogar;
    private EditText editEmail, editNome, editSenha;
    private FirebaseAuth auth = FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnCadastrar = findViewById(R.id.login_btn_cadastrar);
        btnLogar =findViewById(R.id.login_btn_logar);
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Intent = new Intent(getApplicationContext(),CadastroActivity.class);
                startActivity(Intent);
            }
        });
        btnLogar.setOnClickListener(v -> {
            logar();
        });
    }
    public void logar(){
            String email = editEmail.getText().toString();
            String nome = editNome.getText().toString();
            String senha = editSenha.getText().toString();
            if(email.isEmpty() || senha.isEmpty()){
                Toast.makeText(this,"Preencha os campos",Toast.LENGTH_SHORT).show();
                return;
            }

            Task<AuthResult> t = auth.signInWithEmailAndPassword(email,senha);
            //Listener de Sucesso
            t.addOnSuccessListener(authResult -> {
                Toast.makeText(this, "Bem Vindo!",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            });
            //Listener de falha
            t.addOnSuccessListener(authResult -> {
                Toast.makeText(this,"Email ou senha invalidos!",Toast.LENGTH_SHORT).show();
            });

    }
}
