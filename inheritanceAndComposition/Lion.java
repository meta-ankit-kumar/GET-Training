package inheritanceAndComposition;

public class Lion extends Mammals{
	public Lion(int age, String name, String category, int weight, int speed, String sound) {
        super(age, name, category, weight, speed, sound);
    }

    public String getSound() {
        return super.soundOfAnimal;
    }
    public int topSpeed() {
        return super.runningSpeed;
    }
}
