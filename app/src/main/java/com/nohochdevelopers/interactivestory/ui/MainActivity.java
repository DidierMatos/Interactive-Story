package com.nohochdevelopers.interactivestory.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.nohochdevelopers.interactivestory.R;

public class MainActivity extends AppCompatActivity {

    private EditText nameField;
    protected Button startButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameField = (EditText) findViewById(R.id.editText);
        startButton = (Button) findViewById(R.id.btnStart);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameField.getText().toString(); //obtiene el nombre del EditText para almacenarlo

                //Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();
                startStory(name); // llama al metodo pasandole el parametro name
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        nameField.setText("");
    }

    private void startStory(String name) {

        Intent intent = new Intent(this, StoryActivity.class);  // instanciando el intent y declarando el activity hacia donde sera enviada
        Resources resources = getResources(); //crea la instancia para obtener resources del archivo strings.xml
        String key = resources.getString(R.string.key_name);    //se almacena en key obteniendola del archivo strings.xml



        intent.putExtra(key, name); // estableciendo el valor con una llave de identificacion
        startActivity(intent); //la informacion almacenada en intent es enviada a la siguiente activity

    }
}
