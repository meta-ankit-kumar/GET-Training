package inheritanceAndComposition;

abstract public class Bird extends Animal {
    boolean fly;
    public Bird(int age, String name, String category, float weight, boolean canFly, String sound) {
        super(age, name, category, weight, sound);
        fly = canFly;
    }
    abstract public boolean canFly();
}