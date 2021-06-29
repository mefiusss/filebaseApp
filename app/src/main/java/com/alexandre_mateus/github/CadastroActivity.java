package com.alexandre_mateus.github;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class CadastroActivity extends AppCompatActivity {
    private Button btnCadastrar;
    private EditText editEmail, editNome, editSenha;
    private FirebaseAuth auth = FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        btnCadastrar = findViewById(R.id.cadastro_btn_cadastrar);
        editEmail = findViewById(R.id.cadastro_edit_email);
        editNome = findViewById(R.id.cadastro_edit_nome);
        editSenha = findViewById(R.id.cadastro_edit_password);

        btnCadastrar.setOnClickListener(v -> {
            cadastrar();
        });
    }
    public void cadastrar(){
        String email = editEmail.getText().toString();
        String nome = editNome.getText().toString();
        String senha = editSenha.getText().toString();
        if(email.isEmpty() || senha.isEmpty()){
            Toast.makeText(this,"Preencha os campos",Toast.LENGTH_SHORT).show();
            return;
        }
        //criar um usuario com e-mail e senha
        Task t = auth.createUserWithEmailAndPassword(email,senha);
        t.addOnCompleteListener(task -> {
            if(task.isSuccessful()){
                Toast.makeText(getApplicationContext(),"Usuario criado com sucesso!",Toast.LENGTH_SHORT).show();
                finish();
            }else{
                Toast.makeText(getApplicationContext(),"Erro!",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
