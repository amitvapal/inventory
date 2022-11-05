
public class Product
{
	private static long nextStockID = 1000;
	private long stockID;
	private String name;
	private String description;
	private int numInStock;
	private double valueAtPurchase;
	
	
	public Product(String n, String d, int num, double v)
	{
		stockID=nextStockID;
		nextStockID++;
		name = n;
		description = d;
		numInStock = num;
		valueAtPurchase = v;
	}
	
	public boolean equals(Product p)
	{
		if (this.getName().equals(p.getName()) && this.getValueAtPurchase() == p.getValueAtPurchase())
		{
			return true;
		}
		return false;
			
		
	}
	


	public void setNextStockID(long nextStockID)
	{
		this.nextStockID = nextStockID;
	}


	public long getStockID()
	{
		return stockID;
	}


	public void setStockID(long stockID)
	{
		this.stockID = stockID;
	}


	public String getName()
	{
		return name;
	}


	public void setName(String name)
	{
		this.name = name;
	}


	public String getDescription()
	{
		return description;
	}


	public void setDescription(String description)
	{
		this.description = description;
	}


	public int getNumInStock()
	{
		return numInStock;
	}


	public void setNumInStock(int numInStock)
	{
		this.numInStock = numInStock;
	}


	public double getValueAtPurchase()
	{
		return valueAtPurchase;
	}


	public void setValueAtPurchase(double valueAtPurchase)
	{
		this.valueAtPurchase = valueAtPurchase;
	}
	
	public String toString()
	{
		String descript;
		String fmt="%-10s %-11s %-11s %-11s";
		descript = String.format(fmt,stockID,name,description,valueAtPurchase,numInStock);
		return descript;

		
		
	}
	
	
	
	}


	
	

	


