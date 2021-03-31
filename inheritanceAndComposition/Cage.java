package inheritanceAndComposition;

import java.util.HashMap;
/**
 * Cage class which contains animals of a particular type
 * @author ankit.kumar_metacube
 */
public class Cage {
	final String animalBreed;
	final int cageId;
	static int counter = 0;
	// Hashmap to store animal list of zoo
	HashMap<String, Animal> listOfAnimal = new HashMap<>();
	final int capacityOfCage;
	/**
	 *  Constructor
	 * @param typeOfAnimal Type of the animal
	 * @param capacity Capacity of the cage
	 */
	public Cage(String typeOfAnimal, int capacity) {
		animalBreed = typeOfAnimal;
		capacityOfCage = capacity;
		cageId = counter++;
	}
}