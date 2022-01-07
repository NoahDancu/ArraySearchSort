
public class Country 
{
	String Name;
	String Code;
	String Capital;
	Double Population;
	Double GDP;
	Double HappinessRank;
	
	public Country(String Name, String Code, String Capital, Double population, Double GDP, Double happinessRank)
	{
		this.Name = Name;
		this.Capital = Capital;
		this.Code = Code;
		this.GDP = GDP;
		this.Population = population;
		this.HappinessRank = happinessRank;	
	}
	public String getName()
	{
		return Name;
	}
	public void setName(String newName)
	{
		this.Name = newName;
	}
	public String getCode()
	{
		return Code;
	}
	public void setCode(String newCode)
	{
		this.Code = newCode;
	}
	public String getCapital()
	{
		return Capital;
	}
	public void setCapital(String newCapital)
	{
		this.Capital = newCapital;
	}
	public Double getPopulation()
	{
		return Population;
	}
	public void setPopulation(Double newPopulation)
	{
		this.Population = newPopulation;
	}
	public Double getGDP()
	{
		return GDP;
	}
	public void setGDP(Double newGDP)
	{
		this.GDP = newGDP;
	}
	public Double getHappinessRank()
	{
		return HappinessRank;
	}
	public void setHappinessRank(Double newHappinessRank)
	{
		this.HappinessRank = newHappinessRank;
	}
	
	public int compare(Country second)
	{
		return this.getName().compareTo(second.getName());
	}
	
	public String out()
	{
		
		return "Name:\t" + Name + "\nCode:\t" + Code + "\nCapital:\t" + Capital + "\nPopulation:\t" + Population + "\nGDP:\t" + GDP + "\nHappiness Rank:\t" + HappinessRank; 
	}
}
