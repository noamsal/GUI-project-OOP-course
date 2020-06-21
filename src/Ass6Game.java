/**
 * i.d.: 205949258
 */

import gameinterfaces.LevelInformation;
import gaming.AnimationRunner;
import gaming.GameFlow;
import gaming.levels.directhit.DirectHit;
import gaming.levels.finalfour.FinalFour;
import gaming.levels.green.Green;
import gaming.levels.wideeasy.WideEasy;

import java.util.ArrayList;
import java.util.List;

/**
 * Ass5Game class. initialize the new game and run's it
 */
public class Ass6Game {
    /**
     * main method. activate's our game
     *
     * @param args - an array of strings
     *             <p>
     *             the method runs our game by the user
     *             </p>
     */
    public static void main(String[] args) {
        GameFlow gameFlow = new GameFlow(new AnimationRunner());
        List<LevelInformation> levels = new ArrayList<LevelInformation>();
        int flag = args.length;
        //enter the given levels into the level's list
        for (String arg : args) {
            if (Integer.parseInt(arg) > 4) {
                flag--;
                continue;
            }
            if (Integer.parseInt(arg) == 1) {
                levels.add(new DirectHit());
            } else if (Integer.parseInt(arg) == 2) {
                levels.add(new WideEasy());
            } else if (Integer.parseInt(arg) == 3) {
                levels.add(new Green());
            } else if (Integer.parseInt(arg) == 4) {
                levels.add(new FinalFour());
            }
        }
        if (flag == 0) {
            levels.add(new DirectHit());
            levels.add(new WideEasy());
            levels.add(new Green());
            levels.add(new FinalFour());
        }
        gameFlow.runLevels(levels);
    }
}
