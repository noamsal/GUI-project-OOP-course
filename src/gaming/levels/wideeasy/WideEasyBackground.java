package gaming.levels.wideeasy;
/**
 * i.d.: 205949258
 */

import biuoop.DrawSurface;
import gameinterfaces.Sprite;
import gameobjects.Block;
import geometric.Point;
import geometric.Rectangle;

import java.awt.Color;

/**
 * WideEasyBackground class. in charge of the background of the WideEasyBackground background
 */
public class WideEasyBackground implements Sprite {

    @Override
    public void drawOn(DrawSurface d) {
        Block block = new Block(new Rectangle(new Point(0, 40) //background block
                , 800, 600), Color.WHITE);
        block.drawOn(d);
    }

    @Override
    public void timePassed() {

    }
}
