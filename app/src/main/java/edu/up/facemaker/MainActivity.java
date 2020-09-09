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

import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    //String array for Spinner values
    private String[] hairTypes = {"long","short","bald"};
    Spinner hairSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        populateSpinner();
    }

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