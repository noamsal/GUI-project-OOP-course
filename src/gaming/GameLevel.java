package gaming;
/**
 * i.d.: 205949258
 */


import biuoop.DrawSurface;
import gameinterfaces.Animation;
import gameinterfaces.Collidable;
import collections.GameEnvironment;
import gameinterfaces.LevelInformation;
import gameinterfaces.Sprite;
import collections.SpriteCollection;
import gameobjects.Ball;
import gameobjects.Block;
import gameobjects.Paddle;
import geometric.Point;
import geometric.Rectangle;

import java.awt.Color;
import java.util.Random;

/**
 * gaming.Game class. holds a spriteCollection and a gameEnvironment objects.
 * the class is in charge of the animation.
 */
public class GameLevel implements Animation {
    /*fields*/
    private SpriteCollection sprites;
    private GameEnvironment environment;
    //blocks listeners
    private Counter blockCounter;
    private BlockRemover blockRemover;
    //balls listeners
    private Counter ballCounter;
    private BallRemover ballRemover;
    //score listeners
    private Counter score;
    private ScoreTrackingListener scoreTracker;
    private ScoreIndicator scoreBoard;
    //screen
    public static final int SCREEN_W = 800;
    public static final int SCREEN_H = 600;
    //edges Rectangles
    public static final Point START_POINT = new Point(0, 25);
    public static final Color EDGE_COLOR = Color.GRAY;
    //small Rectangles
    public static final int SCREEN_DISTANCE = 25;
    //paddle
    public static final int PADDLE_HEIGHT = 20;
    /*ball*/
    public static final int BALL_R = 5;
    public static final double BALL_Y = SCREEN_H - 3 * PADDLE_HEIGHT;
    public static final Color BALL_COLOR = Color.WHITE;

    private boolean running;
    private AnimationRunner runner;
    private LevelInformation level; //level received

    /**
     * constructor method.
     *
     * @param data           - a LevelInformation object
     * @param ar             - an AnimationRunner object
     * @param generalCounter - a Counter object
     *                       <p>
     *                       the method receives the current receives data of the current level from the gameFlow
     *                       and set's it's right fields according to it
     *                       </p>
     */
    public GameLevel(LevelInformation data, AnimationRunner ar, Counter generalCounter) {
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        //blocks
        this.blockCounter = new Counter(data.numberOfBlocksToRemove()); //know each turn! how many blocks are there
        this.blockRemover = new BlockRemover(this, blockCounter);
        //balls
        this.ballCounter = new Counter(data.numberOfBalls()); //know each turn! how many balls are there
        this.ballRemover = new BallRemover(this, ballCounter);
        //level
        this.level = data;
        //score
        this.score = generalCounter; //the main score. each turn it's been received from the previous levels
        this.scoreTracker = new ScoreTrackingListener(score);
        this.scoreBoard = new ScoreIndicator(score, this.level.levelName());
        //animation runner
        this.runner = ar;
    }

    /**
     * addCollidable method. add's a listeners.Collidable to our collidables list.
     *
     * @param c - a collidable object
     *          <p>
     *          the method receives a collidable object and adds it to our gameEnvironment's collidables list
     *          </p>
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * removeCollidable method. receives a collidable object to be removed from the game.
     *
     * @param c - a collidabe object
     *          <p>
     *          the method receives a collidable object, to be removed from the game
     *          </p>
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);
    }

    /**
     * addSprite method. receives a listeners.Sprite object and add's it to our Sprites list
     *
     * @param s - a listeners.Sprite object
     *          <p>
     *          the method receives a listeners.Sprite object and add it
     *          to our collections.SpriteCollection's Sprites list
     *          </p>
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * removeSprite method. receives a listeners.Sprite object to be removed from the game.
     *
     * @param s - a sprite object
     *          <p>
     *          the method receives a listeners.Sprite object, to be removed from the game
     *          </p>
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }

    /**
     * createBallsOnTopOfPaddle method. initialize the balls and the paddle
     * <p>
     * the method initializes the paddle and the balls - to start on-top of the paddle
     * <p>
     */
    public void createBallsOnTopOfPaddle() {
        int upperLeft = (SCREEN_W - this.level.paddleWidth()) / 2; //upper-left x' component of the paddle
        /*balls*/
        for (int i = 1; i <= this.level.numberOfBalls(); i++) {
            //progress of each ball's x component
            int j = i * (this.level.paddleWidth() / (this.level.numberOfBalls() + 1));
            Ball ball = new Ball(upperLeft + j, BALL_Y, BALL_R, BALL_COLOR);
            ball.setVelocity(this.level.initialBallVelocities().get(i - 1));
            ball.addToGame(this);
            ball.setGameEnvironment(this.environment);
        }
        /*paddle*/
        Paddle paddle = new Paddle(new Rectangle(new Point(upperLeft, SCREEN_H - 2 * PADDLE_HEIGHT)
                , this.level.paddleWidth(), PADDLE_HEIGHT),
                this.runner.getGui().getKeyboardSensor(), this.level.paddleSpeed());
        paddle.addToGame(this);
    }


