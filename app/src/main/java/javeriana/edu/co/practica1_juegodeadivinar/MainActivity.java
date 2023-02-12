package javeriana.edu.co.practica1_juegodeadivinar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.Random;

import javeriana.edu.co.practica1_juegodeadivinar.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity
{
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
            public void onClick(View vistaInicial)
            {
                Log.i("Numero a adivinar: ", String.valueOf(resultadoDelRandom));

                // Pasar del EditText al editable usando binding
                Editable numeroRecibido = binding.textoNumeroAdivinado.getText();
                int numeroSugerido = Integer.parseInt(numeroRecibido.toString());

                Log.i("Numero sugerido: ", String.valueOf(numeroSugerido));

                //if (resultadoDelRandom != numeroSugerido);
            }
        });
    }
}