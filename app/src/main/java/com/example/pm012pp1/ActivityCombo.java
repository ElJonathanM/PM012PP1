package com.example.pm012pp1;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.pm012pp1.Procesos.Empleados;
import com.example.pm012pp1.Procesos.SQLiteConexion;
import com.example.pm012pp1.Procesos.Transsacciones;

import java.util.ArrayList;

public class ActivityCombo extends AppCompatActivity {

    SQLiteConexion conexion;
    Spinner comboEmpleado;
    EditText nombres, apellidos, edad, correo;

    ArrayList<Empleados>listaempleados;
    ArrayList<String>ArregloEmpleados;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combo);
        
        nombres = (EditText) findViewById(R.id.txtconnombres);
        apellidos = (EditText) findViewById(R.id.txtconapellidos);
        edad = (EditText) findViewById(R.id.txtconedad);
        correo = (EditText) findViewById(R.id.txtconemail);
        comboEmpleado = (Spinner) findViewById(R.id.txtcomboPersona);
        
        conexion  = new SQLiteConexion(this, Transsacciones.NameDataBase, null, 1);
        
        ObtenerListaEmpleados();

        ArrayAdapter<CharSequence> adp = new ArrayAdapter(this, android.R.layout.simple_spinner_item, ArregloEmpleados);

    }

    private void ObtenerListaEmpleados() {
        SQLiteDatabase db = conexion.getReadableDatabase();
        Empleados empleado = null;
        listaempleados = new ArrayList<Empleados>();

        Cursor cursor = db.rawQuery("SELECT * FROM " + Transsacciones.tablaEmpleados, null);

        while(cursor.moveToNext()){
            empleado = new Empleados();
            empleado.setId(cursor.getInt(0));
            empleado.setNombres(cursor.getString(1));
            empleado.setApellidos(cursor.getString(2));
            empleado.setEdad(cursor.getInt(3));
            empleado.setCorreo(cursor.getString(4));

            listaempleados.add(empleado);

        }
        cursor.close();
        fillList();
    }

    private void fillList() {
        ArregloEmpleados = new ArrayList<String>();
        for (int i = 0; i<listaempleados.size(); i++){
            ArregloEmpleados.add(listaempleados.get(i).getId() + " + "
                    + listaempleados.get(i).getNombres() + " + "
                    + listaempleados.get(i).getApellidos());
        }
    }
}