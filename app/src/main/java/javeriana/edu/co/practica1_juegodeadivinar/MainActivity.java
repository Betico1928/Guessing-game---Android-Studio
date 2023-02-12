package javeriana.edu.co.practica1_juegodeadivinar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.Random;

import javeriana.edu.co.practica1_juegodeadivinar.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    // Creación del Random
    Random randomNumber = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Hacer numero aleatorio:
        int resultadoDelRandom = randomNumber.nextInt(101);
        Log.i("Numero aleatorio generado: ", String.valueOf(resultadoDelRandom));

        // Contador de intentos:
        int contadorDeIntentos = 0;

        binding.botonAdivinar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Log.i("Numero a adivinar: ", String.valueOf(resultadoDelRandom));

                //if (resultadoDelRandom != )
            }
        });
    }
}