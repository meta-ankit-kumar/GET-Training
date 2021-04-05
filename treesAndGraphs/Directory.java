package treesAndGraphs;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Class to represent a directory or a folder
 * @author ankit.kumar_metacube
 *
 */
public class Directory {
	//name of the directory
	private final String name;
	//time when the directory was created
	private final String timeCreated;
	//parent directory of the current directory
	public final Directory parentDirectory;
	//sub-directories of the current directory
	public ArrayList<Directory> subDirectories = new ArrayList<Directory>();
	
	
	/**
	 * Initialize Directory Object
	 * @param name String, name of Directory
	 * @param parentDirectory Directory, Parent Directory Object
	 */
	public Directory(String name, Directory parentDirectory) {
		this.name = name;
		this.timeCreated  = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
		this.subDirectories.clear();
		this.parentDirectory = parentDirectory;
	}
	
	/**
	 * Get name of Directory
	 * @return String, name of Directory
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 * Get Time of Creation of Directory
	 * @return String, time of Creation
	 */
	public String getTimeCreated(){
		return this.timeCreated;
	}
	
	
}