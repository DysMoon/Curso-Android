package pe.edu.unc.apptomarfoto;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

public class ActividadContador extends AppCompatActivity {
    EditText txtNum;
    Button btnIncrementar;
     int contador = 0;
    boolean mostrarMensaje = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ly_contador);

        txtNum = findViewById(R.id.txtNum);
        btnIncrementar = findViewById(R.id.btnIncrementar);


        btnIncrementar.setOnClickListener(view -> {
            String texto = txtNum.getText().toString();
            if (!texto.isEmpty()) {
                contador = Integer.parseInt(texto);
            }
            contador++;
            txtNum.setText(String.valueOf(contador));
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (!txtNum.getText().toString().isEmpty()) {
            contador = Integer.parseInt(txtNum.getText().toString());
        }
        if (contador > 0) {
            contador--;
            runOnUiThread(() -> txtNum.setText(String.valueOf(contador)));
        } else {
            mostrarMensaje = true;
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mostrarMensaje) {
            Toast.makeText(this, "El contador ya no puede disminuir más", Toast.LENGTH_SHORT).show();
            mostrarMensaje = false; }
    }


}