package gaming.levels.wideeasy;
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
 * WideEasy class. one of the game levels
 */
public class WideEasy implements LevelInformation {
    //fields
    private int numOfBalls;
    private List<Velocity> velocitiesList;
    private int paddleSpeed;
    private int paddleWidth;
    private String levelName;
    private Sprite background;
    private List<Block> blocksList;
    private int blocksToRemove;

    /**
     * constructor method.
     * <p>
     * the method initializes the fields of the level
     * </p>
     */
    public WideEasy() {
        this.numOfBalls = 10;
        this.velocitiesList = this.createVelocities();
        this.paddleSpeed = 10;
        this.paddleWidth = 640;
        this.levelName = "Wide Easy";
        this.blocksToRemove = 15;
        this.blocksList = this.createBlocks();
        this.background = new WideEasyBackground();
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

    /**
     * createBlocks method. creates the blocks
     *
     * <p>
     * the method initializes the blocks of the game and initialize our list according to it
     * </p>
     *
     * @return - a list of blocks
     */
    public ArrayList<Block> createBlocks() {
        ArrayList<Block> list = new ArrayList<Block>();
        Color color = Color.RED;
        int blockWidth = 50;
        for (int x = 0; x < this.blocksToRemove; x++) {
            int progress = x * blockWidth;
            if (x == 2) {
                color = Color.ORANGE;
            } else if (x == 4) {
                color = Color.YELLOW;
            } else if (x == 6) {
                color = Color.GREEN;
            } else if (x == 9) {
                color = Color.BLUE;
            } else if (x == 11) {
                color = Color.PINK;
            } else if (x == 13) {
                color = new Color(51, 204, 255);
            }
            list.add(new Block(new Rectangle(new Point(25 + progress, 200), blockWidth, 25), color));
        }
        return list;
    }

    /**
     * createVelocities method. creates the velocities for the balls
     * <p>
     * the method initializes the velocities for the balls of the game, and set's our list to be it
     * </p>
     *
     * @return - a list of velocities
     */
    public ArrayList<Velocity> createVelocities() {
        ArrayList<Velocity> list = new ArrayList<Velocity>();
        for (int i = 1; i <= this.numOfBalls; i++) {
            int progress = 10 * i;
            list.add(Velocity.fromAngleAndSpeed(-50 + progress, 5));
        }
        return list;
    }
}
