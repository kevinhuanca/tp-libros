package com.ulp.libros;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.ulp.libros.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private MainActivityViewModel mv;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mv = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
        binding =ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mv.getMensaje().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.tvMensaje.setText(s);
            }
        });

        binding.btBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoIngresado = binding.etTextoIngresado.getText().toString().trim();
                mv.buscarLibro(textoIngresado);
            }
        });

    }
}