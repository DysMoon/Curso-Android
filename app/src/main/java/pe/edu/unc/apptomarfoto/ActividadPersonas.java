package pe.edu.unc.apptomarfoto;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import Model.Persona;

public class ActividadPersonas extends AppCompatActivity {

    EditText txtNombres, txtApellidos, txtEdad, txtDni, txtPeso, txtAltura;
    Button btnRegistrar, btnListar;
    ArrayList<Persona> listaPersonas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.ly_personas);

        txtNombres = findViewById(R.id.txtNombres);
        txtApellidos = findViewById(R.id.txtApellidos);
        txtEdad = findViewById(R.id.txtEdad);
        txtDni = findViewById(R.id.txtDni);
        txtPeso = findViewById(R.id.txtPeso);
        txtAltura = findViewById(R.id.txtAltura);
        btnRegistrar = findViewById(R.id.btnRegistrar);
        btnListar = findViewById(R.id.btnListar);

        btnRegistrar.setOnClickListener(v -> registrarPersona());
        btnListar.setOnClickListener(v -> listarPersonas());
    }

    private void registrarPersona() {
        String nombres = txtNombres.getText().toString().trim();
        String apellidos = txtApellidos.getText().toString().trim();
        String edadStr = txtEdad.getText().toString().trim();
        String dni = txtDni.getText().toString().trim();
        String pesoStr = txtPeso.getText().toString().trim();
        String alturaStr = txtAltura.getText().toString().trim();

        // Validar campos vacíos
        if (nombres.isEmpty() || apellidos.isEmpty() || edadStr.isEmpty() || dni.isEmpty() || pesoStr.isEmpty() || alturaStr.isEmpty()) {
            Toast.makeText(this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show();
            return;
        }

        int edad;
        double peso, altura;

        try {
            edad = Integer.parseInt(edadStr);
            peso = Double.parseDouble(pesoStr);
            altura = Double.parseDouble(alturaStr);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Ingrese valores numéricos válidos", Toast.LENGTH_SHORT).show();
            return;
        }

        // Validar DNI
        if (!Persona.verificarDNI(dni)) {
            Toast.makeText(this, "DNI incorrecto", Toast.LENGTH_SHORT).show();
            return;
        }

        // Crear y registrar la persona
        Persona persona = new Persona(nombres, apellidos, edad, dni, peso, altura);
        listaPersonas.add(persona);
        Toast.makeText(this, "Persona registrada correctamente", Toast.LENGTH_SHORT).show();

        // Mostrar la información detallada de la persona
        Toast.makeText(this, persona.toString(), Toast.LENGTH_LONG).show();

        limpiarCampos();
    }

    private void listarPersonas() {
        Intent intent = new Intent(this, ActividadListadoPersonas.class);
        intent.putExtra("listaPersonas", listaPersonas);
        startActivity(intent);
    }

    private void limpiarCampos() {
        txtNombres.setText("");
        txtApellidos.setText("");
        txtEdad.setText("");
        txtDni.setText("");
        txtPeso.setText("");
        txtAltura.setText("");
    }
}
