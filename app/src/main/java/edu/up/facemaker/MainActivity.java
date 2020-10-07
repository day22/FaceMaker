/***************************************************************************************
 *    Title: FaceMaker
 *    Author: Aidan Day
 *    Date: 9/8/2020
 *    Code version: 1.0
 *    Availability: https://github.com/day22/FaceMaker
 *
 ***************************************************************************************/
package edu.up.facemaker;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity  {

    //String array for Spinner values
    private String[] hairTypes = {"bald","short","old man hair","starting to bald"};
    Spinner hairSpinner;


    //OnCreate connects the elements of the view to the corresponding listeners in the controller
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //refenence to faceView
        Face face = findViewById(R.id.faceView);

        SeekBar greenSeek = findViewById(R.id.greenSeekBar);
        SeekBar redSeek = findViewById(R.id.redSeekBar);
        SeekBar blueSeek = findViewById(R.id.blueSeekBar);

        //surfaceView controller with added access to seekbars
        FaceController controller = new FaceController(face,greenSeek,redSeek,blueSeek);

        Button randomButton = findViewById(R.id.randomButton);
        randomButton.setOnClickListener(controller);

        redSeek.setOnSeekBarChangeListener(controller);
        blueSeek.setOnSeekBarChangeListener(controller);
        greenSeek.setOnSeekBarChangeListener(controller);

        RadioGroup radioGroup = findViewById(R.id.rGroup);
        radioGroup.setOnCheckedChangeListener(controller);

        populateSpinner();
        hairSpinner.setOnItemSelectedListener(controller);
    }

    //sets up the spinner with the values from hairTypes
    protected void populateSpinner() {
         /*
        code below was adapted from Andrew Nuxoll spinner example given in class.
         */
        //adapts String array for Spinner drop down item
        ArrayAdapter<String> hairAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,hairTypes);

        //access Spinner by id
        hairSpinner = findViewById(R.id.hairSpinner);

        //sets spinner value
        hairSpinner.setAdapter(hairAdapter);
    }
}