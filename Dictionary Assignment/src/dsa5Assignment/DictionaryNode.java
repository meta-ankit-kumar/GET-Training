package dsa5Assignment;

public class DictionaryNode {
	int key;//to store the value of key
	String value;//to store the value of corresponding key
	DictionaryNode left, right;
	//Constructor to initialize the key, value variables. Also sets the left and right pointer to null
	public DictionaryNode(int k, String v) {
		// TODO Auto-generated constructor stub
		key = k;
		value = v;
		//by default left and right is initialized to null
		left = null;
		right = null;
	}
	/**
	 * To get the key of DictinaryNode
	 * @return Integer value which contains key
	 */
	public int getKey(){
		return key;
	}
	/**
	 * To get the value of DictionaryNode
	 * @return Integer value which contains value
	 */
	public String getValue(){
		return value;
	}
}
