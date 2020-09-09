package edu.up.facemaker;


import java.util.Random;

public class Face {

    private int skinColor;
    private int eyeColor;
    private int hairColor;
    private int hairStyle;

    public Face() {

    }

    public void randomize() {
        Random r = new Random();
        this.skinColor = r.nextInt(255);
        this.eyeColor = r.nextInt(255);
        this.hairColor = r.nextInt(255);
        this.hairStyle = r.nextInt(3) + 1;

    }

}
