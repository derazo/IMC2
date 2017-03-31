package co.edu.umariana.danielsantander.imc;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import co.edu.umariana.danielerazo.imc.R;

import static co.edu.umariana.danielerazo.imc.R.id.et_estatura;
import static co.edu.umariana.danielerazo.imc.R.id.et_multi;
import static co.edu.umariana.danielerazo.imc.R.id.et_peso;

public class Guardar extends AppCompatActivity {

    private EditText et_multi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        et_multi = (EditText) findViewById(R.id.et_multi);

        String[] archivos = fileList();

        if (existe(archivos, "IMC.txt"))
            try {
                InputStreamReader archivo = new InputStreamReader(
                        openFileInput("IMC.txt"));
                BufferedReader br = new BufferedReader(archivo);
                String linea = br.readLine();
                String todo = "";
                while (linea != null) {
                    todo = todo+ linea +"\n";
                    linea = br.readLine();
                }
                br.close();
                archivo.close();
                et_multi.setText(todo);
            } catch (IOException e) {
            }
    }

    private boolean existe(String[] archivos, String archbusca) {
        for (int f = 0; f < archivos.length; f++)
            if (archbusca.equals(archivos[f]))
                return true;
        return false;
    }

    public void salir(View v) {

        finish();
    }


    }

