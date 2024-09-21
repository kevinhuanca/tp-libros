package com.ulp.libros;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class SegundaActivityViewModel extends AndroidViewModel {
    private MutableLiveData<Libro> libro;

    public SegundaActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Libro> getLibro() {
        if (libro == null) {
            libro = new MutableLiveData<>();
        }
        return libro;
    }

    public void cargarLibro(Intent intent) {
        Bundle bundle = intent.getBundleExtra("libro");
        Libro libro = (Libro) bundle.getSerializable("libro", Libro.class);
        this.libro.setValue(libro);
    }
}
