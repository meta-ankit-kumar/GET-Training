package assignemt1;
import product.item;
import java.util.*;
public class Cart {
	ArrayList<item> items=new ArrayList<item>();
	Map<String, Integer> product_details= new HashMap<String, Integer>();
	//Constructor to add some product details so that the user can add them to the cart
	public Cart(){
		product_details.put("MB",Integer.valueOf(10000));
		product_details.put("ST", 1000);
		product_details.put("TS", 500);
		product_details.put("SH",2000);
		product_details.put("JK", 800);
		System.out.println("Some Item details are added...");
	}
	String Add_to_cart(String code,int quantity){
		for(item i:items){
			if(i.item_code.equals(code)){
				i.quantity+=quantity;
				return "Item is already present in the cart...Quantity Updated";
			}
		}
		if(product_details.containsKey(code)){
			item a = new item();
			a.price=product_details.get(code);
			a.quantity=quantity;
			a.item_code=code;
			items.add(a);
			return "Item ("+code+") added successfully";
		}
		else{
			return "Given Item is not available";
		}
	}
	void Show_Cart(){
		if(items.size()==0){
			System.out.println("Your Cart is Empty");
		}
		else{
			int total_cart_value=0;
			System.out.println("Item Code     Quantity      Price(Per Item)    Total");
			System.out.print("----------------------------------------------------\n");
		for(item a:items){
			System.out.print(a.item_code);
			System.out.print("               ");
			System.out.print(a.quantity);
			System.out.print("           ");
			System.out.print(a.price);
			System.out.print("                ");
			System.out.println(a.price*a.quantity);
			total_cart_value+=a.price*a.quantity;
		}
		System.out.println("Total Cart Value:"+total_cart_value);
		}
	}
	String Update_Cart(String code,int new_quantity){
		boolean present=false;
		for(item i:items){
			if(i.item_code.equals(code)){
				present=true;
				i.quantity=new_quantity;
				break;
			}
		}
		if(!present){
			return("Given item-code"+code+ "is not present in the cart");
		}
		return "Item ("+code+") is successfully updated";
		
	}
	String Delete_Item_From_Cart(String code){
		boolean present=false;
		for(item i:items){
			if(i.item_code.equals(code)){
				present=true;
				
				items.remove(i);
				break;
			}
		}
		if(!present){
			return("Item ("+code+") is not present in the cart");
		}
		return("Item ("+code+") is successfully removed from the cart");
		
	}
	String Generate_Bill(){
		int total_quantity=0;
		int total_price=0;
		for(item i:items){
			total_price+=i.price*i.quantity;
			total_quantity+=i.quantity;
		}
		return("Total Amount to be Paid:"+total_price+"\nNo of items:"+total_quantity);
	}
	public static void main(String args[]){
	Cart c = new Cart();
	System.out.println("Item codes for different items are following:\nITEM NAME        ITEM CODE");
	System.out.println("Mobile Phone     MB");
	System.out.println("TShirt           TS");
	System.out.println("Shirt            ST");
	System.out.println("Shoes            SH");
	System.out.println("Jacket           JS");
	System.out.println("Please choose from the following:");
	System.out.println("1. To add items to cart");
	System.out.println("2. Remove items from the cart");
	System.out.println("3. Show the cart items");
	System.out.println("4. Update the items in the cart");
	System.out.println("5. Generate Bill");
	System.out.println("6. Exit Application");
	while(true){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your choice");  
		
		int choice= sc.nextInt(); 
		sc.nextLine();
		boolean exit=false;
		switch(choice){
		case 1:
			System.out.print("Enter the Item Code:");
			String item_code= sc.nextLine();
			System.out.println("Enter the quantity");
			int quantity=sc.nextInt();
			System.out.println(c.Add_to_cart(item_code,quantity ));
			break;
		case 2:
			System.out.print("Enter the Item Code of item that you want to delete:");
			String item_code1= sc.nextLine();
			System.out.println(c.Delete_Item_From_Cart(item_code1));
			break;
		case 3:
			c.Show_Cart();
			break;
			
		case 4:
			System.out.print("Enter the Item Code:");
			String item_code11= sc.nextLine();
			System.out.print("Enter the New Quantity:");
			int quantity1=sc.nextInt();
			System.out.println(c.Update_Cart(item_code11, quantity1));
			break;
		case 5:
			System.out.println(c.Generate_Bill());
			break;
		case 6:
			exit=true;
			break;
		default:
			System.out.println("Please enter the correct choice");
			break;
		}
		if(exit){
			break;
		}
			
	}
	}
}
