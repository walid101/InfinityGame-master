package Extra;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;

public class Line implements Disposable
{
    private String line;
    private BitmapFont font;
    private int numberLine;
    private float futureTime;
    //This class will simply represent a draw that the Dialogue can draw
    public Line(String givenLine,int givenNumberLine)
    {
        //For our purpose we only store 50 characters
        line=givenLine;
        numberLine=givenNumberLine;

        font=new BitmapFont();
    }

    public void drawLine(SpriteBatch batch,int x,int y)
    {
        font.getData().setScale(1.1f);
        font.setColor(Color.WHITE);

        font.draw(batch,line,x,y);
    }

    public void drawName(SpriteBatch batch,int x,int y,String name)
    {
        font.getData().setScale(1.2f);

        font.setColor(Color.WHITE);

        font.draw(batch,name,x,y);
    }


    public int getNumberLine()
    {
        return numberLine;
    }

    public String getLine()
    {
        return line;
    }

    public void dispose()
    {

    }
}
