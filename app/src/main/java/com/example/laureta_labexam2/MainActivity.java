package com.example.laureta_labexam2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    CheckBox checkBox1,checkBox2,checkBox3,checkBox4,checkBox5,checkBox6,
            checkBox7,checkBox8;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        checkBox4 = findViewById(R.id.checkBox4);
        checkBox5 = findViewById(R.id.checkBox5);
        checkBox6 = findViewById(R.id.checkBox6);
        checkBox7 = findViewById(R.id.checkBox7);
        checkBox8 = findViewById(R.id.checkBox8);

    }

    public void writeData (View v) {
        String comment1data = editText.getText().toString();

        String subjects = "";
        if (checkBox1.isChecked()) {
            subjects = subjects + checkBox1.getText().toString() + "\n";
        }
        if (checkBox2.isChecked()) {
            subjects = subjects +  checkBox2.getText().toString()+ "\n" ;
        }
        if (checkBox3.isChecked()) {
            subjects = subjects + checkBox3.getText().toString()+ "\n";
        }
        if (checkBox4.isChecked()) {
            subjects = subjects + checkBox4.getText().toString()+ "\n";
        }
        if (checkBox5.isChecked()) {
            subjects = subjects + checkBox5.getText().toString()+ "\n";
        }
        if (checkBox6.isChecked()) {
            subjects = subjects + checkBox6.getText().toString()+ "\n";
        }
        if (checkBox7.isChecked()) {
            subjects = subjects + checkBox7.getText().toString()+ "\n";
        }
        if (checkBox8.isChecked()) {
            subjects = subjects + checkBox8.getText().toString()+ "\n";
        }



        FileOutputStream writer = null;
        FileOutputStream writer1 = null;
        try {
            writer = openFileOutput("data1.txt", MODE_PRIVATE);
            writer1 = openFileOutput("data2.txt", MODE_PRIVATE);
            writer1.write(subjects.getBytes());
            writer.write(comment1data.getBytes());
        } catch(FileNotFoundException e) {
            Log.d("Error", "File not found.");
        } catch (IOException e) {
            Log.d("Error", "IO Error.");
        } finally {
            try {
                writer.close();
                writer1.close();
            } catch (IOException e) {
                Log.d("Error", "File not found.");
            }
        }
        Toast.makeText(this, "Data is saved.", Toast.LENGTH_LONG).show();
    }


    public void next(View v){
        Intent i = new Intent(getApplicationContext(), Confirmation.class);
        startActivity(i);
    }
}
