package edu.up.facemaker;


import java.util.Random;

public class Face {

    private int skinColor;
    private int eyeColor;
    private int hairColor;
    private int hairStyle;

    public Face() {
        randomize();
    }

    public void randomize() {
        Random r = new Random();

        //selects random integer between 0-255 for color assignment
        this.skinColor = r.nextInt(255);
        this.eyeColor = r.nextInt(255);
        this.hairColor = r.nextInt(255);

        //selects random integer between 1-4 for hair options
        this.hairStyle = r.nextInt(3) + 1;

    }

}
