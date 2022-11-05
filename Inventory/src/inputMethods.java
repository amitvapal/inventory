import java.util.*;

import javax.swing.JOptionPane;

/**
 * 
 * @author amitvapal
 * @since 10/19/20
 * @version 2.0
 *
 *<h3>InputMethods<h3>Set of static methods to expedite the process obtaining valid Áinput
 */
public class inputMethods
{
	public static int getRandom(int low, int high)
	{
		Random r = new Random();
		return r.nextInt(high-low+1) + low;
		
	}
	/**
	 * Retrieves at interger from the user between low and high inclusive
	 * @param message- custom message for input
	 * @param low- lowest number to generate
	 * @param high- highest number to generate
	 * @return num where low &lt;=num
	 * 
	 */
	public static int getIntBetween(String message, int low, int high) 
	{
		Scanner input = new Scanner(System.in);
		boolean done = false;
		int num = Integer.MAX_VALUE;
		
		do	// handle excptons
		{	try {
					System.out.println(message + " between " + low + " and " + high + ":");
					//validate input
					
					num = input.nextInt();
					
					if(num>=low && num<=high)
						done = true;
			
			
		}
		catch(InputMismatchException ex)
		{
			input.nextLine();		// input was a letter, flush input
			System.out.println("Please enter a acalid integer:");
			
		}
			
			
		}while(!done);
		
	return num;
		
		
	}
	
	/**
	 * Retrieves a inteager from the user between low and high inclusive using JOptionPane.showInputDialog
	 * @param message- custom message for input
	 * @param low- lowest number to generate
	 * @param high- highest number to generate
	 * @return num where low &lt;=num
	 * 
	 */
	
	public static double getDoubleBetween(String message, double low, double high) 
	{
		Scanner input = new Scanner(System.in);
		boolean done = false;
		double num = Double.MAX_VALUE;
		
		do	// handle excptons
		{	try {
					System.out.println(message + " between " + low + " and " + high + ":");
					//validate input
					num=(int) input.nextDouble();
					if(num>=low && num<=high)
						done = true;
			
			
		}
		catch(InputMismatchException ex)
		{
			input.nextDouble();		// input was a letter, flush input
			System.out.println("Please enter a acalid integer:");
			
		}
			
			
		}while(!done);
		
	return num;
	
		
		
	}
	/**
	 * Retrieves a double from the user between low and high inclusive using JOptionPane.showInputDialog
	 * @param message- custom message for input
	 * @param low- lowest number to generate
	 * @param high- highest number to generate
	 * @return num where low &lt;=num
	 * 
	 */
	
	public static double getIntBetweenJOP(String message, int low, int high) 
	{
		
		boolean done = false;
		double num = Double.MAX_VALUE;
		
		do	// handle excptons
		{	try {
					num = Double.parseDouble(JOptionPane.showInputDialog(null, message + " between " + low + " and " + high + ":"));
					if(num>=low && num<=high)
						done = true;
			
			
		}
		catch(NumberFormatException ex)
		{
			// input was a letter, flush input
			JOptionPane.showInputDialog(null,"Please enter a integer:");
			
		}
		catch(NullPointerException ex2)
		{
			// input was a letter, flush input
			JOptionPane.showInputDialog(null,"Please enter an integer:");
			
		}
			
			
		}while(!done);
		
	return num;
		
		
	}
	
	public static double getDoubleBetweenJOP(String message, double low, double high)
    {
        boolean done = false;
        double num = 0;
        
        do
        {
            // handle exceptions
            try
            {
                num = Double.parseDouble((JOptionPane.showInputDialog(null,message + " between " + low + " and " + high + ": ")));
                // validate input
                if(num>low && num<=high);
                    done = true;
            }
            catch(NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(null, "Pleaser enter a valid integer");
            }
            catch(NullPointerException ex2)
            {
                JOptionPane.showMessageDialog(null, "Pleaser enter an integer");
            }
        } while(!done);
        
        return num;
    }
	
	
	public static boolean getChoiceYN(String question)
	{
		boolean repeat = true;
		String choice;
		Scanner input = new Scanner(System.in);
		
		do 
		{
			
			System.out.println(question + "Enter y or n: ");
			choice = input.next().substring(0,1).toLowerCase();
			if(choice.equals("y"))
				return true;
			else if(choice.equals("n"))
				return false;
			else
				System.out.println("Error: enter y or n");
			
			
		}while(repeat);
		
		
		return false;
	}



	public static boolean getChoiceYNJOP(String question)
	{
		int choice;
		do
		{
			choice = JOptionPane.showConfirmDialog(null, question, "Choose yes or no", JOptionPane.YES_NO_OPTION);
		}while(choice == JOptionPane.CLOSED_OPTION);
		if(choice == JOptionPane.YES_OPTION)
			return true;
		return false;
		
	}
	
	
	/**
	 * Retrieves a double from the user between low and high inclusive using JOptionPane.showInputDialog
	 * @param message- custom message for input
	 * @param low- lowest number to generate
	 * @param high- highest number to generate
	 * @return num where low &lt;=num
	 * 
	 */
	
	public static int menuJOP(String question, String[] choices)
	{
		int choice;
		do
		{
			choice = JOptionPane.showOptionDialog(null, question, "Choose an Option", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, choices, choices[0]);
			
		}while(choice==JOptionPane.CLOSED_OPTION);
			return choice;
	}
	
	
	/**
	 * Retrieves a double from the user between low and high inclusive using console
	 * @param message- custom message for input
	 * @param low- lowest number to generate
	 * @param high- highest number to generate
	 * @return num where low &lt;=num
	 * 
	 */
	
	public static int menuConsole(String question, String[] choices)
	{
		Scanner input = new Scanner(System.in);
		int choice;
		do {
			try 
			{
				System.out.println(question+ "\n");
				for(int i=0; i<choices.length;i++)
					System.out.println(i + ". " + choices[i]);
				System.out.println("\nEnter choice (0 to " + (choices.length-1)+"): ");
				choice = input.nextInt();
				if(choice < 0 || choice>choices.length-1)
					System.out.println("Invalid entry");
					
				
			}
			catch (InputMismatchException ex)
			{
				System.out.println("Enter a choice between 0 and" + (choices.length-1));
				input.next();
				choice=-1;
			}
			
		}while(choice<0|| choice>=choices.length);
		return choice;
		
	}
} 



