package com.wallegameone;

import com.badlogic.gdx.ApplicationAdapter;

import com.badlogic.gdx.Game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import Screens.GameScreen;
import Screens.MenuScreen;
import Screens.SkillTree;

public class IG extends Game
{
	//::::::::::::::::::::;AUTHOR NOTE: FULLY DOCUMENTED AS OF 8/30/2019:::::::::::::::::::::::::::::::::::::::::

	public SpriteBatch batch; //Main batch that everything will chain from
                              //Methods such as batch.draw will be highly used
	Texture img;//Test for Texture class

    /*
    When the game first loads, this method is called first
    it usually used to instantiate all variable instances

    Overriding the Game class method create() as it is abstract
    press ctrl+i on Game to learn more about the class
     */
	@Override
	public void create ()
	{

		batch = new SpriteBatch();
		//THIS IS FOR TESTING PURPOSES (TESTING SKILL TREE) DATE: 8/15/19
		//this.setScreen(new MenuScreen(this));
		this.setScreen(new MenuScreen(this));
	}
    /*
    This method is called on repeatedly after a deltaTime each time
    a delta time is 1/frameRate, this refreshes and updates the screen
    -like a loop.

    Overriding the Game class method render() as it is abstract
    press ctrl+i on Game to learn more about the class
     */
	@Override
	public void render ()
	{
		super.render();

	}
    /*
    This method is usually called at the end of user interaction
    it disposes of all instances created by calling the .dispose()
    method on each object.

    Overriding the Game class method dispose() as it is abstract
    press ctrl+i on Game to learn more about the class
     */
    @Override
	public void dispose () {

		batch.dispose();

	}
}