    @Override
    public void doOneFrame(DrawSurface d) {
        if (this.runner.getGui().getKeyboardSensor().isPressed("p")) { //pause button
            this.runner.run(new KeyPressStoppableAnimation(runner.getGui().getKeyboardSensor(),
                    runner.getGui().getKeyboardSensor().SPACE_KEY, new PauseScreen()));
        }
        if (this.blockCounter.getValue() == 0) { //all blocks are vanished
            this.score.increase(100);
        }
        if (this.blockCounter.getValue() == 0 || this.ballCounter.getValue() == 0) { //stopping condition
            this.running = false;
        }
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();
    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }

    /**
     * getBallsCounter method. returns the ball's counter
     * <p>
     * the method returns our ball's counter
     * </p>
     *
     * @return - the ball's counter
     */
    public Counter getBallsCounter() {
        return this.ballCounter;
    }

    /**
     * getScore method. returns the game's score
     * <p>
     * the method returns the score counter of the game
     * <p>
     *
     * @return - the game score counter
     */
    public Counter getScore() {
        return this.score;
    }

    /**
     * initialize method. Initialize a new game
     * <p>
     * the method initialize's the game: it add's the background, scoreboard and the blocks of the game
     * </p>
     */
    public void initialize() {
        Random random = new Random();
        //add the score screen and the background to the game
        this.scoreBoard.addToGame(this);
        this.sprites.addSprite(this.level.getBackground());
        /*create the blocks*/
        //left side of screen
        Block block1 = new Block(new Rectangle(START_POINT, SCREEN_DISTANCE, SCREEN_H), EDGE_COLOR);
        //upper side of screen
        Block block2 = new Block(new Rectangle(START_POINT, SCREEN_W, SCREEN_DISTANCE), EDGE_COLOR);
        //right side of screen
        Block block3 = new Block(new Rectangle(new Point(SCREEN_W - SCREEN_DISTANCE, SCREEN_DISTANCE)
                , SCREEN_DISTANCE, SCREEN_H - SCREEN_DISTANCE), EDGE_COLOR);
        //lower side of screen - !!DEATH-REGION!!!
        Block block4 = new Block(new Rectangle(new Point(SCREEN_DISTANCE, SCREEN_H + SCREEN_DISTANCE)
                , SCREEN_W - 2 * SCREEN_DISTANCE, SCREEN_DISTANCE), EDGE_COLOR);
        block4.addToGame(this);
        block4.addHitListener(ballRemover);
        //handle the 3 screen blocks except the death region
        Block[] blocks = new Block[] {block1, block2, block3};
        for (Block b : blocks) {
            b.addToGame(this);
        }
        /*the level blocks*/
        for (int i = 0; i < this.level.blocks().size(); i++) {
            this.level.blocks().get(i).addToGame(this);
            this.level.blocks().get(i).addHitListener(blockRemover);
            this.level.blocks().get(i).addHitListener(scoreTracker);
        }
    }

    /**
     * run method. Run the game
     * <p>
     * the method activate the game, using the it's runner object
     * </p>
     */
    public void run() {
        this.createBallsOnTopOfPaddle();
        this.runner.run(new CountdownAnimation(2, 3, this.sprites));
        // use our runner to run the current animation -- which is one turn of
        // the game.
        this.running = true;
        this.runner.run(this);
    }
}


