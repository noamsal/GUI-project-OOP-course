package gaming.levels.directhit;
/**
 * i.d.: 205949258
 */

import gameinterfaces.LevelInformation;
import gameinterfaces.Sprite;
import gameobjects.Block;
import gameobjects.Velocity;
import geometric.Point;
import geometric.Rectangle;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * DirectHit class. a LevelInformation class that's his idea is to hit the one block in the middle
 */
public class DirectHit implements LevelInformation {
    //fields
    private int numOfBalls;
    private List<Velocity> velocitiesList;
    private int paddleSpeed;
    private int paddleWidth;
    private String levelName;
    private Sprite background = new DirectHitBackground();
    private List<Block> blocksList;
    private int blocksToRemove;

    /**
     * constructor method.
     * <p>
     * the method initializes the fields of the level
     * </p>
     */
    public DirectHit() {
        this.numOfBalls = 1;
        this.velocitiesList = new ArrayList<Velocity>();
        this.paddleSpeed = 10;
        this.paddleWidth = 100;
        this.levelName = "Direct Hit";
        this.blocksToRemove = 1;
        this.blocksList = new ArrayList<Block>();
        this.blocksList.add(new Block(new Rectangle(new Point(390, 160), 20, 20), Color.RED));
        this.velocitiesList.add(Velocity.fromAngleAndSpeed(0, 12));
    }

    @Override
    public int numberOfBalls() {
        return this.numOfBalls;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        return this.velocitiesList;
    }

    @Override
    public int paddleSpeed() {
        return this.paddleSpeed;
    }

    @Override
    public int paddleWidth() {
        return this.paddleWidth;
    }

    @Override
    public String levelName() {
        return this.levelName;
    }

    @Override
    public Sprite getBackground() {
        return this.background;
    }

    @Override
    public List<Block> blocks() {
        return this.blocksList;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.blocksToRemove;
    }
}
