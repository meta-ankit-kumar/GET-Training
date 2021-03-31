package inheritanceAndComposition;

import java.util.ArrayList;
/**
 * class which contains zones properties
 * @author ankit.kumar_metacube
 *
 */
public class Zones {
	//capacity of each cage
	final int limitOfCages;
	String typeOfZone;
	//zone id
	final int zoneId;
	static int counter = 0;
	// List of the cages in a particular zone
	ArrayList<Cage> listOfCages = new ArrayList<Cage>();
	boolean hasPark;
	boolean hasCanteen;
	/**
	 * Constructor to create an instance of zone
	 * @param capacityForCagesInZone Capacity of number of cages in the zone
	 * @param zoneType
	 * @param park Whether a zone has park or not
	 * @param canteen Whether a  zone has canteen or not
	 */
	public Zones(int capacityForCagesInZone, String zoneType, boolean park, boolean canteen) {
		limitOfCages = capacityForCagesInZone;
		typeOfZone = zoneType;
		zoneId = counter++;
		hasPark = park;
		hasCanteen = canteen;
	}
}
