package com.example.a20190924c1act02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MetodoBoton();
    }

    public void MetodoBoton(){
        Button boton = findViewById(R.id.BTN_Calcular);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Se obtienen espacios de memoria para manipular la información de los controles
                final EditText peso = findViewById(R.id.EDT_Peso);
                final EditText altura = findViewById(R.id.EDT_Altura);
                final EditText resultado = findViewById(R.id.EDT_BMI);
                final TextView Catego = findViewById(R.id.STC_Categoria);

                // Se realizan cálculos en base a los datos de los controles
                String sAltura = altura.getText().toString();

                double dPeso = Double.parseDouble(peso.getText().toString());
                double dAltura = Double.parseDouble(sAltura);
                double BMI = (dPeso) / (dAltura * dAltura);
                resultado.setText(Double.toString(BMI));

                // Se realizan cálculos para calcular la categoría
                String categoria;
                if (BMI < 15)
                    categoria = "Muy severo bajo peso.";
                else if (BMI < 16)
                    categoria = "Severo bajo peso.";
                else if (BMI < 18.5)
                    categoria = "Bajo peso.";
                else if (BMI < 25)
                    categoria = "Normal";
                else if (BMI < 30)
                    categoria = "Sobre peso.";
                else if (BMI < 35)
                    categoria = "Clase obesa 1 - Moderadamente obeso.";
                else if (BMI < 40)
                    categoria = "Clase obesa 2 - Severamente obeso";
                else
                    categoria = "Clase obesa 3 - Muy severamente obeso (gordo).";
                Catego.setText(categoria);
            }
        });
    }

}
