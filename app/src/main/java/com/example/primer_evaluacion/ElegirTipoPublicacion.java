package com.example.primer_evaluacion;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ElegirTipoPublicacion extends AppCompatActivity {

    private RadioButton rbLibro, rbRevista;
    private RadioGroup rgbEleccion;

    private Button btnContinuar;

    private Bundle bundle;

    private int idEleccion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegir_tipo_publicacion);

        btnContinuar = findViewById(R.id.btnContinuar);
        rgbEleccion = findViewById(R.id.rgEleccion);
        rbLibro = rgbEleccion.findViewById(R.id.rgLibro);
        rbRevista = rgbEleccion.findViewById(R.id.rbRevista);

        rbLibro.setOnClickListener(v -> idEleccion = 1);
        rbRevista.setOnClickListener(v -> idEleccion = 2);

        btnContinuar.setOnClickListener(v -> {
            bundle = new Bundle();
            bundle.putInt("tipoEleccion", idEleccion);
            Intent intent = new Intent(this, AgregarPublicacion.class);
            intent.putExtras(bundle);
            startActivity(intent);
        });
    }
}