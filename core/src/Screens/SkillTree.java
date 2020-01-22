package Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.wallegameone.IG;

import java.util.ArrayList;

import Characters.Being;
import ScreenMod.mouseControl;

public class SkillTree implements Screen
{
    IG thisGame;
    Being player;
    SaveState state;
    Texture background;
    boolean print = false;
    boolean done = false;
    //MASKING PROCESS >>>>>>>
        Texture midSlot;
        int midSlotW = 159;
        int midSlotH = 191;

        int midX = 240;//Gdx.graphics.getWidth()/2 - midSlotW/2;
        int midY = 240;//Gdx.graphics.getHeight()/2 - midSlotH/2;

        Texture bottomMid;
        int bottomMidX = 240;
        int bottomMidY = 126;

        int bMidW = 159;
        int bMidH = 101;

        Texture mask3;
        int mask3X = 410;
        int mask3Y = 124;

        int mask3W = 208;
        int mask3H = 307;

        Texture mask4;
        int mask4X = 22;
        int mask4Y = 125;

        int mask4W = 208;
        int mask4H = 305;

        Texture mask5;
        int mask5X = 2;
        int mask5Y = 6;

        int mask5W = 256;
        int mask5H = 83;

        Texture mask6;
        int mask6X = 272;
        int mask6Y = 5;

        int mask6W = 96;
        int mask6H = 83;

        Texture mask7;
        int mask7X = 382;
        int mask7Y = 5;

        int mask7W = 357;
        int mask7H = 82;

    //<<<<<<<MASKING PROCESS

    //Ability Tree :::::::::::::::::
    int abilityWidth = 20;
    int abilityHeight = 20;
    int xConst = mask3X + 4;
    int xSpace = 15;
    int ySpace = 25;
    int yConst =  mask3Y - 4 + mask3H + ySpace;



        Texture iceAvalanche;
        Texture iceAvalanche_;
        Texture gloss1;

        Texture iceBomb;
        Texture iceBomb_;

        Texture iceComet;
        Texture iceComet_;

        Texture iceDevil;
        Texture iceDevil_;

        Texture iceGaurdian;
        Texture iceGaurdian_;

        Texture iceHammer;
        Texture iceHammer_;

        Texture iceImage;
        Texture iceImage_;

        Texture iceShard;
        Texture iceShard_;

        Texture iceShell;
        Texture iceShell_;

        Texture iceShield;
        Texture iceShield_;

        Texture iceSkin;
        Texture iceSkin_;

        Texture iceSlash;
        Texture iceSlash_;

        Texture iceSleet;
        Texture iceSleet_;

        Texture iceSpike;
        Texture iceSpike_;

        Texture iceStrike;
        Texture iceStrike_;

        Texture iceWall;
        Texture iceWall_;

        Texture iceWeb;
        Texture iceWeb_;

        Texture iceWind;
        Texture iceWind_;

        Texture multiIceShard;
        Texture multiIceShard_;

        ArrayList<Texture> AbilitiesG = new ArrayList<Texture>(); //AbilitiesG means Abilities gained
        ArrayList<Texture> AbilitiesN = new ArrayList<Texture>(); //AbilitiesN means Abilities NOT gained
        int[] track; //This will be an array of 0's and 1's, if the array contains "0" then that means user
                     //does not have that ability, if it contains "1", that means user has obtained that ability
        ArrayList<String> pos = new ArrayList<String>();
    //:::::::::::::::Ability Tree

    //This is the indents for the move pool in selection.:::::::::::
        Texture indent1; // this will be the top move selection indent
        Texture indent2;
        Texture indent3;
        Texture indent4;
        Texture indent5;
        Texture indent6; // this will be the bottom move selection indent
    //:::::::::Started at 12:00 pm, 8/22/19

    Preferences prefs;


