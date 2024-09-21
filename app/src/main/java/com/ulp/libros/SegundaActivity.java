package com.ulp.libros;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.ulp.libros.databinding.ActivitySegundaBinding;

public class SegundaActivity extends AppCompatActivity {
    private SegundaActivityViewModel mv;
    private ActivitySegundaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mv = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(SegundaActivityViewModel.class);
        binding = ActivitySegundaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mv.getLibro().observe(this, new Observer<Libro>() {
            @Override
            public void onChanged(Libro libro) {
                binding.tvTitulo.setText(libro.getTitulo());
                binding.tvAutor.setText(libro.getAutor());
                binding.tvAnio.setText(libro.getAnio()+"");
                binding.tvGenero.setText(libro.getGenero());
                binding.tvDescripcion.setText(libro.getDescripcion());
                binding.imageView.setImageResource(libro.getFoto());
            }
        });
        mv.cargarLibro(getIntent());

    }
}