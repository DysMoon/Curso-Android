package pe.edu.unc.apptomarfoto;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import Model.Persona;

public class ActividadListadoPersonas extends AppCompatActivity {
    ListView lvPersonas;
    ArrayList<Persona> listaPersonas;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ly_lista);

        lvPersonas = findViewById(R.id.lvPersonas);

        // Obtener la lista del Intent y manejar el caso en que sea null
        listaPersonas = (ArrayList<Persona>) getIntent().getSerializableExtra("listaPersonas");
        if (listaPersonas == null) {
            listaPersonas = new ArrayList<>();
        }

        // Si la lista está vacía, mostrar un mensaje y salir de la actividad
        if (listaPersonas.isEmpty()) {
            Toast.makeText(this, "No hay personas registradas", Toast.LENGTH_SHORT).show();
            finish(); // Cierra la actividad si no hay datos
            return;
        }

        // Convertir la lista de objetos Persona a una lista de cadenas con sus datos
        ArrayList<String> datosPersonas = new ArrayList<>();
        for (Persona p : listaPersonas) {
            datosPersonas.add(p.toString());
        }

        // Mostrar los datos en el ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, datosPersonas);
        lvPersonas.setAdapter(adapter);
    }
}
