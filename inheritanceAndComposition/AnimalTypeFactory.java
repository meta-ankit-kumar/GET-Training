package inheritanceAndComposition;

public class AnimalTypeFactory {
	/**
	 * Defining factory method for Lion class
	 * @param type Type of the animal
	 * @param age Age of the animal
	 * @param name Name of the animal
	 * @param category Category of the animal
	 * @param weight Weight of the animal
	 * @param speed Speed of the animal
	 * @param sound Sound of the animal
	 * @return Animal object of the desired type
	 */
	public static Animal addAnimal(String type, int age, String name, String category, int weight, int speed,
            String sound) {
        Animal animal = null;
        if ("lion".equalsIgnoreCase(type))
            animal = new Lion(age, name, category, weight, speed, sound);
        return animal;
    }
	/**
	 * Defining factory method for crocodile and peacock
	 * @param type Type of the animal
	 * @param age Age of the animal
	 * @param name Name of the animal
	 * @param category Category of the animal
	 * @param weight Weight of the animal
	 * @param addtionalAttribute like canSwim or canFly
	 * @param sound Sound of the animal
	 * @return Animal object of the desired type
	 */
    public static Animal addAnimal(String type, int age, String name, String category, int weight, boolean addtionalAttribute,
            String sound) {
        Animal animal = null;
        if ("crocodile".equalsIgnoreCase(type))
            animal = new Crocodile(age, name, category, weight, addtionalAttribute, sound);
        if ("peacock".equalsIgnoreCase(type))
            animal = new Peacock(age, name, category, weight, addtionalAttribute, sound);
        return animal;
    }
}
