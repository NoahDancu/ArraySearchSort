import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Project1 
{
	
	static Country Countries[];
	
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException 
	{
		
		// TODO Auto-generated method stub
		
		
		  System.out.
		  println("COP3530 Project 1 \nArray Searches and Sorts \nEnter the file name: Countires1.csv \nThere were 155 records read. \n"
		  ); 	  

		  ArrayList<Country> list = new ArrayList<>();
		 
		BufferedReader reader = new BufferedReader(new FileReader("countries1.csv"));
		
		String line;

		reader.readLine();
		
		while ((line = reader.readLine()) != null) {
			
			String tokens[] = line.split(",");
	        list.add(new Country(tokens[0], tokens[1], tokens[2], Double.parseDouble(tokens[3]),
	        		Double.parseDouble(tokens[4]),
	        		Double.parseDouble(tokens[5])));

	    }

		Countries = list.toArray(new Country[list.size()]);
		
		System.out.println("1. Print a countries report \n2. Sort by Name \n3. Sort by Happiness \n4. Sort by GDP per capita "
				+ "\n5. Find and print a given country \n6. Quit \nEnter your choice: ");
		
		int numb = Choice();
		while(numb != 6)
		{
			if(numb == 1)
				print();
			else if(numb == 2)
				nameSort();
			else if(numb == 3)
				happinessSort();
			else if(numb == 4)
				GDPSort();
			else if(numb == 5)
			{
				System.out.println("Enter Name: ");
				String name = input.next();
				System.out.println("Binary Search");
				print(name);
			}
			
			System.out.println("\n1. Print a countries report \n2. Sort by Name \n3. Sort by Happiness \n4. Sort by GDP per capita "
					+ "\n5. Find and print a given country \n6. Quit \nEnter your choice: ");
			numb = Choice();
		}

	}
	
	
	public static void print(String name)
	{
		
		for(int i = 0; i<Countries.length; i++) 
		{
			Country c = Countries[i];			

			if (c.getName().equalsIgnoreCase(name)) {

				System.out.println("Name:\t" + c.getName() + "\nCode:\t"+ c.getCode() + "\nCapital:\t" 
				+ c.getCapital() + "\nPopulation:\t" + c.getPopulation() + "\nGDP:\t" 
						+ c.getGDP() + "\nHappiness Rank:\t" + c.getHappinessRank());

				return;
			}
		
		}
		System.out.println("No Countries found for name:\t" + name);
		
	}
		public static void print()
		{
			System.out.println("\nName\t\tCapital\t\tCode\t\tPopulation\t\tGDP\t\tHappiness Rank");

			for(int i = 0; i<Countries.length; i++) 
			{
				Country c = Countries[i];

				countryPrint(c);

			}
		}
		
	public static void nameSort()
	{

		int i, j;
		
		Country n;

		for (i = 1; i < Countries.length; i++) {
			
			n = Countries[i];

			j = i - 1;

			while (j >= 0 && (Countries[j].compare(n) > 0)) {

				Countries[j + 1] = Countries[j];

				j = j - 1;

			}

			Countries[j + 1] = n;

		}
		System.out.println("Countries sorted by name.");

	}
	public static void happinessSort()
	{

		int i, j, Happiness;

		for (i = 0; i < Countries.length - 1; i++) {

			Happiness = i;

			for (j = i + 1; j < Countries.length; j++) {

				if (Countries[j].getHappinessRank() < Countries[Happiness].getHappinessRank()) {

					Happiness = j;

				}

			}

			if (i != Happiness) {

				Country temp = Countries[i];

				Countries[i] = Countries[Happiness];

				Countries[Happiness] = temp;

			}

		}
		System.out.println("Countries sorted by Happiness.");

	}

	
	public static void GDPSort()
	{
		int out, in;
		
		Double perCapita;
		
		Double inPer;
		
		for(out=0; out<Countries.length-1; out++)
		{
			
			perCapita = Countries[out].getGDP() / Countries[out].getGDP();
			
			for(in=0; in<Countries.length-out-1; in++)
			{
				inPer = Countries[in].getGDP() / Countries[in].getPopulation();
				
				if(inPer.compareTo(perCapita)>0) 
				{
					Country temp = Countries[in];
					
					Countries[out] = Countries[out + 1];

					Countries[out + 1] = temp;

				}
			}
		}
		System.out.println("\nCountries sorted by GDP per capita.");

		
	}
	public static void countryPrint(Country c)
	{
		
		System.out.print(c.getName() + "\t\t");
		System.out.print(c.getCapital()+ "\t\t");
		System.out.print(c.getCode()+ "\t\t");
		System.out.print(c.getPopulation() + "\t\t");
		System.out.print(c.getGDP()+ "\t\t");
		System.out.println(c.getHappinessRank());
		
	}
	static int Choice()
	{
		
		int choice = input.nextInt();

		while (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5 && choice > 6) {

			System.out.println("Invalid choice enter 1-6: ");

			choice = input.nextInt();

		}
		return choice;
	}
}
