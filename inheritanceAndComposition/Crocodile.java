package inheritanceAndComposition;
/**
 * Crocodile class which inherits some common properties from reptile class
 * @author ankit.kumar_metacube
 *
 */
public class Crocodile extends Reptile{
	public Crocodile(int age, String name, String category, int weight, boolean canSwim, String sound) {
        super(age, name, category, weight, canSwim, sound);
    }
	/**
	 * Method to get sound of the animal
	 */
    public String getSound() {
        return super.soundOfAnimal;
    }
    /**
     * Method which returns true if the crocodile is capable of swim otherwise false
     */
    public boolean isCapableOfSwim() {
        return super.swim;
    }
}
