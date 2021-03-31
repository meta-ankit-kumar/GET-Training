package inheritanceAndComposition;
import java.util.LinkedHashMap;
import java.util.Scanner;
/**
 * Zoo class 
 * @author ankit.kumar_metacube
 * contains different methods for addition of animal, zoo and cage.
 */
public class Zoo {
	//creating a zoo class object
	static Zoo zooObject = new Zoo();
	//scanner class object
	public static Scanner scan = new Scanner(System.in);
    private LinkedHashMap<Integer, Zones> listOfZones = new LinkedHashMap<Integer, Zones>();
    /**
     * Method to add zone to the zoo
     * @param capacityOfCages capacity of number of cages in the zone
     * @param zoneType Category of animal
     * @param park whether a zone has park or not
     * @param canteen whether a zone has canteen or not
     * @return true if successful otherwise false.
     */
    public boolean addZone(int capacityOfCages, String zoneType, boolean park, boolean canteen) {
        Zones zoneObj = new Zones(capacityOfCages, zoneType, park, canteen);
        listOfZones.put(zoneObj.zoneId, zoneObj);
        return true;
    }
    /**
     * Method to add cage to a particular zone type
     * @param zoneType type of the zone
     * @param animalBreed Sub category of the animal
     * @param capacity Capacity of the cage
     * @return true if successful otherwise false
     */
    public boolean addCage(String zoneType, String animalBreed, int capacity) {
        Cage cageObj = new Cage(animalBreed, capacity);
        for (int i = 0; i < listOfZones.size(); i++) {
            if (listOfZones.get(i).typeOfZone.equalsIgnoreCase(zoneType)
                    && listOfZones.get(i).limitOfCages > listOfZones.get(i).listOfCages.size()) {
                listOfZones.get(i).listOfCages.add(cageObj);
                return true;
            }
        }
        return false;
    }
    // method to add animal of Mammal type
    public boolean addAnimal(String type, int age, String name, String category, int weight, int speed, String sound){
        Animal animalObj = AnimalTypeFactory.addAnimal(type, age, name, category, weight, speed, sound);
        for (int i = 0; i < listOfZones.size(); i++) {
            if (listOfZones.get(i).typeOfZone.equalsIgnoreCase(category)) {
                for (int j = 0; j < listOfZones.get(i).listOfCages.size(); j++) {
                    if (listOfZones.get(i).listOfCages.get(j).listOfAnimal.containsKey(name)){
                    	System.out.println("Animal with this name already present");
                    	return false;
                    }
                    if (listOfZones.get(i).listOfCages.get(j).animalBreed.equalsIgnoreCase(type) && listOfZones.get(i).listOfCages
                            .get(j).capacityOfCage > listOfZones.get(i).listOfCages.get(j).listOfAnimal.size()) {
                        listOfZones.get(i).listOfCages.get(j).listOfAnimal.put(name, animalObj);
                        return true;
                    }
                }
            }
        }
        return false;
    }
    // method to add animal of Bird type
    public boolean addAnimal(String type, int age, String name, String category, int weight, boolean canFly,
            String sound){
        Animal animalObj = AnimalTypeFactory.addAnimal(type, age, name, category, weight, canFly, sound);
        for (int i = 0; i < listOfZones.size(); i++) {
            if (listOfZones.get(i).typeOfZone.equalsIgnoreCase(category)) {
                for (int j = 0; j < listOfZones.get(i).listOfCages.size(); j++) {
                    if (listOfZones.get(i).listOfCages.get(j).listOfAnimal.containsKey(name))
                        System.out.println("Animal with this name already present");
                    if (listOfZones.get(i).listOfCages.get(j).animalBreed.equalsIgnoreCase(type) && listOfZones.get(i).listOfCages
                            .get(j).capacityOfCage > listOfZones.get(i).listOfCages.get(j).listOfAnimal.size()) {
                        listOfZones.get(i).listOfCages.get(j).listOfAnimal.put(name, animalObj);
                        return true;
                    }
                }
            }
        }

        return false;
    }
    // method to add animal for Reptiles type
    public boolean addReptile(String type, int age, String name, String category, int weight, boolean swim,
            String sound){
        Animal animalObj = AnimalTypeFactory.addAnimal(type, age, name, category, weight, swim, sound);
        for (int i = 0; i < listOfZones.size(); i++) {
            if (listOfZones.get(i).typeOfZone.equalsIgnoreCase(category) ) {
                for (int j = 0; j < listOfZones.get(i).listOfCages.size(); j++) {
                    if (listOfZones.get(i).listOfCages.get(j).listOfAnimal.containsKey(name))
                    	System.out.println("Animal with this name already present");
                    if (listOfZones.get(i).listOfCages.get(j).animalBreed.equalsIgnoreCase(type) && listOfZones.get(i).listOfCages
                            .get(j).capacityOfCage > listOfZones.get(i).listOfCages.get(j).listOfAnimal.size()) {
                        listOfZones.get(i).listOfCages.get(j).listOfAnimal.put(name, animalObj);
                        return true;
                    }
                }
            }
        }

        return false;
    }
    // method to display animals in the zoo
    public void showAnimals(){
    	for (int i = 0; i < listOfZones.size(); i++) {
    		for (int j = 0; j < listOfZones.get(i).listOfCages.size(); j++) {
                if (i==0) {
                	System.out.println("Lions = " + listOfZones.get(i).listOfCages.get(j).listOfAnimal.keySet());            					
				}else if (i==1) {
					System.out.println("Crocodiles = " + listOfZones.get(i).listOfCages.get(j).listOfAnimal.keySet());            					
				}else if (i==2) {
					System.out.println("Peacocks = " + listOfZones.get(i).listOfCages.get(j).listOfAnimal.keySet());
				}
    		}
    	}
    }
    // method to remove animals from the zoo
    public boolean removeAnimal(String category, String breed, String name) {
        for (int i = 0; i < listOfZones.size(); i++) {
            if (listOfZones.get(i).typeOfZone == category) {
                for (int j = 0; j < listOfZones.get(i).listOfCages.size(); j++) {
                    if (listOfZones.get(i).listOfCages.get(j).animalBreed == breed
                            && listOfZones.get(i).listOfCages.get(j).listOfAnimal.containsKey(name)) {
                        listOfZones.get(i).listOfCages.get(j).listOfAnimal.remove(name);
                        return true;
                    }
                }
            }
        }
        return false;
    }
    // method to display sounds of various animals
    public String getAnimalSound(int name) {
        switch (name) {
		case 1:
			return "Roars";
		case 2:
			return "Squawk";
		case 3:
			return "Growls";
		default:
			return "Wrong Input, Animal not found";
		}
    }
    // operation method to perform various operations of zoo
    public static void operations(){
    	System.out.println("Enter 1 to add animal\n"
    			+ "Enter 2 to remove animal\n"
    			+ "Enter 3 to see sound of an animal\n"
    			+ "Enter 4 to add new cage\n"
    			+ "Enter 5 to see animals in the zoo\n"
    			+ "Enter 6 to exit");
    	while(true){
    		boolean checkLoop = false;
    		int input;
    		while(true){
    			try{
    				input = Integer.parseInt(scan.nextLine());
    				break;
    			}
    			catch(Exception e){
    				System.out.println("Please enter the correct choice");

    			}
    		}
    	switch (input) {
		case 1:
			System.out.println("Enter 1 for Lion\nEnter 2 for Peacock\nEnter 3 for crocodile");
			int animalInput;
			while(true){
				try{
					animalInput = Integer.parseInt(scan.nextLine());
					if(animalInput != 1 && animalInput != 2 && animalInput != 3)
						throw new Exception();
					break;
				}
				catch(Exception e){
					System.out.println("Please enter the correct choice");
				}
			}
			switch (animalInput) {
			case 1:
				System.out.println("Enter age");
				int age = Integer.parseInt(scan.nextLine());
				System.out.println("Enter name");
				String name = scan.nextLine();
				System.out.println("Enter weight");
				int weight = Integer.parseInt(scan.nextLine());
				System.out.println("Enter speed");
				int speed = Integer.parseInt(scan.nextLine());
				String sound = "Roars";
				boolean check = zooObject.addAnimal("lion", age, name, "mammal", weight, speed, sound);
				if (check) {
					System.out.println("Lion added successfully");
				}
				else{
					System.out.println("Cage is full. Lion is not added");
				}
				break;
			case 2:
				System.out.println("Enter age");
				int age1 = Integer.parseInt(scan.nextLine());
				System.out.println("Enter name");
				String name1 = scan.nextLine();
				System.out.println("Enter weight");
				int weight1 = Integer.parseInt(scan.nextLine());
				String sound1 = "squawk";
				boolean check1 = zooObject.addAnimal("peacock", age1, name1, "bird", weight1, true, sound1);
				if (check1) {
					System.out.println("Peacock added successfully");
				}
				else{
					System.out.println("Cage is full. Peacock is not added.");
				}
				break;
			case 3:
				System.out.println("Enter age");
				int age2 = Integer.parseInt(scan.nextLine());
				System.out.println("Enter name");
				String name2 = scan.nextLine();
				System.out.println("Enter weight");
				int weight2 = Integer.parseInt(scan.nextLine());
				System.out.println("Can swim? Enter true or false");
				boolean canSwim;
				try{
					canSwim = Boolean.parseBoolean(scan.nextLine());
				}
				catch(Exception e){
					System.out.println("Please enter either true or false");
					continue;
				}
				String sound2 = "Growls";
				boolean check2 = zooObject.addAnimal("crocodile", age2, name2, "reptile", weight2, canSwim, sound2);
				if (check2) {
					System.out.println("Crocodile added successfully");
				}
				else{
					System.out.println("Cage full,Crocodile addition failed");
				}
				break;

			default:
				System.out.println("Wrong input.");
				break;
			}
			break;
		case 2:
			System.out.println("Enter 1 to remove Lion\nEnter 2 to remove Peacock\nEnter 3 to remove crocodile");
			int animalChoice;
			while(true){
				try{
					animalChoice = Integer.parseInt(scan.nextLine());
					if(animalChoice != 1 && animalChoice != 2 && animalChoice != 3)
						throw new Exception();
					break;
				}
				catch(Exception e){
					System.out.println("Please enter the correct choice");
				}
			}
			switch (animalChoice) {
			case 1:
				System.out.println("Enter name of Lion");
				String name_of_lion = scan.nextLine();
				boolean check = zooObject.removeAnimal("mammal", "lion", name_of_lion);
				if(check){
					System.out.println("Lion removed successfully");
				}else{
					System.out.println("Animal not found");
				}
				break;
			case 2:
				System.out.println("Enter name of Peacock");
				String name_of_peacock = scan.nextLine();
				boolean check1 = zooObject.removeAnimal("bird", "peacock", name_of_peacock);
				if(check1){
					System.out.println("Peacock removed successfully");
				}else{
					System.out.println("Animal not found");
				}
				break;
			case 3:
				System.out.println("Enter name of Crocodile");
				String name_of_crocodile = scan.nextLine();
				boolean check2 = zooObject.removeAnimal("reptile", "crocodile", name_of_crocodile);
				if(check2){
					System.out.println("Crocodile removed successfully");
				}else{
					System.out.println("Animal not found");
				}
				break;

			default:
				System.out.println("Wrong input.");
				break;
			}
			break;
		case 3:
			System.out.println("Enter 1 for lion sound\n"
					+ "Enter 2 for peacock sound\n"
					+ "Enter 3 for Crocodile sound");
			int numberChoice = Integer.parseInt(scan.nextLine());
			String sound = zooObject.getAnimalSound(numberChoice);
			System.out.println(sound);
			break;
		case 4:
			System.out.println("Enter 1 to add cage for lion\n"
					+ "Enter 2 to add cage for peacock\n"
					+ "Enter 3 to add cage for crocodile");
			int cageInput;
			while(true){
				try{
					cageInput = Integer.parseInt(scan.nextLine());
					if(cageInput != 1 && cageInput != 2 && cageInput !=3)
						throw new Exception();
					System.out.println("Enter the capacity of the cage");
					break;
				}
				catch(Exception e){
					System.out.println("Please enter the correct choice");
				}
			}
			switch (cageInput) {
			case 1:
				int capacityOfCage;
				try{
					capacityOfCage = Integer.parseInt(scan.nextLine());
					if(capacityOfCage <= 0)
						throw new Exception("Capacity of the cage should be a positive number");
				}
				catch(Exception e){
					System.out.println(e.getMessage());
					break;
				}
				boolean checker = zooObject.addCage("mammal", "lion", capacityOfCage);
				if (checker) {
					System.out.println("Cage added successfully");					
				}else{
					System.out.println("Zone is full, cage can't be alloted");
				}
				break;
			case 2:
				int capacityOfCage1;
				try{
					capacityOfCage1 = Integer.parseInt(scan.nextLine());
					if(capacityOfCage1 <= 0)
						throw new Exception("Capacity of the cage should be a positive number");
				}
				catch(Exception e){
					System.out.println(e.getMessage());
					break;
				}
				boolean checker1 = zooObject.addCage("bird", "peacock", capacityOfCage1);
				if (checker1) {
					System.out.println("Cage added successfully");					
				}else{
					System.out.println("Zone is full, cage can't be alloted");
				}
				break;
			case 3:
				int capacityOfCage2;
				try{
					capacityOfCage2 = Integer.parseInt(scan.nextLine());
					if(capacityOfCage2 <= 0)
						throw new Exception("Capacity of the cage should be a positive number");
				}
				catch(Exception e){
					System.out.println(e.getMessage());
					break;
				}
				boolean checker2 = zooObject.addCage("reptile", "crocodile", capacityOfCage2);
				if (checker2) {
					System.out.println("Cage added successfully");					
				}else{
					System.out.println("Zone is full, cage can't be alloted");
				}
				break;
			default:
				System.out.println("Invaid Choice");
				break;
			}
			break;
		case 5:
			zooObject.showAnimals();
			break;
		case 6:
			checkLoop = true;
			 break;
		default:
			System.out.println("Invalid Choice");
			break;
		}
    	if(checkLoop)
    		break;
    }
    }
    // main method
    public static void main(String[] args) {
        // adding zones for all the animal types
    	zooObject.addZone(5, "mammal", true, false);
        zooObject.addZone(8, "reptile", false, true);
        zooObject.addZone(3, "bird", true, true);
        // add cage to each zone having capacity of 10
        zooObject.addCage("mammal", "lion", 1);
        zooObject.addCage("bird", "peacock", 10);
        zooObject.addCage("reptile", "crocodile", 10);
        // call operations method
        operations();
        scan.close();
    }
}
