package gaming.levels.directhit;
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
 * DirectHitBackground class. in charge of the background of the DirectHit background
 */
public class DirectHitBackground implements Sprite {
    @Override
    public void drawOn(DrawSurface d) {
        Block block = new Block(new Rectangle(new Point(0, 40) //background block
                , 800, 600), Color.BLACK);
        block.drawOn(d);
        d.setColor(Color.BLUE);
        d.drawCircle(400, 170, 130); //big circle
        d.drawCircle(400, 170, 90); //medium circle
        d.drawCircle(400, 170, 50); //small circle
        d.drawLine(250, 170, 550, 170); //horizontal line
        d.drawLine(400, 40, 400, 320); //vertical line
    }

    @Override
    public void timePassed() {

    }
}
