package com.ulp.libros;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;

public class MainActivityViewModel extends AndroidViewModel {
    private ArrayList<Libro> libros;
    private MutableLiveData<String> mensaje;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        libros = new ArrayList<>();
        libros.add(new Libro("El Hobbit",
                "J.R.R Tolkien",
                1937,
                "Fantasia",
                "El Hobbit, ida y vuelta es una novela de fantasia para niños del autor ingles J.R.R Tolkien.",
                R.drawable.ic_launcher_background));
        libros.add(new Libro("Alien",
                "Desconocido",
                1990,
                "Terror",
                "Es de terror, fue best seller en 1990, vendio mucho, su autor es desconocido.",
                R.drawable.ic_launcher_foreground));
    }

    public LiveData<String> getMensaje() {
        if (mensaje == null) {
            mensaje = new MutableLiveData<>();
        }
        return mensaje;
    }

    public void buscarLibro(String textoIngresado) {
        if (textoIngresado.trim().isEmpty()) {
            mensaje.setValue("Escribe algo para buscar.");
            return;
        }
        for (Libro libro : libros) {
            if (libro.getTitulo().trim().equalsIgnoreCase(textoIngresado)) {
                Intent intent = new Intent(getApplication(), SegundaActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("libro", libro);
                intent.putExtra("libro", bundle);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getApplication().startActivity(intent);
                mensaje.setValue("");
                return;
            }
        }
        mensaje.setValue("Libro no disponible.");
    }

}
