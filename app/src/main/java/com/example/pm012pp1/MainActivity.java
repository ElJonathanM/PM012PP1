package com.example.pm012pp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtnombre, txtapellido;
    Button btnmostrar, btnsecond;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtnombre = (EditText) findViewById(R.id.txtnombre);
        txtapellido = (EditText)  findViewById(R.id.txtapellido);
        btnmostrar = (Button)  findViewById(R.id.btnmostrar);
        btnsecond = (Button) findViewById(R.id.btnsecond);

        btnmostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Nombre " + txtnombre.getText().toString(),Toast.LENGTH_LONG).show();
            }
        });

        btnsecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                intent.putExtra("nombre", txtnombre.getText().toString());
                intent.putExtra("apellido", txtapellido.getText().toString());
                startActivity(intent);
            }
        });

    }
}