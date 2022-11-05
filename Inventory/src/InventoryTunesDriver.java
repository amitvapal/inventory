import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class InventoryTunesDriver
{

	public static void main(String[] args) throws IOException
	{
		System.out.println("Sports Equipment and Company");
		Scanner inFile = new Scanner(new File("inven.txt"));
		String n, d;
		int stockNum;
		double p;
		
		Inventory list = new Inventory();
		
		/*
		 * print in nice table
		 */
		while(inFile.hasNextLine())
		{
			
			n = inFile.nextLine();
			d = inFile.nextLine();
			
			stockNum = inFile.nextInt();
			
			p = inFile.nextDouble();
			inFile.nextLine();
			
			
			Product newP = new Product(n,d,stockNum,p);
			
			list.addProduct(newP);
			
			
			
			
		}
		inFile.close();
		System.out.println("Current Inventory");
		System.out.println(list);
		System.out.println("");
		System.out.println("");
		
		
		
		String[] choices = {"Display all Products in inventory", "Display the data for single Product", "Display the value of the current inventory",
				"Add an Product to the inventory", "Add quantities to the inventory of a product", "Remove quantities from the inventory of a product",
				"Discontinue a Product when given the id number of the product","Quit"};
		
		
		boolean stop = false;
		int choice;
		while(stop == false)
		{
			System.out.println("");
			System.out.println("");
			choice = inputMethods.menuConsole("Which option do you choose?", choices);
			if(choice==7)
			{
				System.out.println("Closing program");
				break;
				
			}
			if(choice==0)
			{
				System.out.println("Here are all of the products!");
				System.out.println(list);
			}
			if(choice==1)
			{
				if(getProduct()==true)
				{
					Scanner input = new Scanner(System.in);
					System.out.print("Enter stock number: ");
                    long id = input.nextLong();

					Product findProduct = list.findByID(id);
					System.out.println(findProduct);
					
				}
				else
				{
					Scanner input = new Scanner(System.in);
					System.out.print("Enter product name: ");
                    String name = input.nextLine();

					Product findProduct = list.findByName(name);
					System.out.println(findProduct);
					
				}
					
					
					
					
				
			}
			if(choice==2)
			{
				
				double findtotal = list.findInventoryValue();
				System.out.println("Current total value is " + findtotal);
					
				
				
			}
			if(choice==3)
			{
				Scanner input = new Scanner(System.in);
				System.out.print("Enter product name: ");
                String name = input.nextLine();
                Product nameUpdate = list.findByName(name);
                list.addProduct(nameUpdate);
				
			}
			if(choice==4)
			{
			
				if(getProduct()==true)
				{
					Scanner input = new Scanner(System.in);
					System.out.print("Enter stock number: ");
                    long id = input.nextLong();
                    Product obj = list.findByID(id);
                    if(obj.getName().contains("discontinued"))
                    {
                    	System.out.println("This product is discontnued. Please try again.");
                    }
                    else 
                    {
                    	Scanner input1 = new Scanner(System.in);
    					System.out.print("Enter quanitiy number: ");
                        int quatity = input1.nextInt();
                        list.addToStock(id, quatity);
                        System.out.println(obj);
                        
                    	
                    }

					
					
					
				}
				else
				{
					Scanner input = new Scanner(System.in);
					System.out.print("Enter name: ");
                    String name = input.nextLine();
                    Product obj = list.findByName(name);
                    if(obj.getName().contains("discontinued"))
                    {
                    	System.out.println("This product is discontnued.");
                    }
                    else 
                    {
                    	Scanner input1 = new Scanner(System.in);
    					System.out.print("Enter quantity number: ");
                        int quatity = input1.nextInt();
                        list.addToStock(obj.getStockID(), quatity);
                        System.out.println(obj);
                    	
                    }
					
				}
				
				
			}
			if(choice==5)
			{
				if(getProduct()==true)
				{
					Scanner input = new Scanner(System.in);
					System.out.print("Enter stock number: ");
                    long id = input.nextLong();

					Product findProduct = list.findByID(id);
					System.out.println(findProduct);
					
				}
				else
				{
					Scanner input = new Scanner(System.in);
					System.out.print("Enter product name: ");
                    String name = input.nextLine();

					Product findProduct = list.findByName(name);
					System.out.println(findProduct);
					
				}
				
			}
			if(choice==6)
			{
				
				if(getProduct()==true)
				{
					Scanner input = new Scanner(System.in);
					System.out.print("Enter stock number: ");
                    long id = input.nextLong();
                    list.discontinueProduct(id);

					
					
					
				}
				else
				{
					Scanner input = new Scanner(System.in);
					System.out.print("Enter product name: ");
                    String name = input.nextLine();
                    System.out.print("Are you sure you want to continue (y/n): ");
                    String decision = input.nextLine();
                    if(decision == "n")
                    {
                    	System.out.println("Going back to start");
                    	
                    }
                    else
                    {
                    	Product objectID = list.findByName(name);
                        long getID = objectID.getStockID();
                        list.discontinueProduct(getID);
                    }
                    
					
				}
				
			}
			

			
		}
		
		
		
		

		

		
		
	}
	
	public static boolean getProduct()
	{
	   String[] options = {"By Name", "By ID number"};
	   int chose = inputMethods.menuConsole("How do you want to search the product", options);
	   if (chose==0)
	   {
	       return false;
	   }
	   else
	   {
	        return true;
	   }
	           
	               
	}

}
