package pe.edu.unc.apptomarfoto;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

public class ActividadValidacion extends AppCompatActivity {

    EditText edtNombre;
    RadioGroup rgGenero;
    RadioButton rbMasculino, rbFemenino;
    CheckBox chkAceptar;
    Button btnValidar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ly_validacion);


        edtNombre = findViewById(R.id.edtNombre);
        rgGenero = findViewById(R.id.rgGenero);
        rbMasculino = findViewById(R.id.rbMasculino);
        rbFemenino = findViewById(R.id.rbFemenino);
        chkAceptar = findViewById(R.id.chkAceptar);
        btnValidar = findViewById(R.id.btnValidar);

        rbFemenino.setChecked(true);

        btnValidar.setOnClickListener(view -> validarCampos());
    }

    private void validarCampos() {
        String nombre = edtNombre.getText().toString().trim();
        int idGeneroSeleccionado = rgGenero.getCheckedRadioButtonId();
        boolean aceptoTerminos = chkAceptar.isChecked();

        if (nombre.isEmpty()) {
            edtNombre.setError("Ingrese su nombre");
            edtNombre.requestFocus();
            return;
        }



        if (!aceptoTerminos) {
            Toast.makeText(this, "Debe aceptar los términos y condiciones", Toast.LENGTH_SHORT).show();
            return;
        }

        String generoSeleccionado = (idGeneroSeleccionado == R.id.rbMasculino) ? "Masculino" : "Femenino";
        String mensaje =  nombre  + " del genéro "+ generoSeleccionado + "\n Ha aceptado los términos y condiciones";
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        edtNombre.setText("");
        rbMasculino.setChecked(true);
        rbFemenino.setChecked(false);
        chkAceptar.setChecked(false);
    }

}