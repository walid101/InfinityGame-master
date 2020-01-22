package Slider;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.wallegameone.IG;

public class Slider {
    IG thisGame;
    double xpos1, xpos2, xpos3;
    double currentTime;
    int growthFactor = 2;
    float deltaTime = Gdx.graphics.getDeltaTime();
    double spd = 0 * deltaTime;//these will be Tested:: initital creation at: 12:05, 8/4/2019
    int accel = 2; //these will be Tested:: initial creation at: 12:05, 8/4/2019 (NOTE: to decelerate:: )
    //multiple the accel by -1 and use physics formulas for new velocity;
    double startX1;
    double startX2;
    double thisMiddle = Gdx.graphics.getWidth() / 2;
    double quart;
    int third;
    int height = 80;
    int width = 110;
    float moveSpace = 0;
    Sprite[] slides;

    public Slider(IG game2, Sprite[] slideX, double startArr, double startArr2) {
        thisGame = game2;
        slides = new Sprite[slideX.length];
        startX1 = startArr;
        startX2 = startArr2;
        quart = (int)(thisMiddle - startX1) / 2;
        third = (int)(thisMiddle + startX2) / 2;
    }

    public Sprite[] getSlides() {
        return slides;
    }

    public void setSlides(Texture[] thisSlides) {
        translate(thisSlides, slides);
    }

    public void present() {

    }

    public void translate(Texture[] A, Sprite[] B) {
        for (int i = 0; i < A.length; i++) {
            B[i] = new Sprite(A[i]);
        }
    }

    public void moveArrRight() {
        Sprite[] output = new Sprite[slides.length];
        for (int i = 0; i < slides.length; i++) {
            if (i == 0) {
                output[0] = slides[slides.length - 1];
            } else {
                output[i] = slides[i - 1];
            }
        }
        slides = output;
    }

    public void moveArrLeft() {
        Sprite[] output = new Sprite[slides.length];
        for (int i = slides.length - 1; i >= 0; i--) {
            if (i == slides.length - 1) {
                output[i] = slides[0];
            } else {
                output[i] = slides[i + 1];
            }
        }
    }

    public boolean moveRight(int yPos)//move what is in the beginning of array ot the next slot;
    {
        //NOTE: IF THE BOOLEAN FROM THIS METHOD BECOMES TRUE THAT MEANS ONE SLIDE HAS MOVED

        System.out.println("1");
        double middle = slides[0].getWidth() + slides[0].getX();
        double middle2 = slides[1].getWidth() + slides[1].getX();
        double middle3 = slides[2].getWidth() + slides[2].getX();

        if (middle >= thisMiddle) {
            moveArrRight();
            moveSpace = 0;
            return true;
        } else {
            if (middle < quart) {
                spd += accel;
                width+=growthFactor;
                height += growthFactor;
            } else {
                spd -= accel;
                width -= growthFactor;
                height -= growthFactor;
            }
            Sprite a = slides[0];
            Sprite b = slides[1];
            Sprite c = slides[2];
            //ArrowWifth = 55, height == 45
            a.setRegionHeight(height);
            a.setRegionWidth(width);
            a.setPosition((float) (quart + moveSpace), yPos - a.getHeight() / 2);

            b.setRegionHeight(height);
            b.setRegionWidth(width);
            b.setPosition((float) (thisMiddle + moveSpace), yPos - c.getHeight() / 2);

            c.setRegionHeight(height);
            c.setRegionWidth(width);
            c.setPosition((float) (third + moveSpace), yPos - c.getHeight() / 2);

            a.draw(thisGame.batch);
            c.draw(thisGame.batch);
            b.draw(thisGame.batch);
            moveSpace += spd;
            System.out.println("should be sliding");

        }
        return false;
    }

}
