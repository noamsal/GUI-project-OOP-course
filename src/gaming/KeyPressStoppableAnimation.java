package gaming;

/**
 * i.d.: 205949258
 */

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import gameinterfaces.Animation;

/**
 * KeyPressStoppableAnimation class. in charge of displaying a given animation and to stop it, after pressing
 * the right button in the keyboard, according to the given string
 */
public class KeyPressStoppableAnimation implements Animation {
    //fields
    private KeyboardSensor keyboard;
    private String givenKey;
    private Animation givenAnimation;
    private boolean stop;
    private boolean isAlreadyPressed;

    /**
     * constructor method.
     *
     * @param sensor    - a KeyboardSensor object
     * @param key       - a Sting object
     * @param animation - an Animation object
     *                  <p>
     *                  the method receives parameters and set's our fields according to it
     *                  </p>
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.keyboard = sensor;
        this.givenKey = key;
        this.givenAnimation = animation;
        this.stop = false;
        this.isAlreadyPressed = true;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.givenAnimation.doOneFrame(d);
        if (this.keyboard.isPressed(this.givenKey)) {
            if (!isAlreadyPressed) {
                this.stop = true;
            }
        } else {
            this.isAlreadyPressed = false;
        }
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
