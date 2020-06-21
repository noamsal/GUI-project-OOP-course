package gaming.levels.green;

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
 * GreenBackground class. in charge of level Green 3's background
 */
public class GreenBackground implements Sprite {

    @Override
    public void drawOn(DrawSurface d) {
        Block block = new Block(new Rectangle(new Point(0, 40) //background block
                , 800, 600), new Color(0, 102, 0));
        block.drawOn(d);
    }

    @Override
    public void timePassed() {

    }
}
