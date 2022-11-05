import java.util.ArrayList;
import java.io.*;
import java.util.*;
public class Inventory
{
	private ArrayList<Product> productList = new ArrayList<Product>();

	public Inventory()
	{
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * Adds new product to inventory
	 */
	public void addProduct(Product p)
	{
		productList.add(p);
	}
	
	
	/*
	 * Givin id finds product of id also returns null if id is not found
	 */
	public Product findByName(String name)
	{
		for(Product p : productList)
		{
			if(p.getName().equals(name))
			{
				return p;
			}
		}
		return null;
	}
	/*
	 * Givin product finds id of id also returns null if id is not found
	 */
	public Product findByID(long id)
	{
		for(Product p : productList)
		{
			if(p.getStockID() == id)
			{
				return p;
			}
		}
		return null;
	}
	
	/*
	 * Giving inventory of products finds total monentory value
	 */
	public double findInventoryValue()
	{
		double total=0;
		for(Product p : productList)
		{
			total += p.getValueAtPurchase()* p.getNumInStock();
			
		}
		return total;
	}
	
	/*
	 * Givin Specific ID add all quantities
	 */
	public void addToStock(long id, int stock)
	{
		Product p = findByID(id);
		
		if(p != null)
		{
			p.setNumInStock(p.getNumInStock()+stock);
		}
	}
	
	/*
	 * String method to print in clean order
	 */
	public String toString()
	{
		String headerFormat = "%-8s%-20s%-60s%-6s%8s";
		String itemFormat = "%-8d%-20s%-60s%-6.2f%8d";
		String strReturn = String.format(headerFormat, "ID", "Name", "Description", "Value","Stock") + "\n";
		strReturn += String.format(headerFormat, "--", "----" , "-----------", "----", "----") + "\n";
		for(Product p : productList)
		{
			strReturn+= String.format(itemFormat, p.getStockID(), p.getName(), p.getDescription(),p.getValueAtPurchase(), p.getNumInStock() )+"\n";
		}
		return strReturn;
	}
	
	/*
	 * Givin productID delete product which is not continued
	 */
	 public void discontinueProduct(long id)
	   {
	       for (int i = 0; i < productList.size(); i++)
	       {
	           Product newProduct = productList.get(i);
	           if (newProduct.getStockID() == id)
	           {
	               String name = newProduct.getName();
	               newProduct.setName(name + " -discountinued");
	               newProduct.setNumInStock(0);
	           }
	       }
	   }

	
	/*
	 * If duplicate in inventory return true
	 */
	public boolean isDuplicate(Product p)
	{
		boolean duplicate = false;
		for(Product product : productList)
		{
			if(product.equals(p))
			{
				duplicate = true;
			}
		}
		return duplicate;
	}
	

}
