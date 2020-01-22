package Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.wallegameone.IG;

import Extra.Dialogue;

public class Bar implements Screen
{
    IG myGame;
    public Texture back;
    public Texture bartender;
    public Texture drunkyard;
    public Texture Narrator;
    public Dialogue intro1;
    public Dialogue bartendInfo;
    public Dialogue drunyardInfo;
    public Dialogue nextScript;
    public Bar(IG game)
    {
        myGame = game;
        back = new Texture("Bar.jpg");
    }
    @Override
    public void show()
    {

        drunkyard = new Texture("oldMan.jpg");
       // drunyardInfo = new Dialogue("");
    }

    @Override
    public void render(float delta)
    {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        myGame.batch.begin();
        myGame.batch.enableBlending();
        myGame.batch.draw(back,0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        myGame.batch.end();
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
