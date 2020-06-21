package gaming.levels.finalfour;
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
 * FinalFour class. one of the game levels
 */
public class FinalFour implements LevelInformation {
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
    public FinalFour() {
        this.numOfBalls = 3;
        this.velocitiesList = this.createVelocities();
        this.paddleSpeed = 10;
        this.paddleWidth = 100;
        this.levelName = "Final Four";
        this.blocksToRemove = 105;
        this.blocksList = this.createBlocks();
        this.background = new FinalFourBackGround();
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
            int progress = 10 * i;
            list.add(Velocity.fromAngleAndSpeed(-50 + progress, 6));
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
        for (int x = 25; x <= 725;) {
            Block grey = new Block(new Rectangle(new Point(x, 130), 50, 25), Color.GRAY);
            list.add(grey);
            x = x + 50;
        }
        //red ones
        for (int x = 25; x <= 725;) {
            Block red = new Block(new Rectangle(new Point(x, 155)
                    , 50, 25), Color.RED);
            list.add(red);
            x = x + 50;
        }
        //yellow ones
        for (int x = 25; x <= 725;) {
            Block yellow = new Block(new Rectangle(new Point(x, 180), 50, 25), Color.YELLOW);
            list.add(yellow);
            x = x + 50;
        }
        //green ones
        for (int x = 25; x <= 725;) {
            Block blue = new Block(new Rectangle(new Point(x, 205), 50, 25), Color.GREEN);
            list.add(blue);
            x = x + 50;
        }
        //white ones
        for (int x = 25; x <= 725;) {
            Block pink = new Block(new Rectangle(new Point(x, 230), 50, 25), Color.WHITE);
            list.add(pink);
            x = x + 50;
        }
        //pink ones
        for (int x = 25; x <= 725;) {
            Block pink = new Block(new Rectangle(new Point(x, 255), 50, 25), Color.PINK);
            list.add(pink);
            x = x + 50;
        }
        //light-blue ones
        for (int x = 25; x <= 725;) {
            Block pink = new Block(new Rectangle(new Point(x, 280), 50, 25),
                    new Color(68, 192, 199));
            list.add(pink);
            x = x + 50;
        }
        return list;
    }
}
