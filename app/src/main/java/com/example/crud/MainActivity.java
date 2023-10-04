package com.example.crud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //declaro Variables
    Spinner spSpinner;
    String[] comunas = new String[]{"La Pintana","La Granja","La Pincoya","Puente Alto","El Castillo"};
    EditText edtRut, edtNombre, edtDireccion;
    ListView Lista;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //conexion de las variables con los ID del XML
        edtRut=(EditText) findViewById(R.id.edtRut);
        edtNombre=(EditText) findViewById(R.id.edtNombre);
        edtDireccion=(EditText) findViewById(R.id.edtDireccion);
        spSpinner=(Spinner) findViewById(R.id.spSpinner);
        Lista = (ListView) findViewById(R.id.lstLista);
        //poblar Spinner
        ArrayAdapter<String> spinenerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, comunas);
        spinenerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spSpinner.setAdapter(spinenerAdapter);
    }

    public void onClickAgregar(View view){
        DataHelper dh=new DataHelper(this, "alumno.db",null, 1);
        SQLiteDatabase bd= dh.getReadableDatabase();
        ContentValues reg = new ContentValues();
        reg.put("rut", edtRut.getText().toString());
        reg.put("rut", edtNombre.getText().toString());
        reg.put("rut", edtDireccion.getText().toString());

        long resp=bd.insert("alumno",null,reg);
        bd.close();
        if(resp==1){
            Toast.makeText(this , "no se pudo agregar el alumno", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Registro Agregado con Exito", Toast.LENGTH_SHORT).show();
        }
        CargarLista();
    }
}