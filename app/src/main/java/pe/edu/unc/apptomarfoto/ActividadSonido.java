package pe.edu.unc.apptomarfoto;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Locale;

public class ActividadSonido extends AppCompatActivity {

    private TextView txtMultiple; // TextView donde se mostrará el resultado


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.ly_sonido);

        txtMultiple = findViewById(R.id.txtMultiple); // Asegurar que el ID es correcto

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void onClick(View boton) {
        Intent oIntento = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        oIntento.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "es-PE");
        oIntento.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        startActivityIfNeeded(oIntento, 200);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 200 && resultCode == RESULT_OK && data != null) {
            ArrayList<String> resultados = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            String textoReconocido = resultados.get(0); // Primer resultado de voz a texto

            // Aquí puedes mostrar el resultado en un TextView o hacer algo con el texto
            Toast.makeText(this, "Reconocido: " + textoReconocido, Toast.LENGTH_LONG).show();
            txtMultiple.setText(textoReconocido);
        }
    }

}
