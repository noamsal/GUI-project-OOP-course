package gaming;
/**
 * i.d.: 205949258
 */

/**
 * gaming.Counter class. help us count the amount of an object that's in the game
 */
public class Counter {
    //fields
    private int counter;

    /**
     * constructor method.
     *
     * @param x - an int variable
     *          <p>
     *          the method receives a number(represent the number of the object) and set's it
     *          to be our counter
     *          </p>
     */
    public Counter(int x) {
        this.counter = x;
    }

    /**
     * increase method. add to our object counter the given number
     *
     * @param number - an int variable
     *               <p>
     *               the method receives a number, and add's it to our object counter
     *               </p>
     */
    void increase(int number) {
        this.counter += number;
    }

    /**
     * decrease method. subtract the given number from our counter
     *
     * @param number - an int variable
     *               <p>
     *               the method receives a number and subtract it from our object counter
     *               </p>
     */
    void decrease(int number) {
        this.counter -= number;
    }

    /**
     * getValue method. returns our counter
     * <p>
     * the method returns our objects counter
     * </p>
     * @return the value of the counter
     */
    int getValue() {
        return this.counter;
    }

}
