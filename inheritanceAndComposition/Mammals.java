package inheritanceAndComposition;

/**
 * Class to represent Mammals, extends the Animal class
 * @author ankit.kumar_metacube
 *
 */
abstract public class Mammals extends Animal {
    int runningSpeed;
    /**
     * Constructor for Mammal Class
     * @param age Age of the animal	
     * @param name Name of the animal
     * @param category Category of the animal
     * @param weight Weight of the animal
     * @param speed	Speed of the animal
     * @param sound Sound of the animal
     */
    public Mammals(int age, String name, String category, float weight, int speed, String sound) {
        super(age, name, category, weight, sound);
        runningSpeed = speed;
    }
    /**
     * Abstract method which tells the top speed of the animal
     * @return top speed of the animal
     */
    abstract public int topSpeed();
}