    mouseControl control;
    Texture bluntHit; //This will in the future be a popup;
    public SkillTree(IG game)
    {
        thisGame = game;
        prefs = Gdx.app.getPreferences("myprefs");
        background = new Texture("abilityTree.png");
        //>>>>>>>MASKING PROCESS
            midSlot = new Texture("greySlot.jpg");
            bottomMid = new Texture("greySlot.jpg");
            mask3 = new Texture("greySlot.jpg");
            mask4 = new Texture("greySlot.jpg");
            mask5 = new Texture("greySlot.jpg");
            mask6 = new Texture("greySlot.jpg");
            mask7 = new Texture("greySlot.jpg");
        //<<<<<<<MASKING PROCESS
        //Ability Tree::::::::

        iceAvalanche = new Texture("SS iceAvalanche.png");
        iceAvalanche_ = new Texture("SS iceAvalanche_.jpg");
        gloss1 = new Texture("gloss1.jpg");
        iceBomb = new Texture("SS iceBomb.jpg");
        iceBomb_ = new Texture("SS iceBomb_.jpg");
        iceComet = new Texture("SS iceComet.jpg");
        iceComet_ = new Texture("SS iceComet_.jpg");
        iceDevil = new Texture("SS iceDevil.jpg");
        iceDevil_ = new Texture("SS iceDevil_.jpg");
        iceGaurdian = new Texture("SS iceGaurdian.jpg");
        iceGaurdian_ = new Texture("SS iceGaurdian.jpg");
        iceHammer = new Texture("SS iceHammer.jpg");
        iceHammer_ = new Texture("SS iceHammer_.jpg");
        iceImage = new Texture("SS iceImage.jpg");
        iceImage_ = new Texture("SS iceImage_.jpg");
        iceShard = new Texture("SS iceShard.jpg");
        iceShard_ = new Texture("SS iceShard_.jpg");
        iceShell = new Texture("SS iceShell.jpg");
        iceShell_ = new Texture("SS iceShell_.jpg");
        iceShield = new Texture("SS iceShield.jpg");
        iceShield_ = new Texture("SS iceShield_.jpg");
        iceSkin = new Texture("SS iceSkin.jpg");
        iceSkin_ = new Texture("SS iceSkin_.jpg");
        iceSlash = new Texture("SS iceSlash.jpg");
        iceSlash_ = new Texture("SS iceSlash_.jpg");
        iceSleet = new Texture("SS iceSleet.jpg");
        iceSleet_ = new Texture("SS iceSleet_.jpg");
        iceSpike = new Texture("SS iceSpike.jpg");
        iceSpike_ = new Texture("SS iceSpike_.jpg");
        iceStrike = new Texture("SS iceStrike.jpg");
        iceStrike_ = new Texture("SS iceStrike_.jpg");
        iceWall = new Texture("SS iceWall.jpg");
        iceWall_ = new Texture("SS iceWall_.jpg");
        iceWeb = new Texture("SS iceWeb.jpg");
        iceWeb_ = new Texture("SS iceWeb_.jpg");
        iceWind = new Texture("SS iceWind.jpg");
        iceWind_ = new Texture("SS iceWind_.jpg");
        multiIceShard = new Texture("SS multiIceShard.jpg");
        multiIceShard_ = new Texture("SS multiIceShard_.jpg");
        //Adding all Textures to arrayList AbilitiesG
        AbilitiesG.add(iceAvalanche);
        AbilitiesG.add(iceBomb);
        AbilitiesG.add(iceComet);
        AbilitiesG.add(iceDevil);
        AbilitiesG.add(iceGaurdian);
        AbilitiesG.add(iceHammer);
        AbilitiesG.add(iceImage);
        AbilitiesG.add(iceShard);
        AbilitiesG.add(iceShield);
        AbilitiesG.add(iceSkin);
        AbilitiesG.add(iceSlash);
        AbilitiesG.add(iceSleet);
        AbilitiesG.add(iceSpike);
        AbilitiesG.add(iceStrike);
        AbilitiesG.add(iceWall);
        AbilitiesG.add(iceWeb);
        AbilitiesG.add(iceWind);
        AbilitiesG.add(multiIceShard);
        track = new int[AbilitiesG.size() +1];
        //Adding all Textures to arrayList AbilitiesG
        //Adding all Non Selected Textures On AbilitiesN
        for(int i = 0; i<AbilitiesG.size(); i++)
        {
            int dotPos = AbilitiesG.get(i).toString().indexOf(".");
            AbilitiesN.add(new Texture(AbilitiesG.get(i).toString().substring(0,dotPos) + "_.jpg"));
            track[i] = 0;
        }
        //::::::::Ability Tree
        //Initializing indents::::::::::::::::::;
            indent1 = new Texture("blackIndent.jpg");
            indent2 = new Texture("blackIndent.jpg");
            indent3 = new Texture("blackIndent.jpg");
            indent4 = new Texture("blackIndent.jpg");
            indent5 = new Texture("blackIndent.jpg");
            indent6 = new Texture("blackIndent.jpg");
        //::::::::::::::::::
        control = new mouseControl(thisGame);
        player = new Being(thisGame, "SS iceSleet.jpg", "SS iceSleet.jpg", 0,0, 100,100,100); //THIS IS A TEST
        state = new SaveState(thisGame, track);
    }
    @Override
    public void show()
    {

    }

