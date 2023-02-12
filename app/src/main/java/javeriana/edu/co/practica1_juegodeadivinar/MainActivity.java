package javeriana.edu.co.practica1_juegodeadivinar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.Random;

import javeriana.edu.co.practica1_juegodeadivinar.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    // Creación del Random
    Random randomNumber = new Random();
    int result = randomNumber.nextInt(101);

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Hacer numero aleatorio



        binding.botonAdivinar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                System.out.println(result);
                Toast.makeText(getBaseContext(), "El numero que salió fue " + result, Toast.LENGTH_LONG);
            }
        });
    }
}