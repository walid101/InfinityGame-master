package Extra;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public abstract class Obj{

    //Variables that all the other classes tending from GameObject will have
    public com.badlogic.gdx.math.Rectangle full;
    public Sprite sprite;
    public Texture texture;

    public Obj(int x,int y,int width,int height)
    {
        full=new Rectangle(0,0,width,height);
        texture=new Texture(Gdx.files.internal("skeleton.png"));
        sprite=new Sprite(texture,x,y,width,height);

        setPosition(x,y);
    }

    public abstract void draw();
    public abstract void getHitBox();
    public abstract void setTexture();
    public abstract void setSprite();
    public abstract void setPosition(float x,float y);



}
