/***************************************************************************************
 *    Title: FaceMaker
 *    Author: Aidan Day
 *    Date: 9/8/2020
 *    Code version: 1.0
 *    Availability: https://github.com/day22/FaceMaker
 *
 ***************************************************************************************/

package edu.up.facemaker;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.View;
import android.widget.SeekBar;

import java.util.Hashtable;
import java.util.Random;

public class Face extends SurfaceView {

    FaceModel model = new FaceModel();

    private Paint skinPaint = new Paint(); //paint for skin color
    private Paint hairPaint = new Paint(); //paint for hair color
    private Paint eyePaint = new Paint();  //paint for eye color


    Paint white = new Paint();
    Paint black = new Paint();

    //Constructor for Face class that acts as a surface view
    public Face(Context context, AttributeSet attrs) {
        super(context, attrs);
        randomize();
        setWillNotDraw(false);

        white.setColor(Color.WHITE);
        black.setColor(Color.BLACK);
    }

    //model getter
    public FaceModel getModel() {
        return this.model;
    }

    //draws face on
    @Override
    public void onDraw(Canvas canvas) {
        setPaint();
        drawFace(canvas);

    }

    public void setPaint(){
        int eyeColor = Color.rgb(model.eyeColorRed,model.eyeColorGreen,model.eyeColorBlue);
        eyePaint.setColor(eyeColor);
        int hairColor = Color.rgb(model.hairColorRed,model.hairColorGreen,model.hairColorBlue);
        hairPaint.setColor(hairColor);
        int skinColor = Color.rgb(model.skinColorRed,model.skinColorGreen,model.skinColorBlue);
        skinPaint.setColor(skinColor);
    }

    public void randomize() {
        Random r = new Random();

        //selects random integer between 0-255 for color assignment
        model.eyeColorBlue = r.nextInt(255);
        model.eyeColorGreen = r.nextInt(255);
        model.eyeColorRed = r.nextInt(255);

        model.hairColorBlue = r.nextInt(255);
        model.hairColorGreen = r.nextInt(255);
        model.hairColorRed = r.nextInt(255);

        model.skinColorBlue = r.nextInt(255);
        model.skinColorGreen = r.nextInt(255);
        model.skinColorRed = r.nextInt(255);

        //selects random integer between 1-4 for hair options
        model.hairStyle = r.nextInt(3) + 1;
    }

    public void drawFace(Canvas canvas) {
        drawHead(canvas);
        drawHair(canvas);
        drawEyes(canvas);
        drawMouth(canvas);
    }

    private void drawEyes(Canvas canvas) {

        canvas.drawCircle((float)canvas.getWidth()*.750f,(float)canvas.getHeight()/2,(float)canvas.getWidth()/8,white); //draw left eye background
        canvas.drawCircle((float)canvas.getWidth()/4,(float)canvas.getHeight()/2,(float)canvas.getWidth()/8,white); //draw right eye background
        //draw iris
        canvas.drawCircle((float)canvas.getWidth()*.750f,(float)canvas.getHeight()/2,(float)canvas.getWidth()/10,eyePaint); //draw left eye background
        canvas.drawCircle((float)canvas.getWidth()/4,(float)canvas.getHeight()/2,(float)canvas.getWidth()/10,eyePaint); //draw right eye background
        //draw pupil
        canvas.drawCircle((float)canvas.getWidth()*.750f,(float)canvas.getHeight()/2,(float)canvas.getWidth()/12,black); //draw left eye background
        canvas.drawCircle((float)canvas.getWidth()/4,(float)canvas.getHeight()/2,(float)canvas.getWidth()/12,black); //draw right eye background

    }

    private void drawHair(Canvas canvas) {

        switch(model.hairStyle) {
            case 1:
                canvas.drawCircle((float) canvas.getWidth()*.5f, (float) canvas.getHeight() * .25f, canvas.getWidth() / 8, hairPaint);
                canvas.drawCircle((float) canvas.getWidth()*.4f, (float) canvas.getHeight() * .25f, canvas.getWidth() / 8, hairPaint);
                canvas.drawCircle((float) canvas.getWidth()*.6f, (float) canvas.getHeight() * .25f, canvas.getWidth() / 8, hairPaint);
                break;
            case 2:
                canvas.drawCircle((float) canvas.getWidth()*.2f, (float) canvas.getHeight() * .40f, canvas.getWidth() / 8, hairPaint);
                canvas.drawCircle((float) canvas.getWidth()*.8f, (float) canvas.getHeight() * .40f, canvas.getWidth() / 8, hairPaint);
                break;
            case 3:
                canvas.drawCircle((float) canvas.getWidth()*.2f, (float) canvas.getHeight() * .40f, canvas.getWidth() / 10, hairPaint);
                canvas.drawCircle((float) canvas.getWidth()*.8f, (float) canvas.getHeight() * .40f, canvas.getWidth() / 10, hairPaint);

                canvas.drawCircle((float) canvas.getWidth()*.5f, (float) canvas.getHeight() * .25f, canvas.getWidth() / 10, hairPaint);
                canvas.drawCircle((float) canvas.getWidth()*.4f, (float) canvas.getHeight() * .25f, canvas.getWidth() / 10, hairPaint);
                canvas.drawCircle((float) canvas.getWidth()*.6f, (float) canvas.getHeight() * .25f, canvas.getWidth() / 10, hairPaint);
                break;
        }
        invalidate();
    }

    private void drawHead(Canvas canvas) {

        canvas.drawCircle( (float)canvas.getWidth()/2,(float)canvas.getHeight()/2, (float)canvas.getWidth()/3
                , skinPaint);
        invalidate();
    }

    private void drawMouth(Canvas canvas) {
        black.setStrokeWidth(3);
        canvas.drawLine((float)canvas.getWidth()*.45f,(float)canvas.getHeight()*.65f,(float)canvas.getWidth()*.55f,(float)canvas.getHeight()*.65f,black);
    }
}
