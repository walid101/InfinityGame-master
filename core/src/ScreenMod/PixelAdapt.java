package ScreenMod;
public class PixelAdapt {
    double refX;
    double refY;

    double newX;
    double newY;
    public PixelAdapt(int x, int y, int nX, int nY)
    {
        refX = (double) x;
        refY = (double) y;

        newX = (double)nX;
        newY = (double)nY;

    }

    public double getrefX() {
        return refX;
    }

    public double getRefY() {
        return refY;
    }
    public double getNewX()
    {
        return newX;
    }
    public double getNewY()
    {
        return newY;
    }
    public void setNewX(int someX)
    {
        newX = someX;
    }
    public void setNewY(int someY)
    {
        newY = someY;
    }

    public void setRefX(int newX) {
        refX = newX;
    }

    public void setRefY(int newY) {
        refY = newY;
    }

    public int conX(int x) {
        return x;
    }

    public int conY(int y) {
        return y;
    }
    //Result 1: (635,71) :: (889,79);
    //Result 2: (622, 100) :: (871,112);
    //Height: 540
    //Width: 897
    //public int thisX = 640;
    //public int thisY = 480;
}

