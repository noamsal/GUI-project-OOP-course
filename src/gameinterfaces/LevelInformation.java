package gameinterfaces;

/**
 * i.d.: 205949258
 */

import gameobjects.Block;
import gameobjects.Velocity;

import java.util.List;

/**
 * LevelInformation class. specifies the information required to fully describe a level
 */
public interface LevelInformation {
    /**
     * numberOfBalls method. returns the number of balls that's in our level
     * <p>
     * the method returns the amount of balls that's in our game
     * </p>
     *
     * @return - the amount of balls
     */
     int numberOfBalls();


    /**
     * initialBallVelocities method. returns a list of the velocities for the balls
     * <p>
     * the method returns the list of initialized velocities of the balls in the game.
     * the size of the list is equals to the amount of the balls
     * </p>
     *
     * @return - the list of the velocities of the balls
     */
     List<Velocity> initialBallVelocities();

    /**
     * paddleSpeed method. returns the paddle's speed
     * <p>
     * the method returns the paddle's speed
     * </p>
     *
     * @return - the paddle's speed
     */
     int paddleSpeed();

    /**
     * paddleWidth method. returns the paddle's width
     * <p>
     * the method returns the paddle's width
     * </p>
     *
     * @return - the paddle's width
     */
     int paddleWidth();

    /**
     * levelName method. returns the name of the level
     * <p>
     * the method returns a String - the name of the level.
     * the level name will be displayed at the top of the screen.
     * </p>
     *
     * @return - the level's name
     */
     String levelName();


    /**
     * getBackground method. returns the background of the game
     * <p>
     * the method returns a sprite with the background of the level
     * </p>
     *
     * @return - the background(Sprite) of the game
     */
     Sprite getBackground();


    /**
     * blocks method. returns the list of blocks of the level
     * <p>
     * the method returns a list of the level's blocks. each block contains
     * its size, color and location.
     * </p>
     *
     * @return - the list of blocks
     */
     List<Block> blocks();


    /**
     * numberOfBlocksToRemove method. returns the number of blocks that needs to be removed
     * <p>
     * the method returns the number of balls that's need to be removed.
     * before the level is considered to be "cleared", This number should be <= than
     * the size of the block's size
     * </p>
     *
     * @return - the number of blocks that's need to be removed
     */
    int numberOfBlocksToRemove();
}
