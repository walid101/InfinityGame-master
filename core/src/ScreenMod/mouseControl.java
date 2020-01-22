//AUTHOR NOTE: FULL DOCUMENTED as of 8/22/19
package ScreenMod;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.wallegameone.IG;

public class mouseControl
{

    IG mouseGame;//declaring on which game control should be operating on.
    public int x = Gdx.input.getX();//X-val of mouse position
    public int y = Gdx.input.getY();//Y-val of mouse position
    public int deltaX = Gdx.input.getDeltaX();//change in x-position
    public int deltaY = Gdx.input.getDeltaY();//change in y-position
    public mouseControl(IG game)
    {
        mouseGame = game;//instantiated game to central game instance;
    }

    /*
    Returns true if mouse is hovering over a certain square index
    Parameters: must input 4 integers, the first pair makes up
    the x-horizantal boundary, and the second pair makes the
    y-vertical boundary, the first of each pair must be greater
    than the second, respectively.

    Precondition: input 4 integers, x2>x1, y2>y1
    Postcondition: returns true if mouse x,y position is within
    bounds.

    Exceptions: throws IllegalArgumentException if(X2<X1 || Y2<Y1)
     */
    public boolean isHovering(int x2, int x1, int y2, int y1) // Range here is needed
    {
        int myY = Gdx.graphics.getHeight() - Gdx.input.getY();//this step flips mouse Y-val
        //as it is flipped relative to the screen's y-val.
        //Cheching if parameters follow rule:
        if(x2<x1 && y2<y1)
        { throw new IllegalArgumentException("Illegal Inputs for isHovering method call" +
                                             "your first number must be greater than your second \n" +
                                             "your third number must be greater than your fourth");}

        //Note: x2 is always the larger value, x1 is the smaller value, same for Y
        if (Gdx.input.getX() <=x2 && Gdx.input.getX() >= x1)
        {
            if(myY <= y2 && myY  >= y1)
            {
                return true;
            }

        }
        return false;
    }
    /*
    Returns true if user clicks the mouse
    precondition: user either clicks or does not click the mouse
    postcondition: boolean response on whether user clicked is returned
    parameters: N/A
     */
    public boolean isClicked()
    {
        return Gdx.input.justTouched();
    }
    /*
    This is a getter method, returns x-val of mouse position
    precondition: call method
    postcondition: returns x-val of mouse position
    parameters: N/A
     */
    public int getX()
    {
        return Gdx.input.getX();
    }
    /*
    this is a getter method, returns y-val of mouse position
    precondition: call method
    postcondition: returns y-val of mouse condition
    parameters: N/A
     */
    public int getY()
    {
        return Gdx.input.getY();
    }
    public int convertRW(int w)
    {
        double relW = 640;
        double factor = relW/w;
        int realPos = (int)(Gdx.graphics.getWidth()/factor);
        double currRatio = ((double)Gdx.graphics.getWidth()/(double)Gdx.graphics.getHeight());
        if(currRatio > 640.0/480.0)
        {
            return (int)(4.0/3.0*(double)Gdx.graphics.getHeight());
        }
        return realPos;
    }

    public int convertRH(int h)
    {
        double relW = 480;
        double factor = relW/h;
        int realPos = (int)(Gdx.graphics.getWidth()/factor);
        double currRatio = ((double)Gdx.graphics.getWidth()/(double)Gdx.graphics.getHeight());
        if(currRatio < 640.0/480.0)
        {
            return (int)(3.0/4.0*(double)Gdx.graphics.getWidth());
        }
        return realPos;
    }
    public int convertW(int w)
    {
        //w = 640
        //h = 480
        //We do want to make the screen size with the same aspect ratio
        //w to h : 640/480
        //h to width: 480/640
        //Depending on which ever one is better we will limit one of the dimensions
        double relW = 640;
        double factor = relW/w;
        int realPos = (int)(Gdx.graphics.getWidth()/factor);
        /*
        double desWidth = 4.0/3.0 * (double)Gdx.graphics.getHeight();
        if((double)Gdx.graphics.getWidth()/(double)Gdx.graphics.getHeight() > 640.0/480.0 &&
                (double)Gdx.graphics.getWidth()>desWidth)
        {
            //How much do we have to lessen width by?
            double facLess = (1.0-((640.0/480.0) * (double)Gdx.graphics.getHeight()/(double)Gdx.graphics.getWidth()))
                              *(double)Gdx.graphics.getWidth();
            //We will add or subtract factLess from X positions depending on if they are less than or equal to the middle
            if(realPos > Gdx.graphics.getWidth()/2)
            {
                realPos = realPos + (int)facLess;
            }
            else
            {
                realPos = realPos - (int)facLess;
            }
        }
        */

        return realPos;
    }
    public int convertH(int h)
    {
        double relH = 480;
        double facLess = (3.0/4.0 * Gdx.graphics.getWidth());
        double factor = relH/h;
        int realPos = (int)(Gdx.graphics.getHeight()/factor);
        /*
        double desHeight = 3.0/4.0 * (double)Gdx.graphics.getWidth();
        if((double)Gdx.graphics.getWidth()/(double)Gdx.graphics.getHeight() < 640.0/480.0 &&
                (double)Gdx.graphics.getHeight() > desHeight)
        {
            if(realPos > Gdx.graphics.getHeight()/2)
            {
                realPos = realPos + (int)facLess;
            }
            else
            {
                realPos = realPos - (int)facLess;
            }
        }
        */

        return realPos;
    }

}
