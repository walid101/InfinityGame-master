package Extra;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Disposable;
import com.wallegameone.IG;

import java.util.ArrayList;

import ScreenMod.mouseControl;

public class Dialogue implements Disposable
{
    IG currGame;
    mouseControl control = new mouseControl(currGame);
    ArrayList<Line> lines;
    ArrayList<Line> staticLines;
    Texture dialogueBackground;
    private float futureTime;
    private int currentLine;
    private float stateTime;
    private boolean complete;
    private float DURATION=4;
    private final int GAP=25;
    private String characterName;
    private Texture characterPicture;
    public Texture Char;
    int CharWidth = 125;
    int CharHeight = 140;
    int CharX = 640 - CharWidth;
    int CharY = -20;
    public int height;
    //This class will contain 3 Line in total
    public Dialogue(String a,String b,String c,String name, String Icon, int dur, IG thisGame)
    {
        currGame = thisGame;
        futureTime=0;
        stateTime=Gdx.graphics.getDeltaTime();
        dialogueBackground=new Texture(Gdx.files.internal("dialogueBack.png"));
        complete=false;
        Char = new Texture(Icon);
        lines=new ArrayList<Line>();

        lines.add(new Line(a,0));
        lines.add(new Line(b,1));
        lines.add(new Line(c,2));

        characterName=name;

        currentLine=0;
        DURATION = dur;


    }
    public Dialogue(String a,String b,String c,String name, int dur, IG thisGame)
    {
        currGame = thisGame;
        futureTime=0;
        stateTime=Gdx.graphics.getDeltaTime();
        dialogueBackground=new Texture(Gdx.files.internal("dialogueBack.png"));
        complete=false;
        lines=new ArrayList<Line>();

        lines.add(new Line(a,0));
        lines.add(new Line(b,1));
        lines.add(new Line(c,2));

        characterName=name;

        currentLine=0;
        DURATION = dur;


    }
    public Dialogue(ArrayList<String> strs)
    {
        dialogueBackground=new Texture(Gdx.files.internal("BlackDialogue.png"));
        complete = false;
        for(int i = 0; i<strs.size(); i++)
        {
            lines.add(new Line(strs.get(i), i));
        }
        height = strs.size() * 15;
    }

    public void drawDialogue(SpriteBatch batch, int x, int y, int width, int height)
    {
        stateTime+=Gdx.graphics.getDeltaTime();

        //batch.draw(dialogueBackground,0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight()/4);
        batch.draw(dialogueBackground, x,y, width, height);
        batch.draw(Char, control.convertW(CharX), control.convertH(CharY), control.convertW(CharWidth), control.convertH(CharHeight));
        if(stateTime>futureTime&&currentLine==0)
        {
            futureTime=stateTime+DURATION;

            currentLine=1;
        }
        else if(stateTime>futureTime&&currentLine==1)
        {
            futureTime=stateTime+DURATION;

            currentLine=2;
        }
        else if(stateTime>futureTime&&currentLine==2)
        {
            futureTime=stateTime+DURATION;

            currentLine=3;
        }

        lines.get(0).drawName(batch,GAP,115,characterName);

        if(currentLine==1)
        {
            lines.get(0).drawLine(batch,GAP,90);
        }
        else if(currentLine==2)
        {
            lines.get(0).drawLine(batch,GAP,90);
            lines.get(1).drawLine(batch,GAP,65);
        }
        else if(currentLine==3)
        {
            lines.get(0).drawLine(batch,GAP,90);
            lines.get(1).drawLine(batch,GAP,65);
            lines.get(2).drawLine(batch,GAP,40);

            if(Gdx.input.isTouched()|| stateTime >= futureTime)
            {
                complete=true;
            }
        }

    }
    public void drawStaticDialogue(SpriteBatch batch,int x, int y, int width)
    {
        //batch.draw(dialogueBackground, x,y, width, 3 * 15);
        lines.get(0).drawLine(batch,GAP,y + height);

        lines.get(1).drawLine(batch,GAP,y + height - 15);

        lines.get(2).drawLine(batch,GAP,y + height - 30);
        if(height == 0)
        {
            height = 45;
        }
    }
    public boolean isComplete()
    {
        return complete;
    }

    public void dispose()
    {
        dialogueBackground.dispose();
        lines.get(0).dispose();
        lines.get(1).dispose();
        lines.get(2).dispose();
    }
}

