package dsa5Assignment;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class Dictionary {
	DictionaryNode root;
	List<DictionaryNode> nodeList;
	/**
	 * Constructor to initialize root and nodeList pointer
	 */
	public Dictionary(){
		root = null;
		nodeList = new ArrayList<DictionaryNode>();
	}
	/**
	 * Insert a particular key value in Binary Search Tree
	 * @param key Key
	 * @param value Value corresponds to key
	 */
	public void insert(int key, String value){
		root = insertInDictionary(root, key, value);
	}
	/**
	 * Insert a particular key at its right position
	 * @param root Root pointer of the dictionary
	 * @param key1 Key which is going to be inserted
	 * @param value1 Value corresponds to key
	 * @return returns the root node after adding the key to its right position
	 */
	public DictionaryNode insertInDictionary(DictionaryNode root, int key1, String value1){
		if(root == null){
			root = new DictionaryNode(key1, value1);
			return root;
		}
		if(root.key == key1){
			System.out.println("Duplicates are not allowed");
			throw new IllegalStateException("Duplicates are not allowed");
		}
		else if(key1 < root.key){
			root.left = insertInDictionary(root.left, key1, value1);
		}
		else if(key1 > root.key){
			root.right = insertInDictionary(root.right, key1, value1);
		}
		return root;
	}
	/**
     * This method calls another method to traverse the tree of dictionary
     * @return list of traversal
     */
    public List<DictionaryNode> inorder() {
        nodeList.clear();
        inorderTraversal(root);
        return nodeList;
    }
    /**
     * This method traverses the tree of dictionary
     * @param node
     */
    void inorderTraversal(DictionaryNode node) {
        if (node != null) {
            inorderTraversal(node.left);
            nodeList.add(node);
            inorderTraversal(node.right);
        }
    }
    /**
     * This method prints the list
     * @param list
     */
    void printList(List<DictionaryNode> list) {
        for (int count = 0; count < list.size(); count++) {
            System.out.println("Key : " + list.get(count).key + "\tValue : "
                    + list.get(count).value);
        }
    }
    /**
     * Deletes a particular key from the dictionary
     * @param key Key which is going to be deleted
     */
    public void deleteKey(int key) {
        root = deleteSpecifiedKey(root, key);
    }
    /**
     * This method deletes a key from dictionary
     * @param root
     * @param key
     * @return updated root
     */
    DictionaryNode deleteSpecifiedKey(DictionaryNode root, int key) {
        if (root == null) {
            return root;
        }
        if (root.key > key) {
            root.left = deleteSpecifiedKey(root.left, key);
        } else if (root.key < key) {
            root.right = deleteSpecifiedKey(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            int keyMin = findMinKey(root.right);
            String value = searchValue(keyMin);
            root.key = keyMin;
            root.value = value;
            root.right = deleteSpecifiedKey(root.right, root.key);
        }
        return root;
    }
    /**
     * Finds the minimum key from root
     * @param root
     * @return minimum key
     */
    int findMinKey(DictionaryNode root) {
        int minimumKey = root.key;
        while (root.left != null) {
            minimumKey = root.left.key;
            root = root.left;
        }
        return minimumKey;
    }

    /**
     * This method calls findValueRecursively to search for a value from tree
     * @param key
     * @return value of key
     */
    public String searchValue(int key) {
        DictionaryNode node = findValueRecursively(root, key);

        if (node == null) {
            throw new IllegalStateException("Key not found");
        }
        return node.value;
    }
    /**
     * This method calls another method to find keys between range of 2 keys
     * @param key1
     * @param key2
     * @return list of nodes in range
     */
    public List<DictionaryNode> findInRange(int key1, int key2) {
        nodeList.clear();
        findInRangeRecursively(root, key1, key2);
        return nodeList;
    }
    /**
     * Searches for a value from tree
     * @param root
     * @param key
     * @return
     */
    DictionaryNode findValueRecursively(DictionaryNode root, int key) {
        if (root == null || root.key == key) {
            return root;
        }
        if (root.key > key) {
            return findValueRecursively(root.left, key);
        } else {
            return findValueRecursively(root.right, key);
        }
    }
    /**
     * This method finds keys between range of 2 keys
     * @param node
     * @param key1
     * @param key2
     */
    void findInRangeRecursively(DictionaryNode node, int key1, int key2) {
        if (node == null) {
            return;
        }
        if ((key1 < node.key || node.key == key1)
                && (node.key < key2 || node.key == key2)) {
            nodeList.add(node);
        }
        if (key1 < node.key) {
            findInRangeRecursively(node.left, key1, key2);
        }
        if (node.key < key1) {
            findInRangeRecursively(node.right, key1, key2);
        }
    }

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		// TODO Auto-generated method stub
		 Dictionary dictionary = new Dictionary();
		 JSONParser parser = new JSONParser();
		 System.out.println("Please enter the JSON string eg.{\"1\":\"Hello\"}");
		 Scanner sc = new Scanner(System.in);
		 String jsonInput = "";
		 try{
			 jsonInput = sc.nextLine();
			 JSONObject obj = (JSONObject) parser.parse(jsonInput);
		     System.out.println("Entered String is:");
		     System.out.println(obj);
		     for (Object Key : obj.keySet()) {
		            dictionary.insert(Integer.parseInt(Key.toString()), (obj.get(Key).toString()));
		        }
		 }
		 catch(Exception e){
			 System.out.println("Please enter the valid JSON String");
			 try{
				 System.out.println("Please enter the JSON string eg.{\"1\":\"Hello\"}");
				 jsonInput = sc.nextLine();
				 JSONObject obj = (JSONObject) parser.parse(jsonInput);
			     System.out.println("Entered JSON String is:");
			     System.out.println(obj);
			     for (Object Key : obj.keySet()) {
			            dictionary.insert(Integer.parseInt(Key.toString()), (obj.get(Key).toString()));
			        }
			 }
			 catch(Exception e1){
				 System.out.println("Please enter the valid JSON String");
				 System.exit(0);
			 }
		 }
	     System.out.println("Please select from the following choices");
	     System.out.println("1: Delete a key value pair from the dictionary"
	    		+ "\n2. Add a key-value pair to dictionary," 
	     		+ "\n3: Get the value corresponding to a specified key"
	     		+ "\n4: Sorted list of key value pairs"
	     		+ "\n5: Sorted list of key value pairs for all the keys >=K1 and <=K2"
	     		+ "\n6: Exit");
	     while(true){
	     System.out.println("Enter your choice");
	     int choice;
	     boolean check = false;
	     try{
	    	 choice = Integer.parseInt(sc.nextLine());
	     }
	     catch(Exception e){
	    	 System.out.println("Please enter the correct choice");
	    	 continue;
	     }
	    switch (choice) {
			case 1:
				System.out.println("Enter the key to be deleted");
				try{
					int key = Integer.parseInt(sc.nextLine());
					dictionary.searchValue(key);
					dictionary.deleteKey(key);
					System.out.println("Successfully Deleted");
					break;
				}
				catch(Exception e){
					System.out.println("Key is not present");
					continue;
				}
			case 2:
				int key1;
				String value;
				System.out.println("Enter key(MUST BE A INTEGER)");
					try{
						key1 =	Integer.parseInt(sc.nextLine());
						System.out.println("Enter Value(Must be a string)");
						value = sc.nextLine();
						dictionary.insert(key1, value);
						System.out.println("Successfully added");
						break;
					}
					catch(Exception e){
						System.out.println("Incorrect Input");
						continue;
					}
			case 3:
				int key2;
				System.out.println("Enter the Integer key");
				try{
					key2 = Integer.parseInt(sc.nextLine());
					dictionary.searchValue(key2);
					DictionaryNode result = dictionary.findValueRecursively(dictionary.root, key2);
					System.out.println("Value corresponding to the given key is: " + result.value);
					break;
				}
				catch(Exception e){
					System.out.println("Key is not present");
					break;
				}
			case 4:
				dictionary.printList(dictionary.inorder());
				break;
			case 5:
				int lowerLimit, upperLimit;
				System.out.println("Enter the First Integer key");
				try{
					lowerLimit = Integer.parseInt(sc.nextLine());
					System.out.println("Enter the Second Integer key");
					upperLimit = Integer.parseInt(sc.nextLine());
					List<DictionaryNode> result = dictionary.inorder();
					boolean check1 = false;
					System.out.println("Result:");
					for(int i = 0; i < result.size(); i++){
						if(result.get(i).key >= lowerLimit && result.get(i).key <= upperLimit){
							check1 = true;
							System.out.println("Key: " + result.get(i).key + " Value: " + result.get(i).value);
						}
					}
					if(!check1)
						System.out.println("No Keys in the Given range");
					break;
				}
				catch(Exception e){
					System.out.println("Enter the Correct Integer Keys");
					sc.next();
					continue;
				}
			case 6:
				check = true;
				break;
			default:
				System.out.println("Please enter the correct choice");
				break;
			}
	    if(!check){
	    	if(dictionary.root != null){
	    	 System.out.println("Sorted order of Key-Value Pairs");
	    	 dictionary.printList(dictionary.inorder());
	    	}
	    	else
	    		System.out.println("List is empty");
	    }
	    else
	    	break;
	     }
	     
	    }
	 	
	}

