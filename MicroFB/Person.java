//Jeremiah Crowley
//Person.java

import java.util.LinkedList; 

public class Person 
{
	
	// Fields
	protected String name;
	protected int numFriends;
	LinkedList<Person> friends = new LinkedList(); //Used from java library 

	//Constructor
	public Person(String n)
	{
		name = n; 
		numFriends = 0; 
	}
		
	//Method Void addFriend
	public void addFriend(Person q)
	{
		//If p and q are equal
		if (q == this )
		{
			System.out.println( "Two people are equal." ); 
		}
				
		else
		{
			//Checks to see if q is already p's friend 
			if(friends.contains(q) == true)
			{
				System.out.println( "Already friends." ); 
			}	
			
			else
			{
				//Increments p.numFriends and q.numFriends
				numFriends++; 
				q.numFriends++; 
					
				//Adds q at the end of the array p.friends and vice versa
				friends.add(q);
				q.friends.add(this); 
			}
		}
	}
	
	//Method Void removeFriend
	public void removeFriend(Person q)
	{
		//If p and q are equal
		if (q == this )
		{
			System.out.println( "Two people are equal." ); 
		}
					
		else
		{
			//Checks to see if q is already p's friend 
			if(friends.contains(q) != true)
			{
				System.out.println( "Not friends." ); 
			}	
			
			else
			{
				//Deduct p.numFriends and q.numFriends
				numFriends--; 
				q.numFriends--; 
						
				//Adds q at the end of the array p.friends and vice versa
				friends.remove(q);
				q.friends.remove(this); 			
			}
		}
	}
}

	