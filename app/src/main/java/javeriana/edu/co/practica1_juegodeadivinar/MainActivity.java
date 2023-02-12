package javeriana.edu.co.practica1_juegodeadivinar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

import javeriana.edu.co.practica1_juegodeadivinar.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity
{
    ActivityMainBinding binding;

    // Creación del Random
    Random randomNumber = new Random();

    // Contador de intentos:
    int contadorDeIntentos = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Hacer numero aleatorio:
        int resultadoDelRandom = randomNumber.nextInt(101);
        Log.i("Numero aleatorio generado: ", String.valueOf(resultadoDelRandom));


        binding.botonAdivinar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View vistaInicial)
            {
                Log.i("Numero a adivinar: ", String.valueOf(resultadoDelRandom));

                // Pasar del EditText al editable usando binding.
                Editable numeroRecibido = binding.textoNumeroAdivinado.getText();
                int numeroSugerido = Integer.parseInt(numeroRecibido.toString());

                // Mostrar numero dado por el usuario.
                Log.i("Numero sugerido: ", String.valueOf(numeroSugerido));


                // Logica general
                if (numeroSugerido < 0)
                {
                    binding.resultadoDelJuego.setText("Tu numero es demasiado pequeño");
                    Toast.makeText(getBaseContext(), "Recuerda, el numero debe empieza en 0", Toast.LENGTH_LONG).show();
                }
                else if (numeroSugerido > 100)
                {
                    binding.resultadoDelJuego.setText("Tu numero es demasiado grande");
                    Toast.makeText(getBaseContext(), "Recuerda, el numero debe termina en 100", Toast.LENGTH_LONG).show();
                }
                else if (numeroSugerido > resultadoDelRandom && numeroSugerido <= 100)
                {
                    binding.resultadoDelJuego.setText("Fallaste, el numero debe ser menor!");
                    Log.i("Numero no adivinado (menor)", "Se pide numero menor, el numero fue " + numeroSugerido + " y se necesita " + resultadoDelRandom);

                    contadorDeIntentos = contadorDeIntentos + 1;
                    binding.numeroDeIntentos.setText("Numero de Intentos: " + contadorDeIntentos);
                    Log.i("Intentos: ", "Numero de Intentos: " + contadorDeIntentos);
                }
                else if (numeroSugerido < resultadoDelRandom && numeroSugerido >= 0)
                {
                    binding.resultadoDelJuego.setText("Fallaste, el numero debe ser mayor!");
                    Log.i("Numero no adivinado (mayor)", "Se pide numero mayor, el numero fue " + numeroSugerido + " y se necesita " + resultadoDelRandom);

                    contadorDeIntentos = contadorDeIntentos + 1;
                    binding.numeroDeIntentos.setText("Numero de Intentos: " + contadorDeIntentos);
                    Log.i("Intentos: ", "Numero de Intentos: " + contadorDeIntentos);
                }
                else
                {
                    binding.resultadoDelJuego.setText("GANASTE! El numero era " + resultadoDelRandom);
                    binding.numeroDeIntentos.setText("Numero de Intentos: " + contadorDeIntentos);

                    Log.i("Estado del juego: ", "Finalizado :D");
                }
            }
        });
    }
}