package Characters;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.wallegameone.IG;
//NOTE: Day 1 Tasks: Create an initial frame of creation, things such as health, body type, and other characteristics'
// need to be completed :::::::::::::::::::::::::Tasks completed: Start Date for the Character Module: 7/31/19
//NOTE: Day 2 Tasks: Create a weapons module for the character, the weapons module should be mutable as the
//player will have new weapons when upgraded::::::::::::::::::::::
public class Being
{
    public  SpriteBatch thisBatch;
    public Sprite newBeing;
    public Texture oneBody;
    public IG thisGame;
    public String Name;
    public int x;
    public int y;
    public int Health = 200;
    public int Strength = 40;
    public int Speed = 20;
    public Texture head;
    public Texture body;
    public Texture torso;
    float Height;
    ShapeRenderer healthBar;
    public int skillPoints = 3;
    public Being(IG game,String name, String hair, String shirt, String shoes, int x1, int y1, int health, int strength, int speed)
    {
        thisGame = game;
        Name = name;
        head = new Texture(hair);
        body = new Texture(shirt);
        torso = new Texture(shoes);
        x = x1;
        y = y1;
        Strength = strength;
        Health = health;
        Speed = speed;
        healthBar = new ShapeRenderer();
        Height = head.getHeight() + body.getHeight() + torso.getHeight();
    }
    public Being(IG game,String name, String anim, int x1, int y1, int health, int strength, int speed)
    {
        thisGame = game;
        Name = name;
        oneBody = new Texture(anim);

        x = x1;
        y = y1;
        Strength = strength;
        Health = health;
        Speed = speed;
        healthBar = new ShapeRenderer();
        newBeing = new Sprite(oneBody);
    }
    public void make()
    {
        thisGame.batch.draw(torso, x, y);
        thisGame.batch.draw(body,x,y + torso.getHeight());
        thisGame.batch.draw(head,x,y + torso.getHeight() + body.getHeight());

                /**
        healthBar.begin(ShapeRenderer.ShapeType.Filled);
        healthBar.rect(x,y + 30 + Height,Health, 40);
                 **/


    }
    public void makeBody()
    {
        thisGame.batch.draw(oneBody, x, y, 150, 200);
        /**
        newBeing.setBounds(x,y,200,300);
        newBeing.setColor(1, 0, 0, 0.2f);
        newBeing.draw(thisGame.batch);
         **/

    }
    public Texture getOneBody()
    {
        return oneBody;
    }
    public Texture getHead()
    {
        return head;

    }
    public Texture getBody()
    {
        return body;
    }
    public Texture getTorso()
    {
        return torso;
    }
    public String getName()
    {
        return Name;
    }
    public int getHealth()
    {
        return Health;
    }
    public int getStrength()
    {
        return Strength;
    }
    public int getSpeed()
    {
        return Speed;
    }
    public void setHealth(int newH)
    {
        Health = newH;
    }
    public void setStrength(int newS)
    {
        Strength = newS;
    }
    public void setSpeed(int newSp)
    {
        Speed = newSp;
    }
    public void destroy()
    {
        head.dispose();
        body.dispose();
        torso.dispose();
        System.out.println("remember to set this object to null");
    }
    public int getSkillPoints()
    {
        return skillPoints;
    }
    public void setSkillPoints(int newPoints)
    {
        skillPoints = newPoints;
    }
    public void addPoint()
    {
        skillPoints++;
    }
    public void subPoint()
    {
        skillPoints--;
    }
}
