package inheritanceAndComposition;

public class Peacock extends Bird {
    // constructor method
	public Peacock(int age, String name, String category, int weight, boolean canFly, String sound) {
        super(age, name, category, weight, canFly, sound);
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
    public boolean canFly() {
        return super.fly;
    }
}