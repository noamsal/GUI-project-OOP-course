package gaming.levels.green;
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
 * Green class. one of the Game levels
 */
public class Green implements LevelInformation {
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
     *
     * <p>
     * * the method initializes the fields of the level
     * </p>
     */
    public Green() {
        this.numOfBalls = 2;
        this.velocitiesList = this.createVelocities();
        this.paddleSpeed = 10;
        this.paddleWidth = 100;
        this.levelName = "Green 3";
        this.blocksToRemove = 40;
        this.blocksList = this.createBlocks();
        this.background = new GreenBackground();
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
            int progress = 60 * i;
            list.add(Velocity.fromAngleAndSpeed(-50 + progress, 7));
        }
        return list;
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
        //grey ones
        for (int x = 275; x <= 725;) {
            Block grey = new Block(new Rectangle(new Point(x, 155), 50, 25), Color.GRAY);
            list.add(grey);
            x = x + 50;
        }
        //red ones
        for (int x = 325; x <= 725;) {
            Block red = new Block(new Rectangle(new Point(x, 180)
                    , 50, 25), Color.RED);
            list.add(red);
            x = x + 50;
        }
        //yellow ones
        for (int x = 375; x <= 725;) {
            Block yellow = new Block(new Rectangle(new Point(x, 205), 50, 25), Color.YELLOW);
            list.add(yellow);
            x = x + 50;
        }
        //blue ones
        for (int x = 425; x <= 725;) {
            Block blue = new Block(new Rectangle(new Point(x, 230), 50, 25), Color.BLUE);
            list.add(blue);
            x = x + 50;
        }
        //white ones
        for (int x = 475; x <= 725;) {
            Block pink = new Block(new Rectangle(new Point(x, 255), 50, 25), Color.WHITE);
            list.add(pink);
            x = x + 50;
        }
        return list;
    }
}
