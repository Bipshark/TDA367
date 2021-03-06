package edu.chalmers.sankoss.desktop.mvc.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import edu.chalmers.sankoss.core.core.CorePlayer;
import edu.chalmers.sankoss.desktop.SankossGame;
import edu.chalmers.sankoss.desktop.utils.Common;

public class PlayerPanel extends Table {
    private Label lblName;
    private Image imgNationality;
    private Label turnLabel;


    public PlayerPanel(Alignment align) {
        super(Common.getSkin());

        lblName = new Label("", Common.getSkin());
        imgNationality = new Image();
        turnLabel = new Label("", Common.getSkin());

        Pixmap pix = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pix.setColor(Color.GRAY);
        pix.fill();
        setBackground(new TextureRegionDrawable(new TextureRegion(new Texture(pix))));

        if (align == Alignment.LEFT) {
            align(Align.left);
            add(imgNationality).padRight(8f);
            add(lblName);
            add(turnLabel).expandX().right().pad(8f);
        } else {
            align(Align.right);
            add(turnLabel).expandX().left().pad(8f);
            add(lblName).padRight(8f);
            add(imgNationality);
        }
        //debug();

    }


    public void setNationality(CorePlayer.Nationality nationality) {
        this.imgNationality.setDrawable(new TextureRegionDrawable(new TextureRegion(new Texture(nationality.getPath()))));
    }

    public void setTurnLabelText(String text) {
        turnLabel.setText(text);
    }

    public void setLblName(String name) {
        lblName.setText(name);
    }

    public enum Alignment {
        LEFT, RIGHT
    }
}