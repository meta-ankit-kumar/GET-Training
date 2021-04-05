package treesAndGraphs;

import java.util.ArrayList;

/**
 * Class for representing a directory tree
 * @author ankit.kumar_metacube
 *
 */
public class DirectoryTree {
	//Root node of the tree
	private final Directory rootDirectory;
	//Current working directory
	private Directory currentWorkingDirectory;
	private ArrayList<String> routes = new ArrayList<String>();
	
	/**
	 * Initialize Directory Tree
	 */
	public DirectoryTree() {
		this.rootDirectory = new Directory("root",null);
		this.currentWorkingDirectory = this.rootDirectory;
		this.routes.add(this.rootDirectory.getName() + ":");
	}
	
	/**
	 * Change current working Directory to any Sub Directory of current working Directory  
	 * @param name String, name of Sub-Directory
	 * @throws AssertionError if name is null
	 * @throws Exception if no sub-directory found with given name
	 */
	public void changeDirectory(String name) throws AssertionError, Exception{
		if(name == null){
			throw new AssertionError("Name cannot be Null !");
		}
		boolean flag = false;
		for(Directory directory : this.currentWorkingDirectory.subDirectories){
			if(directory.getName().equals(name)){
				this.currentWorkingDirectory = directory;
				this.routes.add(directory.getName());
				flag = true;
				break;
			}
		}
		if(!flag){
			throw new Exception("Directory Not Found");
		}
	}
	
	
	/**
	 * Make Directory in Current Working Directory
	 * @param name String, name of new Directory
	 * @throws AssertionError if name is null
	 * @throws Exception if Directory with same name is already present
	 */
	public void makeDirectory(String name) throws AssertionError, Exception{
		if(name == null){
			throw new AssertionError("Name cannot be Null !");
		}
		boolean flag = false;
		for(Directory directory : this.currentWorkingDirectory.subDirectories){
			if(directory.getName().equals(name)){
				flag = true;
				break;
			}
		}
		if(flag){
			throw new Exception("Directory with this name already exist !");
		}
		else{
			Directory newDirectory = new Directory(name,this.currentWorkingDirectory);
			this.currentWorkingDirectory.subDirectories.add(newDirectory);
		}
	}
	
	
	/**
	 * Back to parent Directory of Current Working Directory
	 * @throws Exception if Current working Directory is the root directory
	 */
	public void back() throws Exception{
		if(this.currentWorkingDirectory.parentDirectory == null){
			throw new Exception("You are already in Root Directory");
		}
		else{
			this.currentWorkingDirectory = this.currentWorkingDirectory.parentDirectory;
			this.routes.remove(this.routes.size()-1);
		}
	}
	
	/**
	 * Get a list of Directories in CUrrent Working Directory
	 * @return ArrayList<Directory>, list of Sub-Directory
	 */
	public ArrayList<Directory> listFolders(){
		return (ArrayList<Directory>) this.currentWorkingDirectory.subDirectories.clone();
	}
	
	/**
	 * Find Sub Directory in Directory with given name
	 * @param name String, name of Directory to be searched for
	 * @param directory Directory, Directory in which we have to search
	 * @param path String, path of Directory in which we have to search
	 * @return ArrayList<String>, list of Paths of Directories with pattern of name as given name
	 */
	private ArrayList<String> findInDirectory(String name, Directory directory, String path){
		ArrayList<String> paths = new ArrayList<String>();
        if(directory.subDirectories.size()>0){
        	for(Directory subDirectory : directory.subDirectories){
        		String newPath = path + "/" + subDirectory.getName();
    			if(subDirectory.getName().contains(name)){
    				paths.add(newPath);
    			}
    			ArrayList<String> pathsInSubDirectory = findInDirectory(name, subDirectory,newPath);
    			for(String testPath: pathsInSubDirectory){
    				paths.add(testPath);
    			}
    		}
		}
        return paths;
	}
	
	/**
	 * Get paths of Sub Directories with given name
	 * @param name String, name or pattern 
	 * @return ArrayList<String>, list of paths
	 */
	public ArrayList<String> find(String name){
		if(name == null){
			throw new AssertionError("Name cannot be null");
		}
		return findInDirectory(name,this.currentWorkingDirectory,String.join("/", this.routes));
	}
	
	/**
	 * Get root Directory
	 * @return Directory, root directory
	 */
	public Directory getRoot(){
		return this.rootDirectory;
	}
	
	/**
	 * Get current working Directory route as String
	 * @return String, route
	 */
	public String getRoute(){
		return String.join("/",this.routes)+">";
	}
}