    @Override
    public void render(float delta)
    {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        thisGame.batch.begin();
        thisGame.batch.enableBlending();
        thisGame.batch.draw(background,0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        //MASKING PROCESS>>>>>
            thisGame.batch.draw(midSlot, midX,midY,midSlotW, midSlotH);
            thisGame.batch.draw(bottomMid, bottomMidX,bottomMidY,bMidW, bMidH);
            thisGame.batch.draw(mask3, mask3X, mask3Y, mask3W, mask3H);
            thisGame.batch.draw(mask4, mask4X, mask4Y, mask4W,mask4H);
            thisGame.batch.draw(mask5, mask5X, mask5Y, mask5W, mask5H);
            thisGame.batch.draw(mask6, mask6X, mask6Y, mask6W, mask6H);
            thisGame.batch.draw(mask7, mask7X, mask7Y, mask7W, mask7H);
        //<<<<MASKING PROCESS
        //Overriding the masks>>>>> THIS WILL BE THE MOVE POOL
        // this was a TEST: thisGame.batch.draw(AbilitiesG.get(0), mask3X + 4, mask3Y - abilityHeight - 4 + mask3H, abilityWidth, abilityHeight);
            for(int i = 0; i < AbilitiesG.size(); i++)
            {
                if(i % 6 == 0)
                {
                    xConst = mask3X + 4;
                    yConst -= ySpace + abilityHeight;
                }
                if(track[i] == 0) {
                    thisGame.batch.draw(AbilitiesN.get(i), xConst, yConst, abilityWidth, abilityHeight);

                }
                else if(track[i] == 1)
                {
                    thisGame.batch.draw(AbilitiesG.get(i), xConst, yConst, abilityWidth, abilityHeight);
                    //THIS WAS AN ATTEMPT AT ADDING A GLOSSY FINISH BUT SHUTTERSTOCK MONOPOLIZED THEM ALL
                    /**
                    if(i == 0)
                    {
                        thisGame.batch.draw(gloss1, xConst,yConst, abilityWidth, abilityHeight);
                    }
                     */
                }
                if(done == false) {
                    pos.add(xConst + "," + yConst);

                }
                xConst += xSpace + abilityWidth;


            }
            done = true;
            yConst =  mask3Y - 4 + mask3H + ySpace;
            if(control.isHovering(618,410,555,124))
            {
                if(control.isClicked())
                {
                    int posA = -1;
                    for(int i = 0; i<pos.size(); i++)
                    {
                        int comPos = pos.get(i).indexOf(",");
                        int tempX = Integer.parseInt(pos.get(i).substring(0,comPos));
                        int tempY = Integer.parseInt(pos.get(i).substring(comPos + 1));
                        if(control.isHovering(tempX + abilityWidth, tempX, tempY + abilityHeight, tempY))
                        {
                            if( player.getSkillPoints() > 0) {
                                track[i] = 1;
                                if(state.getTransCount() == 1)
                                {
                                    prefs.putString("key1", arrString(track));
                                    prefs.flush();
                                }
                                player.subPoint();
                            }
                        }
                    }
                }
                else
                    {
                        //Description of Moves: Started on 12:05 AM 8/22/19::::::::::::::::::::
                        /** At the time of creation the comment files have not been created, due to that i will comment
                         * this out for now
                         */
                        /**
                        for(int i = 0; i<pos.size(); i++)
                        {
                            int comPos = pos.get(i).indexOf(",");
                            int tempX = Integer.parseInt(pos.get(i).substring(0,comPos));
                            int tempY = Integer.parseInt(pos.get(i).substring(comPos + 1));
                            if(control.isHovering(tempX + abilityWidth, tempX, tempY + abilityHeight, tempY))
                            {

                            }
                        }
                         **/
                        //:::::::::::::::::::Description of Moves;
                }
            }
        //<<<<<Overriding the masks THIS WILL BE THE MOVE POOL
        //System.out.println(Gdx.input.getX() +" , "+ (Gdx.graphics.getHeight()-Gdx.input.getY()));
        if(Gdx.input.isKeyJustPressed(Input.Keys.I))
        {
            print = true;
        }
        if(print == true)
        {
            System.out.println(prefs.getString("key1") + "");
            print = false;
        }
        thisGame.batch.end();
    }
    public String arrString(int[] a)
    {
        String output = "";
        for(int i = 0; i<a.length; i++)
        {
            output += a[i] + ",";
        }
        return output;
    }
    public void printArr(int[] arr)
    {
        for(int i = 0; i<arr.length; i++)
        {
            System.out.print(" , " + arr[i]);
        }
    }
    @Override
    public void resize(int width, int height) {

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
    public void dispose() {

    }
}
