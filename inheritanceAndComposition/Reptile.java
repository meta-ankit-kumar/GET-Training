package inheritanceAndComposition;

abstract public class Reptile extends Animal {
	boolean swim;
    // Reptile class constructor
    public Reptile(int age, String name, String category, float weight, boolean canSwim, String sound) {
        super(age, name, category, weight, sound);
        swim = canSwim;
    }

    abstract public boolean isCapableOfSwim();
}
