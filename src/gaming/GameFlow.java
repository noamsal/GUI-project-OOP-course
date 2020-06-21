package gaming;

/**
 * i.d.: 205949258
 */

import gameinterfaces.Animation;
import gameinterfaces.LevelInformation;

import java.util.List;

/**
 * GameFlow class. in charge of creating the different levels, and moving from one level to the next.
 */
public class GameFlow {
    //fields
    private AnimationRunner animationRunner;
    private Counter counter = new Counter(0);
    private boolean win = true;

    /**
     * constructor method. initializes the game flow
     *
     * @param ar - an AnimationRunner object
     *           <p>
     *           the method receives an AnimationRunner object, and initializes our
     *           field according to them
     *           </p>
     */
    public GameFlow(AnimationRunner ar) {
        this.animationRunner = ar;
    }

    /**
     * runLevels method. is in charge of running the levels
     *
     * @param levels - a list of levels
     *               <p>
     *               the method receives a list of LevelInformation objects (the levels of the game) and
     *               iterates over each of them - and creates a new GameLevel object with the current level
     *               and runs it.
     *               </p>
     */
    public void runLevels(List<LevelInformation> levels) {
        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(levelInfo, this.animationRunner, this.counter);
            level.initialize();
            level.run();
            if (level.getBallsCounter().getValue() == 0) {
                this.win = false;
                break;
            }

        }
        if (win) {
            Animation winScreen = new WinScreen(counter.getValue()); // create new "win screen"
            //create a new KeyPressStoppableAnimation that will run it
            Animation winKey = new KeyPressStoppableAnimation(animationRunner.getGui().getKeyboardSensor(),
                    animationRunner.getGui().getKeyboardSensor().SPACE_KEY, winScreen);
            animationRunner.run(winKey); // run the new KeyPressStoppableAnimation
        } else {
            Animation loseScreen = new LoseScreen(counter.getValue());
            Animation loseKey = new KeyPressStoppableAnimation(animationRunner.getGui().getKeyboardSensor(),
                    animationRunner.getGui().getKeyboardSensor().SPACE_KEY, loseScreen);
            animationRunner.run(loseKey);
        }
        this.animationRunner.getGui().close();
    }
}
