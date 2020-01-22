package Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.sun.org.apache.xpath.internal.operations.Or;
import com.wallegameone.IG;

import java.util.ArrayList;

import Decoders.GifDecoder;

import Extra.Dialogue;
import ScreenMod.mouseControl;

public class GameScreen implements Screen
{
    int setWidth = Gdx.graphics.getWidth();
    int setHeight = Gdx.graphics.getHeight();
    OrthographicCamera cam = new OrthographicCamera();
    Animation<TextureRegion> animation;//This stores GIF screens in the future
    Dialogue converse; // first character to user interaction by dialogue
    Dialogue converse2; // second character to user interaction by dialogue
    boolean stop = false; //
    float elapsed;

    Texture back; // the background image of the GameScreen
    IG thisGame; // taken from the parent class IG game to use the draw method
    Music music2; // the background music for GameScreen
    Texture click; //the rotating circles that will be the click index for user

    //These are the x, and y for click, also
    //Height and width for click :::::::::::::::::::::::::::;
        int clickX = 208;
        int clickY = 170;
        //i, j, k are the relative locations for each circle
        //this is because eventually when the user hovers over
        //the circles will have different speeds
        int i = 0;
        int j = 0;
        int k = 0;
        //this is what adds to the i,j, k (circle position relative to the y-axis)
        //causing it to act like a speed scalar
        int vel = 2;
        //these are the set circle width and height for the click index
        int clickWidth = 63;
        int clickHeight = 60;
    //::::::::::::::::::::::::::::::
    Texture clickCen;
    int click2X = 400;
    int click2Y = 240;

    Texture clickBar;
    int barClickX = 520;
    int barClickY = 240;

    Texture BlackBack;
    mouseControl control;//includes methods to help decode
                         //user input, go to the mouseControl
                         //class for more information.


    //These are the descriptions presented to user
    //when they hover over the rotating circles
    Dialogue log1;
    Dialogue log2;
    Dialogue log3;
    Dialogue log4;

    //These are the encapsulating methods that hold textures
    //allowing them to rotate, these are currently holding
    //the circle textures
    TextureRegion reg;
    TextureRegion centReg;
    TextureRegion barReg;

    boolean con1Comp = false;
    public GameScreen(IG game)
    {

        thisGame = game;//instantiating this game by passing it the main game from menu screen
        back = new Texture("backGame1.jpg");//instantiating background image
        control = new mouseControl(thisGame);//instantiating mouseControl class by passing it thisgame
        click = new Texture("click.png");//instantiating the click class
        reg = new TextureRegion(click);//encapsulating the click texture with a region to make it spin

        clickCen = new Texture("click.png");//instantiating the center click index
        centReg = new TextureRegion(clickCen);//encapsulating center click index

        clickBar = new Texture("click.png");//instantiating bar click index
        barReg = new TextureRegion(clickBar);//encapsulating bar click texture
        music2 = Gdx.audio.newMusic(Gdx.files.internal("Scene2Music.mp3"));//setting
                                                                                 //background music
        //here we are spiliting the gif into an arrayList of textures with a given delta time in between
        animation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("backgroundRain.gif").read());
        //giving the converse instances dialogue to say
        converse = new Dialogue("Ugh..............", "Where am I..........", "..Ugh My head...", "SONNY:", "SonnyIcon.png", 3, thisGame);//Last one always goes first
        converse2 = new Dialogue("the last thing I remember was that doctor.......", "....who was he?....and why did he have the governmential signet?...", ".........", "SONNY:","SonnyIcon.png", 4, thisGame);
        //This is what will be printed on the screen when the user hovers over the click instaances, based on which
        //they are hovering on top of
        log1 = new Dialogue("This is the store, " , "here you can buy new armaments", "for your characters, PRESS TO ENTER", "STORE", 3, thisGame);
        log2 = new Dialogue("This is the NEXT WORLD", "please finish the current challenges first", " and then move forward, PRESS TO ENTER", "NEW WORLD", 3, thisGame);
        log3 = new Dialogue("This is the Local bar", "Wait a minute, did you hear that crash?", "better check it out, PRESS TO ENTER", "first mission", 3 , thisGame);

