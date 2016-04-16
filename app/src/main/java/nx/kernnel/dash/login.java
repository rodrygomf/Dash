package nx.kernnel.dash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import nx.kernnel.dash.Entity.Usuario;

public class login extends AppCompatActivity {
    private EditText etLogin;
    private EditText etPassword;
    private Button btAcess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setUI();
        setActions();
    }

    private void setUI() {
        etLogin = (EditText) findViewById(R.id.etLogin);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btAcess = (Button) findViewById(R.id.btAcess);
    }

    private void setActions() {
        btAcess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuario usuario = userValidate();
                if(usuario != null) {
                    goToMain(usuario);
                }
            }
        });
    }

    private Usuario userValidate() {
        etLogin.setError(null);
        etPassword.setError(null);

        String login = etLogin.getText().toString();
        String password = etPassword.getText().toString();

        if(login.isEmpty()) {
            etLogin.setError(getString(R.string.error_login_username));
            return null;
        }

        if(password.isEmpty()) {
            etPassword.setError(getString(R.string.error_login_password));
            return null;
        }

        Usuario usuario = new Usuario();
        usuario.setLogin(login);
        usuario.setPassword(password);
        if(usuario.userValidate()) {
            return usuario;
        }else{
            etPassword.setError(getString(R.string.error_login_user));
            return null;
        }
    }

    private void goToMain(Usuario usuario) {
        Intent intent = new Intent(login.this, MainActivity.class);
        intent.putExtra("usuario", usuario);
        startActivity(intent);
    }

}
