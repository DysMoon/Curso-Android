package pe.edu.unc.apptomarfoto;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import java.util.Random;

import Model.Juego;
import Model.Papel;
import Model.Piedra;
import Model.Tijera;

public class ActividadJuego extends AppCompatActivity {
    private RadioGroup radioGroup;
    private Button btJugar;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ly_juego);
        radioGroup = findViewById(R.id.radioGroup);
        btJugar = findViewById(R.id.btJugar);
        txtResultado = findViewById(R.id.txtResultado);

        btJugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Juego jugadaUsuario = obtenerJugadaUsuario();

                if (jugadaUsuario != null) {
                    Juego jugadaDispositivo = obtenerJugadaAleatoria();
                    String resultado = jugadaUsuario.comparar(jugadaDispositivo);

                    txtResultado.setText("Dispositivo: " + jugadaDispositivo.getClass().getSimpleName() +
                            "\nResultado del juego: " + resultado);
                } else {
                    txtResultado.setText("Selecciona una opción");
                }
            }
        });

    }

    private Juego obtenerJugadaUsuario() {
        int checkedId = radioGroup.getCheckedRadioButtonId();
        if (checkedId == R.id.rbPiedra) {
            return new Piedra();
        } else if (checkedId == R.id.rbPapel) {
            return new Papel();
        } else if (checkedId == R.id.rbTijera) {
            return new Tijera();
        }
        return null;
    }

    private Juego obtenerJugadaAleatoria() {
        Juego[] opciones = {new Piedra(), new Papel(), new Tijera()};
        return opciones[new Random().nextInt(opciones.length)];
    }



}