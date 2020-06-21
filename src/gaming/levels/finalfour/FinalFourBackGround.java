package gaming.levels.finalfour;

/**
 * i.d.:205949258
 */

import biuoop.DrawSurface;
import gameinterfaces.Sprite;
import gameobjects.Block;
import geometric.Point;
import geometric.Rectangle;

import java.awt.Color;

/**
 * FinalFourBackGround class. in charge of the final four's background
 */
public class FinalFourBackGround implements Sprite {

    @Override
    public void drawOn(DrawSurface d) {
        Block block = new Block(new Rectangle(new Point(0, 40) //background block
                , 800, 600), new Color(34, 96, 155));
        block.drawOn(d);
    }

    @Override
    public void timePassed() {

    }
}
