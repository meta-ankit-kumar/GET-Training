package assignment;
import java.util.*;
public final class intSet {
	private final int array[] = new int[1000];//To store the Set elements. It removes the duplicates.
	private int arrayIndex=0;//It is the size of array(Set). When a new element is added it increases by 1
	public intSet(int [] a,int size){
		int i=0;
		for(i=0;i<size;i++){
			boolean present=false;
			for(int j=0;j<arrayIndex;j++){
				if(array[j]==a[i]){
					present=true;
					break;
				}
			}
			if(!present){
				array[arrayIndex]=a[i];
				arrayIndex+=1;
				}
			
		}	
	}
	public void printSet(){
		if(arrayIndex!=0){
		System.out.println("Set elements are following:");
		for(int i=0;i<arrayIndex;i++){
			System.out.print(array[i]+" ");
		}
		System.out.println();
		}
	}
	public boolean isMember(int x){
		int i=0;
		for(i=0;i<arrayIndex;i++){
			if(array[i]==x)
				return true;
		}
		return false;
	}
	public int size(){
		return arrayIndex;
	}
	public boolean isSubSet(intSet s){
		int i=0;
		for(i=0;i<s.arrayIndex;i++){
			//check whether all the elements of s are present in Original Set in or not
			if(!this.isMember(s.array[i])){
				return false;
			}
		}
		return true;
	}
	public intSet getComplement(){
		int arr[] = new int[1000];
		int complementIndex=0;
		int i;
		for(i=1;i<=1000;i++){
			if(!this.isMember(i)){
				arr[complementIndex]=i;
				complementIndex+=1;
			}
		}
		intSet complementSet = new intSet(arr,complementIndex);
		return complementSet;
	}
	public intSet union(intSet s2){
		int arr[] = new int[1000];
		int i=0,j=0,index=0;
		for(i=0;i<this.arrayIndex;i++){
			boolean present=false;
			for(j=0;j<index;j++){
				if(arr[j]==this.array[i]){
					present=true;
				}
			}
			if(!present){
				arr[index]=this.array[i];
				index+=1;
			}
		}
		for(i=0;i<s2.arrayIndex;i++){
			boolean present=false;
			for(j=0;j<index;j++){
				if(arr[j]==s2.array[i]){
					present=true;
				}
			}
			if(!present){
				arr[index]=s2.array[i];
				index+=1;
			}
		}
		intSet union = new intSet(arr,index);
		return union;
	}
	public static void main(String []args){
		int choice,size;
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the size of the set");
		size = sc.nextInt();
		int setArray[] = new int[size];
		if(size!=0)
			System.out.println("Enter the set elements");
		for(int i=0;i<size;i++)
			setArray[i] = sc.nextInt();
		intSet set = new intSet(setArray,size);
		set.printSet();
		System.out.println("Please choose from the following options");
		System.out.println("1. Check Whether a particular element is present in the given Set or not.");
		System.out.println("2. Check the size of the Set");
		System.out.println("3. Check whether a particular set is Subset of the given set or not.");
		System.out.println("4. Complement of the given Set");
		System.out.println("5. Union of two sets (Entered set and a particular set");
		System.out.println("6. Exit");
		choice = sc.nextInt();
		switch (choice) {
		case 1:
			int element;
			System.out.println("Enter the element:");
			element = sc.nextInt();
			System.out.println(set.isMember(element));
			break;
		case 2:
			System.out.println("Size of the set is: "+set.size());
			break;
		case 3:
			System.out.println("Enter the size of new set:");
			int newSetSize; 
			newSetSize = sc.nextInt();
			int newSetArray[] = new int[newSetSize];
			if(newSetSize!=0)
				System.out.println("Enter the new Set elements");
			for(int i=0;i<newSetSize;i++)
				newSetArray[i] = sc.nextInt();
			intSet newSet = new intSet(newSetArray,newSetSize);
			newSet.printSet();
			System.out.println(set.isSubSet(newSet));
			break;
		case 4:
			System.out.println("Original Set");
			set.printSet();
			intSet complement = set.getComplement();
			System.out.println("Complement of the given is:");
			complement.printSet();
			break;
		case 5:
			System.out.println("Enter the size of new set:");
			int newSetSize1; 
			newSetSize1 = sc.nextInt();
			int newSetArray1[] = new int[newSetSize1];
			if(newSetSize1!=0)
				System.out.println("Enter the new Set elements");
			for(int i=0;i<newSetSize1;i++)
				newSetArray1[i] = sc.nextInt();
			intSet newSet1= new intSet(newSetArray1,newSetSize1);
			newSet1.printSet();
			System.out.println("Union of the two Sets is");
			intSet union = set.union(newSet1);
			union.printSet();
			break;
		case 6:
			break;
		default:
			System.out.println("Please enter the correct choice");
		}
	}
}
