/***************************************************************************************
 *    Title: FaceMaker
 *    Author: Aidan Day
 *    Date: 9/8/2020
 *    Code version: 1.0
 *    Availability: https://github.com/day22/FaceMaker
 *
 ***************************************************************************************/
package edu.up.facemaker;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;

import java.util.Random;

public class FaceController implements AdapterView.OnItemSelectedListener, RadioGroup.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener, Button.OnClickListener{

    private Face view;
    private FaceModel model;
    private SeekBar redBar,greenBar,blueBar;

    //Constucts controller giving access to the Face model and view
    public FaceController(Face myView,SeekBar redBar,SeekBar greenBar,SeekBar blueBar) {
        this.view = myView;
        model = view.getModel();
        this.redBar = redBar;
        this.greenBar = greenBar;
        this.blueBar = blueBar;
    }

    //listens for spinner to changes then updates hair style
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        model.hairStyle = i;
        view.invalidate();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        //do nothing
    }

    //When radio buttons are selected SeekBar values are updated to existing color values
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        model.attributeModify = i;
        switch (model.attributeModify) {
            case 2131165314:
                redBar.setProgress(model.hairColorRed);
                blueBar.setProgress(model.hairColorBlue);
                greenBar.setProgress(model.hairColorGreen);
                break;
            case 2131165304:
                redBar.setProgress(model.eyeColorRed);
                blueBar.setProgress(model.eyeColorBlue);
                greenBar.setProgress(model.eyeColorGreen);
                break;
            case 2131165393:
                redBar.setProgress(model.skinColorRed);
                blueBar.setProgress(model.skinColorBlue);
                greenBar.setProgress(model.skinColorGreen);
                break;
        }
        Log.i("index is",""+i);
        view.invalidate();
    }

    //when Seekbars change values they the Model values are updated
    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        switch (seekBar.getId()){
            case R.id.redSeekBar:
                updateRed(i);
                view.invalidate();
                break;
            case R.id.greenSeekBar:
                updateGreen(i);
                view.invalidate();
                break;
            case R.id.blueSeekBar:
                updateBlue(i);
                view.invalidate();
                break;

        }
    }

    public void updateRed(int color) {
        switch (model.attributeModify) {
            case 2131165314:
                model.hairColorRed = color;
                break;
            case 2131165304:
                model.eyeColorRed = color;
                break;
            case 2131165392:
                model.skinColorRed = color;
                break;
        }
    }
    public void updateGreen(int color) {
        switch (model.attributeModify) {
            case 2131165314:
                model.hairColorGreen = color;
                break;
            case 2131165304:
                model.eyeColorGreen = color;
                break;
            case 2131165393:
                model.skinColorGreen = color;
                break;
        }
    }

    public void updateBlue(int color) {
        switch (model.attributeModify) {
            case 2131165314:
                model.hairColorBlue = color;
                break;
            case 2131165304:
                model.eyeColorBlue = color;
                break;
            case 2131165393:
                model.skinColorBlue = color;
                break;
        }
    }


    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        //do nothing
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        //do nothing
    }

    @Override
    public void onClick(View view) {
        this.view.randomize();
        this.view.invalidate();
    }
}
