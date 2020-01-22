package Extra;

public class Background extends Obj{

    public Background(int x,int y)
    {
        super(x,y,64,64);



    }

    @Override
    public void draw() {

    }

    @Override
    public void getHitBox() {

    }

    @Override
    public void setTexture() {

    }

    @Override
    public void setSprite() {

    }

    @Override
    public void setPosition(float x, float y) {
        this.full.x=x;
        this.full.y=y;
    }
}