        BlackBack = new Texture(Gdx.files.internal("dialogueBack.png"));
    }
    @Override
    public void show()
    {
        music2.play();//playing background music
    }

    @Override
    public void render(float delta) {
        //Each time the previous screen needs to be cleared, otherwise it is Extremely inefficient
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        thisGame.batch.begin();//starting the batch that we will draw on
        thisGame.batch.enableBlending();//allows for clear background images
        elapsed += Gdx.graphics.getDeltaTime();//getting time between frames
        //controlling when to stop the music (like if the user selects this from the options menu)
        if (music2.isPlaying() == false && stop == false) {
            music2.play();
        }
        thisGame.batch.draw(BlackBack,0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        //drawing the background, origin at 0,0 length and width fo the screen
        thisGame.batch.draw(back, 0, 0, control.convertW(640), control.convertH(480));
        //thisGame.batch.draw(back, Gdx.graphics.getWidth()/2 - setWidth/2, Gdx.graphics.getHeight()/2 - setHeight/2, setWidth, setHeight);

        //getting the deltaTime here
        thisGame.batch.draw(animation.getKeyFrame(elapsed), 20.0f, 20.0f, control.convertW(500),Gdx.graphics.getHeight());
        //adding to the i,j,k positions to make the clicks spin
        i += vel;
        j += vel;
        k += vel;
        //drawing the first click index (shop)
        thisGame.batch.draw(reg, control.convertW(clickX), control.convertH(clickY), clickWidth / 2, clickHeight / 2, clickWidth, clickHeight, 1, 1, i, true);
        //LOCATION TEST PURPOSES
        /**
         if(control.isHovering(Gdx.graphics.getWidth(), 0, Gdx.graphics.getHeight(), 0))
         {
         System.out.println("" + Gdx.input.getX() + " , " + Gdx.input.getY());
         }
         **/
        //seeing if user is hovering over the shopClick index
        if (control.isHovering(control.convertW(clickX + clickWidth), control.convertW(clickX), control.convertH(clickY + clickHeight), control.convertH(clickY))) {
            log1.drawStaticDialogue(thisGame.batch, control.convertW(clickX), control.convertH(click2Y), Gdx.graphics.getWidth()/6);
            //the index will spin faster to indicate that the user is hovering over it
            i+=vel;
            //if user decides to click while also hovering over the shopClick index then the user
            //enters the store
            if (control.isClicked()) {
                System.out.println("Enter Store");
                music2.pause();//this is here just for rest
                thisGame.setScreen(new Store(thisGame));//enters the store screen
                stop = true;//stops the music
            }
        }
        //drawing the centerClick index (if clicked sends user to new worls if they completed their quests)
        thisGame.batch.draw(centReg, control.convertW(click2X), control.convertH(click2Y), clickWidth / 2, clickHeight / 2, clickWidth, clickHeight, 1, 1, j, true);
        //the mouse is hovering over the center region then continue::
        if (control.isHovering(control.convertW(click2X + clickWidth), control.convertW(click2X), control.convertH(click2Y + clickHeight), control.convertH(click2Y))) {
            //making the index spin faster as to indicate that the user has hovered over it
            j+=vel;
            log2.drawStaticDialogue(thisGame.batch, click2X, click2Y, 2);
            if (control.isClicked()) {
                System.out.println("Enter New World");
                //THIS IS TEMPORARY :: IT IS FOR TESTING SKILL TREE DATE: 8/15/19
                //
                thisGame.setScreen(new SkillTree(thisGame));

                //
                stop = false;
            }
        }
        System.out.println("nX: " + barClickX);
        System.out.println("newX: " + control.convertW(barClickX));
        thisGame.batch.draw(barReg, control.convertW(barClickX), control.convertH(barClickY), clickWidth / 2, clickHeight / 2, clickWidth, clickHeight, 1, 1, k, true);
        if (control.isHovering(control.convertW(barClickX + clickWidth), control.convertW(barClickX), control.convertH(barClickY + clickHeight), control.convertH(barClickY))) {
            k+=vel;
            log3.drawStaticDialogue(thisGame.batch, control.convertW(barClickX), control.convertH(barClickY), 20);
            if (control.isClicked()) {
                System.out.println("Enter Bar");
                thisGame.setScreen( new Bar(thisGame));
            }
        }
        if(converse.isComplete()){converse.dispose();
        con1Comp = true;
        }
        else {
            converse.drawDialogue(thisGame.batch, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/4);
        }
        if(con1Comp == true && converse2.isComplete() == false)
        {
            converse2.drawDialogue(thisGame.batch, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/4);

        }
        else
        {
            if(converse2 != null)
            {
                converse2.dispose();
            }
        }
        thisGame.batch.end();
    }

    @Override
    public void resize(int width, int height)
    {
        cam.setToOrtho(false);
        thisGame.batch.setProjectionMatrix(cam.combined);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose()
    {
        thisGame.dispose();
    }

}
