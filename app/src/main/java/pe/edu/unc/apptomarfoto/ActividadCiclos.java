package pe.edu.unc.apptomarfoto;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class ActividadCiclos extends AppCompatActivity {

    TextView lbEstado;
    List<String> lista = new ArrayList<>();
    ListView lvListaEstados;

    //IMPORTANTE -FIJO
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.ly_ciclos); //puede ser reemplazado por API
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // Inicialización correcta del TextView
        lbEstado = findViewById(R.id.lbEstado);
        lvListaEstados = findViewById(R.id.lvListaEstados);

        mensaje("Creacion");

    }

    private void mensaje(String estado) {

        lbEstado.setText(estado);
        Log.d("Estado", estado);
        lista.add(estado);
        //la variable de tipo lista se va presentar en el ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lista);
        lvListaEstados.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mensaje ("Inicio");
    }

    //IMPORTANTE - FIJO
    @Override
    protected void onResume() {
        super.onResume();
        mensaje("Ejecucion");
    }

    //IMPORTANTE - FIJO
    @Override
    protected void onPause() {
        super.onPause();
        mensaje("Pausado");
       /* finish();
        if(isFinishing())
            mensaje("Finalizado");*/

    }

    @Override
    protected void onStop() {
        super.onStop();
        mensaje("Detenido");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(isFinishing())
            mensaje("Finalizado");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mensaje("Re-iniciar");
    }




}